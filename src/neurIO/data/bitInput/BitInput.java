/**
 * @author Brice Johnson
 * @version 0.01
 * @category Data
 **/
package neurIO.data.bitInput;

import neurIO.system.Node;
/**
 * BitInput
 * ===
 * A small extension of Node that has methods for setting the  
 * @see Node
 **/
public class BitInput extends Node{
	
	/**
	 *Constructor.
	 *
	 *@param init This is the initial state
	 **/
	public BitInput(boolean init){
		this.value = init;
	}
	
	/**
	 * Get method.
	 **/
	public boolean get(){
		return value;
	}
	/**
	 * Set method.
	 **/
	public void set(boolean value) {
		this.value = value;
	}
}
