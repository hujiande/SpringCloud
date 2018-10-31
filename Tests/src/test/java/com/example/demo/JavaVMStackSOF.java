package com.example.demo;


/**
 * vm: -Xss128k
 * @author ivy
 *
 */
public class JavaVMStackSOF {
	private int stackLength = 1;
	
	private void stackLeak(){
		stackLength ++;
		stackLeak();
	}
	
	public static void main(String[] args) {
		JavaVMStackSOF oom = new JavaVMStackSOF();
		try {
			oom.stackLeak();
		} catch (Throwable e) {
			System.out.println("stack length :" + oom.stackLength);
			e.printStackTrace();
		}
	}

}
