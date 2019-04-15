package com.costalopes.javainterfacesandabstractions.repositoryexample;

public class Query {

	private String client;
	private int atLeastHoursWorked;

	public String getClient() {
		return client;
	}

	public Query client(String client) {
		this.client = client;
		
		return this;
	}

	public int getAtLeastHoursWorked() {
		return atLeastHoursWorked;
	}

	public Query atLeastHoursWorked(int atLeastHoursWorked) {
		this.atLeastHoursWorked = atLeastHoursWorked;
		
		return this;
	}

}
