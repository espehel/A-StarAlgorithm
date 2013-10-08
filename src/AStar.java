import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import sun.font.EAttribute;


public abstract class AStar {
	
	protected long solutionId = 0;
	ArrayList<Node> open, closed, succ;
	boolean soloution = false;
	
	//subclass must handle this
	protected abstract void calculateH(Node node);
	protected abstract ArrayList<Node> generateAllSuccesors(Node node);
	protected abstract boolean solution(Node x);
	protected abstract int arcCost(Node p, Node c);
	
	//initilizign with the starting node
	public AStar(Node node){
		open = new ArrayList<Node>();
		closed = new ArrayList<Node>();
		
		node.g = 0;
		calculateH(node);
		node.f = node.g + node.h;
		open.add(node);
	}
	
	//the search begins here
	public boolean bestFirstSearch() {
		while(!soloution){
			if(open.isEmpty()){
				System.out.println("No more choices to explore");
				System.out.println("SolutionId: " + solutionId);
				return false;
			}
			//chooses the most optimal X
			Node x = popNode();
			closed.add(x);
			System.out.println("X:\t\t" + x.state + " " + x.h + " + " + x.g + " = " + x.f);
			//checks if it is a soulution
			if(solution(x)){
				System.out.println("SOLUTION:\t" + x.state);
				System.out.println("nodes created: " + open.size() + closed.size());
				printSolution(x);
				return true;
			}
			//handles the possible moves from the state x
			succ = generateAllSuccesors(x);
			for (Node s : succ) {
				//if this state already exist, we will use the node keeping it instead
				Node old = findOld(s);
				if(old != null)
					s = old;
				//makes the new node a child of x
				x.kids.add(s);
				//if its a new state it will be inserted to open after evaluation
				if(!open.contains(s) && !closed.contains(s)){
					attachAndEval(s,x);
					insert(s);
				}
				//if its an old node and x is a better parent it will be evalueted again.
				else if(x.g + arcCost(x, s) < s.g){
					attachAndEval(s, x);
					if(closed.contains(s)){
						//if its closed all children will be evaluated with the new score of "s"
						propagatePathImprovements(s);
					}
				}
			}
		}
		return true;
	}
	private void printSolution(Node solution) {
			System.out.println("*********PRINTING SOLUTION**********");
			Node current = solution;
			Stack<String> winningMoves = new Stack<String>();
			while(current != null){
				winningMoves.push(current.state.toString());
				current = current.parent;
			}
			while(!winningMoves.isEmpty()){
				System.out.println(winningMoves.pop());
			}
		
	}
	//recursivly checks if children has a better parent	
	private void propagatePathImprovements(Node p) {
		for (Node c : p.kids) {
			if(p.g + arcCost(p, c) < c.g){
				c.parent = p;
				c.g = p.g + arcCost(p, c);
				c.f = c.g + c.h;
				propagatePathImprovements(c);
			}
			
		}
		
	}
	//inserts node and sorts the list on node.f
	private void insert(Node node) {
//		//A*
		open.add(node);
		Collections.sort(open);
//		
//		//dfs
//		open.add(0, node);
		
		//bfs
//		open.add(node);
	}
	//attaches parent to child and evaluates score
	private void attachAndEval(Node c, Node p) {
		c.parent = p;
		c.g = p.g + arcCost(p,c);
		calculateH(c);
		c.f = c.g + c.h;
	}
	
	//cheks the lists open and closed for the node by using the id of the state.
	private Node findOld(Node node) {		
		for (Node old : open) {
			if(old.state.id == node.state.id){
				return old;
			}
		}
		for (Node old : closed) {
			if(old.state.id == node.state.id){
				return old;
			}
		}
		return null;
	}
	//removes and returns the msot optimal node
	private Node popNode() {
		return open.remove(0);
	}

}
