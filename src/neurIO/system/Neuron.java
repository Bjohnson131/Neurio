/**
 * @author Brice Johnson
 * @version 0.01
 * @category Data
 **/
package neurIO.system;

/**
 * Neuron
 * ===
 * The basic unit of processing.
 * Uses references to children to look up its result on a truth table held in RAM.
 **/
public class Neuron extends Node {
	TruthTable truths;
	Node[] children;
	TruthTable function;
	int width;
	volatile boolean evaluated = false;
	volatile boolean value;//Volatility helps with evaluation.

	public Neuron(Node[] children, TruthTable function) {
		this.children = children;
		this.function = function;
		this.width = function.width;
		if (!this.isValid()) {

		}
	}
	
	public Neuron clone(Node[] newTargets){
		return new Neuron(newTargets, this.truths);
	}

	public boolean isValid() {
		return width == children.length;
	}

	@Override
	public boolean getValue() {
		if (!evaluated) {
			boolean[] ins = new boolean[width];
			for (int i = 0; i < width - 1; i++) {
				ins[i] = children[i].getValue();
			}
			value = function.getResult(ins);
			evaluated = true;
		}
		return value;
	}

	@Override
	public void resetValue() {
		evaluated = false;
	}
	
	
	public static class Presets {
		/**
		 * Presets are commonly used nodes, here for ease of access.
		 **/
		public static Neuron AND(Node in1, Node in2) {
			boolean[] truths = { false, false, false, true };
			Node[] inputs = { in1, in2 };
			return new Neuron(inputs, new TruthTable(truths));
		}

		public static Neuron OR(Node in1, Node in2) {
			boolean[] truths = { false, true, true, true };
			Node[] inputs = { in1, in2 };
			return new Neuron(inputs, new TruthTable(truths));
		}

		public static Neuron NOR(Node in1, Node in2) {
			boolean[] truths = { true, false, false, false };
			Node[] inputs = { in1, in2 };
			return new Neuron(inputs, new TruthTable(truths));
		}

		public static Neuron NAND(Node in1, Node in2) {
			boolean[] truths = { true, true, true, false };
			Node[] inputs = { in1, in2 };
			return new Neuron(inputs, new TruthTable(truths));
		}

		public static Neuron XOR(Node in1, Node in2) {
			boolean[] truths = { false, true, true, false };
			Node[] inputs = { in1, in2 };
			return new Neuron(inputs, new TruthTable(truths));
		}
	}
}
