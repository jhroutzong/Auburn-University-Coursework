import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Element;

public class sqlServer {
    static Connection connection = null;
    public static void main(String[] args) throws SQLException,
            ClassNotFoundException, IOException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/my_hospital"; // connection string
        String username = "root"; // mysql username
        String password = "breaktheice1!"; // mysql password
        System.out.println("hello");

        // 11, 12, 16, 8, 17, 18
        List<String> queries = new ArrayList<>();
        queries.add(0, "SELECT r.room_id, p.patient_id, a.admit_date From Room r INNER JOIN Patient p on p.patient_id = r.patient_id INNER JOIN Admission a on a.admit_id = r.admit_id");
        queries.add(1, "SELECT r.room_id From Room r WHERE r.patient_id = 0");
        queries.add(2, "SELECT r.room_id, p.patient_name, a.admit_date FROM Room r LEFT JOIN Patient p ON r.patient_id = p.patient_id LEFT JOIN Admission a on r.admit_id = a.admit_id");
        queries.add(3, "SELECT p.patient_name FROM Patient p");
        queries.add(4, "SELECT a.patient_id, p.patient_name FROM Patient p INNER JOIN Admission a ON p.patient_id = a.patient_id WHERE discharge_date IS NULL");
        queries.add(5, "SELECT a.patient_id, p.patient_name FROM Admission a INNER JOIN Patient p ON a.patient_id = p.patient_id WHERE a.discharge_date BETWEEN '2020-01-01' AND '2020-12-31'");
        queries.add(6, "SELECT a.patient_id, p.patient_name FROM Admission a INNER JOIN Patient p ON a.patient_id = p.patient_id WHERE a.admit_date BETWEEN '2021-01-01' AND '2021-12-31'");
        queries.add(7, "SELECT a.admit_id, a.admit_date, a.diagnosis FROM Admission a WHERE a.patient_id = 1");
        queries.add(8, "SELECT t.patient_id, t.treatment_id, t.medication, t.admit_id FROM Treatment t WHERE t.patient_id = 1 GROUP by t.admit_id ORDER by t.admit_id DESC, t.treatment_id ASC");
        queries.add(9, "SELECT * FROM (SELECT Admission.*, LEAD(admit_date) OVER (PARTITION BY patient_id ORDER BY admit_date) AS next_date FROM Admission) sub1 WHERE TIMESTAMPDIFF(DAY, next_date, discharge_date) >= -30 AND TIMESTAMPDIFF(DAY, next_date, discharge_date) <= 0;");
        queries.add(10, "SELECT t1.patient_name, total_admissions, minimum_duration, maximum_duration, avg_duration FROM (SELECT p.patient_id, p.patient_name, COUNT(*) AS total_admissions FROM patient p LEFT JOIN admission a ON a.patient_id = p.patient_id GROUP BY p.patient_id) t1 LEFT JOIN (SELECT patient_id, patient_name, MIN(TIMESTAMPDIFF(DAY, admit_date, discharge_date)) AS minimum_duration FROM ( SELECT p.patient_id, p.patient_name, admit_date, discharge_date FROM patient p LEFT JOIN admission a ON a.patient_id = p.patient_id) t1 GROUP BY p.patient_id) t2 ON t1.patient_id = t2.patient_id LEFT JOIN (SELECT patient_id, patient_name, MAX(TIMESTAMPDIFF(DAY, admit_date, discharge_date)) AS maximum_duration FROM (SELECT p.patient_id, p.patient_name, admit_date, discharge_date FROM patient p LEFT JOIN admission a ON a.patient_id = p.patient_id) t2 GROUP BY p.patient_id) t3 ON t3.patient_id = t2.patient_id LEFT JOIN (SELECT patient_id, patient_name, AVG(TIMESTAMPDIFF(DAY, admit_date, discharge_date)) AS avg_duration FROM (SELECT p.patient_id, p.patient_name, admit_date, discharge_date FROM patient p LEFT JOIN admission a ON a.patient_id = p.patient_id) t3 GROUP BY p.patient_id) t4 ON t4.patient_id = t3.patient_id;");
        queries.add(11, "SELECT a.admit_id, a.diagnosis, COUNT(a.diagnosis) as occurences from Admission a GROUP by diagnosis ORDER by occurences DESC");
        queries.add(12, "SELECT t.treatment_id, t.medical_procedure, COUNT(medical_procedure) as occurences_of_treatment FROM Treatment t GROUP BY medical_procedure ORDER BY t.ordertime DESC");
        queries.add(13, "SELECT a.diagnosis, p.patient_name, COUNT(a.admit_id) OVER (PARTITION BY a.patient_id) as num_of_admissions FROM Admission a INNER JOIN Patient p ON a.patient_id = p.patient_id");
        queries.add(14, "SELECT t.treatment_id, p.patient_name, e.emp_name FROM Treatment t INNER JOIN Patient p on t.patient_id = p.patient_id INNER JOIN Employee e on t.emp_id = e.emp_id");
        queries.add(15, "SELECT e.emp_name, e.emp_lvl FROM Employee e ORDER BY e.emp_name ASC");
        queries.add(16, "(SELECT emp_name, occurrences, patient_name FROM (SELECT t1.admit_id, t1.emp_id, t1.patient_id, DATEDIFF(t1.admit_date, t2.admit_date), COUNT(*) AS occurrences FROM admission t1, admission t2  WHERE t1.patient_id = t2.patient_id AND DATEDIFF(t1.admit_date, t2.admit_date) <= 0 AND DATEDIFF(t1.admit_date, t2.admit_date) >= -365 GROUP BY t1.admit_id, t1.admit_date ORDER BY t1.patient_id) t LEFT JOIN employee e ON e.emp_id = t1.emp_id LEFT JOIN patient p ON p.patient_id = t1.patient_id WHERE occurrences >= 4)");
        queries.add(17, "SELECT emp_name, diagnosis, COUNT(*) as total_number_of_occurrences FROM admission a LEFT JOIN employee e ON e.emp_id = a.emp_id GROUP BY diagnosis ORDER by total_number_of_occurrences DESC");
        queries.add(18, "SELECT *, COUNT(*) AS total_treatments FROM treatment t LEFT JOIN employee e ON e.emp_id = t.emp_id WHERE t.emp_id = 5 GROUP BY t.medical_procedure ORDER BY total_treatments DESC;");
        queries.add(19, "SELECT DISTINCT(e.emp_name) FROM treatment t1, treatment t2 LEFT JOIN Employee e ON t2.emp_id = e.emp_id WHERE t1.emp_id = t2.emp_id AND t1.patient_id != t2.patient_id");
        
        // prompt for users to enter an integer
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter int: ");
        String s = br.readLine();
        int value_from_user = Integer.parseInt(s);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queries.get(value_from_user));
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            while(resultSet.next()) {
                for(int i=1; i<=columnCount; i++) {
                    String column_title = resultSetMetaData.getColumnName(i);
                    Object column_value = resultSet.getObject(column_title);
                    System.out.print(column_value + " ");
                }
                System.out.println("");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}