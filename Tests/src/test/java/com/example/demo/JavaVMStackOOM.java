package com.example.demo;

/**
 * vm:-Xss2m
 * 
 * @author ivy
 *
 */
public class JavaVMStackOOM 
{

	public void dontStop() 
	{
		while (true) 
		{

		}
	}

	public void stackLeakByThread()
	{
		while (true) 
		{
			Thread thread = new Thread(new Runnable() 
			{
				@Override
				public void run() 
				{
					dontStop();
				}
			});
			thread.start();
		}
	}

	public static void main(String[] args) 
	{
		JavaVMStackOOM oom = new JavaVMStackOOM();
		oom.stackLeakByThread();
	}

}
