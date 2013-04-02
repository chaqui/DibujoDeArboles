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
     private Usuario[] nodos = new Usuario[31];
     private Integer[] dato = new Integer[31];
     int j=0,l=0;

    public int getL() {
        return l;
    }
     
    public Arbol() {
        raiz=null;
    }
    public void insertar(Usuario valorInsertar){
        if (raiz==null) {
            raiz=new Nodo(valorInsertar,null);
            dato[j]=valorInsertar.getClave();
            j++;
        }
        else{
            if (buscar(valorInsertar.getClave())) {
                raiz.insertar(valorInsertar);
                dato[j]=valorInsertar.getClave();
               dato[j]=valorInsertar.getClave();
                j++;
            }
            
        }
    }
    public int eliminar(int claveDeEliminacion){
        l=0;
        
        if (raiz.getDato().getClave()==claveDeEliminacion) {
            raiz=null;
            this.eliminarellist(claveDeEliminacion);
            return 1;
        }
        else
        {
            int k=raiz.eliminar(claveDeEliminacion);
            if (k==0) {
                return k;
                
            }
            this.eliminarellist(claveDeEliminacion);
            return 1;
        }
        
    }
    private void eliminarellist(int e){
        for (int i = 0; i < j; i++) {
             if (dato[i]==e) {
                    dato[i]=dato[j];
                    dato[j]=0;
                    j--;
                }
        }
    }
    public Boolean buscar(int v)
    {
        if (j!=0) {
            for (int i = 0; i < j; i++) {
                if (dato[i]==v) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }
    public String recorridoPreorden(){
        String a=recorridoPreorden(raiz);
        if (a==null) {
            return "no hay valores";
        }
        return a;
    }
    public String recorridoPostOrden(){
        String a=recorridoPostOrden(raiz);
        if (a==null) {
            return "no hay valores";
        }
        return a;
    }
     public String recorridoEnOrden(){
        String a=recorridoEnOrden(raiz);
        if (a==null) {
            return "no hay valores";
        }
        return a;
    }
    private String recorridoPreorden(Nodo n)
   {
        String palabra="";

       if (n==null) {
           return palabra;
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
           return "";
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
           return "";
       }
       palabra+=recorridoPreorden(n.nodoHijoIzq);
       palabra +=String.valueOf(n.dato.getClave())+", ";
       palabra+=recorridoPreorden(n.nodoHIjoDer);
       

       return palabra;
   }
        public Usuario[] Info(){
            System.out.println("info");
            try{
           auxInfo(raiz);
            return nodos;
            }
            catch(Exception e){
                return null;
            }
        }
        private void auxInfo(Nodo n){
            if (n!=null) {
                nodos[l]=n.dato;
                System.out.println("clave:"+n.dato.getClave());
                l++;
                auxInfo(n.nodoHijoIzq);
                auxInfo(n.nodoHIjoDer);
            }
        }
}