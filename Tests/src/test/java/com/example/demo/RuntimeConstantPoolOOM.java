package com.example.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * vm: -XX:PermSize=10m -XX:MaxPermSize=10m
 * 
 * @author ivy
 *
 */
public class RuntimeConstantPoolOOM {

	public static void main(String[] args) {
		// 使用list保持常量池引用，避免FULLGC回收常量池行为
		List<String> list = new ArrayList<String>();
		int i = 0;
		while (true) {
			list.add(String.valueOf(i++).intern());
		}
	}

}
