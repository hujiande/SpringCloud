package com.example.demo;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * vm: -XX:PermSize=10M -XX:MaxPerSize:10M
 * @author ivy
 *
 */
public class JavaMethodArea {
	
	static class OOMObject{
		
	}
	
	public static void main(String[] args) {
		while (true) {
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(OOMObject.class);
			enhancer.setUseCache(false);
			enhancer.setCallback(new MethodInterceptor() {
				
				@Override
				public Object intercept(Object obj, Method arg1, Object[] arg2, MethodProxy proxy) throws Throwable {
					
					return proxy.invokeSuper(obj, args);
				}
			});
			enhancer.create();
		}
	}

}
