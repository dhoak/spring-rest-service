package com.gstv.exercise.domain.spotify;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * Created by davidhoak on 8/20/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArtistSearch {

    public Artists artists;

    public Artists getArtists() {
        return artists;
    }

    public void setArtists(Artists artists) {
        this.artists = artists;
    }
}
