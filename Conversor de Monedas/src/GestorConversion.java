import java.util.Scanner;

public class GestorConversion {

    public static void realizarConversion(ConsultorMoneda consulta, Scanner teclado, String monedaInicial, String monedaFinal) {
        System.out.println("Ingresa la cantidad a convertir:");
        double cantidad = 0;
        boolean cantidadValida = false;

        while (!cantidadValida) {
            try {
                cantidad = Double.parseDouble(teclado.nextLine());
                if (cantidad >= 0) {
                    cantidadValida = true;
                } else {
                    System.out.println("Error: La cantidad no puede ser negativa. Inténtalo de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingresa un número válido para la cantidad. Inténtalo de nuevo.");
            }
        }

        Conversor conversor = consulta.busquedaMonedas(monedaInicial, monedaFinal, cantidad);

        if (conversor != null) {
            System.out.println("Tasa de conversión: " + conversor.conversion_rate());
            System.out.println("Resultado de la conversión: " + conversor.conversion_result() + "\n");
        } else {
            System.out.println("Error: La conversión no pudo realizarse correctamente. Verifica las monedas ingresadas y la cantidad.");
        }
    }

    public static void realizarConversionPersonalizada(ConsultorMoneda consulta, Scanner teclado, String monedaOrigen, String monedaDestino) {
        System.out.println("Ingresa la cantidad a convertir:");
        double cantidad = 0;
        boolean cantidadValida = false;

        while (!cantidadValida) {
            try {
                cantidad = Double.parseDouble(teclado.nextLine());
                if (cantidad >= 0) {
                    cantidadValida = true;
                } else {
                    System.out.println("Error: La cantidad no puede ser negativa. Inténtalo de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingresa un número válido para la cantidad. Inténtalo de nuevo.");
            }
        }

        Conversor conversor = consulta.busquedaMonedas(monedaOrigen, monedaDestino, cantidad);

        if (conversor != null) {
            System.out.println("Tasa de conversión: " + conversor.conversion_rate());
            System.out.println("Resultado de la conversión: " + conversor.conversion_result() + "\n");
        } else {
            System.out.println("Error: La conversión no pudo realizarse correctamente. Verifica las monedas ingresadas y la cantidad.");
        }
    }
}