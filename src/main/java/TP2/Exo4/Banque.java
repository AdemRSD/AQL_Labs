package TP2.Exo4;

public class Banque {
    private int solde;
    private final int soldeMinimum;

    public Banque(int soldeInitial, int soldeMinimum) {
        this.solde = soldeInitial;
        this.soldeMinimum = soldeMinimum;
    }

    public void crediter(int somme) {
        this.solde += somme;
    }

    public void debiter(int somme) {
        this.solde -= somme;
    }

    public boolean est_solvable() {
        return this.solde >= soldeMinimum;
    }
}
