package en.iut.debeaulieu.adressbook.classes;

public class PersonneFunctions {

    private final Personne[] personneList = new Personne[2];

    public void AjouterUnePersonne(Personne personne) {
        Personne[] tabPersonne = this.personneList;
        int pers = tabPersonne.length;

        for (int i = 0; i < pers; i++) {
            Personne personne1 = tabPersonne[i];
            if (personne1 == null) {
                break;
            }
        }
    }

    public void supprimerUnePersonne(int index) throws Exception {
        if (index != 0 && index != 1) {
            throw new Exception("erreur");
        } else {
            boolean isEmpty = true;
            Personne[] tabPersonne = this.personneList;
            int pers = tabPersonne.length;

            for (int i = 0; i < pers; i++) {
                Personne personne1 = tabPersonne[i];
                if (personne1 != null) {
                    break;
                }
            }
        }
    }

    public Personne[] getPersonneList() {
        return this.personneList;
    }
}
