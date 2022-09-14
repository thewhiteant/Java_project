package Librery;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main{
    String Book_name;
    String Writter_name;
    String qntt;
    String usr;
    String Phone;




    public int get_last_id(){
        String id;
        String bKname;
        String NameW;
        String Dat;
        File rf = new File("person.txt");


        int checkAndHOld = 0;
        try {

            Scanner rdf = new Scanner(rf);
            while (rdf.hasNext()) {
                id = rdf.next();
                bKname = rdf.next();
                NameW = rdf.next();
                Dat = rdf.next();

                if(checkAndHOld < Integer.parseInt(id) ){
                    checkAndHOld = Integer.parseInt(id);
                }
            }
            rdf.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        return  checkAndHOld;

    }
    void menu(){
        Scanner inpu = new Scanner(System.in);
        System.out.print("1.Rent Book\n2.Back Book\n3.Admin\nChoose: ");

        int c = inpu.nextInt();
        switch (c) {
            case 1:
                rent();
                break;
            case 2:
                back();
                break;
            case 3:
                admin();
                break;
            default:
                System.out.println("Please Select Valid Option");
                break;
        }



        inpu.close();
    }




    public void  admin(){
        Scanner inpu = new Scanner(System.in);
        System.out.println("__Admin Menu__");
        System.out.print("1.Add Book\n2.All Books \n3.Edit \n4.remove \n5.Member\nChoose:");
        int c = inpu.nextInt();
        switch (c){
            case 1:
                Add_book();
                break;
            case 2:
                Display_all_book();
                break;
            case 3:
                System.out.print("Book Name:  ");
                String cc = inpu.nextLine();
                edit(cc);
                break;
            case 4:
                System.out.print("Book Name:  ");
                String cck = inpu.nextLine();
                remove_itm(cck);
                break;
            case 5:
                Member();
                break;
            default:
                System.out.println("WOOOW!! WOOOW!! Select Valid");
                break;
        }
        inpu.close();
    }
    public void Add_book(){
        Scanner inpu = new Scanner(System.in);
        System.out.println("__Book Rental System__");
        System.out.print("Enter Book Name: ");
        Book_name = inpu.nextLine();
        System.out.print("Enter Writter Name: ");
        Writter_name = inpu.nextLine();
        System.out.print("Add Book quantities: ");
        qntt = inpu.nextLine();
        writter(Integer.toString(get_last_id() + 1),Book_name,Writter_name,qntt, "person.txt");
        inpu.close();
    }

    void Display_all_book() {
        File rf = new File("person.txt");
        System.out.println("ID     Name        Quantities  ");
        try {
            Scanner rdf = new Scanner(rf);
            while (rdf.hasNext()) {
                String id = rdf.next();
                Book_name = rdf.next();
                Writter_name = rdf.next();
                String Date = rdf.next();
                System.out.println(id + "      " + Book_name + "        " + Date);

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void writter(String id, String BName, String w, String q,String FIlename) {
        try {
            FileWriter myWriter = new FileWriter(FIlename, true);
            myWriter.write(id + " " + BName + " " + w + " " + q + "\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public void edit(String name){
      
  
        try{
            Scanner edito = new Scanner(System.in);
            // File tempfile = new File("temp.txt");
            // tempfile.createNewFile();
            File mainfile = new File("person.txt");
            Scanner temprint = new Scanner(mainfile);
            while(temprint.hasNext()){
                String id = temprint.next();
                Book_name = temprint.next();
                Writter_name =  temprint.next();
                String qntt =  temprint.next();
                if(Objects.equals(name, Book_name)){
                   System.out.print("Enter Name: ");
                   String nm = edito.nextLine();
                   System.out.print("Enter Writter Name: ");
                   String wn = edito.nextLine();
                   System.out.print("Enter Quentities: ");
                   String qnty = edito.nextLine();
                   writter(id,nm, wn, qnty, "temp.txt");
                   continue;

                }
                writter(id,Book_name, Writter_name, qntt, "temp.txt");
            }
                temprint.close();
                edito.close();
                mainfile.delete();
                File rf = new File("temp.txt");
                File nf = new File("person.txt");
                rf.renameTo(nf);

        
            }catch (IOException e) {
              e.printStackTrace();
            }}


    void remove_itm(String Name){

        try{
            Scanner edito = new Scanner(System.in);
            // File tempfile = new File("temp.txt");
            // tempfile.createNewFile();
            File mainfile = new File("person.txt");
            Scanner temprint = new Scanner(mainfile);
            while(temprint.hasNext()){
                String id = temprint.next();
                Book_name = temprint.next();
                Writter_name =  temprint.next();
                String qntt =  temprint.next();
                if(Objects.equals(Name, Book_name)){
                         continue;
                }
                writter(id,Book_name, Writter_name, qntt, "temp.txt");
            }
            temprint.close();
            edito.close();
            mainfile.delete();
            File rf = new File("temp.txt");
            File nf = new File("person.txt");
            rf.renameTo(nf);


        }catch (IOException e) {
            e.printStackTrace();
        }}



    void rent(){
        Scanner inpu = new Scanner(System.in);
        System.out.println("__Book Rental System__");
        System.out.print("Enter Book Name: ");
        Book_name = inpu.nextLine();
        System.out.println("your Name: ");
        String Name = inpu.nextLine();
        System.out.println("Back Date: ");
        String d = inpu.nextLine();
        System.out.println("Book Name   Name   BackDate");
        System.out.println(Book_name + " " + Name + " " + d);
        inpu.close();
    }


    public void back() {
        Scanner inpu = new Scanner(System.in);
        System.out.println("__Book Rental System__");
        System.out.print("Enter Book Name: ");
        Book_name = inpu.nextLine();
        System.out.println("your Name: ");
        String Name = inpu.nextLine();
        System.out.println("Book Backed Thank you");
        inpu.close();
    }

    

    public  void Member(){
        Scanner inpu = new Scanner(System.in);
        System.out.println("__Member Option__");
        System.out.print("1.Add Membr\n2.Remove member\n3.Edit Member\4.Renew Membership\nchoise: ");
        int c = inpu.nextInt();
        switch (c){
            case 1:
                add_member();
                break;
            case 2:
                remove_mem();
                break;
            case 3:
                edit_mem();
                break;
            case 4:
                renew();
                break;
        }

    }

    public int get_member_id(){
        String id;
        String bKname;
        String NameW;
        String Dat;
        File rf = new File("member.txt");


        int checkAndHOld = 0;
        try {

            Scanner rdf = new Scanner(rf);
            while (rdf.hasNext()) {
                id = rdf.next();
                usr = rdf.next();
                Phone = rdf.next();
                Dat = rdf.next();

                if(checkAndHOld < Integer.parseInt(id) ){
                    checkAndHOld = Integer.parseInt(id);
                }
            }
            rdf.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        return  checkAndHOld;

    }



    public  void add_member(){
        Scanner inpu = new Scanner(System.in);
        System.out.println("__Member Adding __");
        System.out.print("Enter Name: ");
        usr = inpu.nextLine();
        System.out.print("your Phone Number: ");
        Phone = inpu.nextLine();
        System.out.print("your data: ");
        String date = inpu.nextLine();
        System.out.println("Added Successfully");
        try {
            FileWriter myWriter = new FileWriter("member.txt", true);
            myWriter.write( (get_member_id() + 1)+ " " + usr + " " + Phone + " " + date + "\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        inpu.close();



    }
    public void remove_mem(String name) throws FileNotFoundException {
        try {
        Scanner edito = new Scanner(System.in);
        File mainfile = new File("member.txt");
        FileWriter myWriter = new FileWriter("member.txt", true);
        Scanner temprint = new Scanner(mainfile);
        while(temprint.hasNext()){
            String id = temprint.next();
            usr = temprint.next();
            Phone =  temprint.next();
            String date =  temprint.next();

            if(Objects.equals(name, usr)){
                System.out.print("Enter Name: ");
                String nm = edito.nextLine();
                System.out.print("Enter Phone: ");
                String phn = edito.nextLine();
                System.out.print("Edit Date: ");
                String dat = edito.nextLine();
                myWriter.write( id + " " + nm + " " + phn + " " + dat + "\n");
                continue;
            }
                myWriter.write( id + " " + usr + " " + Phone + " " + date + "\n");
        }
        myWriter.close();
        temprint.close();
        edito.close();
        mainfile.delete();
        File rf = new File("temp.txt");
        File nf = new File("member.txt");
        rf.renameTo(nf);


    }catch (IOException e) {
        e.printStackTrace();
    }}













    }
    public void edit_mem(){

    }
    public void renew(){

    }
    public static void main(String[] args){

        Main main = new Main();
        main.add_member();


    }
}




