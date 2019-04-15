package com.costalopes.javainterfacesandabstractions.reveneucalculator;

public class ReveneuCalculatorRunner {

	public static void main(String[] args) {
		
		final ClientEngagement clientEngagement = new ClientEngagement("Pluralsight", 100, 15_000);
		
		// "Hourly"
		// "FixedFee"
		// "RoyaltyPercentage"
		
		ReveneuCalculator calcultor = new FixedFeeCalculator(FixedFeeCalculator.STANDARD_FEE);
		
		final double price = calcultor.calculate(clientEngagement);
		System.out.println("price = " + price);
		
	}
	
}
