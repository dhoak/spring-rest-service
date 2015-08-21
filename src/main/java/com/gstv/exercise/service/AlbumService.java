package com.gstv.exercise.service;

import com.gstv.exercise.domain.Discography;
import com.gstv.exercise.exception.ArtistException;

/**
 * Created by davidhoak on 8/20/15.
 */
public interface AlbumService {

    Discography getLast10AlbumsByArtist(String artistName) throws ArtistException;

}
