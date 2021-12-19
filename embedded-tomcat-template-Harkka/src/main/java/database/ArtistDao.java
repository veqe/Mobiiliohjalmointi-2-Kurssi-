package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Artist;

public class ArtistDao implements ArtistListItemDao {
	
	private database db = new database();
	
	@Override
	public List<Artist> getAllArtists() {
		String selectAll = "SELECT ArtistId, Name FROM Artist ORDER BY Name ASC;";
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		
		List<Artist> allArtists = new ArrayList<>();
		
		try {
			// yhteys tietokantaan
			connection = db.connect();
			//kysely muodostetaan
			statement = connection.prepareStatement(selectAll);
			//Kyselyn suoritus
			results = statement.executeQuery();
			
			// käydään läpi
			while(results.next()) {
				long id = results.getLong("ArtistId");
				String name = results.getString("Name");
				
				Artist newItem = new Artist(id, name);
				
				//listalle lisäys
				allArtists.add(newItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.db.close(connection, statement, results);
		}
		return allArtists;
	}
	
	@Override
	public Artist getItem(long id) {
		List<Artist> allItems = this.getAllArtists();
		for (Artist item : allItems) {
			if ( id == item.getId()) {
				return item;
			}
		}
		return null;
	}
	
	@Override
	public boolean addItem(Artist newItem) {
		String sql = "INSERT INTO Artist (name) VALUES (?)";
		
		Connection connection = null;
        PreparedStatement statement = null;
        ResultSet ids = null;
        
        try {
        	connection = this.db.connect();
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, newItem.getName());
            int rows = statement.executeUpdate();
            if( rows == 1) {
            	ids = statement.getGeneratedKeys();
            	ids.next();
            	long generatedId = ids.getLong(1);
            	newItem.setId(generatedId);
            	return true;
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        } finally {
        	this.db.close(connection, statement, ids);
        }
        return false;
	}
	
	/* Remove pois kommentoitu 
	@Override
	public boolean removeArtist(Artist item) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = this.db.connect();
			statement = connection.prepareStatement("DELETE FROM Artist WHERE id = ?");
			statement.setLong(1, item.getId());
			int rows = statement.executeUpdate();
			if(rows == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.db.close(connection, statement, null);
		}
		return false;
	}
	*/
}
