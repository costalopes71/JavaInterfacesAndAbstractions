package com.costalopes.javainterfacesandabstractions.repositoryexample.impl.csv;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.costalopes.javainterfacesandabstractions.repositoryexample.ClientEngagementRepository;
import com.costalopes.javainterfacesandabstractions.repositoryexample.Query;
import com.costalopes.javainterfacesandabstractions.repositoryexample.exceptions.RepositoryException;
import com.costalopes.javainterfacesandabstractions.reveneucalculator.ClientEngagement;

public class CsvClientEngagementRepository implements ClientEngagementRepository {

	private final List<ClientEngagement> engagements;
	private final CsvPersistor persistor;
	private int nextId = 1;
	
	public CsvClientEngagementRepository(final String path) {
		
		persistor = new CsvPersistor(path);
		engagements = persistor.load();
		
	}
	
	@Override
	public void add(ClientEngagement clientEngagement) throws RepositoryException {
		
		if (clientEngagement.getId() == NO_ID) {
			engagements.add(clientEngagement);
			clientEngagement.setId(nextId ++);
		}
		
	}

	@Override
	public void remove(ClientEngagement engagementToRemove) throws RepositoryException {

		if (engagements.removeIf(engagement -> engagement.getId() == engagementToRemove.getId())) {
			engagementToRemove.setId(NO_ID);
		}
		
	}

	@Override
	public Iterable<ClientEngagement> find(Query query) throws RepositoryException {

		return engagements.stream()
				.filter(filterOf(query))
				.collect(Collectors.toList());
		
	}
	
	private Predicate<? super ClientEngagement> filterOf(Query query) {

		final String client = query.getClient();
		return engagement -> engagement.getHoursWorked() >= query.getAtLeastHoursWorked() && 
							 (client ==null || engagement.getClient().equals(client));
	}

	@Override
	public void close() throws Exception {
		
		persistor.save(engagements);
		
	}
	
}
