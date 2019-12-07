package com.example.projetmobile4a.Model;


//Les variables doivent avoir le même nom que ceux de l'API !! (Sinon SerailizeName)

public class MyList {
    private String Nom;
    private String ImageURL;
    private String Status;
    private String Race;
    private String Planete;
    private String Univers;
    private String Groupe;
    private String Capacite;
    private String Description;


    public String getCapacite() {
        return Capacite;
    }

    public String getDescription() {
        return Description;
    }

    public MyList(String Nom, String ImageURL, String Status, String Race, String Planete, String Univers, String Groupe, String Capacite, String Description) {
        this.Nom = Nom;
        this.ImageURL = ImageURL;
        this.Status = Status;
        this.Race = Race;
        this.Planete = Planete;
        this.Univers = Univers;
        this.Groupe = Groupe;
        this.Capacite = Capacite;
        this.Description = Description;
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

      public String getPlanete() {
          return Planete;
      }

      public String getUnivers() {
          return Univers;
      }

      public String getGroupe(){ return Groupe;}

}