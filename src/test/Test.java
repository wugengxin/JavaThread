package test;

public class Test {
	 
	Thread executeTask(Runnable task)
	{
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true)
				{
					task.run();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						break;
					}
				}
			}
		});
		t.setDaemon(true);
		t.start();
		return t;
	}

	void setInterrupt(long time,Thread t){
		long begin = System.currentTimeMillis();
		
		while(true){
			if((System.currentTimeMillis() - begin) > time)
			{
				t.interrupt();
				break;
			}
		}
	}

	void aliveCheck(Thread t)
	{
		if(t.isAlive())
		{
			System.out.println("thread is alive");
		}
		else
		{
			System.out.println("thread not alive");
		}
	}
	
	public static void main(String args[]){
		Test t = new Test();
		Thread task = t.executeTask(new Runnable() {
			
			@Override
			public void run() {
				while(true)
				{
				// TODO Auto-generated method stub
					System.out.println("task is runing......");	
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		t.setInterrupt(10*1000,task);
		t.aliveCheck(task);
	}
}
