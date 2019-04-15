package com.costalopes.javainterfacesandabstractions.repositoryexample.exampleclientcode;

import com.costalopes.javainterfacesandabstractions.repositoryexample.ClientEngagementRepository;
import com.costalopes.javainterfacesandabstractions.repositoryexample.Query;
import com.costalopes.javainterfacesandabstractions.reveneucalculator.ClientEngagement;

public class Example {

	public static void main(String[] args) {
		
		ClientEngagementRepository repository = null;
		
		@SuppressWarnings({ "unused", "null" })
		final Iterable<ClientEngagement> engagements = repository.find(new Query()
				.atLeastHoursWorked(20)
				.client("Pluralsight"));
	
		for (ClientEngagement clientEngagement : engagements) {
			
			System.out.println(clientEngagement);
			
		}
		
	}
	
}
