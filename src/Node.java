import java.util.ArrayList;


public class Node implements Comparable<Node>{
	State state;
	int g;
	int h;
	int f;
	boolean Open = true;
	Node parent;
	ArrayList<Node> kids;
	
	public Node(State state){
		this.state = state;
		kids = new ArrayList<Node>();
	}
	//used when the list of nodes is sorted
	@Override
	public int compareTo(Node o) {
		return this.f-o.f;
	}
	
}
