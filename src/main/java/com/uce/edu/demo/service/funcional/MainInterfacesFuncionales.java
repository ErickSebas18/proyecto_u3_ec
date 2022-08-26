package com.uce.edu.demo.service.funcional;

import org.apache.log4j.Logger;

public class MainInterfacesFuncionales {

	private static Logger logJava = Logger.getLogger(MainInterfacesFuncionales.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ConsumoMetodosHighOrder metodosHighOrder = new ConsumoMetodosHighOrder();
		
		// SUPPLIER
		
		// Clases
		
		IPersonaSupplier<String> supplier = new PersonaSupplierImpl();
		logJava.info("Supplier Class: " + supplier.getNombre());
		
		IPersonaSupplier<String> supplier2 = new PersonaSupplierTEImpl();
		logJava.info("Supplier Class: " + supplier2.getNombre());
		
		// Lambdas
		IPersonaSupplier<String> supplierLambda = () -> "Erick2";
		logJava.info("Supplier Lambda Class: " + supplierLambda.getNombre());
		
		IPersonaSupplier<String> supplierLambdaTE = () -> "Daniel";
		logJava.info("Supplier Lambda Class: " + supplierLambdaTE.getNombre());
		
		//MétodosHighOrder
		String valorHO = metodosHighOrder.consumirSupplier(() -> "HOLA MUNDO");
		logJava.info("Supplier MétodoHighOrder: " + valorHO);
		
		
		// CCNSUMER
		
		
		// CLASES
		IPersonaConsumer<String> consumer = new PersonaConsumerImpl();
		consumer.accept("Prueba Consumer");
		
		// LAMBDAS
		IPersonaConsumer<String> consumerLambda = (cadena) -> System.out.println(cadena);
		consumerLambda.accept("Prueba Consumer Lambda");
	
		//MétodosHighOrder
		
		metodosHighOrder.consumirConsumer(valor -> System.out.println("Consumer Método: " + valor), 7);
		
		// PREDICATE
		
		// Clases
		
		// Lambdas
		
		IPersonaPredicate<String> predicateLambda = (nombre) -> nombre.equals("Hola");
		logJava.info("Prueba Predicate Lambda: " + predicateLambda.evaluar("Habla"));

		//MétodosHighOrder
		logJava.info("Prueba Método: " + metodosHighOrder.consumirPredicate(predicateLambda, "Hola"));
		// FUNCTION
		
		// Clase
		
		// Lambdas
		//Recibe un String y devuelve un Integer
		IPersonaFunction<Integer, String> function = (numero) -> Integer.parseInt(numero) + 1;
		logJava.info("Prueba Function Lambda: " + function.aplicar("7"));
		
		//MétodosHighOrder
		logJava.info("Prueba Método Lambda: " + metodosHighOrder.consumirFunction( valor -> valor.toString(), 7));
		// UNARYOPERATOR
		
		// CLASES
		
		// LAMBDAS
		
		IPersonaUnaryOperator<String> unaryLambda =  cade -> {
			String valorFinal = cade.concat("sufijo");
			return valorFinal;
		};
		logJava.info("Prueba Function Lambda: " + unaryLambda.apply("Daniel"));
	
	}

}
