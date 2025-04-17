package TP2.Exo3;

import TP2.Exo2.ServiceException;
import TP2.Exo2.UserService;
import TP2.Exo2.Utilisateur;
import TP2.Exo2.UtilisateurApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class Scenario3Test {
    @Mock
    private UtilisateurApi utilisateurApiMock;

    @Test
    public void testCreerUtilisateur_SetsUserId() throws ServiceException {
        // Arrange
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");
        UserService userService = new UserService(utilisateurApiMock);

        // Définition d'un ID fictif
        int idUtilisateur = 123;

        // Configuration du mock pour définir l'ID
        doAnswer(invocation -> {
            Utilisateur arg = invocation.getArgument(0);
            arg.setId(idUtilisateur); // Définir l'ID sur l'utilisateur
            return null; // Méthode void
        }).when(utilisateurApiMock).creerUtilisateur(utilisateur);

        // Act
        userService.creerUtilisateur(utilisateur);

        // Vérification de l'ID de l'utilisateur
        assertEquals(idUtilisateur, utilisateur.getId());
    }
}
