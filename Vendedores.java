import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Vendedores {

    public static void main(String[] args){
        int[][] ventas = new int[15][12]; // i vendedores j meses
        Random random = new Random();

        // matriz con valores aleatorios del 0 al 100
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 12; j++) {
                ventas[i][j] = random.nextInt(100); //datos de 0 a 100 para la matriz de ventas
            }
        }

        iniciarMenu(ventas);

    }
    public static void iniciarMenu(int[][] ventas){
        boolean salir = false;
        Scanner scanner = new Scanner(System.in);

        while(!salir) {
            mostrarMenu();                          // llamamos al metodo que imprimira el menu
            int opcion = leerOpcion(scanner);        //lee la opcion del usuario

            switch (opcion){
                case 1:
                    System.out.println("Mostrando matriz: ");
                    mostrarMatriz(ventas);
                    break;
                case 2:
                    System.out.println("Mostrando vendedor con mas ventas: ");
                    mostrarVendedorConMasVentas(ventas);
                    break;
                case 3:
                    System.out.println("Mostrando mes con menores ventas: ");
                    mesConMenoresVentas(ventas);
                    break;

                case 4:
                    System.out.println("Calculando promedio de ventas de la empresa: ");
                    calcularPromedios(ventas);
                    break;

                case 5:
                    System.out.println("Mostrando ventas del vendedor 5: ");
                    mostrarVentasVendedor5(obtenerVentasVendedor5(ventas));
                    break;

                case 6:
                    System.out.println("Saliendo del programa: ");
                    salir = true;
                    break;
                default:
                    System.out.println("La opcion no es valida, intentelo denuevo: ");
            }
        }
        scanner.close();

    }

    public static void mostrarMenu(){
        System.out.println("========= Menú =========");
        System.out.println("1. Mostrar matriz ");
        System.out.println("2. Vendedor con mas ventas ");
        System.out.println("3. Mostrar mes con menores ventas ");
        System.out.println("4. Calcular promedio de ventas mensual ");
        System.out.println("5. Mostrar ventas del vendedor 5 ");
        System.out.println("6. Salir ");
        System.out.println("========================");
        System.out.print("Seleccione una opción: ");
    }

    public static int leerOpcion(Scanner scanner) {
        return scanner.nextInt();

    }


    public static void mostrarMatriz(int[][] matriz) {
        System.out.println(" Matriz de ventas (15x12):");
        for (int i = 0; i < 15; i++) {
            System.out.print("Vendedor "+ (i+1) + ": ");
            for (int j = 0; j < 12; j++) {
                System.out.print(matriz[i][j] + "\t"); // el \t es para darle espacio a la matriz
            }
            System.out.println();
        }
    }

    // hacer una matriz con los valores de las sumas
    public static int sumarConMasVentas(int[][] ventas) {
        int[] ventasPorVendedor = new int[15];

        for (int i = 0; i < 15; i++) {    // recorre los vendedores
            for (int j = 0; j < 12; j++) { // recorre los meses
                ventasPorVendedor[i] += ventas[i][j];
            }
        }

        int maxVentas = 0;
        int vendedorConMasVentas = 0;
        for (int i = 0; i < 15; i++) {
            if (ventasPorVendedor[i] > maxVentas) {
                maxVentas = ventasPorVendedor[i];
                vendedorConMasVentas = i;
            }
        }
        return vendedorConMasVentas;
    }


    public static void mostrarVendedorConMasVentas(int[][] ventas) {
        int vendedorConMasVentas = sumarConMasVentas(ventas);
        System.out.println("El vendedor con más ventas en el año es el vendedor: " + (vendedorConMasVentas + 1));
    }

    public static void mesConMenoresVentas(int[][] ventas){
        int mesMenor = -1;//
        int menorVentas = Integer.MAX_VALUE;

        for (int j = 0; j < 12; j++) {
            int totalVentasMes = 0;

            for (int i = 0; i < 15; i++) {
                totalVentasMes += ventas[i][j];
            }

            if (totalVentasMes < menorVentas) {
                menorVentas = totalVentasMes;
                mesMenor = j + 1;
            }
        }

        System.out.println("El mes con menores ventas fue: " + mesMenor + " y se vendieron " + menorVentas + " productos.");
    }
    public static void calcularPromedios(int[][] ventas) {
        int totalVentasEmpresa = 0;
        int totalVendedores = 15;
        int totalMeses = 12;

        for (int i = 0; i < totalVendedores; i++) {
            for (int j = 0; j < totalMeses; j++) {
                totalVentasEmpresa += ventas[i][j];
            }
        }
        double promedioMensual = (double) totalVentasEmpresa / totalMeses;

        double promedioPorVendedor = (double) totalVentasEmpresa / totalVendedores;

        System.out.println("Promedio de venta mensual de la empresa: " + promedioMensual);
        System.out.println("Promedio de venta por vendedor: " + promedioPorVendedor);
    }
    public static int[] obtenerVentasVendedor5(int[][] ventas) {
        int[] ventasVendedor5 = new int[15];

        for (int i = 0; i < 15; i++) {
            ventasVendedor5[i] = ventas[i][4];
        }

        return ventasVendedor5;
    }
    // Usamos un array para mostrar las ventas del vendedor 5
    public static void mostrarVentasVendedor5(int[] ventasVendedor5) {
        System.out.println("Ventas del vendedor 5: " + Arrays.toString(ventasVendedor5));
        }

}


