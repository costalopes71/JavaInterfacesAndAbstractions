package com.costalopes.javainterfacesandabstractions.reveneucalculator;

public class RoyaltyShareCalculator extends ReveneuCalculator {

	public static final double STANDARD_ROYALTY_PERCENTAGE = 0.15;
	
	private double royaltyPercentage;
	
	public RoyaltyShareCalculator(double percentage) {
		this.royaltyPercentage = percentage;
	}

	@Override
	public double calculate(ClientEngagement clientEngagement) {

		return clientEngagement.getAnticipatedRevenue() * royaltyPercentage;
		
	}

}
