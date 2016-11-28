package main;

import java.math.BigInteger;

public class Main {
	
	public static void main (String args[]){
		
		Paillier p = new Paillier(1117,1471,"652534095028","votes.txt");
		p.extractVotes();
		BigInteger test = p.numberOfVotes();
		p.calculateMuAndLambda();
		p.decryptVotes(test);
		
/*		BigInteger p, q, n, r, g, ns, test;
		BigInteger c1,c2,c3, c;
		BigInteger my, lambda, m;
		BigInteger temp1, temp2;
		BigInteger lambda2;
		g = new BigInteger("867");
		p = new BigInteger("5");
		q = new BigInteger("7");
		n = p.multiply(q);
		ns = n.multiply(n);
		c1 = new BigInteger("929");
		c2 = new BigInteger("296");
		c3 = new BigInteger("428");
		
		
		temp1 = p.subtract(BigInteger.valueOf(1));
		temp2 = q.subtract(BigInteger.valueOf(1));
		lambda = BigInteger.valueOf(lcm(temp1.longValue(),temp2.longValue()));
		
		my = g.modPow(lambda, ns);
		my = my.subtract(BigInteger.valueOf(1));
		my = my.divide(n);
		my = my.modInverse(n);
		
		
		c = c1.multiply(c2).multiply(c3);
		c = c.mod(ns);
		
		//Decrypt
		m = c.modPow(lambda, ns);
	
		m = m.subtract(BigInteger.valueOf(1));
		m = m.divide(n);
		
		m = m.multiply(my).mod(n);
		m = m.subtract(n);
		System.out.println(m);*/
		
	}
	


}
