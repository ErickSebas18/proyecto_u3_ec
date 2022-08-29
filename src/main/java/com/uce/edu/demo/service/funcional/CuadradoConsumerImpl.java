package com.uce.edu.demo.service.funcional;

public class CuadradoConsumerImpl implements ICuadradoConsumer<Integer>{

	@Override
	public void accept(Integer arg1) {
		// TODO Auto-generated method stub
		System.out.println("Consumer: El lado del cuadrado es ->" + arg1);
	}

}
