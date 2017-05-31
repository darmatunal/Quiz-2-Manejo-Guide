
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
public class Reina extends Ficha{
    
    public Reina(String ColorID){
     Image reina;
     if (ColorID.equals("RN")) {
     reina=this.loadImage("RN.png");
     this.setForma(reina);
     this.setId(5);
     }
     if (ColorID.equals("RB")) {
     reina=this.loadImage("RB.png");
     this.setForma(reina);
     this.setId(15);
     }
     else {
         System.out.println("No identificó la dama");
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
    public Boolean CanMove(int Id ,int Xnow, int Ynow, int Xfut, int Yfut, int[][] M) {
    
        Boolean AuxBool=true;
   // Si mueve mas de dos
        
            if (Math.abs(Yfut-Ynow)==2 && Math.abs(Xfut-Xnow)==1) {
            AuxBool= false;
                 }
            if (Math.abs(Xfut-Xnow)==2 && Math.abs(Yfut-Ynow)==1) {
            AuxBool= false;
                 }
            if(M[Yfut][Xfut]>0 && M[Xfut][Yfut]<10 &&Id==3){
            AuxBool=false;
            }
           if( M[Yfut][Xfut]>10 && Id==13){
            AuxBool=false;
            }
           
             if( Xfut==Xnow && Yfut==Ynow){
            AuxBool=false;
            }
             
            if( Math.abs(Xfut-Xnow) !=Math.abs(Yfut-Ynow) && Xfut!=Xnow  && Yfut!=Ynow){
            AuxBool=false;
            }
 
       
            return AuxBool;     
            
    
    }
    
}
