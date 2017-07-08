import static java.lang.System.out;
import static java.lang.System.in;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Input {
 
    public static String lerString() {
        Scanner input = new Scanner(in);
        boolean ok = false; 
        String txt = "";
        while(!ok) {
            try {
                txt = input.nextLine();
                ok = true;
            }
            catch(InputMismatchException e) {
               out.println("Texto Inválido"); 
               out.print("Novo valor: ");
               input.nextLine(); 
            }
        }
        input.close();
        return txt;
    } 

 
    public static int lerInt() {
        Scanner input = new Scanner(in);
        boolean ok = false; 
        int i = 0; 
        while(!ok) {
            try {
                i = input.nextInt();
                ok = true;
            }
            catch(InputMismatchException e) { 
               out.println("Inteiro Inválido"); 
               out.print("Novo valor: ");
               input.nextLine(); 
            }
        }
        input.close();
        return i;
    } 
  
    public static double lerDouble() {
        Scanner input = new Scanner(in);
        boolean ok = false; 
        double d = 0.0; 
        while(!ok) {
            try {
                d = input.nextDouble();
                ok = true;
            }
            catch(InputMismatchException e) { 
                out.println("Valor real Inválido"); 
                out.print("Novo valor: ");
                input.nextLine(); 
            }
        }
        input.close();
        return d;
    }  
  
    public static boolean lerBoolean() {
        Scanner input = new Scanner(in);
        boolean ok = false; 
        boolean b = false; 
        while(!ok) {
            try {
                b = input.nextBoolean();
                ok = true;
            }
            catch(InputMismatchException e) { 
                out.println("Booleano Inválido"); 
                out.print("Novo valor: ");
                input.nextLine(); 
            }
        }
        input.close();
        return b;
    } 
  
    public static long lerLong() {
        Scanner input = new Scanner(in);
        boolean ok = false; 
        long l=0;
        while(!ok) {
            try {
                l = input.nextLong();
            }
            catch(InputMismatchException e) { 
               out.println("Texto Inv·lido"); 
               out.print("Novo valor: ");
               input.nextLine(); 
            }
        }
        input.close();
        return l;
    } 
 
}
