
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import Conversiones.Moneda;
import Conversiones.Temperatura;

public class Convertidor {
    public static void main(String[] args) throws Exception {
        // Mostrar el menú y obtener la opción seleccionada por el usuario
        String[] opciones = { "Convertidor de Monedas", "Convertidor de Temperatura" };
        int opcionSeleccionada = JOptionPane.showOptionDialog(
                null,
                "Seleccione una opción:",
                "Menú de Convertidores",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]);

        // Procesar la opción seleccionada por el usuario
        if (opcionSeleccionada == 0) {
            // Convertidor de Monedas
            convertirMonedas();
        } else if (opcionSeleccionada == 1) {
            // Convertidor de Temperatura
            convertirTemperatura();
        } else {
            // Opción inválida
            JOptionPane.showMessageDialog(null, "Opción inválida. Saliendo del programa.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void convertirMonedas() {
        // Mapa para almacenar las opciones de conversión
        Map<String, Moneda> opcionesDeConversion = new HashMap<>();
        opcionesDeConversion.put("Colones > Dólares", new Moneda("Colones", "Dólares", 0.0018));
        opcionesDeConversion.put("Colones > Euros", new Moneda("Colones", "Euros", 0.0017));
        opcionesDeConversion.put("Colones > Libras", new Moneda("Colones", "Libras", 0.0014));
        opcionesDeConversion.put("Colones > Yenes", new Moneda("Colones", "Yenes", 0.26));
        opcionesDeConversion.put("Colones > Wones", new Moneda("Colones", "Wones", 2.36));
        opcionesDeConversion.put("Dólares > Colones", new Moneda("Dólares", "Colones", 542.64));
        opcionesDeConversion.put("Euros > Colones", new Moneda("Euros", "Colones", 596.16));
        opcionesDeConversion.put("Libras > Colones", new Moneda("Libras", "Colones", 695.64));
        opcionesDeConversion.put("Yenes > Colones", new Moneda("Yenes", "Colones", 3.80));
        opcionesDeConversion.put("Wones > Colones", new Moneda("Wones", "Colones", 0.42));

        // Mostrar el JComboBox para que el usuario seleccione la opción de conversión
        String seleccion = (String) JOptionPane.showInputDialog(
                null,
                "Selecciona la conversión:",
                "Convertidor de Monedas",
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcionesDeConversion.keySet().toArray(new String[0]),
                opcionesDeConversion.keySet().toArray(new String[0])[0]);

        if (seleccion != null) {

            String montoInput = JOptionPane.showInputDialog(null, "Ingresa la cantidad:");
            if (montoInput != null && !montoInput.isEmpty()) {
                double monto = Double.parseDouble(montoInput);

                // Obtener la opción de conversión a partir de la selección del usuario
                Moneda conversionOption = opcionesDeConversion.get(seleccion);
                String monedaOrigen = conversionOption.getMonedaOrigen();
                String monedaDestino = conversionOption.getMonedaDestino();
                double tasaDeCambio = conversionOption.getTasaDeCambio();

                double resultado;

                if (monedaOrigen.equals("Colones")) {
                    resultado = monto * tasaDeCambio;
                } else {                   
                    resultado = monto * tasaDeCambio;
                }

                System.out.println("Resultado: " + resultado);

                JOptionPane.showMessageDialog(
                        null,
                        String.format("%.2f %s equivalen a %.2f %s.", monto, monedaOrigen, resultado, monedaDestino),
                        "Resultado",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Ingresa una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No seleccionaste una opción de conversión. Saliendo del programa.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static String getMonedaOrigen(String seleccion) {
        String[] partes = seleccion.split(" > ");
        return partes[0];
    }

    public static String getMonedaDestino(String seleccion) {
        String[] partes = seleccion.split(" > ");
        return partes[1];
    }

    public static void convertirTemperatura() {
        // Opciones de conversión en el JComboBox
        String[] opcionesTemperatura = {
                "Celsius > Fahrenheit", "Fahrenheit > Celsius"
        };

        // Mapa para almacenar las opciones de conversión de temperatura
        Map<String, Temperatura> conversionesTemperatura = new HashMap<>();
        conversionesTemperatura.put("Celsius > Fahrenheit", new Temperatura("Celsius", "Fahrenheit", 1.8));
        conversionesTemperatura.put("Fahrenheit > Celsius", new Temperatura("Fahrenheit", "Celsius", 0.5556));

        // Mostrar el JComboBox para que el usuario seleccione la opción de conversión
        String seleccion = (String) JOptionPane.showInputDialog(
                null,
                "Selecciona la conversión:",
                "Convertidor de Temperatura",
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcionesTemperatura,
                opcionesTemperatura[0]);

        // Validar si el usuario seleccionó una opción de conversión
        if (seleccion != null) {
            String temperaturaInput = JOptionPane.showInputDialog(null, "Ingresa la temperatura:");
            if (temperaturaInput != null && !temperaturaInput.isEmpty()) {
                double temperatura = Double.parseDouble(temperaturaInput);

                // Obtener la opción de conversión seleccionada por el usuario
                Temperatura conversionSeleccionada = conversionesTemperatura.get(seleccion);

                // Realizar la conversión según la opción seleccionada
                double resultado = seleccion.contains("Celsius > Fahrenheit")
                        ? convertirCelsiusAFahrenheit(temperatura)
                        : convertirFahrenheitACelsius(temperatura);

                JOptionPane.showMessageDialog(
                        null,
                        String.format("%.2f %s equivalen a %.2f %s.", temperatura, conversionSeleccionada.getTemperaturaOrigen(), resultado, conversionSeleccionada.getTemperaturaDestino()),
                        "Resultado",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Ingresa una temperatura válida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No seleccionaste una opción de conversión. Saliendo del programa.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Métodos de conversión de temperatura
    public static double convertirCelsiusAFahrenheit(double celsius) {
        return celsius * 1.8 + 32;
    }

    public static double convertirFahrenheitACelsius(double fahrenheit) {
        return (fahrenheit - 32) * 0.5556;
    }
}

