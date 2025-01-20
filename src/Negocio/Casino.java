/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.util.ArrayList;

import java.util.Date;

public class Casino {   //ESTA ES LA CLASE PRINCIPAL DEL JUEGO, LA CLASE QUE
    //SE VA A COMUNICAR CON LA VISTA             

    private ArrayList<Partido> myPartidos;
    private ArrayList<Jugador> myJugadores;
    private Carta[] myCartas;
    private int saldoCaja;
    private int totalPagos;

    public Casino() {
        this.myPartidos = new ArrayList<>();
        this.myJugadores = new ArrayList<>();
        this.myCartas = new Carta[51];
        this.saldoCaja = 5000000;

        this.crearCartas();
    }
    
    public boolean retirarCartaJuego(int posJuego, int cartaPos, int contR){
    
        int puntaje= this.myPartidos.get(this.myPartidos.size()-1).obtenerPuntajeJuego(posJuego);
        if (puntaje>=21 || contR==3) {
            return false;
        }
       
        
        if (this.myPartidos.get(this.myPartidos.size()-1).enumerarJuegos()==1) {//en caso de un jugador retirado
            posJuego=0;
        }
        
        
       return this.myPartidos.get(this.myPartidos.size()-1).retirarCartaJuego(posJuego, cartaPos); 
    }

    public boolean validarRetiro(int juego) {
        if (this.myPartidos.get(this.myPartidos.size() - 1).validarRetiroJugador(juego)) {// si no cumple con las condiciones
            return true;
        }
        return false;
    }

    public String retirarJugador(int juego) {
        int apuestaPorcentaje = this.myPartidos.get(this.myPartidos.size() - 1).retirarJuego(juego);
        this.saldoCaja -= apuestaPorcentaje;//al juego se le devuelde sola el 50% d la apuesta;
        return "Jugador se ha retirado del partido y el valor que le descuentan es " + apuestaPorcentaje;
    }

    ////metodo listar cartas
    //METODO CREAR CARTAS
    private void crearCartas() {

        String tipo = "";
        int contador = 0;//Toma la osicion del vector carta
        int contadorComodines = 0;
        for (int i = 0; i < 5; i++) { //5 tipos de cartas= 1= trebol, 2= picas, 3=corazones, 4= diamantes, 5 =comodin

            tipo = this.asignarTipo(i);
            for (int j = 1; j <= 12; j++) {

                if (i == 4) {

                    while (j < 4) {
                        int posC = 0;
                        this.myCartas[contador] = new Carta(posC, tipo);
                        j++;
                        contador++;
                    }
                    break;
                }
                this.myCartas[contador] = new Carta(j, tipo);

                contador++;
            }
        }

    }

    public int enumerar(int n) { //0=jugadores, 1=juegos //este metodo espara saber si en tal caso no hay jugadores registrados, deshabilito el boton juego
        if (n == 0) {
            return this.myJugadores.size();
        } else if (n == 1) {
            return this.myPartidos.get(this.myPartidos.size() - 1).enumerarJuegos();
        }else if (n==2) {
            return this.myPartidos.size();
        }
        return 0;

    }

    //metodo asignar tipo
    private String asignarTipo(int i) {
        String tipo = "";
        switch (i) {
            case 0:
                tipo = "Trebol";
                break;
            case 1:
                tipo = "Picas";
                break;
            case 2:
                tipo = "Corazon";
                break;
            case 3:
                tipo = "Diamantes";
                break;
            default:
                tipo = "comodin";
        }
        return tipo;
    }

    //METODO BARAJAR CARTAS
    public void barajarCartas() {  //dato a trabajar : vector de cartas

        Carta aux = null;
        for (int i = 0; i < this.myCartas.length; i++) {

            int aleatorio = (int) (Math.random() * this.myCartas.length); //recibe numeros enteros de cero a myCartas.lenght-1
            while (i == aleatorio) {
                aleatorio = (int) (Math.random() * this.myCartas.length);
            }
            aux = this.myCartas[i];
            this.myCartas[i] = this.myCartas[aleatorio];
            this.myCartas[aleatorio] = aux;

        }

    }

    //EL CASINO DEBE REGISTRAR JUGADORES  PARA QUE  PARTICIPEN EN EL JUEGO
    public String crearJugador(String cedula, String nombre, String correo) {

        String cad = "";
        //se debe garantizar que la cedula no este repetida en el listado de jugadores
        if (this.validarCedulaJugador(cedula) != null) {
            return "Este Jugador ya habia sido registrado con anterioridad." + "-" + " ";
        }
        Jugador nuevo = new Jugador(cedula, nombre, correo);
        this.myJugadores.add(nuevo);

        cad = "El jugador ha sido registrado con exito" + "-" + nuevo.toString();

        return cad;
    }

    private Jugador validarCedulaJugador(String cedula) {

        for (Jugador myJugadore : this.myJugadores) {
            boolean v= myJugadore.validarCedulaJugador(cedula);
            if (v) {

                return myJugadore;
            }
        }

        return null;
    }


    
    private String ValidarAdvertenciaPartido(Jugador jug1, Jugador jug2, int apuesta1, int apuesta2, Date fecha) {
        String cad = "";
        if (jug1 == null) {
            cad = "La cedula del Jugador 1 nunca ha sido registrada" + "-";
        } else if (jug2 == null) {
            cad = "La cedula del jugador 2 nunca ha sido registrada" + "-";

        } else if (jug1.getCedula().equalsIgnoreCase(jug2.getCedula())) {
            cad = "Los jugadores deben se Diferentes";
        } else if (apuesta1 < 20000) {
            cad = "La apuesta del jugador " + jug1.getCedula() + " debe ser mayor a $20000";

        } else if (apuesta2 < 20000) {
            cad = "La apuesta del jugador " + jug2.getCedula() + " debe ser mayor a $20000";

        } else if (this.buscarPartidosFecha(jug1, fecha) >= 10) {
            cad = "El jugador " + jug1.getCedula() + " Ha sobrepasado el limite de juegos sobre un mismo  dia";
        } else if (this.buscarPartidosFecha(jug2, fecha) >= 10) {
            cad = "El jugador " + jug2.getCedula() + " Ha sobrepasado el limite de juegos sobre un mismo  dia";
        }

        return cad;
    }

    //EL PARTIDO SE CREA EN EL CASINO
    public String crearPartido(String ced1, String ced2, int apuesta1, int apuesta2, String tipo, Date fecha) {

        String cad = "";
        this.barajarCartas();
        Jugador jug1 = this.validarCedulaJugador(ced1);
        Jugador jug2 = this.validarCedulaJugador(ced2);

        String advertencia = this.ValidarAdvertenciaPartido(jug1, jug2, apuesta1, apuesta2, fecha);

        if (!advertencia.isEmpty()) {
            return advertencia;
        }
        int consecutivo = this.myPartidos.size() + 1;
        Partido nuevoPartido = new Partido(this.myCartas, jug1, jug2, apuesta1, apuesta2, tipo, fecha, consecutivo);

        this.saldoCaja += apuesta1 + apuesta2;

        this.myPartidos.add(nuevoPartido);
        ///debo verificar que los dos jugadore sposiblemente hayan obtenido 21 o hayan perdido

        this.evaluarVCartas(0, 2, 0, 3);//reacomoda los puntajes en tal caso que alguna de las cartas sea as o comodin

        cad = "El partido fue registrado exitosamente";

        return cad;
    }

    public int mostrarPuntajeJuego(int juego) {
        int num = this.myPartidos.get(this.myPartidos.size() - 1).enumerarJuegos();
        if (num == 1) {
            juego--;
        }
        return this.myPartidos.get(this.myPartidos.size() - 1).obtenerPuntajeJuego(juego);

    }

    private void evaluarVCartas(int posJuegoI, int posJuegoF, int posCartaI, int posCartaF) {

        ///las tres cartas iniciales
        for (int posJuego = posJuegoI; posJuego < posJuegoF; posJuego++) {//0 Y 1

            for (int posCartaJ = posCartaI; posCartaJ < posCartaF; posCartaJ++) { //las tres primeras cartas

                int valorCercano = 0;
                boolean excepcion = this.evaluarCarta(posJuego, posCartaJ);/// me dice si esa carta resulto ser un comodin o un as
                if (excepcion) {
                    valorCercano = this.obtenerValorCercano21(posJuego);
                    this.myPartidos.get(this.myPartidos.size() - 1).sumarPuntajeJuegoC(posJuego, valorCercano);
                }

            }

        }
    }

    private int obtenerValorCercano21(int posJuego) {
        Partido partido = this.myPartidos.get(this.myPartidos.size() - 1);//obtiene el partido actual
        int puntaje = partido.obtenerPuntajeJuego(posJuego);
        int valorCerc21 = 0;

        int a = puntaje + 1;
        int b = puntaje + 11;

        if (a <= 21 && b <= 21) {
            if (a >= b) {
                valorCerc21 = 1;
            } else {
                valorCerc21 = 11;
            }

        } else if (a <= 21 && b > 21) {
            valorCerc21 = 1;
        } else if (b <= 21 && a > 21) {
            valorCerc21 = 11;
        } else if (a > 21 && b > 21) {
            if (a <= b) {
                valorCerc21 = 1;
            } else {
                valorCerc21 = 11;
            }
        }

        return valorCerc21;
    }

    private boolean evaluarCarta(int posJuego, int posCarta) {//este metodo evalua la carta

        Partido partido = this.myPartidos.get(this.myPartidos.size() - 1);
        boolean cad = partido.evaluarCarta(posJuego, posCarta);

        return cad;
    }

    //metodo para buscar las veces que ha jugado un  jugador
    private int buscarPartidosFecha(Jugador jugador, Date fecha) {

        ArrayList<Partido> partidosFecha = new ArrayList<>();
        this.validarPFecha(fecha, partidosFecha);
        int contPart = 0;
         
        for (Partido myPartido : partidosFecha) {
            if (!myPartido.buscarJugadorPartido(jugador).isEmpty()) {//si el jugador ya habia jugado en ese partido
                contPart++;
            }
        }

        return contPart;
    }

    private void validarPFecha(Date fecha, ArrayList<Partido> partidosFecha) {

        for (Partido myPartido : this.myPartidos) {
            boolean v =myPartido.validarFecha2(fecha);
            if (v) {
                partidosFecha.add(myPartido);
            }
        }

    }

    public ArrayList<String> visualizarCartas(int a) {  //visualizar en el partido actual, los dos juegos actuales
        int num = this.myPartidos.get(this.myPartidos.size() - 1).enumerarJuegos();//validar si ya un juego se retiro
        if (num == 1) {
            a--;
        }
        Partido myPartido = this.myPartidos.get(this.myPartidos.size() - 1);
        ArrayList cad = myPartido.mostrarCartasHistorial(a);
//        int puntajeJuego1 = this.myPartidos.get(this.myPartidos.size() - 1).obtenerPuntajeJuego(a);

        return cad;
    }

    //LISTAR JUGADORES
    public String listarJugadores() {
        String cad = "Listado de Jugadores\n\n";

        if (this.myJugadores.isEmpty()) {
            return "No hay jugadores registrados";
        }
        for (Jugador jugador : this.myJugadores) {
            cad += jugador.toString();

        }

        return cad;
    }

    public void pedirCarta(int juego) {
        int num = this.myPartidos.get(this.myPartidos.size() - 1).enumerarJuegos();//validar si un jugador ya se retiro
        if (num == 1) {
            juego--;
        }//////////////VOY ACA
        String cad = "";
        //aca sii hay que pedir una carta aleatoria, no una carta de la lista ordenada
        //saco la carta y pregunto que esa carta no este dentro de las 6 cartas que habia sacado al inicio

        int posAle = (int) (Math.random() * this.myCartas.length);

        Carta CartaAle = this.myCartas[posAle];
        Partido partido = this.myPartidos.get(this.myPartidos.size() - 1);//partido actual
        boolean validacion = partido.validarExistenciaCarta(CartaAle, juego);

        while (validacion) {
            posAle = (int) (Math.random() * this.myCartas.length);
            CartaAle = this.myCartas[posAle];
            validacion = partido.validarExistenciaCarta(CartaAle, juego);
        }
        this.myPartidos.get(this.myPartidos.size() - 1).añadirCartaLista(CartaAle, juego);///añade una carta a la lista del jugador, y ademas me suma el puntaje al total del juegoo
        int cantCartasLista = this.myPartidos.get(this.myPartidos.size() - 1).obtenerCantCartaJ(juego);

        this.evaluarVCartas(juego, juego + 1, cantCartasLista, cantCartasLista + 1);

    }

    private void actualizarSaldo() {

        int a = this.myPartidos.get(this.myPartidos.size() - 1).restarTotalPagado();
        this.saldoCaja -= a;
        if (a != 0) {
            return;
        }

        this.saldoCaja -= this.myPartidos.get(this.myPartidos.size() - 1).getTotalPagadoGanador();
        this.totalPagos += this.myPartidos.get(this.myPartidos.size() - 1).getTotalPagadoGanador();
    }

    public String hacerEvaluacionFinal() {

        this.myPartidos.get(this.myPartidos.size() - 1).evaluarPartido(0, 1);  //el juego1 con respecto al 2

        int cantJuegos = this.myPartidos.get(this.myPartidos.size() - 1).enumerarJuegos();
        if (cantJuegos > 1) {
            this.myPartidos.get(this.myPartidos.size() - 1).evaluarPartido(1, 0);  //el juego 2 con respecto al 1
        }
        this.myPartidos.get(this.myPartidos.size() - 1).evaluarPartido1();
        this.actualizarSaldo();
        return this.myPartidos.get(this.myPartidos.size() - 1).getEstado();
    }

    public String mostrarConsecutivo() {
        return String.valueOf(this.myPartidos.size());
    }

    public String listarPartidos(Date fechainicio, Date fechaFin) {
        String cad = "";

        ArrayList<Partido> myP = new ArrayList<>();

       
            for (Partido partido : this.myPartidos) {
               
                boolean validacion= partido.validarFecha(fechainicio, fechaFin);
                if (validacion) {
                myP.add(partido);
                }
                

        }
        
        if (myP.isEmpty()) {
            return "No hay partidos registrados dentro de ese rango";
        }
        for (Partido partido : myP) {
            cad+=partido.toString();
        }

        return cad;

    }

    public String evaluarResultado() {
        String cad = "Datos del ultimo Partido: \n\n" + this.myPartidos.get(this.myPartidos.size() - 1).getEstado()
                + "\n\n" + this.myPartidos.get(this.myPartidos.size() - 1).listarJuegos();

        return cad;
    }

    public String mostrarSaldosCasino() {
        String cad = "Saldo del casino:\n\nSaldo Caja: " + this.saldoCaja + "\nTotal Pagado En apuestas: " + this.totalPagos;
        return cad;
    }

    public String buscarJugadorCedula(String cedula) {
        String cad="";
        Jugador jugador = this.validarCedulaJugador(cedula);
        if (jugador == null) {
            return "Esta cedula no se encuentra registrada en el Casino";
        }
        cad+= jugador.toString();
        
        String cad2="";
        for (Partido partido : this.myPartidos) {
             cad2+=partido.buscarJugadorPartido(jugador);
        }
        if (cad2.isEmpty()) {
            cad+="El jugador "+cedula+ " no tiene juegos registrados";
            return cad;
        }
        
        cad+=cad2;
        
      
        
        
        return cad;
    }

    

    public String consultarPartido(int mes) {  //el dia y el año son datos de tipo int
        int recaudo = 0;
        String cad="";
        Date fecha = new Date();
        int añoActual = fecha.getYear();//ME OBTIENE EL AÑO ACTUAL
        String cad2 = "Partido (s) que obtuvieron mas ganancia  \n";
   int gananciasMay=0;
        for (Partido myPartido : myPartidos) {
            int Ganancia= myPartido.validarMes(mes, añoActual);
            if (Ganancia>gananciasMay) {
                gananciasMay=Ganancia;
                cad=myPartido.toStringGanancia(Ganancia);
            }else if(Ganancia==gananciasMay){
                 cad+="\n\n"+myPartido.toStringGanancia(Ganancia);
            }
            
        }
        if (cad.isEmpty()) {
            return "No hay partidos con Ganancias";
        }
        cad=cad2+cad;
        
        return cad;
    }
    

    
}
