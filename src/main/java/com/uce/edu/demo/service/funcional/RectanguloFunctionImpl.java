package com.uce.edu.demo.service.funcional;

public class RectanguloFunctionImpl implements IRectanguloFunction<Integer, String>{

	@Override
	public Integer aplicar(String arg1) {
		// TODO Auto-generated method stub
		String menor = "4";
		return arg1.compareTo(menor);
	}

}
