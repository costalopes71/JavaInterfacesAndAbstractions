package com.costalopes.javainterfacesandabstractions.repositoryexample.impl.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.costalopes.javainterfacesandabstractions.repositoryexample.ClientEngagementRepository;
import com.costalopes.javainterfacesandabstractions.repositoryexample.Query;
import com.costalopes.javainterfacesandabstractions.repositoryexample.exceptions.RepositoryException;
import com.costalopes.javainterfacesandabstractions.reveneucalculator.ClientEngagement;
import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class DatabaseClientEngagementRepository implements ClientEngagementRepository {

	private final Connection connection;
	private final PreparedStatement addStatement;
	private final PreparedStatement removeStatement;
	
	public DatabaseClientEngagementRepository(final Connection connection) {
		
		this.connection = connection;
		
		try {
			
			connection.createStatement().executeUpdate(
					"CREATE TABLE IF NOT EXISTS " + 
					"client_engagements (" + 
					"id INT IDENTITY," + 
					"client VARCHAR(15) NOT NULL," + 
					"hoursWorked INT NOT NULL" +
					")");
			
			addStatement = connection.prepareStatement(
					"INSERT INTO client_engagements (client, hoursWorked) VALUES (?, ?)", 
					RETURN_GENERATED_KEYS);
			
			removeStatement = connection.prepareStatement("DELETE FROM client_engagements WHERE id = ?");
			
		} catch (SQLException e) {

			throw new RepositoryException("Could not initialize repository", e);
			
		}
		
	}
	
	@Override
	public void add(ClientEngagement clientEngagement) throws RepositoryException {
		
		try {
			
			addStatement.setString(1, clientEngagement.getClient());
			addStatement.setInt(2, clientEngagement.getHoursWorked());
			addStatement.executeUpdate();
			
			final ResultSet keys = addStatement.getGeneratedKeys();
			if (keys.next()) {
				
				final int id = keys.getInt("id");
				clientEngagement.setId(id);
				
			}
			
		} catch (SQLException e) {
			
			throw new RepositoryException("Failed to add" + clientEngagement, e);
		
		}
		
	}

	@Override
	public void remove(ClientEngagement clientEngagement) throws RepositoryException {
		
		try {
			
			removeStatement.setInt(1, clientEngagement.getId());
			if (removeStatement.executeUpdate() > 0) {
				clientEngagement.setId(NO_ID);
			}
			
		} catch (SQLException e) {

			throw new RepositoryException("Failed to remove " + clientEngagement, e);
			
		}
		
	}

	@Override
	public Iterable<ClientEngagement> find(Query query) throws RepositoryException {

		try {
			
			final Statement statement = connection.createStatement();
			final ResultSet resultSet = statement.executeQuery(
					"SELECT * " +
					"FROM client_engagements " + 
					"WHERE " + generateWhere(query));
			
			return new DatabaseIterable(resultSet);
			
		} catch (SQLException e) {

			throw new RepositoryException("Failed to query: " + query, e);
			
		}
		
	}

	private String generateWhere(Query query) {

		final StringBuilder builder = new StringBuilder();
		
		final boolean hasClientClause = query.getClient() != null;
		if (hasClientClause) {
			
			builder.append("client = '")
				.append(query.getClient())
				.append("'");
			
		}
		
		final boolean hasHoursWorkedClause = query.getAtLeastHoursWorked() > 0;
		if (hasHoursWorkedClause) {
			
			if (hasClientClause) {
				
				builder.append(" and ");
				
			}

			builder.append(" hoursWorked > ")
			.append(query.getAtLeastHoursWorked());
			
		}
		
		if (!hasClientClause && !hasHoursWorkedClause) {
			
			return "true";
			
		}
		
		return builder.toString();
	}

	@Override
	public void close() throws RepositoryException {
		
		try {
			
			connection.close();
			
		} catch (SQLException e) {

			throw new RepositoryException("Failed to close DB connection", e);
			
		}
		
	}
	
}
