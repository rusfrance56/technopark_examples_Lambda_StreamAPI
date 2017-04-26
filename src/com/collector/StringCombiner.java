package com.collector;

public class StringCombiner {
    private StringBuilder builder = new StringBuilder();
    private String prefix;
    private String delim;
    private String suffix;

    public StringCombiner(String prefix, String delim, String suffix) {
        this.prefix = prefix;
        this.delim = delim;
        this.suffix = suffix;
    }

    public StringCombiner add(String element) {
        if (builder.length() == 0) {
            builder.append(prefix);
        } else {
            builder.append(delim);
        }
        builder.append(element);
        return this;
    }

    public StringCombiner merge(StringCombiner other) {
        builder.append(other.builder);
        return this;
    }

    @Override
    public String toString() {
        return prefix + builder.toString() + suffix;
    }
}
