package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("What is the win limit? ");
		int winLimit = in.nextInt();
		
		System.out.println("What is the win chance (as a decimal)? ");
		double winChance = in.nextDouble();
		
		System.out.println("What is the start amount? ");
		int startAmount = in.nextInt();
		
		int veryStart = startAmount;
		
		System.out.println("How many days? ");
		int totalSimulations = in.nextInt();
		int count=1;
		int win =0;
		int lose=0;
		
		for(int i=0;i <= totalSimulations; i++) {
	startAmount = veryStart;
		while ((startAmount > 0) && (startAmount < winLimit) ) {
			
			double rand = Math.random() ;
			if (rand <= winChance) {
				startAmount++;
		
			} else {
				startAmount--;
				
			}
			
		}
		if  (startAmount <= 0) {
			System.out.println("Simulation " + count + ": You lose");
			count++;
			lose++;
			
		} else {
			System.out.println("Simulation " + count + ": You win");
			count++;
			win++;
		}
		}
		
		double expectedRuin;
		if (winChance ==.5) {
			expectedRuin = 1 - (startAmount/winLimit);
		} else {
			expectedRuin = ((Math.pow(((1-winChance)/winChance),startAmount) - Math.pow(((1-winChance)/winChance), winLimit))/(1-Math.pow(((1-winChance)/winChance), winLimit)));
		}
		System.out.println("Expected ruin rate: " + expectedRuin);
		System.out.println("Ruin rate: "  +(lose/win));
	}
		
	}

	


