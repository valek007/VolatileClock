public class Clock implements Runnable{

	private volatile boolean isCancel = false;

	public void cancel(){
		this.isCancel = true;
	}

	@Override
	public void run(){

		while(!isCancel){
			try{

				Thread.sleep(1000);
				System.out.println("Tik Tak");

			} catch(Exception e){}
		}
	}

	public static void main(String[] args) throws Exception{

		Clock clock = new Clock();
		Thread clockThread = new Thread(clock);
		clockThread.start();
	
		Thread.sleep(10000);
		clock.cancel();
	}
}