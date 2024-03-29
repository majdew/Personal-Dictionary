package com.example.personaldictionary;

public class Dictionary {
    private int id;
    private String word;
    private String mean;

    public Dictionary(String word, String mean) {
        this.word = word;
        this.mean = mean;
    }

    public Dictionary(int id, String word, String mean) {
        this.id = id;
        this.word = word;
        this.mean = mean;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }
}
