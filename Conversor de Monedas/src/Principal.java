import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ConsultorMoneda consulta = new ConsultorMoneda();

        int opcion = 0;
        while (opcion != 8) {
            System.out.println("****************************\n\n" +
                    "Bienvenidos al convertidor de monedas\n" +
                    "Ingresa la conversión que deseas realizar\n\n" +
                    "Opción 1 ==> Dólar a Peso Argentino\n" +
                    "Opción 2 ==> Peso Argentino a Dólar\n" +
                    "Opción 3 ==> Dólar a Real Brasileño\n" +
                    "Opción 4 ==> Real Brasileño a Dólar\n" +
                    "Opción 5 ==> Dólar a Peso Colombiano\n" +
                    "Opción 6 ==> Peso Colombiano a Dólar\n" +
                    "Opción 7 ==> Ingresar Monedas Personalizadas\n" +                                          
                    "Opción 8 ==> Salir\n" +
                    "*********************************************\n\n");

            try {
                opcion = teclado.nextInt();
                teclado.nextLine(); 

                switch (opcion) {
                    case 1:
                        GestorConversion.realizarConversion(consulta, teclado, "USD", "ARS");
                        break;

                    case 2:
                        GestorConversion.realizarConversion(consulta, teclado, "ARS", "USD");
                        break;

                    case 3:
                        GestorConversion.realizarConversion(consulta, teclado, "USD", "BRL");
                        break;

                    case 4:
                        GestorConversion.realizarConversion(consulta, teclado, "BRL", "USD");
                        break;

                    case 5:
                        GestorConversion.realizarConversion(consulta, teclado, "USD", "COP");
                        break;

                    case 6:
                        GestorConversion.realizarConversion(consulta, teclado, "COP", "USD");
                        break;

                    case 7:
                        System.out.println("Ingresa la moneda de origen:");
                        String monedaOrigen = teclado.nextLine().toUpperCase();
                        System.out.println("Ingresa la moneda de destino:");
                        String monedaDestino = teclado.nextLine().toUpperCase();
                        GestorConversion.realizarConversionPersonalizada(consulta, teclado, monedaOrigen, monedaDestino);
                        break;

                    case 8:
                        System.out.println("Gracias por utilizar el conversor de monedas");
                        opcion = 8;
                        break;
                }

            } catch (Exception e) {
                System.out.println("Error de conversion.");
                teclado.nextLine();
            }

        }
    }
}