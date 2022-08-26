package com.uce.edu.demo.service.funcional;

@FunctionalInterface
public interface IRectanguloFunction<R, T> {

	public R aplicar (T arg1);
}
