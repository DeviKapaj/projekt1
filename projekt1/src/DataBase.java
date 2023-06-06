import javax.print.attribute.ResolutionSyntax;
import java.sql.*;

public class DataBase {

    protected final String url = "jdbc:mysql://localhost:3306/Klasa";

    protected final String username = "root";

    protected final String password = "devis123";

    protected Connection connection;

    protected Statement statement;

    DataBase(){
        try{
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        }catch (SQLException e){
            e.printStackTrace();
            //System.out.println("Couldn't connect");
        }
    }

    public void addStudent(int id, String name, int date, char sex, String branch, int grade, int year) throws SQLException {
        String sqlInsert = "insert into student values("+ id + ",'" + name + "'," + date + ",'" + sex + "','" + branch + "'," + grade + "," + year +");";
        statement.executeUpdate(sqlInsert);
    }

    public ResultSet getAll() throws SQLException {
        String strselect = "select * from student";
        System.out.println("The SQL statement is: " + strselect + "\n");

        ResultSet rset = statement.executeQuery(strselect);

        return rset;
    }

    public ResultSet getId(int id) throws SQLException{
        String strselect = "select * from student where id="+ id;
        System.out.println("The SQL statement is: " + strselect + "\n");

        ResultSet rset = statement.executeQuery(strselect);

        return rset;
    }

    public void change(int id, int year, int age) throws SQLException {
        String strselect = "update student set viti = "+year+ ", mosha="+age+" where id="+id;
        System.out.println("The SQL statement is: " + strselect + "\n");
        statement.executeUpdate(strselect);
    }

    public void delete(int id) throws SQLException{
        String strselect = "delete from student where id="+id;
        System.out.println("The SQL statement is: " + strselect + "\n");
        statement.executeUpdate(strselect);
    }

    public void sortTable() throws SQLException {
        statement.executeUpdate("create table Student like student");
        statement.executeUpdate("insert into Student (id, emer, mosha, gjinia, dega, mesatare, viti) select id, emer, mosha, gjinia, dega, mesatare, viti from student order by id ASC");
        statement.executeUpdate("drop table student");
        statement.executeUpdate("rename table Student to student");
    }
}
