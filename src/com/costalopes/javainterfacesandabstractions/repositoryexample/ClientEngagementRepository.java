package com.costalopes.javainterfacesandabstractions.repositoryexample;

import com.costalopes.javainterfacesandabstractions.repositoryexample.exceptions.RepositoryException;
import com.costalopes.javainterfacesandabstractions.reveneucalculator.ClientEngagement;

public interface ClientEngagementRepository extends AutoCloseable {

	int NO_ID = 0;
	
	void add(ClientEngagement engagement) throws RepositoryException;
	
	void remove(ClientEngagement engagement) throws RepositoryException;
	
	Iterable<ClientEngagement> find(Query query) throws RepositoryException;
	
}
