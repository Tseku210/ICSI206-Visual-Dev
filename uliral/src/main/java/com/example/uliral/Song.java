package com.example.uliral;

public class Song {
    private int id;
    private String title;
    private String artist;
    private double star;
    private String length;
    private String image;

    public Song(String title, String artist, double star, String length, String image) {
        this.title = title;
        this.artist = artist;
        this.star = star;
        this.length = length;
        this.image = image;
    }

    public Song(int id, String title, String artist, double star, String length, String image) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.star = star;
        this.length = length;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public double getStar() {
        return star;
    }

    public void setStar(double star) {
        this.star = star;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
