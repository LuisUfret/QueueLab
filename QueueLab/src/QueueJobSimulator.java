import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class QueueJobSimulator {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner inputReader = new Scanner(new File("input.txt")).useDelimiter("\\D");
		SLLQueue<Job> inputQueue = new SLLQueue<>();
		int pid=1;
		while(inputReader.hasNext()) {
			StringTokenizer s = new StringTokenizer(inputReader.nextLine(), ", ");
			Job j= new Job(pid, Integer.parseInt(s.nextToken()), Integer.parseInt(s.nextToken()));
			inputQueue.enqueue(j);
			pid++;
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
				if(inputQueue.first().getArrivalTime()==t) 
					processingQueue.enqueue(inputQueue.dequeue());
			}
			t++;
			}
			
			double promedio = 0;
			for(Job j: terminatedJobs) {
				int excecutionTime = j.getDepartureTime() - j.getArrivalTime();
				promedio+= excecutionTime;
			}
			promedio /= terminatedJobs.size();
			System.out.println("Average Time: " + promedio);
		}

	}

}
