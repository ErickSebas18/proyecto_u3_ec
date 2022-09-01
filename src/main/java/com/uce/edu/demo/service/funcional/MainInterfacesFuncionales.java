package com.uce.edu.demo.service.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

public class MainInterfacesFuncionales {

	private static Logger logJava = Logger.getLogger(MainInterfacesFuncionales.class);
	
	public static  void imprimir(String cadena) {
        logJava.info("impresion: "+cadena);
    }
	
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
		
		//JAVA
		
		/*//SUPPLIER
		System.out.println("Supplier");
		Stream<String> test = Stream.generate(() -> "Erick2").limit(2);
		test.forEach((cadena) -> System.out.println("Supplier con Java" + cadena));
		
		//CONSUMER
		System.out.println("Consumer");
		List<Integer> listaNumeros = Arrays.asList(1,2,3,4,5);
		listaNumeros.forEach((numero) -> System.out.println("Consumer con Java: " + numero));
		
		//PREDICATE
		System.out.println("Predicate");
		Stream<Integer> nuevaLista = listaNumeros.stream().filter(numero -> numero >= 3);
		nuevaLista.forEach(numero -> System.out.println(numero));
	
		//FUNCTION
		System.out.println("Function");
		Stream<String> listaCambiada = listaNumeros.stream().map(numeroLista -> {
			Integer valor = numeroLista+1;
			String cadena = "Num: " + valor.toString();
			return cadena;
		});
		
		listaCambiada.forEach((numero) -> imprimir(numero));*/
		
		
		System.out.println("\nSupplier con Java");
		Stream<Integer> supplierJava = Stream.generate(() -> 45 + 2).limit(1);
		supplierJava.forEach((edad)-> System.out.println("El año de la persona es: " + edad));
		
		System.out.println("\nConsumer con Java");
		List<String> nombres = Arrays.asList("Erick", "David", "Paúl");
		nombres.forEach((nombre) -> System.out.println("La longitud de " + nombre + " es: " + nombre.length()));
		
		System.out.println("\nPredicate con Java");
		Stream<String> letra = nombres.stream().filter((nombre) -> nombre.charAt(1) == 'r');
		letra.forEach((e) -> System.out.println("El nombre que contiene una r es: " + e));
		
		System.out.println("\nPredicate con Java");
		Stream<String> listaNombre = nombres.stream().map( nombre -> {
			String nombreCompleto = "Villavicencio " + nombre;
			return nombreCompleto;
		});
		listaNombre.forEach((e) -> System.out.println("Los nombres con apellido Villavicencio son: " + e));
		
	}

}
