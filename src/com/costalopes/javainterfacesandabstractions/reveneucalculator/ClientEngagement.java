package com.costalopes.javainterfacesandabstractions.reveneucalculator;

public class ClientEngagement {

	private final String client;
	private final int hoursWorked;
	private final double anticipatedRevenue;
	
	private int id;
	
	public ClientEngagement(final String client, final int hoursWorked) {
		this(client, hoursWorked, 0);
	}
	
	public ClientEngagement(String client, int hoursWorked, double anticipatedRevenue) {
		this.client = client;
		this.hoursWorked = hoursWorked;
		this.anticipatedRevenue = anticipatedRevenue;
	}

	public String getClient() {
		return client;
	}

	public int getHoursWorked() {
		return hoursWorked;
	}

	public double getAnticipatedRevenue() {
		return anticipatedRevenue;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "ClientEngagement [" + 
				"client=" + client + 
				", hoursWorked=" + hoursWorked + 
				", anticipatedRevenue=" + anticipatedRevenue + "]";
	}

}
