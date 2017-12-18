/**
 * @author Brice Johnson
 * @version 0.01
 * @category Data
 **/
package neurIO.system;

/**
 * Node
 * ===
 * A lower level class that is used in columns and networks
 * Allows for differentiation between Neurons(computational nodes), Inputs (constant nodes), and Outputs (resultant nodes)
 **/
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
