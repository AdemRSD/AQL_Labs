package TP2.Exo2;

class Utilisateur {
private String prenom;
private String nom;
private String email;

public Utilisateur(String prenom, String nom, String email) {
    this.prenom = prenom;
    this.nom = nom;
    this.email = email;
}

// Getters nécessaires pour la comparaison dans verify
public String getPrenom() { return prenom; }
public String getNom() { return nom; }
public String getEmail() { return email; }
}
