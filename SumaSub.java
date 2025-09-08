import java.util.Scanner;

public class SumaSub {

    // Función recursiva para determinar si existe un subconjunto con suma objetivo
    public static boolean subsetSum(int[] nums, int n, int valor) {
        if (valor == 0) return true;  
        if (n == 0 && valor != 0) return false; 

        // Si el último número es mayor que la suma objetivo, lo ignoramos
        if (nums[n - 1] > valor) 
            return subsetSum(nums, n - 1, valor);

        // Caso recursivo: considerar dos opciones
        // 1. Incluir el número actual
        // 2. Excluir el número actual
        return subsetSum(nums, n - 1, valor) || subsetSum(nums, n - 1, valor - nums[n - 1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] conjunto = {3, 34, 4, 12, 5, 2};
        System.out.print("Introduce el valor objetivo: ");
        int valor = sc.nextInt();

        if (subsetSum(conjunto, conjunto.length, valor))
            System.out.println("Sí existe un subconjunto con suma " + valor);
        else
            System.out.println("No existe un subconjunto con suma " + valor);
    }
}
