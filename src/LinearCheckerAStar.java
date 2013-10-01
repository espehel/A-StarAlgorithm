import java.util.ArrayList;


public class LinearCheckerAStar extends AStar{

	public LinearCheckerAStar(Node node) {
		super(node);
	}
	
	@Override
	protected void calculateH(Node node){
	//TODO skille en dårlig state fra en bedre state matematisk
	}
	@Override
	protected int arcCost(Node p, Node c){
		return 1;
	}
	@Override
	protected ArrayList<Node> generateAllSuccesors() {
	//TODO lag alle mulige stater som man kan gå fra den opprinnelige staten
		return null;
	}
	@Override
	protected boolean solution(Node x) {
	//TODO identifiser at denne staten er "mål"
		return false;
	}

}
