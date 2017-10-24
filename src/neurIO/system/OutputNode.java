package neurIO.system;

public class OutputNode extends Node{
	Node resultNode;
	
	public OutputNode(Node result){
		this.resultNode = result;
	}
	
	public static OutputNode[] makeOutputNodes(Node...nodes){
		OutputNode[] outs = new OutputNode[nodes.length];
		for(int i = 0; i < nodes.length; i++){
			outs[i] = new OutputNode(nodes[i]);
		}
		return outs;
	}
	
	@Override
	public boolean getValue(){
		return resultNode.getValue();
	}
}
