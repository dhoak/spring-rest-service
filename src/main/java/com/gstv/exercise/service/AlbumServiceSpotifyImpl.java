package com.gstv.exercise.service;

import com.gstv.exercise.domain.*;
import com.gstv.exercise.domain.spotify.AlbumSearch;
import com.gstv.exercise.domain.spotify.ArtistSearch;
import com.gstv.exercise.domain.spotify.Item;
import com.gstv.exercise.domain.spotify.TrackSearch;
import com.gstv.exercise.exception.ArtistException;
import com.gstv.exercise.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidhoak on 8/20/15.
 */
@Service
public class AlbumServiceSpotifyImpl implements AlbumService {

    public static final Logger log = LoggerFactory.getLogger(AlbumServiceSpotifyImpl.class);

    /**
     * This is the driving service method that finds the artist, compiles up to the last 10 albums, and populates
     * the tracks
     *
     * @param artistName
     * @return
     * @throws ArtistException
     */
    public Discography getLast10AlbumsByArtist(String artistName) throws ArtistException
    {
        log.debug("Getting the last 10 albums for artist: " + artistName);
        Discography discography = new Discography();
        Artist artist = getArtist(artistName);
        discography.setArtist(artist);

        List<Album> albums = getAlbumsByArtist(artist);
        discography.setAlbums(albums);

        return discography;
    }

    /**
     * This method makes the call out to spotify's web api to search for a given artist.  The response is interrogated
     * to ensure an exact match based on the input.  This method does not take into consideration multiple artists with
     * same name.
     *
     * @param artistName
     * @return
     * @throws ArtistException
     */
    private Artist getArtist(String artistName) throws ArtistException {

        Artist artist = null;
        RestTemplate restTemplate = new RestTemplate();
        ArtistSearch search = restTemplate.getForObject(Constants.SPOTIFY_BASE_URL + "/search?type=artist&q=" + artistName, ArtistSearch.class);

        for (Item item : search.getArtists().getItems())
        {
            if(item.getName().equalsIgnoreCase(artistName)){
                artist = new Artist(item.getId(), item.getName());
                break;
            }
        }

        if(artist == null)
        {
            log.error("Artist is null");
            throw new ArtistException(Constants.ARTIST_ERROR_NOT_FOUND);
        }

        return artist;
    }

    /**
     * This method leverages the spotify web api to get the albums associated with a given artist.  To limit the amount
     * results, this method limits the album_type to album and the market to US.
     *
     * @param artist
     * @return
     */
    private List<Album> getAlbumsByArtist(Artist artist) {

        List<Album> albums = new ArrayList<Album>();
        RestTemplate restTemplate = new RestTemplate();
        AlbumSearch search = restTemplate.getForObject(Constants.SPOTIFY_BASE_URL + "/artists/"+ artist.getId() +"/albums?album_type=album&market=US&limit=10", AlbumSearch.class);

        for (Item item : search.getItems())
        {
            Album album = new Album(item.getId(), item.getName());
            List<Track> tracks = getAlbumTracks(album);
            album.setTracks(tracks);
            albums.add(album);
        }

        return albums;
    }

    /**
     * This method uses the spotify web api to get all of the tracks for a particular album.
     *
     * @param album
     * @return
     */
    private List<Track> getAlbumTracks(Album album) {

        List<Track> tracks = new ArrayList<Track>();
        RestTemplate restTemplate = new RestTemplate();
        TrackSearch search = restTemplate.getForObject(Constants.SPOTIFY_BASE_URL + "/albums/"+ album.getId() +"/tracks", TrackSearch.class);

        for (Item item : search.getItems())
        {
            Track track = new Track(item.getId(), item.getName(), item.getTrack_number());
            tracks.add(track);
        }

        return tracks;
    }


}