import java.sql.*;

/**
 * Created by Mohammed on 6/11/2016.
 * Created by Zahey
 */
public class DbConnectorInsertAndSelectData {

    private static String url = "jdbc:postgresql://127.0.0.1:5432/Roostering";
    private static String username = "postgres";
    private static String password = "admin";



    public static void voegStudentToe(Student student1) throws ClassNotFoundException, SQLException {

        try {
            PostgresControwler postgresControwler = new PostgresControwler(username, password, url);
            postgresControwler.connectionToPostGres();
            String query = "INSERT INTO dmn.student ("
                    + " studentnr,"
                    + " voornaam,"
                    + " tussenvoegsel,"
                    + " achternaam,"
                    + " leeftijd,"
                    + " geslacht,"
                    + " straat,"
                    + " postcode,"
                    + " woonplaats,"
                    + " telefoonnummer  ) VALUES (? ,? ,? ,? ,? ,? ,? ,? ,? ,? )";

            PreparedStatement prep = postgresControwler.connection.prepareCall(query);
            prep.setInt(1, student1.getStudentnr());
            prep.setString(2, student1.getVoornaam());
            prep.setString(3, student1.getTussenvoegsel());
            prep.setString(4, student1.getAchternaam());
            prep.setDate(5, student1.getLeeftijd());
            prep.setString(6, student1.getGeslacht());
            prep.setString(7, student1.getStraat());
            prep.setString(8, student1.getPostcode());
            prep.setString(9, student1.getWoonplaats());
            prep.setString(10, student1.getTelefoonnummer());
            prep.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void koppelStudentToKlass(Klas klas, Student student) throws  ClassNotFoundException, SQLException {

        try {
            PostgresControwler postgresControwler = new PostgresControwler(username, password, url);
            String query = "INSERT INTO student_heeft_klas ("
                    + " studentnr_student,"
                    + " klasnaam_klas) VALUES (? ,?)";
            PreparedStatement prep = postgresControwler.connection.prepareCall(query);
            prep.setInt(1, student.getStudentnr());
            prep.setString(2, klas.getKlasnaam());

        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    public static void voegDocentToe(Docent docent) throws  ClassNotFoundException, SQLException {

        try {
            PostgresControwler postgresControwler = new PostgresControwler(username, password, url);
            postgresControwler.connectionToPostGres();
            String query = "INSERT INTO dmn.student ("
                    + " medewerkerscode,"
                    + " voornaam,"
                    + " tussenvoegsel,"
                    + " achternaam,"
                    + " leeftijd,"
                    + " geslacht,"
                    + " straat,"
                    + " postcode,"
                    + " woonplaats,"
                    + " telefoonnummer  ) VALUES (? ,? ,? ,? ,? ,? ,? ,? ,? ,? )";

            PreparedStatement prep = postgresControwler.connection.prepareCall(query);

            prep.setInt(1, docent.getMedewerkerscode());
            prep.setString(2, docent.getVoornaam());
            prep.setString(3, docent.getTussenvoegsel());
            prep.setString(4, docent.getAchternaam());
            prep.setDate(5, docent.getLeeftijd());
            prep.setString(6, docent.getGeslacht());
            prep.setString(7, docent.getStraat());
            prep.setString(8, docent.getPostcode());
            prep.setString(9, docent.getWoonplaats());
            prep.setString(10, docent.getTelefoonnummer());
            prep.executeUpdate();


        } catch (Throwable e) {
            e.printStackTrace();
        }

    }

    public static void voegModuleToe(Module module) throws  ClassNotFoundException, SQLException {

        try {
            PostgresControwler postgresControwler = new PostgresControwler(username, password, url);
            postgresControwler.connectionToPostGres();
            String query = "INSERT INTO dmn.modules ("
                    + " modulecode,"
                    + " invoerdatum,"
                    + " einddatum  ) VALUES (? ,? ,?)";

            PreparedStatement prep = postgresControwler.connection.prepareCall(query);
            prep.setString(1, module.getModuleCode());
            prep.setDate(2, module.getInvoerdatum());
            prep.setDate(3, module.getEinddatum());
            prep.executeUpdate();


        } catch (Throwable e) {
            e.getCause();
        }

    }

    public static void main(String[] args) throws  ClassNotFoundException, SQLException {
        PerformanceManager performanceManager = new PerformanceManager();
        PostgresControwler postgresControwler = new PostgresControwler(username, password, url);
        performanceManager.testSettings();
        postgresControwler.exit();
    }

    public static void koppelModuleToKlass(Klas klas, Module module) {

        try {
            PostgresControwler postgresControwler = new PostgresControwler(username, password, url);
            postgresControwler.connectionToPostGres();
            String query = "INSERT INTO dmn.module_heeft_klas ("
                    + " modulecode,"
                    + " invoerdatum,"
                    + " einddatum) VALUES (? ,? ,?)";

            PreparedStatement prep = postgresControwler.connection.prepareCall(query);
            prep.setString(1, module.getModuleCode());
            prep.setDate(2, module.getInvoerdatum());
            prep.setDate(3, module.getEinddatum());
            prep.execute();

        } catch (SQLException e) {
            e.getCause();
        } catch (ClassNotFoundException e) {
            e.getCause();
        }

    }

    public static void selecteerAllStudenten() {
        PostgresControwler postgresControwler  = new PostgresControwler(username,password,url);
        try {
            postgresControwler.connectionToPostGres();
            String query = "SELECT voornaam, achternaam FROM dmn.student ORDER BY RANDOM() LIMIT 1";
            PreparedStatement prep =  postgresControwler.connection.prepareCall(query);
            prep.execute();


            String getGroup = "SELECT dmn.student_heeft_klas.klasnaam_klas FROM dmn.student_heeft_klas, dmn.student WHERE dmn.student.studentnr = dmn.student_heeft_klas.studentnr_student";
            PreparedStatement prep1 = postgresControwler.connection.prepareCall(getGroup);
            prep1.execute();

            String getModules = "SELECT * FROM dmn.module_heeft_klas WHERE module_heeft_klas.klasnaam_klas  = dmn.klasnaam";
            PreparedStatement prep2 = postgresControwler.connection.prepareCall(getModules);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
