import java.util.ArrayList;


public class Node {
	State state;
	int g;
	int h;
	int f;
	boolean Open = true;
	Node parent;
	ArrayList<Node> kids;
}
