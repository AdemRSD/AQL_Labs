package TP2.Exo4;

public class Jeu {
    private final BanqueI banqueI;
    private boolean ouvert;

    public Jeu(BanqueI labanque) {
        this.banqueI = labanque;
        this.ouvert = true;
    }

    public void jouer(Joueur joueur, De de1, De de2) throws JeuFermeException {
        if (!estOuvert()) {
            throw new JeuFermeException("Le jeu est fermé");
        }

        int mise = joueur.mise();
        try {
            joueur.debiter(mise);
        } catch (DebitImpossibleException e) {
            throw new RuntimeException("Joueur insolvable", e);
        }

        banqueI.crediter(mise);

        int sommeDes = de1.lancer() + de2.lancer();
        if (sommeDes == 7) {
            int gain = 2 * mise;
            banqueI.debiter(gain);
            joueur.crediter(gain);
            if (!banqueI.est_solvable()) {
                fermer();
            }
        }
    }

    public void fermer() {
        this.ouvert = false;
    }

    public boolean estOuvert() {
        return ouvert;
    }
}
