
public class App {
    public static void main(String[] args) throws InterruptedException {

        int[][] numeros = generaArray(4, 5, 100, 999);
        mostrarArray(numeros);
    }

    public static int[][] generaArray(int filas, int columnas, int min, int max) {
        int[][] array = new int[filas][columnas];
        for (int i= 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int)(Math.random() * (max - min + 1)) + min;
            }
        }
        return array;
    }

    public static void mostrarArray(int[][] array) throws InterruptedException {
        System.out.println();
        for (int i = 0; i < array.length; i++)
            muestraFila(array, i);
        System.out.println("------------------------------------------------");
        muestraTotales(array);
    }

    public static void muestraFila(int[][] array, int fila) throws InterruptedException  {
        int suma = 0, valor;
        for (int j = 0; j < array[fila].length; j++) {
            valor = array[fila][j];
            muestraValor("%7d", valor, 800);
            suma += array[fila][j];
        }
        muestraValor("  |%7d%n", suma, 1000);
    }

    public static int sumaColumna(int[][] array, int columna) {
        int suma = 0;
        for (int[] array1 : array) {
            suma += array1[columna];
        }
        return suma;
    }

    public static void muestraTotales(int[][] array) throws InterruptedException {
        int suma = 0, total;
        for (int i: array[0]) {
            total = sumaColumna(array, i);
            muestraValor("%7d", total, 1000);
            suma += total;
        }
        muestraValor("  |%7d%n%n", suma, 1500);
    }

    public static void muestraValor(String texto, int valor, int tiempo) throws InterruptedException {
        Thread.sleep(tiempo);
        System.out.printf(texto, valor);
    }
}


