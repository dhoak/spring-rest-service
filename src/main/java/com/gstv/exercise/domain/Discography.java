package com.gstv.exercise.domain;

import java.util.List;

/**
 * Created by davidhoak on 8/20/15.
 */
public class Discography {

    private Artist artist;
    private List<Album> albums;

    public Discography() {

    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}
