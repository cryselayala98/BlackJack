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
public class CartaJuego {
    
    private Carta myCarta;

    public CartaJuego(Carta myCarta) {

      this.myCarta= myCarta;  
    }

    public Carta getMyCarta() {
        return myCarta;
    }

    public void setMyCarta(Carta myCarta) {
        this.myCarta = myCarta;
    }
public int BuscarNum(){
    return this.myCarta.getNumero();
}
    
    @Override
    public String toString() {
       return this.getMyCarta().toString();
        
    }
    
    
    
    
}
