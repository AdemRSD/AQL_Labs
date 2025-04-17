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

@RunWith(MockitoJUnitRunner.class)
public class Scenario1Test {

    @Mock
    private UtilisateurApi utilisateurApiMock;

    @Test(expected = ServiceException.class)
    public void testCreerUtilisateur_ThrowsServiceException() throws ServiceException {
        // Arrange
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");
        UserService userService = new UserService(utilisateurApiMock);

        // Configurer le mock pour lever une exception
        doThrow(new ServiceException("Échec de la création de l'utilisateur"))
                .when(utilisateurApiMock).creerUtilisateur(utilisateur);

        // Act
        userService.creerUtilisateur(utilisateur);

        // Assert : L'exception est levée, vérifiée par @Test(expected)
    }
}
