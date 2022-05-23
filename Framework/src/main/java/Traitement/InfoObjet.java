package Traitement;

public class InfoObjet {
    String Classe;
    String Id  ;

    public InfoObjet(String classe, String id) {
        Classe = classe;
        Id = id;
    }

    public String getClasse() {
        return Classe;
    }

    public void setClasse(String classe) {
        Classe = classe;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "InfoObjet{" +
                "Classe='" + Classe + '\'' +
                ", Id='" + Id + '\'' +
                '}';
    }
}
