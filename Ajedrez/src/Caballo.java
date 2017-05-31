
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
public class Caballo extends Ficha {
    
    public Caballo(String ColorID){
     Image caballo;
     if (ColorID.equals("CN")) {
     caballo=this.loadImage("CN.png");
     this.setForma(caballo);
     this.setId(3);
     }
     if (ColorID.equals("CB")) {
     caballo=this.loadImage("CB.png");
     this.setForma(caballo);
     this.setId(13);
     }
     else {
         System.out.println("No identificó bien el Caballo");
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
   // Si mueve mas de dos
        
            if (Math.abs(Yfut-Ynow)==2 && Math.abs(Xfut-Xnow)==1) {
            AuxBool= true;
                 }
            if (Math.abs(Xfut-Xnow)==2 && Math.abs(Yfut-Ynow)==1) {
            AuxBool= true;
                 }
            if(M[Xfut][Yfut]<7 && Id==3 && M[Xfut][Yfut]!=0){
            AuxBool=false;
            }
            if( Xfut==Xnow && Yfut==Ynow){
            AuxBool=false;
            }
           if( M[Yfut][Xfut]>10 && Id==13){
            AuxBool=false;
            }
           
            
            
 
       
            return AuxBool;     
            
      }
}
