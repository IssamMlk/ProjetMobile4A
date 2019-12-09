package com.example.projetmobile4a.Model;

public class MyTransformationList {

    private String Stade;
    private String ImageURL;


    public MyTransformationList(String Stade, String ImageURL) {
        this.Stade = Stade;
        this.ImageURL = ImageURL;
    }

    public String getStade() {
        return Stade;
    }

    public String getImage() {
        return ImageURL;
    }

}