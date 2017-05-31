
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
public class Torre extends Ficha{
    
    public Torre(String ColorID){
     Image torre;
     if (ColorID.equals("TN")) {
     torre=this.loadImage("TN.png");
     this.setForma(torre);
     this.setId(2);
     }
     if (ColorID.equals("TB")) {
     torre=this.loadImage("TB.png");
     this.setForma(torre);
     this.setId(12);
     }
     else {
         System.out.println("No identificó bien la torre");
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
    // No presenta trayectoria recta
        if (Xnow!=Xfut && Ynow!=Yfut) {
          AuxBool=false;
        }
    // Identificar si es en X o en Y
    // Cambio  En X
    ////****************************************************
        if (Xnow!=Xfut && Ynow==Yfut && Id==12) {
        if(Xnow>Xfut){
        AuxBool=true;
            for (int i = 0; i < Xnow-Xfut;i++) {
                if (M[Ynow][Xnow-1-i]>10) {
                  AuxBool=false;    
                                             }   
                                             }
                            }
        else{
        AuxBool=true;
            for (int i = 0; i < Xfut-Xnow;i++) {
                if (M[Ynow][Xnow+1+i]>10) {
                  AuxBool=false;    
                                             }   
                                             }
                            }
        }
        
       
       //************************************************
       if (Xnow!=Xfut && Ynow==Yfut && Id==2) {
        if(Xnow>Xfut){
        AuxBool=true;
            for (int i = 0; i < Xnow-Xfut;i++) {
                if (M[Ynow][Xnow-1-i]>1 && M[Ynow][Xnow-1-i]<10) {
                  AuxBool=false;    
                                             }   
                                             }
                            }
        else{
        AuxBool=true;
            for (int i = 0; i < Xfut-Xnow;i++) {
                if (M[Ynow][Xnow-1-i]>1 && M[Ynow][Xnow-1-i]<10) {
                  AuxBool=false;    
                                             }   
                                             }
                            }
        }
        
       //**********************************
         
        if (Xnow==Xfut && Ynow!=Yfut && Id==12) {
        AuxBool=true;
            if (Ynow<Yfut) {
                for (int i = 0; i < Yfut-Ynow; i++) {
                    if (M[Ynow+1+i][Xnow]>10) {
                      AuxBool=false;  
                    }
                }
                
            }
            else{
            for (int i = 0; i < Ynow-Yfut; i++) {
                    if (M[Ynow-1-i][Xnow]>10) {
                      AuxBool=false;  
                    }
                }
            }
        
        }
        //*******************************************
        if (Xnow==Xfut && Ynow!=Yfut && Id==2) {
        AuxBool=true;
            if (Ynow<Yfut) {
                for (int i = 0; i < Yfut-Ynow; i++) {
                    if (M[Ynow+1+i][Xnow]>1 && M[Ynow+1+i][Xnow]<10) {
                      AuxBool=false;  
                    }
                }
                
            }
            else{
            for (int i = 0; i < Ynow-Yfut; i++) {
                    if (M[Ynow-1-i][Xnow]>1 && M[Ynow-1-i][Xnow]<10) {
                      AuxBool=false;  
                    }
                }
            }
        
        }
          if( Xfut==Xnow && Yfut==Ynow){
            AuxBool=false;
            }
    return AuxBool;    
    }
    
}
