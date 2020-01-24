package Database;


import net.bit.academia.model.Course;
import net.bit.academia.model.net.bit.academia.persistence.repositories.DataExeption;
import net.bit.academia.model.net.bit.academia.persistence.repositories.abstractions.CourseRepository;
import net.bit.academia.model.net.bit.academia.persistence.repositories.inMemory.InMemoryRepositoryCorsi;

import java.io.*;
import java.util.Collection;
import java.util.Scanner;

public class DatabaseFile{
    public static void main(String[] args) throws DataExeption {
        DatabaseFile dbt = new DatabaseFile();
        dbt.writeFileCorsi();
    }
    public void createFile(){
        try {
            File file = new File("db.txt");
            if (file.createNewFile()){
                System.out.println("File created: "+ file.getName());
            }else {
                System.out.println("File already exists");
            }
        }catch (IOException e){
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }
    public void writeFile(){
        Scanner sc = new Scanner(System.in);
        System.out.println("ID");
        String id = sc.nextLine();
        System.out.println("Firstname");
        String fn = sc.nextLine();
        System.out.println("Lastname");
        String ln = sc.nextLine();
        System.out.println("Sex");
        String sx = sc.nextLine();


        try {
            File file = new File("db.txt");
            PrintWriter pw = new PrintWriter(new FileOutputStream(file,true));
            pw.append("\n"+id+","+fn+","+ln+","+sx);
            pw.close();
            System.out.println("Successfully wrote the file");
        }catch (IOException e ){
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }
    public void readFile(){

        try {
            BufferedReader br = new BufferedReader(new FileReader("db.txt"));
            System.out.println("lettura");
            String s = "";
            while ((s= br.readLine())!=null){
                String data[]=new String[4];
                data = s.split(",");
                for (int i = 0; i<4;i++){
                    System.out.print(data[i]+ " ");
                }
                System.out.println();
            }
        }catch (IOException e ){
            System.out.println("An error occured");
            e.printStackTrace();
        }

    }public void writeFileCorsi() throws DataExeption {
        CourseRepository courses = new InMemoryRepositoryCorsi();
        Collection<Course> cc ;
        cc = courses.getAll();
        try {
            File file = new File("db.txt");
            BufferedWriter pw = new BufferedWriter(new FileWriter(file));
            pw.write(cc.toString());

            pw.close();
            System.out.println("Successfully wrote the file");
        }catch (IOException e ){
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }
}
