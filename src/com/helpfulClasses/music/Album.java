package com.helpfulClasses.music;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private String name;

    private List<Track> trackList;

    public Album(String name) {
        this.name = name;
        this.trackList = new ArrayList<>();
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
}
