import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class QueueJobSimulator {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner inputReader = new Scanner(new File("input.txt")).useDelimiter("\\D");
		SLLQueue<Job> inputQueue = new SLLQueue<>();
		int pid=1;
		while(inputReader.hasNext()) {
			
		}
		inputReader.close();
		
		ArrayQueue<Job> processingQueue = new ArrayQueue<>();
		ArrayList<Job> terminatedJobs = new ArrayList<>();
		int t =0;
		
		while(!(inputQueue.isEmpty()) || !(processingQueue.isEmpty())) {
			if(!(processingQueue.isEmpty())) {
				processingQueue.first().isServed(1);
				if(processingQueue.first().getRemainingTime()==0) {
					processingQueue.first().setDepartureTime(t);
					terminatedJobs.add(processingQueue.first());
					processingQueue.dequeue();
				}
				else {
					processingQueue.enqueue(processingQueue.dequeue());
				}
			if(!inputQueue.isEmpty()) {
				if()
			}
			}
		}

	}

}
