/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import java.util.Random;

/**
 *
 * @author Dario Arango
 */
public class Memoria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    Toolkit t = Toolkit.getDefaultToolkit();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Pantalla frame=new Pantalla();
    
    frame.setTitle("Dario Arango Game");
    frame.getMenuBar();
    frame.setSize(screenSize.width,screenSize.height);    
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
   
    Aleatorios A=new Aleatorios();
    int [] Arreglo1=A.Generar(6,6);
        
    }
    
    
}
