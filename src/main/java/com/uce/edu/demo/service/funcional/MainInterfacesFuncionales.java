package com.uce.edu.demo.service.funcional;

import org.apache.log4j.Logger;

public class MainInterfacesFuncionales {

	private static Logger logJava = Logger.getLogger(MainInterfacesFuncionales.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Interfaces Funcionales con Clases");
		
		ITrianguloSupplier<String> trianguloSupplier = new TrianguloSupplierImpl();
		logJava.info("Supplier Class: " + trianguloSupplier.getNombre());
		
		ICuadradoConsumer<Integer> cuadradoConsumer = new CuadradoConsumerImpl();
		cuadradoConsumer.accept(7);
		
		IRomboPredicate<Integer> romboPredicate = new RomboPredicateImpl();
		logJava.info("Predicate Class: " + romboPredicate.evaluar(4));
		
		IRectanguloFunction<Integer, String> rectanguloFunction = new RectanguloFunctionImpl();
		logJava.info("Function Class: " + rectanguloFunction.aplicar("5"));
		
		IRectanguloUnaryOperator<Integer> rectanguloUnaryOperator = new UnaryOperatorImpl();
		logJava.info("Unary Operator Class: " + rectanguloUnaryOperator.aplicar(9));
		
		System.out.println("**************************************");
		
		System.out.println("Interfaces Funcionales con Lambdas");
		
		ITrianguloSupplier<String> trianguloSupplierLambda = () -> "Triángulo Rectángulo";
		logJava.info("Supplier Lambda: " + trianguloSupplierLambda.getNombre());
		
		ICuadradoConsumer<Integer> cuadradoConsumerLambda = (perimetro) -> System.out.println("El perímetro es: " + perimetro);
		cuadradoConsumerLambda.accept(10);
		
		IRomboPredicate<Integer> romboPredicateLambda = (menor) -> menor > 7;
		logJava.info("Predicate Class: " + romboPredicateLambda.evaluar(4));
		
		IRectanguloFunction<Boolean, Integer> rectanguloFunctionLambda = (area) -> area < 4;
		logJava.info("Function Class: " + rectanguloFunctionLambda.aplicar(8));
		
		IRectanguloUnaryOperator<String> rectanguloUnaryOperatorLambda = (altura) -> altura.concat(" m^2");
		logJava.info("Unary Operator Class: " + rectanguloUnaryOperatorLambda.aplicar("6"));
		
		System.out.println("**************************************");
		
		System.out.println("Interfaces Funcionales con Métodos High Order");
		
		ConsumoMetodosHighOrder metodosHighOrder = new ConsumoMetodosHighOrder();
		
		logJava.info(metodosHighOrder.consumirSupplier2(() -> "Triangulo Isósceles"));
		
		metodosHighOrder.consumirConsumer2((lado) -> System.out.println(lado), 5);
		
		logJava.info(metodosHighOrder.consumirPredicate2((diametro) -> diametro.equals("6"), "6"));
		
		logJava.info(metodosHighOrder.consumirFunction2((area) -> area.toString().concat(" es el área"), 12));
		
		logJava.info(metodosHighOrder.consumirUnaryOperator((volumen) -> volumen.concat("Es el volumen en m^3"), "1264.1234"));
		
		/*// SUPPLIER
		
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
		logJava.info("Prueba Function Lambda: " + unaryLambda.apply("Daniel"));*/
	
	}

}
