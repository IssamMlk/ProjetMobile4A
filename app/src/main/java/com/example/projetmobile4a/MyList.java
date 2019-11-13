package com.example.projetmobile4a;


//Les variables doivent avoir le même nom que ceux de l'API !! (Sinon SerailizeName)

public class MyList {
    private String name;
    private String imgUrl;

    public MyList(String name, String imgUrl){
        this.name = name;
        this.imgUrl = imgUrl;
    }

    public String getName() { return name; }
    //recupere le titre/nom de l'item pour la page d'acceuil

    public String getImage() {
        return imgUrl;
    }
    //recupere l'url de l'image de l'item pour la page d'acceuil (convertie par Picasso)
}
