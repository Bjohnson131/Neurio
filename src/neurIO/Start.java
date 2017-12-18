package neurIO;
import neurIO.data.bitInput.BitInput;
import neurIO.data.bitInput.BitInputSet;
import neurIO.engine.Column;
import neurIO.engine.Network;
import neurIO.system.Neuron;
import neurIO.system.Node;
import neurIO.system.OutputNode;
import neurIO.system.Truth;
import neurIO.system.TruthTable;
/**
 * Start
 * ===
 *  
 *This is the main class to start tests, GUI, etc.
 **/
public class Start {
	
	/**
	 *  The main program used to start the GUI, do tests, etc. 
	 *  This is NOT for API usage.  
	 **/
	public static void main(String[] args) {
		Global.args = args;
		printColTest();
		printTruthTest();
		printHelp();
		printNetworkTest();
		switch(args[0]){
			default : printHelp();
		}
	}
	
	/**
	 * Doesn't actually print any help at the moment...
	 * 
	 * will eventually print out a command line help form
	 **/
	public static void printHelp(){
		System.out.println("NEURIO 2017 Brice Johnson");
		System.out.println("-----------------------------");
		System.out.println("           OPTIONS           ");
		System.out.println("-----------------------------");
	}
	
	/**
	 * Tests the naming system of Columns. This is in excel
	 * (A-Z,AA-ZZ, etc)
	 **/
	private static void printColTest() {
		for(int i = 0; i < 27; i++) {
			System.out.println(Truth.colIndexName(i));
		}
	}
	
	/**
	 * Prints a truth table using the ToString test.
	 **/
	private static void printTruthTest(){
		boolean[] conditions = {false, false, true};
		Truth truth = new Truth(conditions, true);
		System.out.println(truth.toString());
	}
	
	/**
	 * Prints out the result of a summing network which sums one byte at a time
	 **/
	private static void printNetworkTest(){
		boolean[] xor = {false,true,true,false};
		boolean[] and = {false,false,false,true};
		boolean[] sum = {false,true,true,false,true,false,false,true};
		boolean[] car = {false,false,false,true,false,true,true,true};
		
		Network eightBitAdder = new Network(8,2);
		BitInput A1 = new BitInput(false),
		A2 = new BitInput(false),
		A3 = new BitInput(false),
		A4 = new BitInput(false),
		A5 = new BitInput(false),
		A6 = new BitInput(false),
		A7 = new BitInput(false),
		A8 = new BitInput(false),
		B1 = new BitInput(false),
		B2 = new BitInput(false),
		B3 = new BitInput(false),
		B4 = new BitInput(false),
		B5 = new BitInput(false),
		B6 = new BitInput(false),
		B7 = new BitInput(false),
		B8 = new BitInput(false);
		BitInput[] num1 = {A1,A2,A3,A4,A5,A6,A7,A8};
		BitInput[] num2 = {B1,B2,B3,B4,B5,B6,B7,B8};
		BitInput[] nums = {A1,A2,A3,A4,A5,A6,A7,A8,B1,B2,B3,B4,B5,B6,B7,B8};
		BitInputSet bus1 = new BitInputSet(num1);
		BitInputSet bus2 = new BitInputSet(num2);
		
		Column in = new Column(nums);
		
		eightBitAdder.input = in;
		
		bus1.numToInput(234);
		bus2.numToInput(154);
		
		Node[] bitIns1 = {A1,B1};  //Add the first bit of numbers A and B together.
		Neuron sum1= new Neuron(bitIns1, new TruthTable(xor)); //Get the sum of the bits
		Neuron car1= new Neuron(bitIns1, new TruthTable(and)); //Get the carry of the bits
		Column c1 = (new Column(sum1,car1)); // Make into a function
		eightBitAdder.addColumn(c1);// Add to a network
		Node[] bitIns2 = {A2,B2,car1};//Add the last carry, and the second bits together.
		Neuron sum2 = new Neuron(bitIns2,new TruthTable(sum));// Different truth tables are used for 3 bits.
		Neuron car2 = new Neuron(bitIns2,new TruthTable(car));
		Column c2 = (new Column(sum2,car2));
		eightBitAdder.addColumn(c2);
		Node[] bitIns3 = {A3,B3,car2};
		Neuron sum3 = new Neuron(bitIns3,new TruthTable(sum));
		Neuron car3 = new Neuron(bitIns3,new TruthTable(car));
		Column c3 = (new Column(sum3,car3));
		eightBitAdder.addColumn(c3);
		Node[] bitIns4 = {A4,B4,car3};
		Neuron sum4 = new Neuron(bitIns4,new TruthTable(sum));
		Neuron car4 = new Neuron(bitIns4,new TruthTable(car));
		Column c4 = (new Column(sum4,car4));
		eightBitAdder.addColumn(c4);
		Node[] bitIns5 = {A5,B5,car4};
		Neuron sum5 = new Neuron(bitIns5,new TruthTable(sum));
		Neuron car5 = new Neuron(bitIns5,new TruthTable(car));
		Column c5 = (new Column(sum5,car5));
		eightBitAdder.addColumn(c5);
		Node[] bitIns6 = {A6,B6,car5};
		Neuron sum6 = new Neuron(bitIns6,new TruthTable(sum));
		Neuron car6 = new Neuron(bitIns6,new TruthTable(car));
		Column c6 = (new Column(sum6,car6));
		eightBitAdder.addColumn(c6);
		Node[] bitIns7 = {A7,B7,car6};
		Neuron sum7 = new Neuron(bitIns7,new TruthTable(sum));
		Neuron car7 = new Neuron(bitIns7,new TruthTable(car));
		Column c7 = (new Column(sum7,car7));
		eightBitAdder.addColumn(c7);
		Node[] bitIns8 = {A8,B8,car7};
		Neuron sum8 = new Neuron(bitIns8,new TruthTable(sum));
		Neuron car8 = new Neuron(bitIns8,new TruthTable(car));
		Column c8 = (new Column(sum8,car8));
		eightBitAdder.addColumn(c8);
		OutputNode[] outputNodes = OutputNode.makeOutputNodes(sum1,sum2,sum3,sum4,sum5,sum6,sum7,sum8,car8);
		Column outputColumn = new Column(outputNodes);
		eightBitAdder.output = outputColumn;
		
		int result = 0;
		for(int i = 0; i < outputNodes.length; i++){
			System.out.println(outputNodes[i].getValue());
			result +=(outputNodes[i].getValue()?1:0)<<i;
		}
		
		System.out.println(result);
		
	}
}
