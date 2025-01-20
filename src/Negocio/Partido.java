/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.util.ArrayList;
import java.util.Date;


public class Partido {

    private int consecutivo;
    private Date fecha;
    private String estado;
    private String tipo;
    private int totalPagadoGanador;
    private ArrayList<Juego> myJuegos;   //el partido al menos tiene dos juegos
    private int totalApuestas;
    private String observacion;

    public Partido(Carta[] myBaraja, Jugador jug1, Jugador jug2, int apuesta1,
            int apuesta2, String tipo, Date fecha, int consecutivo) {
        this.myJuegos = new ArrayList<>();
        this.consecutivo = consecutivo;
        this.tipo = tipo;
        this.fecha = fecha;
        this.totalApuestas = apuesta1 + apuesta2;
        this.estado = "";
        this.observacion = "ninguna";
//en el constructor de partido, crean los juegos (2 juegos)

        this.crearJuego(apuesta1, jug1, myBaraja, 0);
        this.crearJuego(apuesta2, jug2, myBaraja, 3);

    }
    public boolean retirarCartaJuego(int posJ, int carta){
        return this.myJuegos.get(posJ).RetirarCarta(carta);
    }

    public int retirarJuego(int juego) { //se obvia que deben estar los dos jugadores
        int ap = (this.myJuegos.get(juego).getApuesta()) / 2;//la mitad de la apuesta

        this.myJuegos.remove(juego);
        this.totalApuestas -= ap;//actualizar total apostado
        this.observacion = "se retiro el jugador " + (juego + 1);
        return ap;
    }

//    private boolean
    public boolean validarRetiroJugador(int juego) {

        if (this.myJuegos.size() == 1) { //si su puntaje no es el apropiado y ya se retiro un jugador
            return true;
        }
        boolean v1 = this.myJuegos.get(juego).validarRetiroPuntaje();
        if (v1) {
            return true;
        }
        return false;
    }

    public boolean validarFecha(Date fechaIn, Date fechaFin) {///valida la feca dentro de un rango
        if ((this.getFecha().after(fechaIn)) && (this.getFecha().before(fechaFin))) {
            return true;
        }
        return false;
    }

    public boolean validarFecha2(Date fecha) {
        if (fecha.getDay() == this.getFecha().getDay() && fecha.getMonth() == this.getFecha().getMonth()
                && fecha.getYear() == this.getFecha().getYear()) {
            return true;
        }

        return false;
    }

    

    public int validarMes(int mes, int añoActual) {
        

        if ((this.fecha.getMonth() + 1) == mes && this.fecha.getYear() == añoActual && !this.estado.equals("Empate") ) {

          //cuando ocurre un empate se supone q el estado economico del casino no se modifica
                
                 return (this.totalApuestas - this.totalPagadoGanador);
            
           
            
        }

        return 0;
    }
public String toStringGanancia(int ganancia){
    return "Consecutivo: "+this.consecutivo+"\nTotal Apostado: "+this.totalApuestas+"\nTotal Pagado Ganador: "+this.totalPagadoGanador+"\nGanancia: "+ganancia;
    
}
    public int restarTotalPagado() {
        int num = 0;
        if (this.estado.equals("Empate")) {
            num = this.totalApuestas;
        }

        return num;
    }

    public int enumerarJuegos() {
        return this.myJuegos.size();
    }

    public void sumarPuntajeJuegoC(int posJuego, int vObtenerVc21) {
        this.myJuegos.get(posJuego).setPuntaje(this.myJuegos.get(posJuego).getPuntaje() + vObtenerVc21);

    }

    public boolean evaluarCarta(int posJuego, int posCarta) {

        Juego juego = this.myJuegos.get(posJuego);//0 o 1
        //necesito un metodo en el juego que me capture si en esa posicion de las cartas del juego hay un comodin o un as

        boolean validacion = juego.condicionarCarta(posCarta);
        return validacion;
    }

    public String buscarJugadorPartido(Jugador jugador) {
        String cad = "";

        for (int i = 0; i < this.myJuegos.size(); i++) {
            String aux = this.myJuegos.get(i).BuscarJugadorJuego(jugador);
            if (!aux.isEmpty()) {//si el jugador que se estaba buscando esta registrado en el juego
                cad += "Partido nº " + this.consecutivo + "\n";
                cad += aux;
                break;
            }
        }
        return cad;
    }

    ///LA CLASE PARTIDO ES UN TODO PARA LA CLASE JUEGO, POR TANTO TOCA CREAR UN METODO DE CREAR JUEGO
    private void crearJuego(int apuesta, Jugador jugador, Carta[] myBaraja, int pos) {

        //haCEr todas la validaciones
        ArrayList<Carta> myCartasJuego = this.obtenerTresCartas(myBaraja, pos);//me saca las tres cartas

        Juego nuevo = new Juego(apuesta, jugador, myCartasJuego);

        //hacer un metodo el cual me saque las tres cartas retorna arraylist y lo envio al new juego
        this.myJuegos.add(nuevo);

    }

    private ArrayList<Carta> obtenerTresCartas(Carta[] myCartas, int pos) {
        ArrayList<Carta> CartaJuego = new ArrayList<>();
        int pos3 = pos + 3;
        while (pos < pos3) {
            CartaJuego.add(myCartas[pos]);
            pos++;
        }
        return CartaJuego;
    }

    public ArrayList<String> mostrarCartasHistorial(int a) {  //a==0 o a==1

        ArrayList<String> cad = this.myJuegos.get(a).mostrarCartas();

        return cad;
    }

    public int obtenerPuntajeJuego(int posJuego) {//pos 0 o pos 1 en el arraylist de juego
        int puntaje = this.myJuegos.get(posJuego).getPuntaje();
        return puntaje;
    }

    public boolean validarExistenciaCarta(Carta myCarta, int posJuego) {///me valida si la carta existe en la cartaJuego o nope

        return this.myJuegos.get(posJuego).buscarCarta(myCarta);

    }

    public void añadirCartaLista(Carta myCarta, int posJuego) {
        int valorCarta = this.myJuegos.get(posJuego).asignarCartaJuego(myCarta);
        this.sumarPuntajeJuegoC(posJuego, valorCarta);
    }

    public int obtenerCantCartaJ(int posJuego) {///este metodo retorna la cant de cartas que hay en un juego dentro de ese partido
        return this.myJuegos.get(posJuego).obtenerCantCartas();

    }

    //puede ocurrir varias situaciones:
    //*que no ocurra nada
    //*que saque mas de 21, menos de 17(en caso de que este obligado de pedir otra carta)
    public Date getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getTotalPagadoGanador() {
        return totalPagadoGanador;
    }

    public void setTotalPagadoGanador(int totalPagadoGanador) {
        this.totalPagadoGanador = totalPagadoGanador;
    }

    public int getTotalApuestas() {
        return totalApuestas;
    }

    public void setTotalApuestas(int totalApuestas) {
        this.totalApuestas = totalApuestas;
    }

    public int getConsecutivo() {
        return consecutivo;
    }

    public void evaluarPartido(int posJuego1, int posJuego2) {//un jugador con respecto al otro

        int puntajeJ1 = this.myJuegos.get(posJuego1).getPuntaje();
        int apuesta = this.myJuegos.get(posJuego1).getApuesta();

        //caso gana blackjack
        if (puntajeJ1 == 21 && this.myJuegos.get(posJuego1).obtenerCantCartas() + 1 == 3) { //obtuvo blackjack automaticamente gano
           
            if(this.myJuegos.size()>1 && this.myJuegos.get(posJuego2).getPuntaje()==21 && 
                    this.myJuegos.get(posJuego2).obtenerCantCartas() + 1 >3){
                this.myJuegos.get(posJuego1).setEstado("Empate");
                
                return;
            }
                this.myJuegos.get(posJuego1).setEstado("Blackjack");
            this.totalPagadoGanador += (apuesta * 5);

            //el casino le da 5 veces la suma apostada 
            this.myJuegos.get(posJuego1).getMyJugador().setTotalJuegosGanados(
                    this.myJuegos.get(posJuego1).getMyJugador().getTotalJuegosGanados() + 1);
            return;

        }
//si solamente hay un jugador
        if (this.myJuegos.size() == 1) {
            //evaluar solamente a un jugador
            if (puntajeJ1 > 21) {
                this.myJuegos.get(posJuego1).setEstado("Perdio");
            } else {
                this.myJuegos.get(posJuego1).setEstado("Gano");
                this.totalPagadoGanador += apuesta * 3;

                this.myJuegos.get(posJuego1).getMyJugador().setTotalJuegosGanados(
                        this.myJuegos.get(posJuego1).getMyJugador().getTotalJuegosGanados() + 1);
            }

            return;
        }
//en caso de que si haigan dos jugadores
        int puntajeJ2 = this.myJuegos.get(posJuego2).getPuntaje();

        if (puntajeJ1 <= 21) {
            if (puntajeJ1 == puntajeJ2) {
                this.myJuegos.get(posJuego1).setEstado("Empate");

            } else if ((puntajeJ1 > puntajeJ2) || (puntajeJ2 > 21)) {
                this.myJuegos.get(posJuego1).setEstado("Gano");
                this.totalPagadoGanador += apuesta * 3;

                this.myJuegos.get(posJuego1).getMyJugador().setTotalJuegosGanados(
                        this.myJuegos.get(posJuego1).getMyJugador().getTotalJuegosGanados() + 1);

            } else {
                this.myJuegos.get(posJuego1).setEstado("Perdio");
            }

        } else {///perdio :(
            this.myJuegos.get(posJuego1).setEstado("Perdio");

        }

    }

    public void evaluarPartido1() { //evaluar el partido en general

        String cad = "";
        String estadoJ1 = this.myJuegos.get(0).getEstado();
        if (this.myJuegos.size() == 1) {
            if (estadoJ1.equals("Gano")) {
                this.estado = "Perdio el casino";
            } else if (estadoJ1.equals("Perdio")) {
                this.estado = "Gano el casino";
            }

            return;
        }
        //si hay dos jugadores

        String estadoJ2 = this.myJuegos.get(1).getEstado();

        if (estadoJ1.equals("Gano") && estadoJ2.equals("Gano")) {
            this.estado = "Perdio el casino";
        } else if (estadoJ1.equals("Perdio") && estadoJ2.equals("Perdio")) {
            this.estado = "Gano el casino";
        } else if (estadoJ1.equals("Empate")) { ///se obvia q el juego 2 tambien tiene que empatar
            this.estado = "Empate";
        } else if (estadoJ1.equals("Gano") && estadoJ2.equals("Perdio")) {
            this.estado = "Gano el Jugador 1";
        } else if (estadoJ1.equals("Perdio") && estadoJ2.equals("Gano")) {
            this.estado = "Gano el Jugador 2";
        } else if (estadoJ1.equals("Blackjack") && estadoJ2.equals("Perdio")) {
            this.estado = "El jugador 1 obtuvo  Blackjack";
        } else if (estadoJ1.equals("Perdio") && estadoJ2.equals("Blackjack")) {
           this.estado = "El jugador 2 obtuvo  Blackjack";
        }
    }

    public String listarJuegos() {

        String cad = "";
        int cont = 1;
        for (Juego myJuego : this.myJuegos) {

            cad += "Juego " + cont + ": \n" + myJuego.toString() + "\n";
            cont++;
        }
        return cad;
    }

    public String buscarInforPartido() {
        String cad = "";
        if (this.estado.equals("Empate") || this.estado.equals("Gano el casino")) {
            cad = this.toString();
        }

        return cad;
    }

    public int retornarApuesta() {

        if (this.estado.equals("Gano el casino")) {
            return this.totalApuestas;
        }
        return 0;
    }

    private String toStringFecha() {
//        this.fecha.;
        return (this.fecha.getDate()) + "/" + (this.fecha.getMonth() + 1) + "/" + (this.fecha.getYear() + 1900);
    }

    @Override
    public String toString() {
        return "N° Partido: " + this.consecutivo + "\nfecha: " + this.toStringFecha() + "\nestado: " + this.estado
                + "\ntipo: " + this.tipo + "\ntotalPagadoGanador: " + this.totalPagadoGanador
                + "\ntotalApuestas: " + this.totalApuestas + "\n" + "Observacion: " + this.observacion + "\n" + this.listarJuegos();
    }

}
