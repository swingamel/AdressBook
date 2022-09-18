package en.iut.debeaulieu.adressbook;

import en.iut.debeaulieu.adressbook.classes.Personne;
import en.iut.debeaulieu.adressbook.classes.Carnet;

import java.util.Scanner;

public class Main {

    private static String nom;

    public static void main(String[] args) {
        Carnet carnet = new Carnet();
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (true) {
            label44:
            while (choice != 4) {
                sc.reset();
                System.out.println("-------------------------Menu-------------------------");
                System.out.println("1.Ajouter une Personne");
                System.out.println("2.Supprimer une fiche");
                System.out.println("3.Rechercher une fiche");
                System.out.println("4.Afficher les personnes");
                System.out.println("5.Quitter");
                System.out.println("Taper votre choix :");
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        String nom = "";
                        String prenom = "";
                        String adresse = "";
                        System.out.println("Veuillez entrer votre nom :");
                        nom = sc.nextLine();
                        System.out.println("Veuillez entrer votre prenom :");
                        prenom = sc.nextLine();
                        System.out.println("Veuillez entrer votre adresse :");
                        adresse = sc.nextLine();

                        try {
                            carnet.AjouterUnePersonne(new Personne(nom, prenom, adresse));
                        } catch (Exception var10) {
                            System.out.println("Erreur!!!");
                        }
                        break;
                    case 2:
                        System.out.print("\n Veillez entrer l'index de la personne à supprimer: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        try {
                            carnet.supprimerUnePersonne(id);
                        } catch (Exception var9) {
                            System.out.println("\n Error: " + var9.getMessage());
                        }
                        break;
                    case 3:
                        break;
                    case 4:
                        //voir le contenu

                        carnet.voirCarnet();
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("\n This choice is not valid!");
                }
            }

            sc.close();
            return;
        }
    }
}