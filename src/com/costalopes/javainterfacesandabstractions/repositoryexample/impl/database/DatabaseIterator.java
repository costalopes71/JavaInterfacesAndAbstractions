package com.costalopes.javainterfacesandabstractions.repositoryexample.impl.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import com.costalopes.javainterfacesandabstractions.repositoryexample.exceptions.RepositoryException;
import com.costalopes.javainterfacesandabstractions.reveneucalculator.ClientEngagement;

class DatabaseIterator implements Iterator<ClientEngagement> {

	private ResultSet resultSet;

	DatabaseIterator(final ResultSet resultSet) {
		
		this.resultSet = resultSet;
		
	}

	@Override
	public boolean hasNext() {

		try {
			
			return resultSet.next();
			
		} catch (SQLException e) {

			throw new RepositoryException("Unable to iterate the result set", e);
		
		}
		
	}

	@Override
	public ClientEngagement next() {

		try {
			
			final int id = resultSet.getInt(1);
			final String client = resultSet.getString(2);
			final int hoursWorked = resultSet.getInt(3);
			ClientEngagement clientEngagement = new ClientEngagement(client, hoursWorked);
			clientEngagement.setId(id);
			return clientEngagement;
			
		} catch (SQLException e) {

			throw new RepositoryException("Unable to read engagement record", e);
		
		}

	}

}
