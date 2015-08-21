package com.gstv.exercise.domain.spotify;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by davidhoak on 8/20/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

    private String id;
    private String name;
    private String type;
    private int popularity;
    private int track_number;

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

    public int getPopularity() {

        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTrack_number() {
        return track_number;
    }

    public void setTrack_number(int track_number) {
        this.track_number = track_number;
    }
}
