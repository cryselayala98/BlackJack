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
public class Carta {
    
    private int numero;
    private String tipo;

    public Carta(int numero, String tipo) {  
        this.numero = numero;
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

   
    @Override
    public String toString(){
        String cad= "";
        switch(numero){
            case 1: 
                cad+= "Az-" + this.tipo;
                break;
            case 10:
                cad+= "J-" + this.tipo;
                break;
            case 11:
                cad+= "K-" + this.tipo;
                break;
            case 12:
                cad+= "Q-" + this.tipo;
                break;
            case 0: 
                cad+= "Comodín";
                break;
            default: 
                cad+= this.numero + "-" + this.tipo;
        }
        return cad;
    }
    
    
}
