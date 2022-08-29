package com.uce.edu.demo.service.funcional;

public class RomboPredicateImpl implements IRomboPredicate<Integer>{

	@Override
	public boolean evaluar(Integer arg1) {
		// TODO Auto-generated method stub
		Integer menor = 4;
		return menor.equals(arg1);
	}

}
