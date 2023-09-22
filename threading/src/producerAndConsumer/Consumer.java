package producerAndConsumer;

import java.util.List;

public class Consumer implements Runnable {

	List<Integer> questionList = null;//Runnable interface, indicating that it can be executed as a thread.

	public Consumer(List<Integer> questionList) {//constructors only for public variables 
		this.questionList = questionList;
	}
	
	public void answerQuestion() throws InterruptedException {
		//checks if the list is empty
		synchronized(questionList) {
			while(questionList.isEmpty()) {
				System.out.println("No questions to answer....waiting to get questions");
				questionList.wait();
			}
		}
		//simulates answering a question by sleeping for 5 seconds, printing the answer, and removing the first question from the list.
		synchronized(questionList) {
			Thread.sleep(5000);
			System.out.println("Answer: " + questionList.remove(0));
			questionList.notify();
		}
		
	}
	
	@Override
	public void run() {
		while(true) {
			try {
			answerQuestion();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
		 
	}

}

