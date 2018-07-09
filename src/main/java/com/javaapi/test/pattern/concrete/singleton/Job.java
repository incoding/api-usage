package com.javaapi.test.pattern.concrete.singleton;

class Job implements Runnable {
	String a;
	public Job(int i) {
		// TODO Auto-generated constructor stub
		a = String.valueOf(i);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println(Singleton.getInstance(a).getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
