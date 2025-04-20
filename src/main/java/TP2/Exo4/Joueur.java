package TP2.Exo4;
import TP2.Exo4.DebitImpossibleException;
public interface Joueur {
    public int mise(); // Mise positive
    public void debiter(int somme) throws DebitImpossibleException;
    public void crediter(int somme);
}
