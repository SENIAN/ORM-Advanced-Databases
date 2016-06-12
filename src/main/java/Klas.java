import lombok.Data;

/**
 * Created by Mohammed on 6/11/2016.
 */
import java.sql.Time;
import java.sql.Timestamp;

@Data
public class Klas {
    public String Klasnaam;
    public Timestamp startdatum;
    public Timestamp einddatum;

    public Klas(String Klasnaam, Timestamp startdatum, Timestamp einddatum) {
        this.einddatum = einddatum;
        this.startdatum = startdatum;
        this.Klasnaam = Klasnaam;
    }
}
