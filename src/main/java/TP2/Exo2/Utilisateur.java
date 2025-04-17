package TP2.Exo2;

public class Utilisateur {
    private String prenom;
    private String nom;
    private String email;
    private int id; // Ajouté pour le scénario 3

    public Utilisateur(String prenom, String nom, String email) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
    }

    // Getters
    public String getPrenom() { return prenom; }
    public String getNom() { return nom; }
    public String getEmail() { return email; }
    public int getId() { return id; }

    // Setter pour l'ID (scénario 3)
    public void setId(int id) { this.id = id; }
}