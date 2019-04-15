package com.costalopes.javainterfacesandabstractions.reveneucalculator;

import java.util.Arrays;
import java.util.List;

public class SalesPredictor {

	public static void main(String[] args) {
		
		final List<ClientEngagement> engagements = Arrays.asList(
					new ClientEngagement("Catherine's Cookies", 40, 40_000),
					new ClientEngagement("Bob's Burguer", 30, 4000),
					new ClientEngagement("Dave's Burguer", 25, 1000),
					new ClientEngagement("Susan's Sausages", 10, 2000)
				);
			
		System.out.println("Fixed Fee");
		ReveneuCalculator calculator = new FixedFeeCalculator(FixedFeeCalculator.STANDARD_FEE);
		printTotalRevenue(engagements, calculator);
		
		System.out.println("Hourly Rate");
		calculator = new HourlyRateCalculator(HourlyRateCalculator.STANDARD_HOURLY_RATE);
		printTotalRevenue(engagements, calculator);
		
		System.out.println("Royalty Share");
		calculator = new RoyaltyShareCalculator(RoyaltyShareCalculator.STANDARD_ROYALTY_PERCENTAGE);
		printTotalRevenue(engagements, calculator);
		
	}

	private static void printTotalRevenue(List<ClientEngagement> engagements, ReveneuCalculator calculator) {

		double total = 0;
		for (ClientEngagement clientEngagement : engagements) {
			
			total += calculator.calculate(clientEngagement);
			
		}
		
		System.out.println("total = " + total);
		
	}
	
}
