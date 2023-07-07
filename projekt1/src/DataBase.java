import java.sql.*;

public class DataBase {

    protected final String url = "jdbc:mysql://localhost:3306/klasa";

    protected final String username = "root";

    protected final String password = "onepieceluffy1";

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

    public void addStudent(int id, String name, int date, char sex, String branch, double grade, int year) throws SQLException {
        String sqlInsert = "insert into student values("+ id + ",'" + name + "'," + date + ",'" + sex + "','" + branch + "'," + grade + "," + year +");";
        statement.executeUpdate(sqlInsert);
        statement.executeUpdate("insert into subject (ID) values(" + id + ")");

    }

    public ResultSet getAll() throws SQLException {
        String strselect = "select * from student";
        System.out.println("The SQL statement is: " + strselect + "\n");

        ResultSet rset = statement.executeQuery(strselect);

        return rset;
    }

    public ResultSet getId(int id) throws SQLException{
        String strselect = "select * from student where ID="+ id;
        System.out.println("The SQL statement is: " + strselect + "\n");

        ResultSet rset = statement.executeQuery(strselect);

        return rset;
    }

    public void change(int id, int year, int age)throws SQLException {
        String strselect = "update student set YEAR = "+year+ "where ID="+id;
        System.out.println("The SQL statement is: " + strselect + "\n");
        statement.executeUpdate(strselect);
    }

    public void delete(int id) throws SQLException{
        String strselect = "delete from student where ID="+id;
        System.out.println("The SQL statement is: " + strselect + "\n");
        statement.executeUpdate(strselect);
    }

    public void sortTable() throws SQLException {
        statement.executeUpdate("create table Student like student");
        statement.executeUpdate("insert into Student (ID, NAME, AGE, SEX, BRANCH, GRADE, YEAR) select ID, NAME, AGE, SEX, BRANCH, GRADE, YEAR from student order by id ASC");
        statement.executeUpdate("drop table student");
        statement.executeUpdate("rename table Student to student");
        statement.executeUpdate("create table Subject like subject");
        statement.executeUpdate("insert into Subject(ID, Algoritmike, Matematike, Anglisht, Cpp, SistemeMultimediale, ArkitektureKomp, LendeMeZgjedhje, Java) select ID, Algoritmike, Matematike, Anglisht, Cpp, SistemeMultimediale, ArkitektureKomp, LendeMeZgjedhje, Java from subject order by id ASC");
        statement.executeUpdate("drop table subject");
        statement.executeUpdate("rename table Subject to subject");
    }

    public void changeGrade(double grade, int id) throws SQLException{
        String strselect = "update student set GRADE= " + grade + " where ID=" + id;
        System.out.println("The SQL statement is: " + strselect + "\n");
        statement.executeUpdate(strselect);
    }

    public ResultSet byGrade() throws SQLException{
        ResultSet rset = statement.executeQuery("select ID, NAME, AGE, SEX, BRANCH, GRADE, YEAR from student order by GRADE DESC");
        return rset;

    }

    public void addGrade(int grade1,int grade2,int grade3,int grade4,int grade5,int grade6,int grade7, int grade8, int id) throws SQLException {
        String strselect = "update subject set Algoritmike= " + grade1 + ", Matematike= "+ grade2 + " , Anglisht= " + grade3 + ", Cpp= " + grade4 + ", SistemeMultimediale= " + grade5 + ", ArkitektureKomp= " + grade6 + ", LendeMeZgjedhje= " + grade7 + ", Java= " +grade8 + " where ID= "+ id;
        statement.executeUpdate(strselect);
    }

}
