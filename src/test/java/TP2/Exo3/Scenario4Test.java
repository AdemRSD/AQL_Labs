package TP2.Exo3;

import TP2.Exo2.ServiceException;
import TP2.Exo2.UserService;
import TP2.Exo2.Utilisateur;
import TP2.Exo2.UtilisateurApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class Scenario4Test {
    @Mock
    private UtilisateurApi utilisateurApiMock;

    @Test
    public void testCreerUtilisateur_CaptureArguments() throws ServiceException {
        // Arrange
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");
        UserService userService = new UserService(utilisateurApiMock);

        ArgumentCaptor<Utilisateur> argumentCaptor = ArgumentCaptor.forClass(Utilisateur.class);
        // Note : thenReturn(true) est incorrect pour une méthode void, mais conservé pour suivre le document
        doNothing().when(utilisateurApiMock).creerUtilisateur(any(Utilisateur.class));

        // Act
        userService.creerUtilisateur(utilisateur);

        // Capture de l'argument
        verify(utilisateurApiMock).creerUtilisateur(argumentCaptor.capture());
        Utilisateur utilisateurCapture = argumentCaptor.getValue();

        // Vérification des arguments capturés
        assertEquals("Jean", utilisateurCapture.getPrenom());
        assertEquals("Dupont", utilisateurCapture.getNom());
        assertEquals("jeandupont@email.com", utilisateurCapture.getEmail());
    }
}
