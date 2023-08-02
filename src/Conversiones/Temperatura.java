package Conversiones;

public class Temperatura {

    private String TemperaturaOrigen;
    private String TemperaturaDestino;
    private double tasaDeCambio;

    public Temperatura(String TemperaturaOrigen, String TemperaturaDestino, double tasaDeCambio) {
        this.TemperaturaOrigen = TemperaturaOrigen;
        this.TemperaturaDestino = TemperaturaDestino;
        this.tasaDeCambio = tasaDeCambio;
    }

    public String getTemperaturaOrigen() {
        return TemperaturaOrigen;
    }

    public String getTemperaturaDestino() {
        return TemperaturaDestino;
    }

    public double getTasaDeCambio() {
        return tasaDeCambio;
    }
    
}


