package TP2.Exo4;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class JeuTest {
    @Mock
    private BanqueI banque;
    @Mock
    private Joueur joueur;
    @Mock
    private De de1;
    @Mock
    private De de2;

    private Jeu jeu;

    @Test(expected = JeuFermeException.class)
    public void testJouer_JeuFerme_ThrowsException() throws JeuFermeException {
        // Arrange
        jeu = new Jeu(banque);
        jeu.fermer();

        // Act
        jeu.jouer(joueur, de1, de2);
    }

    @Test
    public void testJouer_JoueurInsolvable_ThrowsException() throws JeuFermeException, DebitImpossibleException {
        // Arrange
        jeu = new Jeu(banque);
        when(joueur.mise()).thenReturn(100);
        doThrow(new DebitImpossibleException("Solde insuffisant")).when(joueur).debiter(100);

        // Act & Assert
        try {
            jeu.jouer(joueur, de1, de2);
            fail("Une exception aurait dû être levée");
        } catch (RuntimeException e) {
            assertEquals("Joueur insolvable", e.getMessage());
        }

        // Vérifier que les dés n'ont pas été lancés
        verify(de1, never()).lancer();
        verify(de2, never()).lancer();
        verifyNoInteractions(banque);
    }

    @Test
    public void testJouer_SommeNon7_Perte() throws JeuFermeException, DebitImpossibleException {
        // Arrange
        jeu = new Jeu(banque);
        when(joueur.mise()).thenReturn(100);
        doNothing().when(joueur).debiter(100);
        when(de1.lancer()).thenReturn(3);
        when(de2.lancer()).thenReturn(2); // Somme = 5 ≠ 7
        doNothing().when(banque).crediter(100);
        // Suppression de : when(banque.est_solvable()).thenReturn(true); car inutile ici

        // Act
        jeu.jouer(joueur, de1, de2);

        // Assert
        verify(joueur).debiter(100);
        verify(banque).crediter(100);
        verify(de1).lancer();
        verify(de2).lancer();
        verify(joueur, never()).crediter(anyInt());
        verify(banque, never()).debiter(anyInt());
        assertTrue(jeu.estOuvert());
    }

    @Test
    public void testJouer_Somme7_GainBanqueSolvable() throws JeuFermeException, DebitImpossibleException {
        // Arrange
        jeu = new Jeu(banque);
        when(joueur.mise()).thenReturn(100);
        doNothing().when(joueur).debiter(100);
        when(de1.lancer()).thenReturn(4);
        when(de2.lancer()).thenReturn(3); // Somme = 7
        doNothing().when(banque).crediter(100);
        doNothing().when(banque).debiter(200);
        when(banque.est_solvable()).thenReturn(true);
        doNothing().when(joueur).crediter(200);

        // Act
        jeu.jouer(joueur, de1, de2);

        // Assert
        verify(joueur).debiter(100);
        verify(banque).crediter(100);
        verify(de1).lancer();
        verify(de2).lancer();
        verify(banque).debiter(200);
        verify(joueur).crediter(200);
        assertTrue(jeu.estOuvert());
    }

    @Test
    public void testJouer_Somme7_GainBanqueInsolvable() throws JeuFermeException, DebitImpossibleException {
        // Arrange
        jeu = new Jeu(banque);
        when(joueur.mise()).thenReturn(100);
        doNothing().when(joueur).debiter(100);
        when(de1.lancer()).thenReturn(4);
        when(de2.lancer()).thenReturn(3); // Somme = 7
        doNothing().when(banque).crediter(100);
        doNothing().when(banque).debiter(200);
        when(banque.est_solvable()).thenReturn(false);
        doNothing().when(joueur).crediter(200);

        // Act
        jeu.jouer(joueur, de1, de2);

        // Assert
        verify(joueur).debiter(100);
        verify(banque).crediter(100);
        verify(de1).lancer();
        verify(de2).lancer();
        verify(banque).debiter(200);
        verify(joueur).crediter(200);
        assertFalse(jeu.estOuvert());
    }
}