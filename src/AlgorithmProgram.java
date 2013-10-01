
public class AlgorithmProgram {
	
	public static void main(String[] args){
		char[] initState = {'r','r','r',' ','b','b','b'};
		AStar algorithm = new AStar(new Node(new LinearCheckerState(0, initState)));
		algorithm.bestFirstSearch();
	}

}
