/**
 * @author Brice Johnson
 * @version 0.01
 * @category Data
 **/
package neurIO.engine;

import neurIO.system.Node;

/**
 * Network
 * ===
 * A network (as it stands now) is a set of columns that are interconnected.
 * Usually, one column is dedicated to inputs, and one is dedicated to outputs.
 **/
public class Network {
	final int colheight;
	Column[] cols;
	public Column input, output;
	
	public Network(int cols, int colheight){
		this.cols = new Column[cols-2];
		this.colheight = colheight;
	}
	
	public boolean addColumn(Column c){
		if(cols[cols.length-1] != null) {
			return false;
		}else {
			for(int i = 0; i < cols.length; i++){
				if(cols[i] == null) {
					cols[i] = c;
					break;
				}
			}
		}
		return true;
	}
	
	public Node getNode(int row, int col){
		return cols[col].rows[row];
	}
	
	public void resetBoard(){
		for(Column col: cols){
			for(Node node: col.rows){
				node.resetValue();
			}
		}
	}
}
