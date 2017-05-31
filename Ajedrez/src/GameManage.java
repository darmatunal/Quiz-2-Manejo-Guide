
import java.awt.Dimension;
import java.awt.Toolkit;
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
public class GameManage {
    
    public static void  main(String[] args){
    
         
    Toolkit t = Toolkit.getDefaultToolkit();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Pantalla frame=new Pantalla();
    
    frame.setTitle("Dario Arango Game");
    frame.getMenuBar();
    frame.setSize(screenSize.width,screenSize.height);    
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    
         // TODO code application logic here
    Bienvenida B=new Bienvenida();
    B.setTitle("Inicio");
    B.setVisible(true);
    
    // Código para cuadrar  caracteristicas del juego 
     Boolean a=true;
        while (a) {
    Boolean B1=B.getSalir();
    if (B1) {
    frame.getP().setHABILITAR(Boolean.TRUE);
    a=false;
    }   }
// Se toman los nmbres de los jugadores con negras y blancas
    String NameB=B.getId1().getText();
    String NameN=B.getId2().getText();
    frame.getP().setPlayerBlancas(NameB);
    frame.getP().setPlayerNegras(NameN);
    
    
    
    
    }}
