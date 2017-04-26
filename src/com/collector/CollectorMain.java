package com.collector;

import com.helpfulClasses.music.Artist;

import static com.util.TestsBase.artists;

public class CollectorMain {
    public static void main(String[] args) {
        /*StringBuilder builder = new StringBuilder("[");
        artists.stream().map(artist -> artist.getName()).forEach(name -> {
            if (builder.length() > 1) {
                builder.append(", ");
            }
            builder.append(name);
        });
        builder.append("]");*/


        /*StringBuilder reduce = artists.stream().map(artist -> artist.getName())
                .reduce(new StringBuilder(), (newBuilder, name) -> {
                    if (newBuilder.length() > 1) {
                        newBuilder.append(", ");
                    }
                    newBuilder.append(name);
                    return newBuilder;
                }, (left, right) -> left.append(right));
        reduce.insert(0, "[");
        reduce.append("]");
        String result = reduce.toString();*/

     /*   StringBuilder reduce = artists.stream().map(Artist::getName)
                .collect(new StringCollector(", ", "[", "]"));*/
    }
}
