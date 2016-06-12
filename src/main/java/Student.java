import lombok.Data;

/**
 * Created by Mohammed on 6/11/2016.
 */
import java.sql.Date;

@Data
public class Student {
    int Studentnr;
    String Voornaam;
    String Tussenvoegsel;
    String Achternaam;
    Date Leeftijd;
    String Geslacht;
    String Straat;
    String Postcode;
    String Woonplaats;
    String Telefoonnummer;

    public Student(int Studentnr, String Voornaam, String Tussenvoegsel, String Achternaam, Date Leeftijd, String Geslacht, String Straat, String Postcode,
                   String Woonplaats, String Telefoonnummer) {
        this.Studentnr = Studentnr;
        this.Voornaam = Voornaam;
        this.Achternaam = Achternaam;
        this.Leeftijd = Leeftijd;
        this.Geslacht = Geslacht;
        this.Straat = Straat;
        this.Postcode = Postcode;
        this.Woonplaats = Woonplaats;
        this.Telefoonnummer = Telefoonnummer;
    }

}
