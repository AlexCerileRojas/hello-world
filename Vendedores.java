import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Vendedores {

    public static void main(String[] args){
        int[][] ventas = new int[12][15];
        Random random = new Random();

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 15; j++) {
                ventas[i][j] = random.nextInt(100);
            }
        }
        mostrarMatriz(ventas);
    }

    public static void mostrarMatriz(int[][] matriz){
    System.out.println(" Matriz de ventas (12x15):");
    for (int i = 0; i < 12; i++) {
        for (int j = 0; j < 15; j++) {
            System.out.print(matriz[i][j] + "\t"); // el \t es para darle espacio a la matriz
        }
        System.out.println();

    public static void CalcularVentasAño(int[][] ventas) {
        for (int j = 0; j < 15; j++){
            int totalVentas = 0;

            for (int i = 0; i < 12; i++){
                totalVentas += ventas[i][j]
            }
        }
        }
    }
}
}