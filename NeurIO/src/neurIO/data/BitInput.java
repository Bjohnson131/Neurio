package neurIO.data;

import neurIO.system.Node;

public class BitInput extends Node{
	
	public BitInput(boolean init){
		this.value = init;
	}
	public boolean get(){
		return value;
	}
	public void set(boolean value) {
		this.value = value;
	}
}
