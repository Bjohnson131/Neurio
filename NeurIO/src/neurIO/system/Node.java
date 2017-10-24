package neurIO.system;

public class Node {
	protected boolean value;
	
	public Node() {}
	
	public Node(boolean value) {
		this.value = value;
	}

	public boolean getValue(){
		return value;
	}
	public void resetValue(){
	}
}
