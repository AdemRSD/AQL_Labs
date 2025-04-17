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
public class Scenario2Test {
    @Mock
    private UtilisateurApi utilisateurApiMock;

    @Test
    public void testCreerUtilisateur_InvalidEmail_ThrowsException() throws ServiceException {
        // Arrange
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", ""); // Email vide
        UserService userService = new UserService(utilisateurApiMock);

        // Act & Assert
        try {
            userService.creerUtilisateur(utilisateur);
            fail("Une ServiceException aurait dû être levée");
        } catch (ServiceException e) {
            assertEquals("Email invalide", e.getMessage());
        }

        // Vérification que l'API n'a pas été appelée
        verify(utilisateurApiMock, never()).creerUtilisateur(any(Utilisateur.class));
    }
}
