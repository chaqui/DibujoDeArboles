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
        this.nodoHijoIzq= null;
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
    //eliminar nodo
    public int eliminar(int valoreliminar){
        int a = 0;
        if(dato.getClave() == valoreliminar) {
               return dato.getClave();
                        }
        else{
          if (valoreliminar<dato.getClave()) {
              if (this.nodoHijoIzq!=null) {
                   a= this.nodoHijoIzq.eliminar(valoreliminar);
                   if (a==this.nodoHijoIzq.dato.getClave()) {
                      this.nodoHijoIzq=null;
                  }
              }
        }
            else if(valoreliminar>dato.getClave()) {
            if (this.nodoHIjoDer!=null) {
                    a= this.nodoHIjoDer.eliminar(valoreliminar);
                    if (a==this.nodoHIjoDer.dato.getClave()) {
                        this.nodoHIjoDer=null;
                }
                }

        }
          else
            {
                if (this.nodoHIjoDer!=null) {
                    Usuario A=this.nodoHIjoDer.ramaizq();
                    if (A.getClave()== this.nodoHIjoDer.dato.getClave()) {
                        this.dato.setClave(A.getClave());
                        this.nodoHIjoDer=this.nodoHIjoDer.getNodoHIjoDer();
                    }
                    else{
                        this.dato.setClave(A.getClave());
                    }
                }
                else {
                    if (this.nodoHijoIzq!= null) {
                        Usuario A=this.nodoHijoIzq.ramaDer();
                        if (A.getClave()== this.nodoHijoIzq.dato.getClave()) {
                            this.dato.setClave(A.getClave());
                            this.dato.setNombre(A.getNombre());
                            this.nodoHijoIzq=this.nodoHijoIzq.getNodoHijoIzq();
                        }
                        else{
                            this.dato.setClave(A.getClave());
                            this.dato.setNombre(A.getNombre());
                        }
                    }
                    else{
                        
                            return -1;
                    }
                }
                }
            }
        return a;
    }
    //Hallar rama Derecho 
     public Usuario ramaDer(){
         if (this.nodoHIjoDer!=null ) {
             Usuario h = this.nodoHIjoDer.ramaDer();
             if (h.getClave()==this.nodoHIjoDer.dato.getClave()) {
                 this.nodoHIjoDer=null;
             }
            return h;
        }
            Usuario aux= this.dato;

            return aux;
    }
      public Usuario ramaizq(){
        if (this.nodoHijoIzq!=null) {
            Usuario h= this.nodoHijoIzq.ramaizq();
             if (h.getClave()==this.nodoHijoIzq.dato.getClave()) {
                 this.nodoHijoIzq=null;
             }
        }
            Usuario aux= dato;
            return aux;
    }
      public void insertar(Usuario valorinsertar)
    {
        Nodo nPadre= new Nodo(this.getDato(),this.getNodoPadre());
        //insertar datos lado izquierdo
        if (valorinsertar.getClave()<dato.getClave()) {
            if (this.nodoHijoIzq==null) {
                int a= this.dato.getClaveAux()*2+1;
                valorinsertar.setClaveAux(a);
               
               this.nodoHijoIzq= new Nodo(valorinsertar,nPadre);
                       
            }
            else
            {
                this.nodoHijoIzq.insertar(valorinsertar);
            }
        }
            else if(valorinsertar.getClave()>dato.getClave())
                 {
                     if (this.nodoHIjoDer==null) {
                         int a= this.dato.getClaveAux()*2+2;
                           valorinsertar.setClaveAux(a);
                         this.nodoHIjoDer= new Nodo(valorinsertar,nPadre);
                     }
                     else
                     {
                         this.nodoHIjoDer.insertar(valorinsertar);
                     }
                 }        
        }
    }