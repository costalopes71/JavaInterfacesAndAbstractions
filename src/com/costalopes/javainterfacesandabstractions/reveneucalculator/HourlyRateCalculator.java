package com.costalopes.javainterfacesandabstractions.reveneucalculator;

public class HourlyRateCalculator extends ReveneuCalculator {

	public static final double STANDARD_HOURLY_RATE = 50;
	
	private final double hourlyRate;
	
	public HourlyRateCalculator(double hourlyRate) {
		
		this.hourlyRate = hourlyRate;
		
	}

	@Override
	public double calculate(ClientEngagement clientEngagement) {
		
		return clientEngagement.getHoursWorked() * hourlyRate;
		
	}

}
