package en.iut.debeaulieu.adressbook.classes;

import java.io.*;

public class Carnet {

    public final Personne[] personneList = new Personne[10];

    // Ajouter une personne
    public void AjouterUnePersonne(Personne personne) {
        int pers = this.personneList.length;//

        for (int i = 0; i < pers; i++) { //
            if (this.personneList[i] == null) {
                this.personneList[i] = personne;
                break;
            }
        }
    }

    //Supprimer une personne
    public void supprimerUnePersonne(Personne personne) {
        for (int i = 0; i < this.personneList.length; i++) {
            if (this.personneList[i] == personne) {
                this.personneList[i] = null; //
                break;
            }
        }
    }

    // Voir la liste des personnes
    public void voirCarnet() {
        int pers = this.personneList.length;

        for (int i = 0; i < pers; i++) {
            if (this.personneList[i] != null) {
                System.out.println(i + ":" + this.personneList[i].toString());
            }
        }
    }

    //sauvegarder dans un fichier
    public void sauvegarderCarnet() {
        try {
            FileWriter fw = new FileWriter("carnet.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < this.personneList.length; i++) {
                if (this.personneList[i] != null) {
                    bw.write(this.personneList[i].toString());
                    bw.newLine();
                }
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //carnet vide
    public boolean carnetVide() {
        for (int i = 0; i < this.personneList.length; i++) {
            if (this.personneList[i] != null) {
                return false;
            }
        }
        return true;
    }

    //importer un fichier
    public void importer() {
        try {
            FileReader fr = new FileReader("carnet.txt");
            BufferedReader br = new BufferedReader(fr);
            String ligne = br.readLine();
            String[] tab;
            while (ligne != null) {
                tab = ligne.split(" ");
                Personne p = new Personne(tab[0], tab[1], tab[2]);
                this.AjouterUnePersonne(p);
                ligne = br.readLine();
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //recherche dynamique
    public void rechercheDynamique(String recherche) {
        for (int i = 0; i < this.personneList.length; i++) {
            if (this.personneList[i] != null) {
                if (this.personneList[i].getNom().contains(recherche) || this.personneList[i].getPrenom().contains(recherche) || this.personneList[i].getAdresse().contains(recherche)) {
                    System.out.println(this.personneList[i].toString());
                }
            }
        }
    }

    //jeux de test
    public void jeuxDeTest() {
        Personne p1 = new Personne("Bourgeois", "Agnes", "valadon");
        Personne p2 = new Personne("Bogusz", "Thierry", "retraite");
        Personne p3 = new Personne("Pasqualini", "Claude", "retraite");
        Personne p4 = new Personne("Jaouen", "Francoise", "valadon");
        Personne p5 = new Personne("Garnier", "Tristan", "Neop");
        Personne p6 = new Personne("Paulhiac", "Quentin", "Neop");
        Personne p7 = new Personne("Laporte", "Benjamin", "Neop");
        Personne p8 = new Personne("Marcuzzi", "Quentin", "iut");
        Personne p9 = new Personne("Nouillaguet", "Jeremy", "valadonIut");
        this.AjouterUnePersonne(p1);
        this.AjouterUnePersonne(p2);
        this.AjouterUnePersonne(p3);
        this.AjouterUnePersonne(p4);
        this.AjouterUnePersonne(p5);
        this.AjouterUnePersonne(p6);
        this.AjouterUnePersonne(p7);
        this.AjouterUnePersonne(p8);
        this.AjouterUnePersonne(p9);
    }

    //fontion trier par nom et prenom

    public void trieInsertionParNom() {
        Personne temp;
        for (int i = 0; i < this.personneList.length; i++) {
            for (int j = 0; j < this.personneList.length; j++) {
                if (this.personneList[i] != null && this.personneList[j] != null) {
                    if (this.personneList[i].getNom().compareTo(this.personneList[j].getNom()) < 0) {
                        temp = this.personneList[i];
                        this.personneList[i] = this.personneList[j];
                        this.personneList[j] = temp;
                    }
                }
            }
        }
    }

    public void trieInsertionParPrenom() {
        Personne personne;
        for (int i = 0; i < this.personneList.length; i++) {
            for (int j = 0; j < this.personneList.length; j++) {
                if (this.personneList[i] != null && this.personneList[j] != null) {
                    if (this.personneList[i].getPrenom().compareTo(this.personneList[j].getPrenom()) < 0) {
                        personne = this.personneList[i];
                        this.personneList[i] = this.personneList[j];
                        this.personneList[j] = personne;
                    }
                }
            }
        }
    }

    public void trieInsertionParAdresse() {
        Personne p;
        for (int i = 0; i < this.personneList.length; i++) {
            for (int j = 0; j < this.personneList.length; j++) {
                if (this.personneList[i] != null && this.personneList[j] != null) {
                    if (this.personneList[i].getAdresse().compareTo(this.personneList[j].getAdresse()) < 0) {
                        p = this.personneList[i];
                        this.personneList[i] = this.personneList[j];
                        this.personneList[j] = p;
                    }
                }
            }
        }
    }

    public void trieInsertionParNomEtPrenom() {
        Personne temp;
        for (int i = 0; i < this.personneList.length; i++) {
            for (int j = 0; j < this.personneList.length; j++) {
                if (this.personneList[i] != null && this.personneList[j] != null) {
                    if (this.personneList[i].getNom().compareTo(this.personneList[j].getNom()) < 0 || this.personneList[i].getPrenom().compareTo(this.personneList[j].getPrenom()) < 0) {
                        temp = this.personneList[i];
                        this.personneList[i] = this.personneList[j];
                        this.personneList[j] = temp;
                    }
                }
            }
        }
    }

    public void rechercheParNom(String recherche) {
        trieInsertionParNom();
        int strart = 0;
        int end = this.personneList.length - 1;
        int milieu = (strart + end) / 2;
        while (strart <= end) {
            if (this.personneList[milieu].getNom().compareTo(recherche) < 0) {
                strart = milieu;
            } else if (this.personneList[milieu].getNom().compareTo(recherche) == 0) {
                System.out.println(this.personneList[milieu].toString());
                break;
            } else {
                end = milieu;
            }
            milieu = (strart + end) / 2;
        }
        if (strart > end) {
            System.out.println("Personne non trouvée");
        }
    }

    public void RechercheParNomEtPrenom(String recherche) {
        int min = 0;
        int max = 0;
        for (Personne personne : this.personneList) {
            if (personne != null) max++;
        }
        max--;
        int milieu = (min + max) / 2;
        while (min <= max) {
            if (this.personneList[milieu].getNom().compareTo(recherche) < 0 || this.personneList[milieu].getPrenom().compareTo(recherche) < 0) {
                min = milieu;
            } else if (this.personneList[milieu].getNom().compareTo(recherche) == 0 || this.personneList[milieu].getPrenom().compareTo(recherche) == 0) {
                System.out.println(this.personneList[milieu].toString());
                break;
            } else {
                max = milieu;
            }
            milieu = (min + max) / 2;
        }
        if (min > max) {
            System.out.println("Personne non trouvée");
        }
    }

    public void rechercheParPrenom(String recherche) {
        trieInsertionParPrenom();
        int min = 0;
        int max = this.personneList.length - 1;
        int milieu = (min + max) / 2;
        while (min <= max) {
            if (this.personneList[milieu].getPrenom().compareTo(recherche) < 0) {
                min = milieu;
            } else if (this.personneList[milieu].getPrenom().compareTo(recherche) == 0) {
                System.out.println(this.personneList[milieu].toString());
                break;
            } else {
                max = milieu;
            }
            milieu = (min + max) / 2;
        }
        if (min > max) {
            System.out.println("Personne non trouvée");
        }
    }

    public void rechercheParAdresse(String recherche) {
        trieInsertionParAdresse();
        int min = 0;
        int max = this.personneList.length - 1;
        int milieu = (min + max) / 2;
        while (min <= max) {
            if (this.personneList[milieu].getAdresse().compareTo(recherche) < 0) {
                min = milieu;
            } else if (this.personneList[milieu].getAdresse().compareTo(recherche) == 0) {
                System.out.println(this.personneList[milieu].toString());
                break;
            } else {
                max = milieu;
            }
            milieu = (min + max) / 2;
        }
        if (min > max) {
            System.out.println("Personne non trouvée");
        }
    }
}