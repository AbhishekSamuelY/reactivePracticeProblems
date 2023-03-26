package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SignalType;

import java.io.IOException;

public class Exercise8 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()
    	//ReactiveSources.intNumbersFluxWithException().doOnError(e -> System.out.println("Error Occured: "+e.getMessage())).subscribe(System.out::println);

        // Print values from intNumbersFluxWithException and print a message when error happens
    	//throws error and continues execution
    	//ReactiveSources.intNumbersFluxWithException().doOnError(e -> System.out.println("Error Occured: "+e.getMessage())).subscribe(System.out::println);

        // Print values from intNumbersFluxWithException and continue on errors
    	//ReactiveSources.intNumbersFluxWithException().onErrorContinue((e,item) -> System.out.println("Error Occured: "+item)).subscribe(System.out::println);

        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
    	//ReactiveSources.intNumbersFluxWithException().onErrorResume(e -> Flux.just(-1,-2)).subscribe(System.out::println);
    	
    	ReactiveSources.intNumbersFluxWithException().doFinally(signalType -> {
    		if(signalType == SignalType.ON_COMPLETE) 
    			System.out.println("execution completed!");
    		else if(signalType == SignalType.ON_ERROR) 
    			System.out.println("execution failed");
    	}).subscribe();

        System.out.println("Press a key to end");
        System.in.read();
    }

}
