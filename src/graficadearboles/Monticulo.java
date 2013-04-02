/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graficadearboles;

/**
 *
 * @author chaqui
 */
public class Monticulo {
   
    public int hijoIzq(int padre)
    {
        return padre*2+1;
    }
    public int hijoDer(int padre)
    {
        return padre*2+2;
    }
    public int Padre(int hijo)
    {
        if (hijo%2 == 0) {
            return (hijo-2)/2;
        }
        else
        {
            return (hijo-1)/2;
        }
    }
}