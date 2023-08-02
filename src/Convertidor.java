import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

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
        Map<String, Conversion> opcionesDeConversion = new HashMap<>();
        opcionesDeConversion.put("Colones > Dólares", new Conversion("Colones", "Dólares", 0.0018));
        opcionesDeConversion.put("Colones > Euros", new Conversion("Colones", "Euros", 0.0017));
        opcionesDeConversion.put("Colones > Libras", new Conversion("Colones", "Libras", 0.0014));
        opcionesDeConversion.put("Colones > Yenes", new Conversion("Colones", "Yenes", 0.26));
        opcionesDeConversion.put("Colones > Wones", new Conversion("Colones", "Wones", 2.36));
        opcionesDeConversion.put("Dólares > Colones", new Conversion("Dólares", "Colones", 542.64));
        opcionesDeConversion.put("Euros > Colones", new Conversion("Euros", "Colones", 596.16));
        opcionesDeConversion.put("Libras > Colones", new Conversion("Libras", "Colones", 695.64));
        opcionesDeConversion.put("Yenes > Colones", new Conversion("Yenes", "Colones", 3.80));
        opcionesDeConversion.put("Wones > Colones", new Conversion("Wones", "Colones", 0.42));

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
                Conversion conversionOption = opcionesDeConversion.get(seleccion);
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
        // Aquí puedes poner el código del convertidor de temperatura
        // ...
    }
}