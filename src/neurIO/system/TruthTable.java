/**
 * @author Brice Johnson
 * @version 0.01
 * @category Data
 **/
package neurIO.system;

public class TruthTable {
	/**
	 * TruthTable
	 * ===
	 * A truth table contains outputs for every combination of inputs of length n.
	 * The current configuration of this class allows for some inputs to be missing, making the table incomplete.
	 **/
	public Truth[] truths;
	public int width;
	
	public TruthTable(boolean[] results){
		int width = binaryWidth(results.length);
		this.width = width;
		this.truths = makeTruths(results, width);
	}
	
	public static Truth[] makeTruths(boolean[] results, int width){
		Truth[] truths = new Truth[results.length];
		for(int i = 0; i < results.length; i++){
			Truth truth = (new Truth(width, results[i]));
			for(int w = 0; w < width; w++ ){
				truth = truth.addParam(((i>>w)&1)>0);
			}
			truths[i] = truth;
		}
		return truths;		
	}
	
	public boolean getResult(boolean[] truth) {
		int index = 0;
		System.out.println("indexing.. len : "+truth.length);
		for(int i = 0; i <truth.length; i++) {
			if(truth[i]) {
				index |= 1<<i;
			}
			System.out.println("index: "+index);
		}
		return truths[index].result;
	}
	
	public boolean isComplete() {
		return (1<<width) == truths.length;
	}
	
	public Truth getTruth(boolean[] truth) {
		int index = 0;
		for(int i = 0; i <truth.length; i++) {
			if(truth[i]) {
				index |= 1<<i;
			}
		}
		return truths[index];
	}
	
	private static int binaryWidth(int bTen) {
		 int bWidth = Integer.toBinaryString(bTen).length();
		 System.out.println("int: "+bTen+" wid:"+bWidth);
		 return bWidth;
	}
}
