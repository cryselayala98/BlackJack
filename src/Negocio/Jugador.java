/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Crysel Ayala
 */
public class Jugador {
    
    private String cedula;
    private String nombre;
    private String correo;
    private int totalApostado;
    private int totalJuegosGanados;

    public Jugador(String cedula, String nombre, String correo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.totalApostado =0;
        this.totalJuegosGanados =0;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTotalApostado() {
        return totalApostado;
    }

    public void setTotalApostado(int totalApostado) {
        this.totalApostado = totalApostado;
    }

    public int getTotalJuegosGanados() {
        return totalJuegosGanados;
    }

    public void setTotalJuegosGanados(int totalJuegosGanados) {
        this.totalJuegosGanados = totalJuegosGanados;
    }

    public boolean validarCedulaJugador(String cedula){
        if (this.getCedula().equalsIgnoreCase(cedula)) {
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return  "cedula=" + this.cedula 
                + "\nnombre=" + this.nombre 
                + "\ncorreo=" + this.correo 
                + "\ntotalApostado=" + this.totalApostado 
                + "\ntotalJuegosGanados=" + this.totalJuegosGanados +"\n\n";
    }
    
    
    
    
    
}
