package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Paillier {
	
	private BigInteger p, q, n, ns, m, g, mu, lambda;
	private String filename;
	private ArrayList<BigInteger> encryptedVotes;
	
	public Paillier(int p, int q, String g, String filename){
		
		this.p = BigInteger.valueOf(p);
		this.q = BigInteger.valueOf(q);
		this.g = new BigInteger(g);
		this.filename = filename;
		encryptedVotes = new ArrayList<BigInteger>();
		n = this.p.multiply(this.q);
		ns = n.multiply(n);
		
	}
	
	public ArrayList<BigInteger> extractVotes(){
		Scanner inFile = null;
		String votes;
		try {
			inFile = new Scanner(new FileReader(filename));

		} catch (FileNotFoundException e) {
			System.out.println();
			e.printStackTrace();
		}

		while (inFile.hasNext()) {
			votes = inFile.next();
			//System.out.println(votes);
			encryptedVotes.add(new BigInteger(votes));
		}
		
		return encryptedVotes;
	}
	
	public BigInteger numberOfVotes(){
		
		BigInteger c = new BigInteger("1");
		for(int i=0; i<encryptedVotes.size(); i++){
			c = c.multiply(encryptedVotes.get(i));
		}
		c = c.mod(ns);
		System.out.println("nbrvotes: "+c);
		return c;
	}
	
	public void calculateMuAndLambda(){
		BigInteger temp1, temp2;
		temp1 = p.subtract(BigInteger.valueOf(1));
		temp2 = q.subtract(BigInteger.valueOf(1));
		lambda = BigInteger.valueOf(lcm(temp1.longValue(),temp2.longValue()));
		mu = g.modPow(lambda, ns);
		mu = mu.subtract(BigInteger.valueOf(1));
		mu = mu.divide(n);
		mu = mu.modInverse(n);
	
	}
	
	public BigInteger decryptVotes(BigInteger c){
		BigInteger size = BigInteger.valueOf(encryptedVotes.size());
		m = c.modPow(lambda, ns);		
		m = m.subtract(BigInteger.valueOf(1)).divide(n);	
		m = m.multiply(mu).mod(n);
		System.out.println("vtot: "+m);
		if(m.compareTo(size)>0){
			System.out.println("Vote result: "+m.subtract(n));
		}
		
		return m;
	}
	
	private static long gcd(long x, long y){
	    while (y > 0){
	        long tmp = y;
	        y = x % y; 
	        x = tmp;
	    }
	    return x;
	}
	
	private static long lcm(long x, long y){
	    return x * (y / gcd(x, y));
	}
	

}
