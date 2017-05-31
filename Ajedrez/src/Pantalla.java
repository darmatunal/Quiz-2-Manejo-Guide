
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dario Arango
 */

 public class Pantalla extends JFrame{

 private MiPanel P=new MiPanel();
    //En el constructor se crea crea en Panel 
    public Pantalla(){
     add (P);
    }

    /**
     * @return the P
     */
    public MiPanel getP() {
        return P;
    }

    /**
     * @param P the P to set
     */
    public void setP(MiPanel P) {
        this.P = P;
    }
    
    
   
}
   
