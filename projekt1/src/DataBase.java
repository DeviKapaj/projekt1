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
            statement = connection.createStatement(); /*{
               String strselect = "select emer, mosha,  id from Zhigolo";
                System.out.println("The SQL statement is: " + strselect + "\n"); // Echo For debugging

                ResultSet rset = statement.executeQuery(strselect);

                System.out.println("The records selected are: ");
                int rowcount = 0;
                while (rset.next()){
                    String emer = rset.getString("emer");
                    int mosha = rset.getInt("mosha");
                    int id = rset.getInt("id");
                    System.out.println(emer + " " + mosha + " " + id);
                    ++rowcount;
                }
                System.out.println("Total numbers of rows: "+ rowcount);
            }*/
        }catch (SQLException e){
            e.printStackTrace();
            //System.out.println("Couldn't connect");
        }
    }

    public void shtoStudent(int id, String emer, int dtl, char gjini, String dega, int mesatare, int viti) throws SQLException {
        String sqlInsert = "insert into student values("+ id + ",'" + emer + "'," + dtl + ",'" + gjini + "','" + dega + "'," + mesatare + "," + viti +");";
        statement.executeUpdate(sqlInsert);
    }

    public ResultSet getAll() throws SQLException {
        String strselect = "select * from student";
        System.out.println("The SQL statement is: " + strselect + "\n"); // Echo For debugging

        ResultSet rset = statement.executeQuery(strselect);

        return rset;
    }

    public ResultSet getId(int id) throws SQLException{
        String strselect = "select * from student where id="+ id;
        System.out.println("The SQL statement is: " + strselect + "\n");

        ResultSet rset = statement.executeQuery(strselect);

        return rset;
    }

    public void change(int id, int viti, int mosha) throws SQLException {
        String strselect = "update student set viti = "+viti+ ", mosha="+mosha+" where id="+id;
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
