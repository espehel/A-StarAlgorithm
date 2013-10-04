
public class LinearCheckerState extends State{
	char[] state;
	
	public LinearCheckerState(char[] state){
		this.state = state;
		//calculates the id
		for (int i = 0; i < state.length; i++) {
			int n;
			if(state[i] == 'b')
				n = 0;
			else if(state[i] == 'r')
				n = 1;
			else
				n = 2;
			//using the 3 number system to give an unique id
			id += n * Math.pow(3, i);
		}
	}
	
	//for printing
	@Override
	public String toString(){
		String output;
		output = "[" + state[0];
		for (int i = 1; i < state.length; i++) {
			output += ", " + state[i];
		}
		output += "]";
		return output;
	}
}
