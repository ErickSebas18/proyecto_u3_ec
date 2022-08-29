package com.uce.edu.demo.service.funcional;

public class ConsumoMetodosHighOrder {

	public String consumirSupplier(IPersonaSupplier<String> function) {
		return function.getNombre();
	}
	
	public void consumirConsumer(IPersonaConsumer<Integer> function, Integer valor) {
		function.accept(valor);
	}
	
	public boolean consumirPredicate(IPersonaPredicate<String> function, String valor) {
		return function.evaluar(valor);
	}
	
	public String consumirFunction(IPersonaFunction<String, Integer> function, Integer valor) {
		return function.aplicar(valor);
	}
	
	public String consumirSupplier2(ITrianguloSupplier<String> function) {
		return function.getNombre();
	}
	
	public void consumirConsumer2(ICuadradoConsumer<Integer> function, Integer valor) {
		function.accept(valor);
	}
	
	public boolean consumirPredicate2(IRomboPredicate<String> function, String valor) {
		return function.evaluar(valor);
	}
	
	public String consumirFunction2(IRectanguloFunction<String, Integer> function, Integer valor) {
		return function.aplicar(valor);
	}
	
	public String consumirUnaryOperator(IRectanguloUnaryOperator<String> function, String valor) {
		return function.aplicar(valor);
	}
}
