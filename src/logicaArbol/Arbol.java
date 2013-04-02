/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaArbol;
import java.util.LinkedList;

/**
 *
 * @author chaqui
 */
public class Arbol {
    Nodo raiz;
    LinkedList lista = new LinkedList();
     LinkedList listan = new LinkedList();
    public Arbol() {
        raiz=null;
    }
    public void insertar(Usuario valorInsertar){
        if (raiz==null) {
            raiz=new Nodo(valorInsertar,null);
            
        }
        else{
            if (buscar(valorInsertar.getClave())) {
                raiz.insertar(valorInsertar);
            }
            
        }
    }
    public int eliminar(int claveDeEliminacion){
        if (raiz.getDato().getClave()==claveDeEliminacion) {
            raiz=null;
            return 1;
        }
        else
        {
            int j=raiz.eliminar(claveDeEliminacion);
            if (j==0) {
                return j;
            }
            return 1;
        }
    }
    public Boolean buscar(int v)
    {
        if (lista.size()!=0) {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.indexOf(i)==v) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
    private String recorridoPreorden(Nodo n)
   {
        String palabra="";

       if (n==null) {
           return " no hay elementos";
       }
       palabra +=String.valueOf(n.dato.getClave())+", ";
       palabra+=recorridoPreorden(n.nodoHijoIzq);
       palabra+=recorridoPreorden(n.nodoHIjoDer);
       return palabra;
   }
      private String recorridoPostOrden(Nodo n)
   {
        String palabra="";

       if (n==null) {
           return " no hay elementos";
       }
       palabra+=recorridoPreorden(n.nodoHijoIzq);
       palabra+=recorridoPreorden(n.nodoHIjoDer);
       palabra +=String.valueOf(n.dato.getClave())+", ";

       return palabra;
   }
        private String recorridoEnOrden(Nodo n)
   {
        String palabra="";

       if (n==null) {
           return " no hay elementos";
       }
       palabra+=recorridoPreorden(n.nodoHijoIzq);
       palabra +=String.valueOf(n.dato.getClave())+", ";
       palabra+=recorridoPreorden(n.nodoHIjoDer);
       

       return palabra;
   }
        public LinkedList Info(){
            try{
           auxInfo(raiz);
            return listan;
            }
            catch(Exception e){
                return null;
            }
        }
        private void auxInfo(Nodo n){
            if (n!=null) {
                listan.add(n.dato);
                auxInfo(n.nodoHijoIzq);
                auxInfo(n.nodoHIjoDer);
            }
        }
}
