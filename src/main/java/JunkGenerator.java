import com.sun.istack.internal.Nullable;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 * Created by Mohammed on 6/11/2016.
 * Created by Zahey
 */
public class JunkGenerator {

    public int betweenValues(int begin, int eind) {
        return begin + (int) Math.round(Math.random() * (eind - begin));
    }

    public String randomCharGenerator() {
        char[] chars = "abcdefghijklmnopqrstuvwxyz01234567890".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        char c = chars[random.nextInt(chars.length)];
        sb.append(c);
        return sb.toString();
    }

    public String randomDateGenerator() {
        StringBuilder stringBuilder = new StringBuilder();
        GregorianCalendar gc = new GregorianCalendar();
        int year = betweenValues(2015, 2016);
        gc.set(Calendar.YEAR, year);
        int month = betweenValues(9, 12);
        int dayOfYear = betweenValues(1, 30);
        gc.set(Calendar.DAY_OF_YEAR, dayOfYear);
        int year2 = gc.get(Calendar.YEAR);
        stringBuilder.append(year2);
        stringBuilder.append("-");
        int mm = month;
        stringBuilder.append(mm);
        stringBuilder.append("-");
        int dd = gc.get(Calendar.DAY_OF_YEAR);
        stringBuilder.append(dd);
        String datum = stringBuilder.toString();

        return datum;
    }

    public Timestamp randomTimeStampDateGenerator() {
        StringBuilder stringBuilder = new StringBuilder();
        GregorianCalendar gc = new GregorianCalendar();
        int year = betweenValues(2015, 2016);
        gc.set(Calendar.YEAR, year);
        int month = betweenValues(1, 12);
        int dayOfYear = betweenValues(1, 30);
        int hour = betweenValues(00, 23);
        int minute = betweenValues(0, 59);
        int seconds = betweenValues(0, 59);
        gc.set(Calendar.DAY_OF_YEAR, dayOfYear);
        gc.set(Calendar.HOUR, hour);
        gc.set(Calendar.MINUTE, minute);
        gc.set(Calendar.SECOND, seconds);
        int year2 = gc.get(Calendar.YEAR);
        stringBuilder.append(year2);
        int mm = month;
        stringBuilder.append(mm);
        int dd = gc.get(Calendar.DAY_OF_YEAR);
        stringBuilder.append(dd);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String timestamp = stringBuilder.toString();
    return new Timestamp(gc.getTimeInMillis());
    }
    public String randomGeslachtGenerator() {
        String geslacht;
        Random r = new Random();
        if (r.nextBoolean()) {
            geslacht = "M";
        } else {
            geslacht = "V";
        }
        return geslacht;
    }

    public String randomPostcodeGenerator() {

        char[] chars = "dsadddjfsjdfkfkwqlfdkfsfkdddsmcc".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        int postcode = random.nextInt(99 - 10);
        for (int i = 0; i < 4; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        sb.append(postcode);
        return sb.toString();
    }

    public int randomTelefoonnummerGenerator() {

        Random r = new Random();
        int abc = r.nextInt(9999999 - 0100000);
        return abc;
    }

    public Student returnNewStudent() {
        // region Random Studentnr
        Random r = new Random();
        int Studentnr = r.nextInt(99999);
        // endregion
        // region VoornaamGenerator
        String voornaam = randomCharGenerator();
        // endregion
        // region Tussenvoegsel
        String Tussenvoegsel = "van";
        // endregion
        // region AchternaamGenerator
        String achternaam = randomCharGenerator();
        // endregion
        //region LeeftijdGenerator

        Date Leeftijd = Date.valueOf(randomDateGenerator());

        //endregion
        // region GeslachtGenerator
        String Geslacht = randomGeslachtGenerator();
        // endregion
        // region StraatGenerator
        String Straat = randomCharGenerator();
        // endregion
        // region PostcodeGeneraor
        String Postcode = randomPostcodeGenerator();
        // endregion
        // region WoonplaatsGenerator
        String Woonplaats = randomCharGenerator();
        // endregion
        // region TelefoonnummerGenerator
        String Telefoonnummer = String.valueOf(randomTelefoonnummerGenerator());
        // endregion

        Student student = new Student(Studentnr, voornaam, Tussenvoegsel, achternaam, Leeftijd, Geslacht, Straat,
                Postcode, Woonplaats, Telefoonnummer);
        return student;
    }

    public Klas returnNewKlas() {
        // region Random Klasnaam
        Random r = new Random();
        int klasnaam = r.nextInt(99999);
        // endregion
        // region startDatum Generator
        Timestamp startDatum = randomTimeStampDateGenerator();
        System.out.println(startDatum);
        // endregion
        // region Einddatum Generator
        Timestamp einddatum = randomTimeStampDateGenerator();
        // endregion
        Klas klas = new Klas("", startDatum, einddatum);
        return klas;
    }

    public Module returnNewModule() {

        return new Module("", Date.valueOf(randomDateGenerator()), Date.valueOf(randomDateGenerator()));
    }

}
