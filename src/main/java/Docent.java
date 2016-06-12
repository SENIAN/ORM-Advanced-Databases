import lombok.Data;

import java.sql.Date;

/**
 * Created by Mohammed on 6/11/2016.
 */

@Data
public class Docent {
    int Medewerkerscode;
    String Voornaam;
    String Tussenvoegsel;
    String Achternaam;
    Date Leeftijd;
    String Geslacht;
    String Straat;
    String Postcode;
    String Woonplaats;
    String Telefoonnummer;

    public Docent(int Medewerkerscode, String Voornaam, String Tussenvoegsel, String Achternaam, Date Leeftijd, String Geslacht, String Straat,
                  String Postcode, String Woonplaats, String Telefoonnummer) {
        this.Medewerkerscode = Medewerkerscode;
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
