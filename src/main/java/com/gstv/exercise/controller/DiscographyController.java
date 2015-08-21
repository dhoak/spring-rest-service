package com.gstv.exercise.controller;

import com.gstv.exercise.domain.BaseResponse;
import com.gstv.exercise.domain.Error;
import com.gstv.exercise.service.AlbumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by davidhoak on 8/20/15.
 */
@RestController
@RequestMapping("/discography")
public class DiscographyController {

    public static final Logger log = LoggerFactory.getLogger(DiscographyController.class);

    @Autowired
    AlbumService albumService;

    /**
     * This method acts as the api endpoint for retrieving the top 10 ablums for a specified artist.
     * @param artist
     * @return
     */
    @RequestMapping("/{artist}/albums/last10")
    public BaseResponse getArtistLast10Albums(@PathVariable(value="artist") String artist)
    {
        BaseResponse response = new BaseResponse();
        try{
            response.setData(albumService.getLast10AlbumsByArtist(artist));
        }
        catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            response.setStatus("error");
            response.setData(new Error(e.getMessage()));
        }

        return response;
    }

}
