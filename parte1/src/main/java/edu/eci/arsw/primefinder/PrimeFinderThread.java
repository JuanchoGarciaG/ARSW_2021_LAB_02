package edu.eci.arsw.primefinder;

import java.util.LinkedList;
import java.util.List;

public class PrimeFinderThread extends Thread{

	
	int a,b;
	
	private List<Integer> primes;
	
	public PrimeFinderThread(int a, int b, List<Integer> primes) {
		super();
		this.a = a;
		this.b = b;
		this.primes = primes;
	}

	public void run(){
		for (int i=a;i<=b;i++){						
			if (isPrime(i)){
				primes.add(i);
				System.out.println("Prime: "+i+"\n");
			}
		}
		
		
	}
	
	boolean isPrime(int n) {
	    if (n%2==0) return false;
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}

	
	
	
	
}
