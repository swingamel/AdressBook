package en.iut.debeaulieu.adressbook.classes;

public class Personne {
    public String nom;
    public String prenom;
    public String adresse;

    public Personne() {
        this.nom = "";
        this.prenom = "";
        this.adresse = "";
    }

    public Personne(String nom, String prenom, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }
    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public String getAdresse() { return this.adresse; }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String toString() {
        return this.nom + " " + this.prenom + " " + this.adresse;
    }
}