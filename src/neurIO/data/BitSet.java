package neurIO.data;

public class BitSet{
	/**
	 * 
	 */
	
	@SuppressWarnings("unused")
	private static final long serialVersionUID = -8960459244413913816L;
	final boolean[] bits;
	boolean locked = false;
	short index;
	final int width;
	
	public BitSet(int width) {
		this.width = width;
		bits = new boolean[width];
	}
	
	public void reset() {
		for(int i = 0; i < bits.length; i++){
			bits[i] = false;
		}
		index = 0;
		locked = false;
	}
	
	public void addBit(boolean b){
		if(!locked) {
			bits[index] = b;
			index++;
			setLock();
		}
	}
	
	public void addByte(byte b){
		int in = b&0xFF;
		for(int i = 0; i < 8; i++) {
			addBit(((in>>i)&1)==1);
		}
	}	
	
	public boolean isLocekd(){
		return locked;
	}
	
	public int currentIndex() {
		return index;
	}
	
	private void setLock(){
		if(index > width){
			locked = true;
		}
	}
}
