package en.iut.debeaulieu.adressbook.classes;

import java.util.Scanner;

public class BinarySearch {
    Scanner sc = new Scanner(System.in);

    public void isResult(Boolean result) {
        if (!result) System.out.println("We couldn't find the person we were looking for");
    }

    public void searchAddressByKeyWords(Personne[] addressList) {
        System.out.println("Please enter your search (you can search by firstname, lastname or address) ");
        String personSearch = sc.nextLine();
        String[] mySearch = personSearch.split(" ");
        boolean result = false;

        for (Personne value : addressList) {
            if (value != null) {
                String lastname = value.getNom();
                String firstname = value.getPrenom();
                String address = value.getAdresse();
                for (String search : mySearch) {
                    if (firstname.equals(search) || lastname.equals(search) || address.equals(search)) {
                        System.out.println(value);
                        result = true;
                        break;
                    }
                }
            }
        }
        isResult(result);
    }

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

        System.out.println("Veuillez entrer votre recherche");
        String choice = sc.nextLine();
        System.out.println("Résultat de votre recherche :");
        for(Personne personne : personneList) {
            if (personne != null) {
                for (String critere : critereRecherche) {
                    for (int j = 0; j < calcul.length; j++) {
                        if (calcul[j] == null) {
                            if (critere.equals("a")) {
                                calcul[j] = personne.getNom();
                                break;
                            } else if (critere.equals("b")) {
                                calcul[j] = personne.getPrenom();
                                break;
                            } else if (critere.equals("c")) {
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
}