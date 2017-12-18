/**
 * @author Brice Johnson
 * @version 0.01
 * @category Data
 **/
package neurIO.data.bitInput;
/**
 * BitInputSet
 * ===
 * This is a wrapper class for the Bitset, and allows one to translate an integer to bits that the network can use.
 **/
public class BitInputSet {
	
	public BitInput[] bits;
	public String name = "";
	
	public BitInputSet(BitInput[] bits){
		this.bits = bits;
	}
	
	public BitInputSet(BitInput[] bits, String name){
		this.bits = bits;
		this.name = name;
	}
	
	public void numToInput(int in){
		for(int i = 0; i < bits.length; i++){
			bits[i].set((in&(1<<i))>0);
		}
	}
}
