
import java.awt.Image;
import java.awt.Point;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dario Arango
 */
public abstract class Ficha {
private int id;
private double Color;
private Image Forma;
private Point  PosActual;

/**
 Se le da punto actual y punt futuro para que sepa si es válido el movimiento
     * @param Xnow
     * @param 
 */
public abstract Boolean CanMove(int Id, int Xnow,int Ynow,int Xfut,int Yfut, int [][] M);
public abstract Boolean CanEat(Point Pact, Point Pfut);
public abstract void Moverse(Point Pfut);
public abstract void Eliminar();

public Image loadImage(String imageName) {
   ImageIcon ii = new ImageIcon(imageName);
   Image image = ii.getImage();
   return image;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the Color
     */
    public double getColor() {
        return Color;
    }

    /**
     * @param Color the Color to set
     */
    public void setColor(double Color) {
        this.Color = Color;
    }

    /**
     * @return the Forma
     */
    public Image getForma() {
        return Forma;
    }

    /**
     * @param Forma the Forma to set
     */
    public void setForma(Image Forma) {
        this.Forma = Forma;
    }

    /**
     * @return the PosActual
     */
    public Point getPosActual() {
        return PosActual;
    }

    /**
     * @param PosActual the PosActual to set
     */
    public void setPosActual(Point PosActual) {
        this.PosActual = PosActual;
    }


}
