package com.uce.edu.demo.service.funcional;

@FunctionalInterface
public interface IRectanguloUnaryOperator<T> extends IRectanguloFunction<T, T>{

	public T aplicar (T arg1);
	
}
