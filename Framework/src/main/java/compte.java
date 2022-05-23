import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class compte {

    private int code ;
    private double solde ;
    private Date DateCreation;
     Utilisateur user ;

    public compte(int code, double solde, Date dateCreation,Utilisateur user) {
        this.code = code;
        this.solde = solde;
        DateCreation = dateCreation;
        this.user=user ;
    }

    public compte(Utilisateur user) {

        this.user=user ;
    }

    public compte (){}

    public Utilisateur getUser() {
        return user;
    }

    public void setuser(Utilisateur user) {
        this.user = user;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "compte{" +
                "code=" + code +
                ", solde=" + solde +
                ", DateCreation=" + DateCreation +
                ", user=" + user +
                '}';
    }

    public void setCode(int code) {
        this.code = code;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Date getDateCreation() {
        return DateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        DateCreation = dateCreation;
    }
}
