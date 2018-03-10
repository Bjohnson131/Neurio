package neurIO.engine;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import neurIO.data.BitSet;
import neurIO.system.Node;

public class NeworkEvaluator implements Runnable{
	
	private static long currentUUID = 0;
	
	private static final int dumpBufferSize = 10;
	private short bufferIndex = 0;
	
	private BlockingQueue<Network> dataBuffer = new LinkedBlockingQueue<Network>();
	private BlockingQueue<Long> dataIdBuffer = new LinkedBlockingQueue<Long>();
	private Long[] dumpBufferId = new Long[dumpBufferSize];
	private BitSet[] dumpBufferCol = new BitSet[dumpBufferSize];
	
	private HashMap<Long,BitSet> outputList = new HashMap<Long,BitSet>();
	private boolean running = true;

	@Override
	public void run() {
		while(running) {
			if(!dataBuffer.isEmpty()){
				try {
					Network toEval = dataBuffer.take();
					long workingUUID = dataIdBuffer.take();
					//create an output BitSet to evaluate the network into
					BitSet result = new BitSet(toEval.output.rows.length);
					//Network evaluation
					for(Node n : toEval.output.rows) {
						result.addBit(n.getValue());
					}
					
					this.addResult(currentUUID, result);
					
				} catch (InterruptedException e) {
					//catch for the blocking queue.
					e.printStackTrace();
				}
				
			}else{
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void addResult(long id, BitSet c){
		dumpBufferId[bufferIndex] = id;
		dumpBufferCol[bufferIndex] = c;
		bufferIndex++;
		if(bufferIndex >= dumpBufferSize){
			flushBuffer();
		}
	}
	
	public boolean idle() {
		return dataBuffer.isEmpty();
	}
	
	public synchronized long addNetwork(Network n) {
		dataBuffer.add(n);
		long uuid = UUID.getUUID();
		dataIdBuffer.add(uuid);
		return uuid;
	}
	
	public synchronized void flushResults(){
		for(int i = 0; i < dumpBufferSize; i++){
			if(dumpBufferId[i] == null) {
				break;
			}
			outputList.put(dumpBufferId[i],dumpBufferCol[i]);
			dumpBufferId[i] = null;
			dumpBufferCol[i] = null;
		}
		bufferIndex = 0;		
	}
	
	private synchronized void flushBuffer() {
		for(int i = 0; i < dumpBufferSize; i++){
			outputList.put(dumpBufferId[i],dumpBufferCol[i]);
			dumpBufferId[i] = null;
			dumpBufferCol[i] = null;
		}
		bufferIndex = 0;
	}
	
	public synchronized BitSet getResult(long id) {
		if(outputList.containsKey(id)) {
			return outputList.get(id);
		}else {
			return null;			
		}
	}
	
	public synchronized void quit() {
		running = false;
	}

}
