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

        calcularVentasAño(ventas);

        mesConMenoresVentas(ventas);

    }

    public static void mostrarMatriz(int[][] matriz) {
        System.out.println(" Matriz de ventas (12x15):");
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 15; j++) {
                System.out.print(matriz[i][j] + "\t"); // el \t es para darle espacio a la matriz
            }
            System.out.println();
        }
    }

    public static void calcularVentasAño(int[][] ventas) {
        for (int j = 0; j < 15; j++) {
            int totalVentas = 0;

            for (int i = 0; i < 12; i++){
                totalVentas += ventas[i][j];
            }

            System.out.println("Total de ventas en el año para el vendedor " + (j + 1) ": "+ totalVentas);
        }
    }

    public static void mesConMenoresVentas(int[][] ventas){
        int mesMenor = -1;//
        int menorVentas = Integer.MAX_VALUE;

        for (int i = 0; i < 12; i++) {
            int totalVentasMes = 0;

            for (int j = 0; j < 15; j++){
                totalVentasMes+= ventas[i][j];
            }
            if (totalVentasMes < mesMenor){
                menorVentas = totalVentasMes;
                mesMenor = i + 1;
            }
        }
        System.out.println("El mes con menor ventas fue :" + mesMenor + "y vendio" + menorVentas);
    }
}

