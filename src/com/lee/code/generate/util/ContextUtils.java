package com.lee.code.generate.util;

public final class ContextUtils {
	ThreadLocal<String> tempLocal = new ThreadLocal<String>();
	
	private final int a;
	
	private final int b;
	
	public ContextUtils(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public ContextUtils add(ContextUtils other) {
		return new ContextUtils(a + other.a, b+ other.b);
	}
	
	public final String getId() {
		return tempLocal.get();
	}
	
	public final void setId(String id) {
		tempLocal.set(id);
	}
}
