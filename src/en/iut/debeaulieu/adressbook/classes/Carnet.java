package en.iut.debeaulieu.adressbook.classes;

import java.io.*;
import java.util.Scanner;

public class Carnet {
    public final Personne[] personneList = new Personne[10];
    private final Scanner sc = new Scanner(System.in);

    /*
     * Cette méthode permet d'ajouter une personne dans le carnet d'adresse
     */
    public void AjouterUnePersonne(Personne personne) {
        int pers = this.personneList.length;//

        for (int i = 0; i < pers; i++) { //
            if (this.personneList[i] == null) {
                this.personneList[i] = personne;
                break;
            }
        }
    }

    /*
     * Cette méthode permet de supprimer une personne du carnet d'adresse
     */
    public void supprimerUnePersonne(Personne personne) {
        for (int i = 0; i < this.personneList.length; i++) {
            if (this.personneList[i] == personne) {
                this.personneList[i] = null; //
                break;
            }
        }
    }

    /*
     * Cette méthode permet d'afficher toutes les personnes du carnet d'adresse
     */
    public void voirCarnet() {
        int pers = this.personneList.length;

        for (int i = 0; i < pers; i++) {
            if (this.personneList[i] != null) {
                System.out.println(i + ":" + this.personneList[i].toString());
            }
        }
    }

    /*
     * Cette méthode permet de rechercher une personne avec plusieurs critères
     */
    public void rechercheAvecCriteres(Personne[] personneList) {
        System.out.println("a. Recherche par nom");
        System.out.println("b. Recherche par prénom");
        System.out.println("c. Recherche par adresse");
        String[] critereRecherche = sc.nextLine().replace(" ", "").split("");
        int i = 0;
        for (Personne personne : personneList) {
            if (personne == null)
                i++;
        }
        int nbResult = personneList.length - i;

        String[] calcul = new String[critereRecherche.length * nbResult];
        boolean result = false;

        System.out.println("Veuillez entrer votre recherche :");
        String choice = sc.nextLine();

        for (Personne personne : personneList) {
            if (personne != null) {
                for (String critere : critereRecherche) {
                    for (int j = 0; j < calcul.length; j++) {
                        if (calcul[j] == null) {
                            if (critere.equals("a")) {
                                calcul[j] = personne.getNom();
                                break;
                            }
                            if (critere.equals("b")) {
                                calcul[j] = personne.getPrenom();
                                break;
                            }
                            if (critere.equals("c")) {
                                calcul[j] = personne.getAdresse();
                                break;
                            }
                        }
                    }
                }
            }
        }
        for (Personne value : personneList) {
            if (value != null) {
                for (String searchSetting : calcul) {
                    boolean isValidResult = searchSetting.equals(value.getAdresse()) || searchSetting.equals(value.getNom()) || searchSetting.equals(value.getPrenom());
                    if (isValidResult) {
                        if (searchSetting.equals(choice)) {
                            System.out.println(value);
                            result = true;
                            break;
                        }
                    }
                }
            }
        }
        if (!result) System.out.println("Nous n'avons pas trouvé la personne que vous cherchiez");
    }

    /*
     * Cette méthode permet de rechercher une personne par nom et prénom
     */
    public void rechercheNomPrenom(Personne[] personneList) {
        System.out.println("Veuillez entrer votre recherche :");
        String choice = sc.nextLine();
        System.out.println("Résultat de votre recherche :");
        boolean result = false;
        for (Personne personne : personneList) {
            if (personne != null) {
                if (personne.getNom().equals(choice) || personne.getPrenom().equals(choice)) {
                    System.out.println(personne);
                    result = true;
                }
            }
        }
        if (!result) System.out.println("Nous n'avons pas trouvé la personne que vous cherchiez");
    }

    /*
     * Cette méthode permet de rechercher une personne par nom et adresse
     */
    public void rechercheNomAdresse(Personne[] personneList) {
        System.out.println("Veuillez entrer votre recherche :");
        String choice = sc.nextLine();
        System.out.println("Résultat de votre recherche :");
        boolean result = false;
        for (Personne personne : personneList) {
            if (personne != null) {
                if (personne.getNom().equals(choice) || personne.getAdresse().equals(choice)) {
                    System.out.println(personne);
                    result = true;
                }
            }
        }
        if (!result) System.out.println("Nous n'avons pas trouvé la personne que vous cherchiez");
    }

    /*
     * Cette méthode permet de rechercher une personne par prénom et adresse
     */
    public void recherchePrenomAdresse(Personne[] personneList) {
        System.out.println("Veuillez entrer votre recherche :");
        String choice = sc.nextLine();
        System.out.println("Résultat de votre recherche :");
        boolean result = false;
        for (Personne personne : personneList) {
            if (personne != null) {
                if (personne.getPrenom().equals(choice) || personne.getAdresse().equals(choice)) {
                    System.out.println(personne);
                    result = true;
                }
            }
        }
        if (!result) System.out.println("Nous n'avons pas trouvé la personne que vous cherchiez");
    }

    /*
     * Cette méthode permet de rechercher une personne par nom, prénom et adresse
     */

    public void rechercheNomPrenomAdresse(Personne[] personneList) {
        System.out.println("Veuillez entrer votre recherche");
        String choice = sc.nextLine();
        System.out.println("Résultat de votre recherche :");
        boolean result = false;
        for (Personne personne : personneList) {
            if (personne != null) {
                if (personne.getNom().equals(choice) || personne.getPrenom().equals(choice) || personne.getAdresse().equals(choice)) {
                    System.out.println(personne);
                    result = true;
                }
            }
        }
        if (!result) System.out.println("Nous n'avons pas trouvé la personne que vous cherchiez");
    }

    /*
     * Menu de recherche de plusieurs critères
     */

    public void recherchePlusieursCriteres() {
        int choice = 0;
        do {
            System.out.println("1. Recherche par nom et prénom");
            System.out.println("2. Recherche par nom et adresse");
            System.out.println("3. Recherche par prénom et adresse");
            System.out.println("4. Recherche par nom, prénom et adresse");
            System.out.println("0. Retour");
            System.out.println("Taper votre choix :");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    rechercheNomPrenom(personneList);
                    break;
                case 2:
                    rechercheNomAdresse(personneList);
                    break;
                case 3:
                    recherchePrenomAdresse(personneList);
                    break;
                case 4:
                    rechercheNomPrenomAdresse(personneList);
                    break;
                case 5:
                    break;
            }

        } while (choice != 0);
    }

    /*
     * Cette méthode permet de rechercher par nom
     */
    public void rechercheDichotomiqueNom(Personne[] personneList) {
        System.out.println("Veuillez entrer votre recherche");
        String choice = sc.nextLine();
        System.out.println("Résultat de votre recherche :");
        boolean result = false;
        int min = 0;
        int max = personneList.length - 1;
        int mid = (min + max) / 2;
        while (min <= max) {
            if (personneList[mid] != null) {
                if (personneList[mid].getNom().compareTo(choice) < 0) {
                    min = mid;
                } else if (personneList[mid].getNom().compareTo(choice) == 0) {
                    System.out.println(personneList[mid]);
                    result = true;
                    break;
                } else {
                    max = mid;
                }
                mid = (min + max) / 2;
            }
        }
        if (!result) System.out.println("Nous n'avons pas trouvé la personne que vous cherchiez");
    }

    /*
     * Cette méthode permet de rechercher par prénom
     */
    public void rechercheDichotomiquePrenom(Personne[] personneList) {
        System.out.println("Veuillez entrer votre recherche");
        String choice = sc.nextLine();
        System.out.println("Résultat de votre recherche :");
        boolean result = false;
        int min = 0;
        int max = personneList.length - 1;
        int mid = (min + max) / 2;
        while (min <= max) {
            if (personneList[mid] != null) {
                if (personneList[mid].getPrenom().compareTo(choice) < 0) {
                    min = mid;
                } else if (personneList[mid].getPrenom().compareTo(choice) == 0) {
                    System.out.println(personneList[mid]);
                    result = true;
                    break;
                } else {
                    max = mid;
                }
                mid = (min + max) / 2;
            }
        }
        if (!result) System.out.println("Nous n'avons pas trouvé la personne que vous cherchiez");
    }

    /*
     * Cette méthode permet de rechercher par adresse
     */
    public void rechercheDichotomiqueAdresse(Personne[] personneList) {
        System.out.println("Veuillez entrer votre recherche");
        String choice = sc.nextLine();
        System.out.println("Résultat de votre recherche :");
        boolean result = false;
        int min = 0;
        int max = personneList.length - 1;
        int mid = (min + max) / 2;
        while (min <= max) {
            if (personneList[mid] != null) {
                if (personneList[mid].getAdresse().compareTo(choice) < 0) {
                    min = mid;
                } else if (personneList[mid].getAdresse().compareTo(choice) == 0) {
                    System.out.println(personneList[mid]);
                    result = true;
                    break;
                } else {
                    max = mid;
                }
                mid = (min + max) / 2;
            }
        }
        if (!result) System.out.println("Nous n'avons pas trouvé la personne que vous cherchiez");
    }

    /*
     * Menu de recherche dichotomique
     */
    public void rechercheDichotomique() {
        int choice = 0;
        do {
            System.out.println("1. Recherche par nom");
            System.out.println("2. Recherche par prénom");
            System.out.println("3. Recherche par adresse");
            System.out.println("0. Retour");
            System.out.println("Taper votre choix :");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    rechercheDichotomiqueNom(personneList);
                    break;
                case 2:
                    rechercheDichotomiquePrenom(personneList);
                    break;
                case 3:
                    rechercheDichotomiqueAdresse(personneList);
                    break;
                case 4:
                    break;
            }

        } while (choice != 0);
    }

    /*
     * Tri avec plusieurs critères
     */

    public void TrieCarnetAvecCritere(Personne[] personneList, int choix, int ordre) {

        int choixCritere = choix;
        if (choix == 0) {
            System.out.println("Veuillez choisir un critère de tri :");
            System.out.println("1. Nom");
            System.out.println("2. Prénom");
            System.out.println("3. Adresse");
            choixCritere = sc.nextInt();
        }

        int choixOrdre = ordre;
        if (ordre == 0) {
            System.out.println("Veuillez choisir un ordre de tri :");
            System.out.println("1. Croissant");
            System.out.println("2. Décroissant");
            choixOrdre = sc.nextInt();
        }
        int a = 0;
        for (Personne personne : personneList) {
            if (personne == null)
                a++;
        }
        int nbNull = personneList.length - a;
        String[] tab = new String[nbNull];

        boolean prenom = false;
        boolean nom = false;
        boolean adresse = false;

        for (Personne personne : personneList) {
            for (int i = 0; i < tab.length; i++) {
                if (tab[i] == null) {
                    switch (choixCritere) {
                        case 1:
                            tab[i] = personne.getNom();
                            nom = true;
                            break;
                        case 2:
                            tab[i] = personne.getPrenom();
                            prenom = true;
                            break;

                        case 3:
                            tab[i] = personne.getAdresse();
                            adresse = true;
                            break;
                        default:
                            System.out.println("Veuillez choisir un critère de tri");
                            break;
                    }
                    break;
                }
            }
        }
        String temp;

        for (int i = 0; i < nbNull; i++) {
            for (int j = i + 1; j < nbNull; j++) {
                assert tab[i] != null;
                int compare = tab[i].compareTo(tab[j]);
                if (choixOrdre == 1) {
                    if (compare > 0) {
                        temp = tab[i];
                        tab[i] = tab[j];
                        tab[j] = temp;
                    }
                } else {
                    if (compare < 0) {
                        temp = tab[i];
                        tab[i] = tab[j];
                        tab[j] = temp;
                    }
                }
            }
        }

        Personne[] tabPersonne = new Personne[personneList.length];
        for (int i = 0; i < nbNull; i++) {
            for (Personne personne : personneList) {
                if ((prenom && personne.getPrenom().equals(tab[i])) || (nom && personne.getNom().equals(tab[i])) || (adresse && personne.getAdresse().equals(tab[i]))) {
                    for (int l = 0; l < tabPersonne.length; l++) {
                        if (tabPersonne[l] == null) {
                            tabPersonne[l] = personne;
                            break;
                        }
                    }
                    break;
                }
            }
        }
        System.arraycopy(tabPersonne, 0, personneList, 0, personneList.length);
    }
    public void afficherPersonnesListe(Personne[] personneList) { //affiche la liste des personnes
        for (Personne personne: personneList) {
            System.out.println(personne);
        }
    }
    /*
     * Sauvegarde du carnet
     */
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

    /*
     * Importation du carnet
     */
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
}