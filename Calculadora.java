public class Calculadora {
    public int sumar(int a, int b) {
        return a + b;
    }
    public int restar(int a, int b) {
        return a - b;
    }
    public int multiplicar(int a, int b) {
        return a * b;
    }
    public int dividir(int a, int b) {
        if (b == 0) {
            System.out.println("No se puede dividir por cero.");
            return 0;
        }
        return a / b;
    }

    public static void main(String[] args) {

        Calculadora calc = new Calculadora();

        int suma = calc.sumar(8, 5);
        int resta = calc.restar(8, 5);
        int multiplicacion = calc.multiplicar(8, 5);
        int division = calc.dividir(8, 5);

        System.out.println("El resultado de la suma: " + suma);
        System.out.println("El resultado de la resta: " + resta);
        System.out.println("El resultado de la multiplicación: " + multiplicacion);
        System.out.println("El resultado de la división: " + division);
    }
}