package com.gstv.exercise.domain.spotify;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by davidhoak on 8/20/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrackSearch {

    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
