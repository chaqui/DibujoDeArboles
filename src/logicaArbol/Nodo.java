/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaArbol;

/**
 *
 * @author chaqui
 */
public class Nodo {
    Usuario dato;
    Nodo nodoPadre;
    Nodo nodoHijoIzq;
    Nodo nodoHIjoDer;

    public Nodo(Usuario dato, Nodo padre) {
        this.dato = dato;
        this.nodoPadre =padre;
        this.nodoHIjoDer= null;
        this.nodoHIjoDer=null;
    }

    public Usuario getDato() {
        return dato;
    }

    public void setDato(Usuario dato) {
        this.dato = dato;
    }

    public Nodo getNodoPadre() {
        return nodoPadre;
    }

    public void setNodoPadre(Nodo nodoPadre) {
        this.nodoPadre = nodoPadre;
    }

    public Nodo getNodoHijoIzq() {
        return nodoHijoIzq;
    }

    public void setNodoHijoIzq(Nodo nodoHijoIzq) {
        this.nodoHijoIzq = nodoHijoIzq;
    }

    public Nodo getNodoHIjoDer() {
        return nodoHIjoDer;
    }

    public void setNodoHIjoDer(Nodo nodoHIjoDer) {
        this.nodoHIjoDer = nodoHIjoDer;
    }   
    
}
