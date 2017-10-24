package neurIO.engine;

import neurIO.system.Node;

public class Column {
	Node[] rows;
	
	public Column(Node... nodes){
		this.rows = nodes;
	}
	
	public Column expand(int places) {
		Node[] oldRows = this.rows;
		Node[] newRows = new Node[places + oldRows.length];
		for(int i = 0; i < oldRows.length; i++){
			newRows[i] = oldRows[i];
		}
		return this;
	}
	public Column expandTo(int places) {
		Node[] oldRows = this.rows;
		Node[] newRows = new Node[places];
		for(int i = 0; i < oldRows.length; i++){
			newRows[i] = oldRows[i];
		}
		return this;
	}
	
	public Node getRow(int row) {
		return rows[row];
	}

}
