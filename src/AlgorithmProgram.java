
public class AlgorithmProgram {
	
	public static void main(String[] args){
		//different variatons
		char[] puzzle6 = {'b','b','b',' ','r','r','r'};
		char[] puzzle12 = {'b','b','b','b','b','b',' ','r','r','r','r','r','r'};
		char[] puzzle24 = {'b','b','b','b','b','b','b','b','b','b','b','b',' ','r','r','r','r','r','r','r','r','r','r','r','r'};
		char[] puzzle30 = {'b','b','b','b','b','b','b','b','b','b','b','b','b','b','b',' ','r','r','r','r','r','r','r','r','r','r','r','r','r','r','r'};
		
		//initializing
		Node initNode = new Node(new LinearCheckerState(puzzle6));
		System.out.println("STARTING: " + ((LinearCheckerState)initNode.state).state.length + " cells");
		AStar algorithm = new LinearCheckerAStar(initNode);
		//starting the search with the already given state
		algorithm.bestFirstSearch();
	}

}
