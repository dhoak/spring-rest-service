# spring-rest-service

The objective of this project was to write a webservice in Java that makes use of the LastFM API (http://www.last.fm/api).  The service will take in a String that is a recording artist’s name and return back in JSON format, the top 10 albums by that artist listing the individual tracks for each album.  Keep in mind we are a Spring/REST environment.

At the time of creation, the LastFM API was down due to site maintenance, so the Spotify Web API was used instead.  There are several differences between the Last.fm and Spotify APIs, but most notably is Spotify's lack of a Top Albums service call.  This ranking can still be achieved using Spotify's API, but would be an incredibly expensive call to make, For this reason, I chose to use Spotify's album service to display the 10 most recent albums for a given artist.

This application was written using Spring Boot in order to leverage it's embedded tomcat server as well as it's opinionated view of building Spring applications.

Once cloning the repo, run the following maven command from the root directory to startup the server:

mvn spring-boot:run

After the server has started, navigate to the following url to test the webservice: http://localhost:8080/discography/bruno%20mars/albums/last10
