package io.javabrains.reactiveworkshop;

import java.io.IOException;

import org.reactivestreams.Subscription;

import reactor.core.Disposable;
import reactor.core.publisher.BaseSubscriber;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
    	Disposable subscription = ReactiveSources.intNumberMono().subscribe(
    			number -> System.out.println(number),
    			error -> System.out.println(error.getMessage()),
    			() -> System.out.println("completed"));
    	
    	subscription.dispose();
    	
        // Subscribe to a flux using an implementation of BaseSubscriber
        // TODO: Write code here
    	
    	ReactiveSources.intNumbersFlux().subscribe(new MySubscriber());

        System.out.println("Press a key to end");
        System.in.read();
    }

}

class MySubscriber<T> extends BaseSubscriber<T>{
	public void hookOnSubscribe(Subscription subscription) {
		System.out.println("Subscription happened");
		request(2);
	}
	
	public void hookOnNext(T value) {
		System.out.println(value.toString()+" recieved");
		request(2);
	}
	
	public void hookOnComplete() {
		System.out.println("reactive stream completed!");
	}
}