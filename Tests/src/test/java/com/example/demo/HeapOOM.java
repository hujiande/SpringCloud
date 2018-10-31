package com.example.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * vm args:-Xms:20M -Xmx:20 -XX:+HeapDumpOnOutOfMemoryError
 * @author Administrator
 *
 */

public class HeapOOM {

	static class OOMObject{
		
	}
	
	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<>();
		while(true){
			list.add(new OOMObject());
		}
	}
}
