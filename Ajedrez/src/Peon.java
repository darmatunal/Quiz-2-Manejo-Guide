
import java.awt.Image;
import java.awt.Point;
import static java.lang.Math.abs;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dario Arango
 */
public class Peon extends Ficha {
    
 

 public Peon(String ColorID){
     Image peon;
     if (ColorID.equals("PN")) {
     peon=this.loadImage("PN.png");
     this.setForma(peon);
     this.setId(1);
     }
     if (ColorID.equals("PB")) {
     peon=this.loadImage("PB.png");
     this.setForma(peon);
     this.setId(11);
     }
     else {
         System.out.println("No identificó bien el peon");
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
    public Boolean CanMove(int Id, int Xnow, int Ynow, int Xfut, int Yfut, int[][] M) {
   Boolean AuxBool=false;
   // Si mueve mas de dos
        if (Id==11) {
            if (Math.abs(Yfut-Ynow)>2) {
        AuxBool= false;
                }
   // Si mueve una al frente
        if((Ynow-Yfut)==1 && Xnow==Xfut){
        AuxBool=true;
        }
   // Si va a comer     
        if (Ynow-Yfut==1 && Math.abs(Xnow-Xfut)==1 && M[Yfut][Xfut]!=0) {
        AuxBool=true;        
            }
   //    // Si mueve dos al frente
        if((Ynow-Yfut)==2 && Xnow==Xfut && Ynow==6){
        AuxBool=true;
        }   
        }
 // *********************************************
 // Ficha Negra
        if (Id==1) {
           if (Math.abs(Yfut-Ynow)>2) {
        AuxBool= false;
                }
   // Si mueve una al frente
        if((Yfut-Ynow)==1 && Xnow==Xfut){
        AuxBool=true;
        }
   // Si va a comer     
        if (Yfut-Ynow==1 && Math.abs(Xnow-Xfut)==1 && M[Yfut][Xfut]!=0) {
        AuxBool=true;        
            }
   //    // Si mueve dos al frente
        if((Yfut-Ynow)==2 && Xnow==Xfut && Ynow==1){
        AuxBool=true;
        }       
            
        }
         if( Xfut==Xnow && Yfut==Ynow){
            AuxBool=false;
            }
        
    return AuxBool;
    }
}
