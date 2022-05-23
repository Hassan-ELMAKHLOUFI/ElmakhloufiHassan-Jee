public class Utilisateur {

     String nom;
     String password;

    public Utilisateur(String nom, String password) {
        this.nom = nom;
        this.password = password;
    }

    public Utilisateur() {
    }

    public String getNom() {
        return nom;
    }

    public void setnom(String nom) {
        this.nom = nom;
    }

    public String getPassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "nom='" + nom + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
