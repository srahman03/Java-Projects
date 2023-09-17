package threading;

public class timer {

	public static void main(String[] args) {
		System.out.println("=============Countdown from 10!============");
		
		// Create a new thread for the countdown using an anonymous inner class. This comment explains that a new thread is being created to handle the countdown. The thread is defined using an anonymous inner class, which means it doesn't have a separate name but is defined inline.
		Thread countdownThread = new Thread(new Runnable() {//when you create a new thread, you typically define the behavior of that thread by implementing the Runnable interface. The Runnable interface has a single method called run(), which represents the code that the thread will execute when it starts running.
			//This comment tells us that the anonymous inner class overrides the run method. 
			@Override//to provide specific behaviour
			public void run() {
				for(int i = 10; i>=0; i--) {
					System.out.print(i+" ");
					try {
						Thread.sleep(1000);//This comment describes that the code pauses the thread for one second (1000 milliseconds) using the Thread.sleep method. This creates a one-second delay between each countdown step.
					}catch(Exception e) {
						System.out.println("Error : " + e);//handles exception
					}
				}
				System.out.println("\nFinished!!");
			}
		});
		countdownThread.start();
	}
}
