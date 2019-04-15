package com.costalopes.javainterfacesandabstractions.reveneucalculator;

public class FixedFeeCalculator extends ReveneuCalculator {

	public static final double STANDARD_FEE = 500;
	
	private final double fee;
	
	public FixedFeeCalculator(double fee) {
		
		this.fee = fee;
		
	}

	@Override
	public double calculate(ClientEngagement clientEngagement) {
		
		return fee;
		
	}

}
