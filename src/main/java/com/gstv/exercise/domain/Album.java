package com.gstv.exercise.domain;

import java.util.List;

/**
 * Created by davidhoak on 8/20/15.
 */
public class Album {

    private String id;
    private String name;
    private List<Track> tracks;

    public Album(String id, String name) {

        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }
}
