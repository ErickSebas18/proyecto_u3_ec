package com.uce.edu.demo.service.funcional;

import java.util.function.Consumer;
import java.util.function.Supplier;

import org.apache.log4j.Logger;

public class MainInterfacesFuncionales {

	private static Logger logJava = Logger.getLogger(MainInterfacesFuncionales.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
		
		// CCNSUMER
		
		
		// CLASES
		IPersonaConsumer<String> consumer = new PersonaConsumerImpl();
		consumer.accept("Prueba Consumer");
		
		// LAMBDAS
		IPersonaConsumer<String> consumerLambda = (cadena) -> System.out.println(cadena);
		consumerLambda.accept("Prueba Consumer Lambda");
		
		Consumer<String> consumerLambda2 = (x) -> System.out.println(x);
		consumerLambda2.accept("Consumer");
		
		// PREDICATE
		
		// CLASES
		
		// LAMBDAS

		// FUNCTION
		
		// CLASES
		
		// LAMBDAS

		// UNARYOPERATOR
		
		// CLASES
		
		// LAMBDAS
	}

}
