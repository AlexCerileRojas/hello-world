import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Vendedores {

    public static void main(String[] args){
        int[][] ventas = new int[12][15];
        Random random = new Random();

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 15; j++) {
                ventas[i][j] = random.nextInt(100); //datos de 0 a 100 para la matriz de ventas
            }
        }
        mostrarMatriz(ventas);

        mostrarVendedorConMasVentas(ventas);

        mesConMenoresVentas(ventas);

        calcularPromedios(ventas);

        int[] ventasVendedor5 = obtenerVentasVendedor5(ventas);
        mostrarVentasVendedor5(ventasVendedor5);

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

    public static int vendedorConMasVentas(int[][] ventas) {
        int[] ventasPorVendedor = new int[15];

        for (int j = 0; j < 15; j++) {
            for (int i = 0; i < 12; i++) {
                ventasPorVendedor[j] += ventas[i][j];
            }
        }

        int maxVentas = 0;
        int vendedorConMasVentas = 0;
        for (int j = 0; j < 15; j++) {
            if (ventasPorVendedor[j] > maxVentas) {
                maxVentas = ventasPorVendedor[j];
                vendedorConMasVentas = j;
            }
        }
        return vendedorConMasVentas;
    }


    public static void mostrarVendedorConMasVentas(int[][] ventas) {
        int vendedorConMasVentas = vendedorConMasVentas(ventas);
        System.out.println("El vendedor con más ventas en el año es el vendedor: " + (vendedorConMasVentas + 1));
    }

    public static void mesConMenoresVentas(int[][] ventas){
        int mesMenor = -1;//
        int menorVentas = Integer.MAX_VALUE;

        for (int i = 0; i < 12; i++) {
            int totalVentasMes = 0;

            for (int j = 0; j < 15; j++){
                totalVentasMes+= ventas[i][j];
            }
            if (totalVentasMes < menorVentas){
                menorVentas = totalVentasMes;
                mesMenor = i + 1;
            }
        }
        System.out.println("El mes con menor ventas fue el : " + mesMenor + " y se vendio " + menorVentas);
    }
    public static void calcularPromedios(int[][] ventas) {
        int totalVentasEmpresa = 0;
        int totalVendedores = 15;
        int totalMeses = 12;

        for (int i = 0; i < totalMeses; i++) {
            for (int j = 0; j < totalVendedores; j++) {
                totalVentasEmpresa += ventas[i][j];
            }
        }
        double promedioMensual = (double) totalVentasEmpresa / totalMeses;

        double promedioPorVendedor = (double) totalVentasEmpresa / totalVendedores;

        System.out.println("Promedio de venta mensual de la empresa: " + promedioMensual);
        System.out.println("Promedio de venta por vendedor: " + promedioPorVendedor);
    }
    public static int[] obtenerVentasVendedor5(int[][] ventas) {
        int[] ventasVendedor5 = new int[12];

        for (int i = 0; i < 12; i++) {
            ventasVendedor5[i] = ventas[i][4];
        }

        return ventasVendedor5;
    }
    // Usamos un array para mostrar las ventas del vendedor 5
    public static void mostrarVentasVendedor5(int[] ventasVendedor5) {
        System.out.println("Ventas del vendedor 5: " + Arrays.toString(ventasVendedor5));
        }

}


