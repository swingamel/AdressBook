package en.iut.debeaulieu.adressbook;

import en.iut.debeaulieu.adressbook.classes.Personne;
import en.iut.debeaulieu.adressbook.classes.Carnet;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Carnet carnet = new Carnet();
        //POUR JEUX D'ESSAIS
        carnet.jeuxDeTest();

        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("-----------------Menu-----------------");
            System.out.println("1.Ajouter une personne dans le carnet");
            System.out.println("2.Supprimer une personne du carnet");
            System.out.println("3.Afficher toutes les personnes du carnet");
            System.out.println("4.Rechercher une personne par nom et prénom");
            System.out.println("5.Sauvegarder le carnet");
            System.out.println("6.Charger le carnet");
            System.out.println("7.Quitter");
            System.out.println("Taper votre choix :");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    String nom = "";
                    String prenom = "";
                    String adresse = "";

                    if (carnet.personneList[9] != null) {
                        System.out.println("Le carnet est plein !");
                        break;
                    } else {
                        System.out.println("Veuillez entrer votre nom :");
                        nom = sc.nextLine();
                        if (nom.equals("")) {
                            System.out.println("vous n'avez pas entré de nom.");
                            break;
                        }
                        System.out.println("Veuillez entrer votre prenom :");
                        prenom = sc.nextLine();
                        if (prenom.equals("")) {
                            System.out.println("vous n'avez pas entré de prenom.");
                            break;
                        }
                        System.out.println("Veuillez entrer votre adresse :");
                        adresse = sc.nextLine();
                        if (adresse.equals("")) {
                            System.out.println("vous n'avez pas entré d'adresse.");
                            break;
                        }

                        try {
                            carnet.AjouterUnePersonne(new Personne(nom, prenom, adresse));
                        } catch (Exception var10) {
                            System.out.println("Erreur!!!");
                        }
                    }
                    break;

                case 2:
                    if (carnet.personneList[0] == null) {
                        System.out.println("Le carnet est vide.");
                        break;
                    } else {
                        carnet.voirCarnet();
                        System.out.println("Quelle personne voulez-vous supprimer ? (exemple : 0 pour la première personne)");
                    }
                    int place = Integer.parseInt(sc.nextLine());

                    try {
                        carnet.supprimerUnePersonne(carnet.personneList[place]);
                    } catch (Exception e) {
                        System.out.println("La personne n'existe pas :(");
                    }

                    System.out.println("Personne supprimée du carnet.");
                    break;

                case 3:
                    if (carnet.personneList[0] == null) {
                        System.out.println("Il n'y a personne dans le carnet.");
                    } else {
                        carnet.voirCarnet();
                    }
                    break;

                case 4:
                    //menu de recherche
                    System.out.println("1.Recherche par nom");
                    System.out.println("2.Recherche par prénom");
                    System.out.println("3.Recherche par nom et prénom");
                    System.out.println("4.Recherche par adresse");
                    int choices = 0;
                    choices = Integer.parseInt(sc.nextLine());
                    switch (choices) {
                        case 1:
                            System.out.println("Veuillez entrer le nom de la personne que vous recherchez :");
                            String nomRecherche = sc.nextLine();
                            carnet.rechercheParNom(nomRecherche);
                            break;
                        case 2:
                            System.out.println("Veuillez entrer le prénom de la personne que vous recherchez :");
                            String prenomRecherche = sc.nextLine();
                            carnet.rechercheParPrenom(prenomRecherche);
                            break;
                        case 3:
                            System.out.println("Veuillez entrer le nom de la personne que vous recherchez :");
                            String rechercheNomPrenom = sc.nextLine();
                            carnet.RechercheParNomEtPrenom(rechercheNomPrenom);
                            break;
                        case 4:
                            System.out.println("Veuillez entrer l'adresse de la personne que vous recherchez :");
                            String rechercheAdresse = sc.nextLine();
                            carnet.rechercheParAdresse(rechercheAdresse);
                            break;

                        default:
                            System.out.println("veuillez entrez un nombre entre 1 et 4");
                    }
                    while (choice != 4) ;
                    break;

                case 5:
                    try {
                        carnet.sauvegarderCarnet();
                        System.out.println("Le carnet a été sauvegardé.");
                    } catch (Exception var10) {
                        System.out.println("Erreur lors de la sauvegarde.");
                    }
                    break;

                case 6:
                    try {
                        carnet.importer();
                        System.out.println("Le carnet a été chargé.");
                    } catch (Exception var10) {
                        System.out.println("Erreur lors du chargement.");
                    }
                    break;

                case 7:
                    try {
                        System.out.print("Merci d'avoir utilisé notre application. A bientôt !");
                    } catch (Exception var10) {
                        System.out.println("Erreur lors de la fermeture.");
                    }
                    break;

                default:
                    System.out.println("Veuillez entrer un nombre entre 1 et 7 !");
            }
        }
        while (choice != 7);
    }
}