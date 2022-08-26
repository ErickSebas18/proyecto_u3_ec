package com.uce.edu.demo.service.funcional;

@FunctionalInterface
public interface IRomboPredicate<T> {

	public boolean evaluar(T arg1);
}

