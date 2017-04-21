package com.helpfulClasses.music;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private String name;
    private List<Track> trackList;
    private Artist artist;

    public Album(String name, Artist artist) {
        this.name = name;
        this.trackList = new ArrayList<>();
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Track> getTrackList() {
        return trackList;
    }

    public void setTrackList(List<Track> trackList) {
        this.trackList = trackList;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
