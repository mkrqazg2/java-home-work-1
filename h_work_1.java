// Написать программу вычисления n-ого треугольного числа.


public class h_work_1 {

    public static void main(String[] args) {
        int n = 7;
        for (int i = 1; i <= n; i++) {
            int triangular = 0;

            for (int j = 1; j <= i; j++) {
                triangular = triangular + j;
            }
            System.out.println(i + " = " + triangular);
       }
        
    }
}

