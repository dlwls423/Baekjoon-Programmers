import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            
            if(A == 0 && B == 0 && C == 0) break;
            if(A*A == B*B + C*C || B*B == A*A + C*C || C*C == A*A + B*B)
                System.out.println("right");
            else
                System.out.println("wrong");
        }
       
    }
}