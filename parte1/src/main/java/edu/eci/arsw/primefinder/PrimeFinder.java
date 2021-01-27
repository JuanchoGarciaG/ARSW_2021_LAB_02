package edu.eci.arsw.primefinder;

import java.util.LinkedList;
import java.util.List;

public class PrimeFinder {

    int a,b, numThreads;
    private List<Integer> primes =new LinkedList<Integer>();
    private PrimeFinderThread[] listThreads;

    public PrimeFinder(int a, int b, int numThreads) {
        this.a = a;
        this.b = b;
        this.numThreads = numThreads;
        this.listThreads = new PrimeFinderThread[numThreads];
    }

    public List<Integer> find(){
        int totalNumbers = b-a;
        int range = totalNumbers/numThreads;
        int remaining = totalNumbers % numThreads;

        for (int i=0; i<numThreads; i++){
            int initialNumber = i*range;
            int finalRange = initialNumber +range;
            int lastNumber = (i != numThreads-1) ? finalRange : finalRange +remaining;
            listThreads[i] = new PrimeFinderThread(initialNumber,lastNumber,primes);
            listThreads[i].start();
        }
        for(PrimeFinderThread t : listThreads){
            try {
                t.join();
            }catch (InterruptedException e){
                t.interrupt();
            }
        }
        return primes;
    }



}
