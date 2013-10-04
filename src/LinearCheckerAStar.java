import java.util.ArrayList;
import java.util.Collections;


public class LinearCheckerAStar extends AStar{
	
	public LinearCheckerAStar(Node node) {
		super(node);
		generateSolutionId((((LinearCheckerState)node.state).state.length));
	}
	//generates the id that the solution will have
	private void generateSolutionId(int length) {
		int mid = (length/2);
		for (int i = 0; i < length; i++) {
			int n;
			if(i < mid)
				n = 1;
			else if(i > mid)
				n = 0;
			else
				n = 2;
			solutionId += n * Math.pow(3, i);
		}
	}

	//calculates the H value. cells with 'r' will get more optimal scores towards the left, vica versa with 'b'
	protected void calculateH(Node node){
		int score = 0;
		char[] state = ((LinearCheckerState) node.state).state;
		//iterates thru list
		for (int i = 0; i < state.length; i++) {
			char cell = state[i];
			//if cell is 'r' then score will be added
			if(cell == 'r')
				score += i;
			//if cell is 'b' score will be substracted
			else if(cell == 'b')
				score -= i;
		}
		node.h = score;
	}
	//arcost is 1 for every step
	protected int arcCost(Node p, Node c){
		return 1;
	}
	//generates all possible succesors by using the rules
	protected ArrayList<Node> generateAllSuccesors(Node node) {
		ArrayList<Node> succesors = new ArrayList<Node>();
		char[] state = ((LinearCheckerState)node.state).state;
		//locates the free cell
		int space = -1;
		for (int i = 0; i < state.length; i++) {
			if(state[i] == ' ')
				space = i;
		}
		//this should not happen
		if(space == -1){
			System.out.println("ERROR: Couldnt find space");
			return null;
		}
		//all theese checks how close the free cell is to the edges of the list. If its to close for a move it will not be allowed
		if(space > 1){
			char[] newState = state.clone();
			swap(space-2,space, newState);
			succesors.add(new Node(new LinearCheckerState(newState)));
		}
		if(space > 0){
			char[] newState = state.clone();
		swap(space-1,space, newState);
		succesors.add(new Node(new LinearCheckerState(newState)));
		}
		if(space < state.length-1){
			char[] newState = state.clone();
		swap(space+1,space, newState);
		succesors.add(new Node(new LinearCheckerState(newState)));
		}
		if(space < state.length-2){
			char[] newState = state.clone();
		swap(space+2,space, newState);
		succesors.add(new Node(new LinearCheckerState(newState)));
		}
		return succesors;
	}
	//swaps two cells
	private void swap(int i, int j, char[] array) {
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;	
	}

	//checks if the soulutin is correct
	protected boolean solution(Node x) {
		return x.state.id == solutionId;
	}
}
