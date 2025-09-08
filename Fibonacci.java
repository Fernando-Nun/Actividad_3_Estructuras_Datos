import java.util.Scanner;

public class Fibonacci {

    public static void mostrar(int a, int b, int n) {
        if (n > 0) {
            System.out.print(a + ", ");
            mostrar(b, a + b, n - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Serie de Fibonacci");
        System.out.print("\nIntroduce el número de elementos de la serie: ");
        int n = scanner.nextInt();
        System.out.println("");
        mostrar(0, 1, n);
    }
}
