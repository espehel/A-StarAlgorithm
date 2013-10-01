import java.util.ArrayList;
import java.util.Collections;


public class AStar {

	ArrayList<Node> open, closed, succ;
	boolean soloution = false;
	Node target;
	
	public AStar(Node node){
		open = new ArrayList<Node>();
		closed = new ArrayList<Node>();
		
		node.g = 0;
		calculateH(node);
		node.f = node.g + node.h;
		open.add(node);
	}
	
	private void calculateH(Node node) {
		node.h = 1+1; //TODO
	}

	public boolean bestFirstSearch() {
		while(!soloution){
			if(open.isEmpty())
				return false;
			Node x = popNode();
			closed.add(x);
			if(solution(x))
				return true;
			succ = generateAllSuccesors();
			for (Node s : succ) {
				
				Node sOld = findOld(s);
				if(sOld != null){
					if(s.state == sOld.state){
						s = sOld;
					}
				}
				x.kids.add(s);
				if(!open.contains(s) && ! closed.contains(s)){
					attachAndEval(s,x);
					insert(s);
				}
				else if(x.g + arcCost(x, s) < s.g){
					attachAndEval(s, x);
					if(closed.contains(s))
						propagatePathImprovements(s);
				}
			}
		}
		return true;
	}
		
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

	private void insert(Node node) {
		open.add(node);
		Collections.sort(open, null); //TODO fiks comparator
	}

	private void attachAndEval(Node c, Node p) {
		c.parent = p;
		c.g = p.g + arcCost(p,c);
		calculateH(c);
		c.f = c.g + c.h;
	}

	private int arcCost(Node p, Node c) {
		// TODO Auto-generated method stub
		return 0;
	}

	private Node findOld(Node node) {
		if(open.contains(node))
			return null;
		else if (closed.contains(node))
			return null;
		else
			return null;
	}

	private ArrayList<Node> generateAllSuccesors() {
		// TODO Auto-generated method stub
		return null;
	}

	private boolean solution(Node x) {
		// TODO Auto-generated method stub
		return false;
	}

	private Node popNode() {
		// TODO sorting
		return open.remove(open.size()-1);
	}

}
