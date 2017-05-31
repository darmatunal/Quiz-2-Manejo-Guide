
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dario Arango
 */
public class Rey extends Ficha{

    public Rey(String ColorID){
     Image rey;
     if (ColorID.equals("ReyN")) {
     rey=this.loadImage("ReyN.png");
     this.setForma(rey);
     this.setId(6);
     }
     if (ColorID.equals("ReyB")) {
     rey=this.loadImage("ReyB.png");
     this.setForma(rey);
     this.setId(16);
     }
     else {
         System.out.println("No identificó el Rey");
     }
    }
    public Boolean CanEnroque(int Id,int Xnow, int Ynow, int Xfut, int Yfut, int[][] M){
        Boolean AuxBool=false;
        
    if (Id==16 && Ynow==0 && Xnow==4 &&( Xfut==0 || Xfut==6) ) {
        AuxBool=true;  
            if (Xfut==0) {
            for (int i=0; i <3; i++) {
            if (M[Ynow][Xnow-1-i]!=0) {
            AuxBool=false;        
            }}
                if (M[Ynow][0]!=12) {
            AuxBool=false;
                }
            }   
      if (Xfut==0) {
            for (int i=0; i <2; i++) {
            if (M[Ynow][Xnow+1+i]!=0) {
            AuxBool=false;        
            }}
                if (M[Ynow][7]!=12) {
            AuxBool=false;
                }
            }        
        }
    
    if (Id==6 && Ynow==0 && Xnow==4 &&( Xfut==0 || Xfut==6) ) {
        AuxBool=true;  
            if (Xfut==0) {
            for (int i=0; i <3; i++) {
            if (M[Ynow][Xnow-1-i]!=0) {
            AuxBool=false;        
            }}
                if (M[Ynow][0]!=2) {
            AuxBool=false;
                }
            }   
        //******************+
        if (Xfut==0) {
            for (int i=0; i <2; i++) {
            if (M[Ynow][Xnow+1+i]!=0) {
            AuxBool=false;        
            }}
                if (M[Ynow][7]!=2) {
            AuxBool=false;
                }
            }   
        }
    
    return AuxBool;
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
   // Si mueve mas de dos en Y
            if (Math.abs(Yfut-Ynow)>2 ) {
        AuxBool= false;
                }
   // Si mueve una al frente o atrás
        if(Math.abs(Ynow-Yfut)==1 && Xnow==Xfut){
        AuxBool=true;
        }
    // Si mueve a los lads
        if(Math.abs(Xnow-Xfut)==1 && Ynow==Yfut){
        AuxBool=true;
        }     
   // Si se mueve en diagonal
        if (Math.abs(Ynow-Yfut)==1 && Math.abs(Xnow-Xfut)==1) {
        AuxBool=true;        
            }
   //    // Si mueve dos al frente
        if((Ynow-Yfut)==2 && Xnow==Xfut && Ynow==6){
        AuxBool=true;
        }   
   // Enroque
        if (Id==16 && Ynow==0 && Xnow==4 &&( Xfut==0 || Xfut==6) ) {
        AuxBool=true;  
            if (Xfut==0) {
            for (int i=0; i <3; i++) {
            if (M[Ynow][Xnow-1-i]!=0) {
            AuxBool=false;        
            }}
                if (M[Ynow][0]!=12) {
            AuxBool=false;
                }
            }   
        }
        if (Id==6 && Ynow==0 && Xnow==4 &&( Xfut==0 || Xfut==6) ) {
        AuxBool=true;  
            if (Xfut==0) {
            for (int i=0; i <3; i++) {
            if (M[Ynow][Xnow-1-i]!=0) {
            AuxBool=false;        
            }}
                if (M[Ynow][0]!=2) {
            AuxBool=false;
                }
            }   
        }
      if( Xfut==Xnow && Yfut==Ynow){
            AuxBool=false;
            }
    return AuxBool;   
    }
    
    public boolean checkJaque(int Id ,int[][] M){
    
      int auxid=0;
      int Xrey=0;
      int Yrey=0;
      boolean Jaque=false;
      // Para comparar fichas se llama el arraylist con la información de las mismas
      MiPanel Paux= new MiPanel();
      ArrayList<Ficha> Fichas= new ArrayList<>();
      
       //Creación de Fichas
  Peon PB=new Peon("PB");
  Peon PN=new Peon("PN");
  Torre TN=new Torre("TN");
  Torre TB=new Torre("TB");
  Caballo CN=new Caballo("CN");
  Caballo CB=new Caballo("CB");
  Alfil AN= new Alfil("AN");
  Alfil AB= new Alfil("AB");
  Reina RN= new Reina("RN");
  Reina RB= new Reina("RB");
  Rey ReyN=new Rey("ReyN");
  Rey ReyB =new Rey("ReyB");
  //
      
        Fichas.add(PB);
        Fichas.add(PN);
        Fichas.add(TB);
        Fichas.add(TN);
        Fichas.add(CB);
        Fichas.add(CN);
        Fichas.add(AB);
        Fichas.add(AN);
        Fichas.add(RB);
        Fichas.add(RN);
        Fichas.add(ReyB);
        Fichas.add(ReyN);

      
      // Se crea variable auxiliar tipo ficha para saber si se puede mover.
      Ficha FichaAux=new Peon("PB");
      
     // Identificar la posición del Rey
      for (int i = 0; i < 8; i++) {
        for (int j = 0; j <8; j++) {
        if (M[i][j]==Id) {
        Xrey=j;
        Yrey=i;
            }
            }
      }
      
     //Verificar jaque para  Rey Negro
        for (int i = 0; i < 8; i++) {
        for (int j = 0; j <8; j++) {
        if (M[i][j]!=0 && Id>10 && M[i][j]<10) {
        auxid=M[i][j];   
        
        // Con Id ficha se identifica el elemento
         for (int k = 0; k <Fichas.size(); k++) {
         if ( Fichas.get(k).getId()==auxid) {
         FichaAux= Fichas.get(k);
         k=Fichas.size();
          }  
         }
        // Se verifica si la ficha puede comerse el rey
        Boolean B=FichaAux.CanMove(auxid, j,i, Xrey, Yrey, M);
            if (B==true) {
         Jaque=true;    
                
            }
            }  
            }
            }
       //Verificar jaque para  Rey Blanco
        for (int i = 0; i < 8; i++) {
        for (int j = 0; j <8; j++) {
        if (M[i][j]!=0 && Id<10 && M[i][j]>10) {
        auxid=M[i][j];   
         
        // Con Id ficha se identifica el elemento
         for (int k = 0; k <Fichas.size(); k++) {
         if ( Fichas.get(k).getId()==auxid) {
         FichaAux= Fichas.get(k);
         k=Fichas.size();
         
          }  
         }
        // Se verifica si la ficha puede comerse el rey
        Boolean B=FichaAux.CanMove(auxid, j,i, Xrey, Yrey, M);
      
            if (B==true) {
         Jaque=true;       
            }
            }  
            }
            }
        
        
        return Jaque;
    }
    
    
}
