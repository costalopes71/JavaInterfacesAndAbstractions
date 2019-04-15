package com.costalopes.javainterfacesandabstractions.repositoryexample.impl.database;

import java.sql.ResultSet;
import java.util.Iterator;

import com.costalopes.javainterfacesandabstractions.reveneucalculator.ClientEngagement;

class DatabaseIterable implements Iterable<ClientEngagement> {

	private ResultSet resultSet;

	DatabaseIterable(final ResultSet resultSet) {
		
		this.resultSet = resultSet;
		
	}

	@Override
	public Iterator<ClientEngagement> iterator() {

		return new DatabaseIterator(resultSet);
	}

}
