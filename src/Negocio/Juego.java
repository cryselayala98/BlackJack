/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.util.ArrayList;

public class Juego {

    private int puntaje;
    private String estado;/// como qdo el juego
    private int apuesta;
    private ArrayList<CartaJuego> myCartasJuego;
    private Jugador myJugador;

    public Juego(int apuesta, Jugador myJugador, ArrayList<Carta> myCartaJuego) {//tengo dudas de que poner exactamente en este constructor, aunque la apuesta si es digitada por el usuario, por tanto si va en el contructor 

        this.myCartasJuego = new ArrayList<>();
        this.apuesta = apuesta;
        this.myJugador = myJugador;
        this.estado = "";
        this.myJugador.setTotalApostado(this.myJugador.getTotalApostado()+apuesta);
        //hacer un metodo que inserte cartas de juego a myCartaJuego
        this.llenarCartaJuego(myCartaJuego);//me elige las tres cartas

    }
public boolean RetirarCarta(int carta){
    if (this.myCartasJuego.size()==2) {
        return false;
    }
    int num= this.myCartasJuego.get(carta).BuscarNum();
    this.puntaje-=num;
     this.myCartasJuego.remove(carta);
     
     return true;
}
   
    public boolean validarRetiroPuntaje(){
        String cad="";
        if (this.puntaje<18 || this.puntaje>=21) {
            return true;//no se puede retirar
        }
        
        return false;
    }
    private void llenarCartaJuego(ArrayList<Carta> myCartaJuego) {
        for (int i = 0; i < myCartaJuego.size(); i++) {

            this.asignarCartaJuego(myCartaJuego.get(i));
            this.puntaje += this.calcularPuntajeJugador(this.myCartasJuego.get(this.myCartasJuego.size() - 1));//obtener 
        }

    }

    public boolean buscarCarta(Carta myCarta) {//buscar que la carta aleatoria si se repite en el arraylist d cartas del juego

        for (CartaJuego myCartasJuego1 : this.myCartasJuego) {
            if (myCarta == myCartasJuego1.getMyCarta()) {
                return true;
            }

        }

        return false;
    }

    public int asignarCartaJuego(Carta myCartaJuego) {

        this.myCartasJuego.add(new CartaJuego(myCartaJuego));
        return this.calcularPuntajeJugador(this.myCartasJuego.get(this.myCartasJuego.size()-1));
    }

    public int calcularPuntajeJugador(CartaJuego myCartaJuego) {
        int puntaje = 0;

        //si puntaje retorn 0= es un comodin y toca preguntale al jugador que agarre un valor que le sirva
        //si el puntaje retorna -1= es un as y toca preguntarle al usuario si quiere 1 o 11;
        if (myCartaJuego.getMyCarta().getTipo().equalsIgnoreCase("Comodin") || myCartaJuego.getMyCarta().getNumero() == 1) { //comodin o as
            return puntaje;  //puntaje=0;
        }
        if (myCartaJuego.getMyCarta().getNumero() > 10) {
            puntaje = 10;
        } else {
            puntaje = myCartaJuego.getMyCarta().getNumero();

        }

        return puntaje;
    }

    public ArrayList <String> mostrarCartas() {
        ArrayList <String> cad = new ArrayList<>();

        for (int i = 0; i < this.myCartasJuego.size(); i++) {
            cad.add(this.myCartasJuego.get(i).toString());
        }

        return cad;
    }

    public String BuscarJugadorJuego(Jugador jugador) {
        String cad="";
        if (this.myJugador == jugador) {
           cad+=this.toString();
        }
        return cad;
    }

    public boolean condicionarCarta(int posCartaJuego) {
        String cad = "";

        CartaJuego cartaJuego = this.myCartasJuego.get(posCartaJuego);

        if (cartaJuego.getMyCarta().getNumero() == 1 || cartaJuego.getMyCarta().getTipo().equalsIgnoreCase("Comodin")) { //si la carta es un as
            return true;
        }

        return false;
    }
    
    private String listarCartasJuego(){
        String cad="";
        for (CartaJuego myCartasJuego1 : this.myCartasJuego) {
            cad+= myCartasJuego1.toString()+"\n";
        }
        return cad;
    }

    public int obtenerCantCartas(){
        
        return this.myCartasJuego.size()-1;
    }
///1.un metoo publico que me retorne una cadena de informacion y en ese metodo aca hago los metodos privados necesarios
    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public Jugador getMyJugador() {
        return myJugador;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getApuesta() {
        return apuesta;
    }

    @Override
    public String toString() {
        return  "\nNombre Jugador: "+this.myJugador.getNombre()+ "\nestado: " + this.estado + "\napuesta: " + this.apuesta 
                +"\n"+"Listado de Cartas: \n"+this.listarCartasJuego()+"\n";
    }
    
    
    
  

}
