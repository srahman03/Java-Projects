package producerAndConsumer;

import java.util.List;

public class Producer implements Runnable {

	List<Integer> questionList = null;//shared list that will hold the questions produced by this producer and consumed by another thread 
	final int LIMIT = 5;//specifies the maximum number of questions that can be stored in the questionList.
	private int questionNo;
	
	
	public Producer(List<Integer> questionList) {//constructors only for public variables and is used to initialize 
		this.questionList = questionList;
	}
	
	//method that simulates reading and adding a new question to the list. It is synchronized to ensure that only one thread can access it at a time.
	public void readQuestion(int questionNo) throws InterruptedException {
		//The first synchronized block checks if the list is full. If it is, it prints a message and waits for other threads to consume questions
		synchronized(questionList) {
			while(questionList.size() == LIMIT) {
				System.out.println("Questions have piled up....wait for answers");
				questionList.wait();
			}
			
		}
		
		//The second synchronized block adds a new question to the list, simulates some processing time, and then notifies waiting threads that a new question is available.
		synchronized(questionList) {
			System.out.println("New Question: " + questionNo);
			questionList.add(questionNo);
			Thread.sleep(100);
			//It then notifies waiting threads that a question has been answered and removed.
			questionList.notify();
		}
		
	}
	
	@Override
	public void run() {
		while(true) {
			try {
			readQuestion(questionNo++);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
		 
	}

}
