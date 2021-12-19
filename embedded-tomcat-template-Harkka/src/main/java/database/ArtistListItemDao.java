package database;

import java.util.List;

import model.Artist;

/**
 * ShoppingListItemDao on rajapinta, joka määrittelee, mitä operaatioita
 * DAO-luokan on toteutattava.
 */
public interface ArtistListItemDao {

    public List<Artist> getAllArtists();

    public Artist getItem(long id);
    
    public boolean addItem(Artist newItem);

    // Remove pois kommentoitu 
    //public boolean removeArtist(Artist item);
}