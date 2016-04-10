package com.cnkaptan.popularmovies.data;

import android.net.Uri;
import android.test.AndroidTestCase;

/**
 * Created by cnkaptan on 09/04/16.
 */
public class TestMovieContract extends AndroidTestCase{

    // intentionally includes a slash to make sure Uri is getting quoted correctly
    private static final String TEST_MOVIE_URI = "deneme123";



    public void testBuildWeatherLocation() {
        Uri locationUri = MovieContract.MovieEntry.buildMovieWithMovieId(TEST_MOVIE_URI);
        assertNotNull("Error: Null Uri returned.  You must fill-in buildWeatherLocation in " +
                        "WeatherContract.",
                locationUri);
        assertEquals("Error: Weather location not properly appended to the end of the Uri",
                TEST_MOVIE_URI, locationUri.getLastPathSegment());
        assertEquals("Error: Weather location Uri doesn't match our expected result",
                locationUri.toString(),
                "content://com.cnkaptan.popularmovies/movie/deneme123");
    }
}
