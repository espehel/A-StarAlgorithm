import java.util.ArrayList;
import java.util.Collections;


public class LinearCheckerAStar extends AStar{

	public LinearCheckerAStar(Node node) {
		super(node);
	}
	
	@Override
	protected void calculateH(Node node){
	//TODO skille en dårlig state fra en bedre state matematisk
		int score = 0;
		char[] state = ((LinearCheckerState) node.state).state;
		
		for (int i = 0; i < state.length; i++) {
			char cell = state[i];
			if(cell == 'r')
				score -= i;
			else if(cell == 'b')
				score += i;
		}
		node.h = score;
	}
	@Override
	protected int arcCost(Node p, Node c){
		return 1;
	}
	@Override
	protected ArrayList<Node> generateAllSuccesors(Node node) {
	//TODO lag alle mulige stater som man kan gå fra den opprinnelige staten
		ArrayList<Node> succesors = new ArrayList<Node>();
		char[] state = ((LinearCheckerState)node.state).state;
		//finn space
		int space = -1;
		for (int i = 0; i < state.length; i++) {
			if(state[i] == ' ')
				space = i;
		}
		if(space == -1){
			System.out.println("ERROR: Couldnt find space");
			return null;
		}
		
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
	private void swap(int i, int j, char[] array) {
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;	
	}

	@Override
	protected boolean solution(Node x) {
		return x.state.id == 1908;
	}
	public void testMethod(Node node){
		calculateH(node);
		System.out.println(node.h);
		System.out.println(node.state.id);
	}

}
