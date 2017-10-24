package neurIO.data;

public class BitInputSet {
	BitInput[] bits;
	public BitInputSet(BitInput[] bits){
		this.bits = bits;
	}
	
	public void numToInput(int in){
		for(int i = 0; i < bits.length; i++){
			bits[i].set((in&(1<<i))>0);
		}
	}
}
