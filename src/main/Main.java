package main;

import java.math.BigInteger;

public class Main {
	
	public static void main (String args[]){
		
		Paillier p = new Paillier(1117,1471,"652534095028","votes.txt");
		p.extractVotes();
		BigInteger test = p.numberOfVotes();
		p.calculateMuAndLambda();
		p.decryptVotes(test);
		
	}
	


}
