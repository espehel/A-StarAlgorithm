
public class LinearCheckerState extends State{
	char[] state;
	
	public LinearCheckerState(char[] state){
		this.state = state;
		for (int i = 0; i < state.length; i++) {
			id += i * state[i];
		}
	}

}
