
public class AlgorithmProgram {
	
	public static void main(String[] args){
		char[] initState = {'r','r','r',' ','b','b','b'};
		Node initNode = new Node(new LinearCheckerState(initState));
		AStar algorithm = new LinearCheckerAStar(initNode);
//		algorithm.bestFirstSearch();
		((LinearCheckerAStar)algorithm).testMethod(initNode);
	}

}
