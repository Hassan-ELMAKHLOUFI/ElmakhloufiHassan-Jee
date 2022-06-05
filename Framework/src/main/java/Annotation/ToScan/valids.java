package Annotation.ToScan;

import Annotation.Attribut;


public class valids {
    @Attribut
    main numero;

    String nom;

    public main getNumero() {
        return numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNumero(main numero) {
        this.numero = numero;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "valids{" +
                "numero=" + numero +
                ", nom='" + nom + '\'' +
                '}';
    }
}
