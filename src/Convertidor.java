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
        // Opciones de conversión en el JComboBox
        String[] opcionesMonedas = {
                "Colones a Dolares", "Colones a Euros", "Colones a Libras",
                "Colones a Yenes", "Colones a Wones", "Dolares a Colones",
                "Euros a Colones", "Libras a Colones", "Yenes a Colones", "Wones a Colones"
        };

        // Mapa para almacenar las tasas de cambio
        Map<String, Double> tasasDeCambio = new HashMap<>();
        tasasDeCambio.put("Colones a Dólares", 0.0018);
        tasasDeCambio.put("Colones a Euros", 0.0017);
        tasasDeCambio.put("Colones a Libras", 0.0014);
        tasasDeCambio.put("Colones a Yenes", 0.26);
        tasasDeCambio.put("Colones a Wones", 2.36);
        tasasDeCambio.put("Dolares a Colones", 542.64);
        tasasDeCambio.put("Euros a Colones", 596.16);
        tasasDeCambio.put("Libras a Colones", 695.64);
        tasasDeCambio.put("Yenes a Colones", 3.80);
        tasasDeCambio.put("Wones a Colones", 0.42);

        // Agrega las demás tasas de cambio

        // Mostrar el JComboBox para que el usuario seleccione la opción de conversión
        String seleccion = (String) JOptionPane.showInputDialog(
                null,
                "Selecciona la conversión:",
                "Convertidor de Monedas",
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcionesMonedas,
                opcionesMonedas[0]);

        // Validar si el usuario seleccionó una opción de conversión
        if (seleccion != null) {
            String montoInput = JOptionPane.showInputDialog(null, "Ingresa la cantidad:");
            if (montoInput != null && !montoInput.isEmpty()) {
                double monto = Double.parseDouble(montoInput);

                // Realizar la conversión según la opción seleccionada utilizando el mapa
                double tasaDeCambio = tasasDeCambio.get(seleccion);
                double resultado = seleccion.contains("a Colones") ? monto / tasaDeCambio : monto * tasaDeCambio;

                String monedaOrigen = getMonedaOrigen(seleccion);
                String monedaDestino = getMonedaDestino(seleccion);

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

    // Métodos de utilidad para obtener la moneda de origen y destino según la
    // opción seleccionada
    public static String getMonedaOrigen(String seleccion) {
        String[] partes = seleccion.split(" a ");
        return partes[0];
    }

    public static String getMonedaDestino(String seleccion) {
        String[] partes = seleccion.split(" a ");
        return partes[1];
    }

public static void convertirTemperatura() {
    // Aquí puedes poner el código del convertidor de temperatura
    // ...
}

}
