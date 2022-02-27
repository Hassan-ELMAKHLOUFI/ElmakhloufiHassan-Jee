import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;


@XmlRootElement
public class compte {

    private int code ;
    private double solde ;
    private Date DateCreation;

    public compte(int code, double solde, Date dateCreation) {
        this.code = code;
        this.solde = solde;
        DateCreation = dateCreation;
    }
    public compte (){}
    public int getCode() {
        return code;
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
