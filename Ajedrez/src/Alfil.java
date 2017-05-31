
import java.awt.Image;
import java.awt.Point;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dario Arango
 */
public class Alfil extends Ficha{

    public Alfil(String ColorID){
     Image alfil;
     if (ColorID.equals("AN")) {
     alfil=this.loadImage("AN.png");
     this.setForma(alfil);
     this.setId(4);
     }
     if (ColorID.equals("AB")) {
     alfil=this.loadImage("AB.png");
     this.setForma(alfil);
     this.setId(14);
     }
     else {
         System.out.println("No identificó bien el alfil");
     }
 
 }

   

    @Override
    public Boolean CanEat(Point Pact, Point Pfut) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Moverse(Point Pfut) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean CanMove(int Id,int Xnow, int Ynow, int Xfut, int Yfut, int[][] M) {
    
        Boolean AuxBool=false;
    // Condición para que no se mueva, no debe ser linea recta y los incrementos 
   // Deben ser iguales tanto en X como en Y
      if( Xfut==Xnow && Yfut==Ynow){
            AuxBool=false;
            }     
   
       if (Xnow==Xfut || Ynow==Yfut) {
         AuxBool=false;   
        }
        if (Math.abs(Xnow-Xfut)!= Math.abs(Ynow-Yfut)) {
         AuxBool=false;   
        }
     // Cuando si se puede mover:   
    if (Math.abs(Xnow-Xfut)== Math.abs(Ynow-Yfut)) {
         AuxBool=true;   
          // Excepciones
        //1) Cuando se encuentra a una ficha de su equipo
        //1.a) Ficha negra
      
        
        }
 
       
        
    return AuxBool;
    }
}
