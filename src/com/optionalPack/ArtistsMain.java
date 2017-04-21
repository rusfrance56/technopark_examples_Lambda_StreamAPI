package com.optionalPack;

import com.helpfulClasses.music.Artist;

import java.util.ArrayList;
import java.util.List;

public class ArtistsMain {
    public static void main(String[] args) {
        List<Artist> artists = new ArrayList<>();
        artists.add(new Artist("McCartny"));
        artists.add(new Artist("McCartny"));
        Artists artists1 = new Artists(artists);

        artists1.getArtist(-1);
        artists1.getArtist(0);
        artists1.getArtistName(-1);
        artists1.getArtistName(0);
    }
}
