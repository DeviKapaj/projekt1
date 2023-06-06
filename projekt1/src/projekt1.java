
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class projekt1 {

    Scanner scanner = new Scanner(System.in);
    projekt1() throws SQLException {

        DataBase dataBase = new DataBase();

        System.out.println("Cfare veprimi doni te beni?");
        System.out.println("1: Shto student");
        System.out.println("2: Kalo tek komandat");

        int veprimi = scanner.nextInt();

        if(veprimi == 1){
            System.out.println("Jepni numrin e studenteve qe doni te shtoni");
            int nrstudent = scanner.nextInt();

            System.out.println("Jepni te dhenat e cdo studenti: id, emer, mosha, gjinia, dega, mesatare, viti");
            for (int i = 0; i < nrstudent; i++) {
                System.out.print("Studenti "+ i +" :");
                dataBase.shtoStudent(scanner.nextInt(), scanner.next(), scanner.nextInt(), scanner.next().charAt(0), scanner.next(), scanner.nextInt(), scanner.nextInt());
                System.out.println();
            }
        } else if (veprimi == 2) {
            System.out.println("");
        }

        System.out.println("Jepni nje komand:");
        System.out.println("1: Shiko listen e renditur te studenteve");
        System.out.println("2: Kerko nje student specifik duke perdorur ID");
        System.out.println("3: Ndrysho vitin dhe moshen e studentit");
        System.out.println("4: Hiq nje student nga tabela");

        int nr = scanner.nextInt();
            switch(nr){

                case 1:
                    dataBase.sortTable();
                    ResultSet rset = dataBase.getAll();
                    while(rset.next()){
                        System.out.println(rset.getInt("id") + " " + rset.getString(2) + " " + rset.getInt(3) + " " + rset.getString(4) + " " + rset.getString(5) + " " + rset.getInt(6) + " " + rset.getInt(7));
                    }
                    break;

                case 2:
                    System.out.println("Kerko me ID");
                    rset = dataBase.getId(scanner.nextInt());
                    while(rset.next()){
                        System.out.println(rset.getInt("id") + " " + rset.getString(2) + " " + rset.getInt(3) + " " + rset.getString(4) + " " + rset.getString(5) + " " + rset.getInt(6) + " " + rset.getInt(7));
                    }
                    break;

                case 3:
                    System.out.println("Kerko me ID");
                    int id = scanner.nextInt();
                    System.out.println("Vendosni vitin e ri");
                    int viti = scanner.nextInt();
                    System.out.println("Vendosni moshen");
                    int mosha = scanner.nextInt();
                    dataBase.change(id, viti, mosha);
                    break;

                case 4:
                    System.out.println("Kerko me ID studentin qe doni te fshini");
                    id = scanner.nextInt();
                    dataBase.delete(id);

                default:
                    System.exit(0);
            }

        }
    }

