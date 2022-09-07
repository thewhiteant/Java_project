import java.util.Scanner;

public Main{
    String Book_name;
    String Writter_name;
    int book_count;




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
                break;
        }





        inpu.close();
    }



    public static void main(){




    }
}