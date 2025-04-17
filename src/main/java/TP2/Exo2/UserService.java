package TP2.Exo2;

public class UserService {
    private final UtilisateurApi utilisateurApi;

    public UserService(UtilisateurApi utilisateurApi) {
        this.utilisateurApi = utilisateurApi;
    }

    public void creerUtilisateur(Utilisateur utilisateur) throws ServiceException {
        // Validation : email ne doit pas être vide
        if (utilisateur.getEmail() == null || utilisateur.getEmail().isEmpty()) {
            throw new ServiceException("Email invalide");
        }
        utilisateurApi.creerUtilisateur(utilisateur);
    }
}
