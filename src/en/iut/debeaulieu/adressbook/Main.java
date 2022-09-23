package en.iut.debeaulieu.adressbook;

import en.iut.debeaulieu.adressbook.classes.BinarySearch;
import en.iut.debeaulieu.adressbook.classes.Carnet;
import en.iut.debeaulieu.adressbook.classes.Personne;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Carnet carnet = new Carnet();

        carnet.jeuxDeTest();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("-----------------Menu-----------------");
            System.out.println("1 : Ajouter une personne au carnet");
            System.out.println("2 : Supprimer une personne du carnet");
            System.out.println("3 : Afficher tout le contenu du carnet");
            System.out.println("4 : Recherche avec critères");
            System.out.println("5 : Plusieurs critères en une recherche");
            System.out.println("6 : Recherche dichotomique (un seul résultat)");
            System.out.println("7 : Trier le carnet avec critères");
            System.out.println("8 : Sauvegarde du carnet");
            System.out.println("9 : Importation d'un nouveau carnet");
            System.out.println("10 : Quitter le programme");

            System.out.print("\nVotre choix : ");

            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Ajout d'une personne au carnet");
                    System.out.println("----------------------------");
                    System.out.print("Nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Prénom : ");
                    String prenom = scanner.nextLine();
                    System.out.print("Adresse : ");
                    String adresse = scanner.nextLine();
                    //confirmation de l'ajout
                    System.out.println("Ajouter la personne suivante ? (oui/non)");
                    System.out.println("Nom : " + nom);
                    System.out.println("Prénom : " + prenom);
                    System.out.println("Adresse : " + adresse);
                    String choix = scanner.nextLine();
                    if (choix.equals("oui")) {
                        carnet.AjouterUnePersonne(new Personne(nom, prenom, adresse));
                        System.out.println("Personne ajoutée au carnet.");
                    } else {
                        System.out.println("Personne non ajoutée au carnet.");
                        //demande d'ajout d'une autre personne
                        System.out.println("Souhaitez-vous ajouter une autre personne ? (oui/non)");
                        choix = scanner.nextLine();
                        if (choix.equals("oui")) {
                            carnet.AjouterUnePersonne(new Personne(nom, prenom, adresse));
                        } else if (choix.equals("non")) {
                            System.out.println("Retour au menu principal.");
                        } else {
                            System.out.println("Choix invalide.");
                        }
                    }
                    break;

                case 2:
                    if (carnet.personneList[0] == null) {
                        System.out.println("Le carnet est vide.");
                    } else {
                        System.out.println("Suppression d'une personne du carnet");
                        System.out.println("-----------------------------------");
                        carnet.voirCarnet();
                        System.out.println("Quelle personne souhaitez-vous supprimer ? (exemple : 0 pour la première personne)");
                    }
                    int place = Integer.parseInt(scanner.nextLine());

                    //confirmation de la suppression
                    System.out.println("Souhaitez vous vraiment supprimer la personne suivante ? (oui/non)");
                    System.out.println("Nom : " + carnet.personneList[place].getNom());
                    System.out.println("Prénom : " + carnet.personneList[place].getPrenom());
                    System.out.println("Adresse : " + carnet.personneList[place].getAdresse());
                    String choix1 = scanner.nextLine();
                    if (choix1.equals("oui")) {
                        carnet.supprimerUnePersonne(carnet.personneList[place]);
                        System.out.println("Personne supprimée du carnet.");
                    } else if (choix1.equals("non")) {
                        System.out.println("Personne non supprimée du carnet.");
                    } else if (carnet.personneList[place] == null) {
                        System.out.println("Cette personne n'existe pas.");
                    } else {
                        System.out.println("Choix invalide.");
                    }
                    //demande de suppression d'une autre personne
                    System.out.println("Souhaitez-vous supprimer une autre personne ? (oui/non)");
                    choix = scanner.nextLine();
                    if (choix.equals("oui")) {
                        carnet.supprimerUnePersonne(carnet.personneList[place]);
                    } else if (choix.equals("non")) {
                        System.out.println("Retour au menu principal.");
                    } else {
                        System.out.println("Choix invalide.");
                    }
                    break;

                case 3:
                    if (carnet.personneList[0] == null) {
                        System.out.println("Le carnet est vide.");
                    } else {
                        System.out.println("Affichage du contenu du carnet");
                        System.out.println("----------------------------");
                        carnet.voirCarnet();
                    }
                    break;

                case 4:
                    carnet.rechercheAvecCriteres(carnet.personneList);
                    break;
                case 5:
                    System.out.println("Plusieurs critères en une recherche");
                    System.out.println("----------------------------------");
                    carnet.recherchePlusieursCriteres();
                    System.out.println("Souhaitez-vous faire une autre recherche ? (oui/non)");
                    String choix3 = scanner.nextLine();
                    if (choix3.equals("oui")) {
                        carnet.recherchePlusieursCriteres();
                    } else if (choix3.equals("non")) {
                        System.out.println("Retour au menu principal.");
                    } else {
                        System.out.println("Choix invalide.");
                    }
                    break;

                case 6:
                    System.out.println("Recherche dichotomique");
                    System.out.println("----------------------");
                    carnet.rechercheDichotomique();
                    System.out.println("Souhaitez-vous faire une autre recherche ? (oui/non)");
                    String choix4 = scanner.nextLine();
                    if (choix4.equals("oui")) {
                        carnet.rechercheDichotomique();
                    } else if (choix4.equals("non")) {
                        System.out.println("Retour au menu principal.");
                    } else {
                        System.out.println("Choix invalide.");
                    }
                    break;

                case 7:
                    System.out.println("Trier le carnet avec critères");
                    System.out.println("-----------------------------");
                    carnet.TrieCarnetAvecCritere(carnet.personneList, 0, 0);
                    carnet.afficherPersonnesListe(carnet.personneList);
                    System.out.println("Souhaitez-vous faire un autre tri ? (oui/non)");
                    String choix5 = scanner.nextLine();
                    if (choix5.equals("oui")) {
                        carnet.TrieCarnetAvecCritere(carnet.personneList, 0, 0);
                        carnet.afficherPersonnesListe(carnet.personneList);
                    } else if (choix5.equals("non")) {
                        System.out.println("Retour au menu principal.");
                    } else {
                        System.out.println("Choix invalide.");
                    }
                    break;

                case 8:
                    System.out.println("Sauvegarde du carnet");
                    System.out.println("--------------------");
                    carnet.sauvegarderCarnet();
                    System.out.println("Souhaitez-vous faire une autre sauvegarde ? (oui/non)");
                    String choix6 = scanner.nextLine();
                    if (choix6.equals("oui")) {
                        carnet.sauvegarderCarnet();
                    } else if (choix6.equals("non")) {
                        System.out.println("Retour au menu principal.");
                    } else {
                        System.out.println("Choix invalide.");
                    }
                    break;

                case 9:
                    System.out.println("Chargement du carnet");
                    System.out.println("--------------------");
                    carnet.importer();
                    System.out.println("Souhaitez-vous faire un autre chargement ? (oui/non)");
                    String choix7 = scanner.nextLine();
                    if (choix7.equals("oui")) {
                        carnet.importer();
                    } else if (choix7.equals("non")) {
                        System.out.println("Retour au menu principal.");
                    } else {
                        System.out.println("Choix invalide.");
                    }
                    break;

                default:
                    System.out.println("Veuillez entrer un nombre entre 1 et 7 !");
            }
        }
        while (choice != 9);
    }
}