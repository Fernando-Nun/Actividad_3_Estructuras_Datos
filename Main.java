public class Main {

    private static final int N = 9; // tamaño del tablero 9x9

    // Verificar si un número se puede colocar en una celda
    public static boolean esSeguro(int[][] tablero, int fila, int col, int num) {
        // Verificar fila y columna
        for (int i = 0; i < N; i++) {
            if (tablero[fila][i] == num || tablero[i][col] == num)
                return false;
        }

        // Verificar subcuadro 3x3
        int inicioFila = fila - fila % 3;
        int inicioCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i + inicioFila][j + inicioCol] == num)
                    return false;
            }
        }
        return true;
    }

    // Resolver el Sudoku con backtracking
    public static boolean resolverSudoku(int[][] tablero, int fila, int col) {
        if (fila == N - 1 && col == N) return true;
        if (col == N) {
            fila++;
            col = 0;
        }
        if (tablero[fila][col] != 0) return resolverSudoku(tablero, fila, col + 1);

        for (int num = 1; num <= 9; num++) {
            if (esSeguro(tablero, fila, col, num)) {
                tablero[fila][col] = num;
                if (resolverSudoku(tablero, fila, col + 1)) return true;
                tablero[fila][col] = 0; // backtracking
            }
        }
        return false;
    }

    // Imprimir el tablero
    public static void imprimirTablero(int[][] tablero) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] tablero = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if (resolverSudoku(tablero, 0, 0))
            imprimirTablero(tablero);
        else
            System.out.println("No existe solución para este Sudoku");
    }
}
