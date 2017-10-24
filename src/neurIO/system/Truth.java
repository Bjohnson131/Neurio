package neurIO.system;

import neurIO.Global;

public class Truth {
	
	boolean[] conditions;
	boolean result;
	public String name = "";
	short index = 0;

	public Truth(int width){
		conditions = new boolean[width];
		
	}
	
	public Truth(String name, int width, boolean result) {
		conditions = new boolean[width];
		this.result = result;
		this.name = name;
	}	

	public Truth(int width, boolean result) {
		conditions = new boolean[width];
		this.result = result;
	}	
	 
	public Truth( boolean[] conditions, boolean result) {
		this.conditions = conditions;
		index = (short) (conditions.length-1);
		this.result = result;		
	}	
	
	public Truth(String name, boolean[] conditions, boolean result) {
		this.conditions = conditions;
		index = (short) (conditions.length-1);
		this.result = result;	
		this.name = name;
	}
	
	public int getWidth() {
		return conditions.length;
	}
	
	public Truth addParam(boolean param) {
		if(index < conditions.length) {
			conditions[index] = param;
			index++;
		}
		return this;			
	}
	
	@Override
	public String toString() {
		String tstr = "";
		short width = (short) (Math.max(this.getWidth()*2,name.length())+2);
		tstr += Global.rept("_", width)+'\n';
		tstr += "|"+Global.rept(" ", (width - name.length())/2)+name+Global.rept(" ",((width - name.length())/2)-2)+"|"+'\n';
		tstr += "|"+Global.rept("-", width-2)+"|"+'\n';
		tstr += "|"+generateStringHeader()+"|"+'\n';
		tstr += "|"+generateStringTruth()+"||"+'\n';
		tstr += "|"+Global.rept("-", width-2)+"|"+'\n';
		
		
		return tstr;
	}
	
	private String generateStringTruth(){
		String toReturn = "";
		for(int i = 0; i < getWidth(); i++) {
			toReturn+=conditions[i]?"1":"0"+"|";
			
		}
		return toReturn;
	}
	
	private String generateStringHeader(){
		String toReturn = "";
		for(int i = 0; i < getWidth(); i++) {
			toReturn+=colIndexName(i)+"|";
		}
		return toReturn;
	}
	
	public static String colIndexName(int index) {
		String toReturn = "";
		while(index >= 0){
			int indexLetter = (index%26);
			index /= 26;
			index--;
			toReturn = (char)(indexLetter+65)+toReturn;
		}
		return toReturn;
	}
	
}
