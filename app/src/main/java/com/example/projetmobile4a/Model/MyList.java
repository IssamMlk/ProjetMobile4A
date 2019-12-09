package com.example.projetmobile4a.Model;


//Les variables doivent avoir le même nom que ceux de l'API !! (Sinon SerailizeName)

import java.util.List;

public class MyList {
    private String Nom;
    private String ImageURL;
    private String Status;
    private String Race;
    private List<MyTransformationList> Transformation;




    public MyList(String Nom, String ImageURL, String Status, String Race, List<MyTransformationList> Transformation) {
        this.Nom = Nom;
        this.ImageURL = ImageURL;
        this.Status = Status;
        this.Race = Race;
        this.Transformation = Transformation;
    }

    public String getName() {
        return Nom;
    }
    //recupere le titre/nom de l'item pour la page d'acceuil

    public String getImage() {
        return ImageURL;
    }
//recupere l'url de l'image de l'item pour la page d'acceuil (convertie par Picasso)

     public String getStatus() {
          return Status;
     }

      public String getRace() {
          return Race;
      }

      public List<MyTransformationList> getTransformation(){return Transformation;}


}