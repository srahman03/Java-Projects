package producerAndConsumer;

import java.util.List;
import java.util.ArrayList;

public class Application {

	public static void main(String[] args) {
		//declares an empty Arraylist named questionList to hold integers.
		List<Integer> questionList = new ArrayList<Integer>();
		
		Thread t1 = new Thread(new Producer(questionList));//new thread t1 is created and associated with an instance of the Producer class.
		Thread t2 = new Thread(new Consumer(questionList));
		
		t1.start();
		t2.start();
	}

}
