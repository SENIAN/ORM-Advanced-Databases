import lombok.Data;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Mohammed on 6/11/2016.
 * Created by Zahey
 */


public class PerformanceManager {

    private static String url = "jdbc:postgresql://127.0.0.1:5432/Roostering";
    private static String username = "postgres";
    private static String password = "admin";
    DbConnectorInsertData dbConnectorInsertData = new DbConnectorInsertData();

    public void testSettings() throws ClassNotFoundException, SQLException {
        String leeftijd = "1991-01-17";
        Date DateValueOfLeeftijd = Date.valueOf(leeftijd);
        Student student = new Student(3, "m", "el", "m",
                DateValueOfLeeftijd, "M", "van m 41", "3119TR", "m", "0610287399");
        dbConnectorInsertData.voegStudentToe(student);
    }

    public static ArrayList arrayListStudent = new ArrayList();
    public static ArrayList arrayListKlas = new ArrayList();

    public static void main(String[] args) throws ClassNotFoundException, InterruptedException {
        PostgresControwler postgresControwler = new PostgresControwler(username, password, url);
        JunkGenerator junkGenerator = new JunkGenerator();
        Runnable runnable = () -> {
            long beginTijd = System.currentTimeMillis();
            for (int i = 0; i < 600; i++) {
                try {
                    postgresControwler.connectionToPostGres();
                    Student student = junkGenerator.returnNewStudent();
                    arrayListStudent.add(junkGenerator.returnNewStudent());
                    Klas klas = junkGenerator.returnNewKlas();
                    int ChangeActionTransaction = (int) (Math.random() * 30);

                    if (ChangeActionTransaction == 5) {
                        arrayListKlas.add(klas);
                        Random R = new Random();
                        Klas addStudentToKlass = (Klas) arrayListKlas.get(R.nextInt(arrayListKlas.size()));
                        DbConnectorInsertData.koppelStudentToKlass(addStudentToKlass, student);
                        System.out.println("Student successvol gekoppeld aan een klas");
                    } else {
                        System.out.println("Nog geen Student aan klas gekoppeld");
                    }
                    int kansSpelSpelen = (int) (Math.random() * 30);
                    int kansspelSpelenOpModule = (int) (Math.random() * 7);

                    if (kansSpelSpelen == 5) {
                        Module module = junkGenerator.returnNewModule();
                        DbConnectorInsertData.voegModuleToe(module);
                        if (kansspelSpelenOpModule == 5) {
                            for (int k = 0; k < arrayListKlas.size(); k++) {
                                Klas klasNew = (Klas) arrayListKlas.get(k);
                                DbConnectorInsertData.koppelModuleToKlass(klasNew, module);
                                System.out.println("Module Successvol Gekoppeld aan een Klas");
                            }
                        } else {
                            System.out.println("Helaas nog geen Module aan een klas kunnen koppelen");
                        }
                    } else {
                        System.out.println("Niet gelukt om een Module te koppelen");
                    }
                    postgresControwler.exit();
                    Thread.currentThread().sleep(1000);

                } catch (SQLException e) {
                    e.printStackTrace();

                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (InterruptedException e) {
                 e.printStackTrace();
                }

            }
            long eindTijd = System.currentTimeMillis();

            long duurInMS = eindTijd - beginTijd;
            long gemiddeldTijd1 = duurInMS / 600;
            System.out.println("gemiddeld tijd van thread 1:" + gemiddeldTijd1);

        };
            Thread thread1 = new Thread(runnable::run);
            Thread thread2 = new Thread(runnable::run);
            Thread thread3 = new Thread(runnable::run);
            Thread thread4 = new Thread(runnable::run);
            Thread thread5 = new Thread(runnable::run);

            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
            thread5.start();

    }
}