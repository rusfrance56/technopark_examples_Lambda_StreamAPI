package com.helpfulClasses.music;

import java.util.ArrayList;
import java.util.List;

public class Artist {
    private String name;
    private List<String> members;

    public Artist(String name) {
        this.name = name;
        this.members = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

    public boolean isSolo() {
        return members.size() == 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Artist artist = (Artist) o;

        if (name != null ? !name.equals(artist.name) : artist.name != null) return false;
        return members != null ? members.equals(artist.members) : artist.members == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (members != null ? members.hashCode() : 0);
        return result;
    }
}
