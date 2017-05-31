/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @Se obliga a que se implementen los métodos de Action y Mouse Listener
 * Para tener interración con la pantalla.
 */
public class MiPanel  extends JPanel implements ActionListener,  MouseListener{
    
    // Se crea la variable timer que será la que va a coordinar los
    // tiempos de ejecucion, esta llama la clase Timer
   private final Timer timer;
   Toolkit t = Toolkit.getDefaultToolkit();
   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  private ArrayList<Image>  Imagenes=new ArrayList<>();
  int x=0;
  int xExt=screenSize.width;
  int ymin=screenSize.height-80;
 
  /////
  int filas=4;
  int columnas=3;
  //
  int [][] Matriz=new int [filas][columnas];
  int tam=filas*columnas/2;
  // Numeros clave para dibujar
  int xsep=xExt/50;
  int ysep=ymin/50;
  int Wx=(xExt-(columnas+1)*xsep)/columnas;
  int Ly=(ymin-(filas+1)*ysep)/filas;      
  
  
  // Arreglo Aleatorio
  Aleatorios A=new Aleatorios();
   // Arreglos para guardar números aleatorios.
  int [] Arreglo1=A.Generar(tam,tam);
  
// Variable de posición del Mouse
 Point pxy;
 int Xnow;
 int Ynow;
 int Xsel=10;
 int Ysel=10;
 int Xant=11;
 int Yant=11;
 //  
 int press;
 //
  int DER=0;
  int IZQ=0;
  int ARR=0;
  int bajo=0;
  int aux;
  // Variable para identificar los pasos antes de la muerte
  int bien=0;
  
    //private Object thread;
 ArrayList<Point> Aciertos=new ArrayList<>();
    // Constructor del panel, este tiene como objetivo inicializar el Timer
    // Y agregar el Listener del teclado y del Mouse.
    
     public MiPanel(){
         
         
    //para el teclado inicializa la clase interna Tapadter.
     addKeyListener(new Tadapter());
     setFocusable(true);
     // Agrega el funcionamiento en modo receptivo del Mouse.   
    this.addMouseListener(this);
    // Inicializa el Timer para pasos de 200ms En este caso    
    this.timer=new Timer(50,this);
    //Inicializa el Timer
    this.timer.start();
    }
    // Se crea una clase que va a extender la clase KeyApater,
    // Esta  clase permite trabajar las funciones del teclado
    private class Tadapter extends KeyAdapter{

     // Libera las teclas
     @Override
     public void keyReleased(KeyEvent e){
     
      }
     @Override
     // Reacciona ante el evento de presionar una tecla
     public void keyPressed(KeyEvent e){
    
     }
  
 }  
 public void AddImagenes(Image I){
 
     this.getImagenes().add(I);
 
 }
    
  // En esta parte se deben definir todas las imagenes que se deben definir en el 
  //Panel
 @Override
 protected void paintComponent(Graphics g){
 super.paintComponent(g);
 
// ajuste de pantalla y fondo
Image fondo = loadImage("Fondo.PNG");
// Se carga el fondo
g.drawImage(fondo,0,0,screenSize.width ,screenSize.height, null);

// Se cargan algunas imagenes, se pueden agregar más desde un método
Image Im0=loadImage("IM0.PNG");
Image Im1=loadImage("IM1.PNG");
Image Im2=loadImage("IM2.PNG");
Image Im3=loadImage("IM3.PNG");
Image Im4=loadImage("IM4.PNG");
Image Im5=loadImage("IM5.PNG");
Image Im6=loadImage("IM6.PNG");
Image Im7=loadImage("IM7.PNG");
Image FIN=loadImage("Fin.PNG");

// Se graban en el ArrayList de imagenes

this.AddImagenes(Im1);
this.AddImagenes(Im2);
this.AddImagenes(Im3);
this.AddImagenes(Im4);
this.AddImagenes(Im5);
this.AddImagenes(Im6);
this.AddImagenes(Im0);

// Se crea una matriz que va a ser la que coloque las imagenes en cada espacio
int k=0;
     for (int i = 0; i < this.filas; i++) {
         for (int j = 0; j <this.columnas; j++) {
         this.Matriz[i][j]=Arreglo1[k];
         k=k+1;
         //System.out.print(Matriz[i][j]+" , ");
             
         }
        // System.out.println("   ");
        }
 // Se dibujan las imagenes cerradas
 int auxint;
 Image Iaux;
     
     for (int i = 0; i <this.filas; i++) {
     for (int j = 0; j <this.columnas; j++) {
     g.drawImage(Im0,xsep*(j+1)+Wx*j,ysep*(i+1)+Ly*i,xsep*(j+1)+Wx*(j+1),ysep*(i+1)+Ly*(i+1),0,0,500,600 ,null);    
     }
     }
     
// Se Dibujan las imagenes
if (Xsel<10) {    
int i =Xsel;
int j=Ysel;
g.drawImage(Imagenes.get(Matriz[i][j]),xsep*(j+1)+Wx*j,ysep*(i+1)+Ly*i,xsep*(j+1)+Wx*(j+1),ysep*(i+1)+Ly*(i+1),0,0,500,500 ,null);         
}  
if (Xant<10) {    
int i =Xant;
int j=Yant;
g.drawImage(Imagenes.get(Matriz[i][j]),xsep*(j+1)+Wx*j,ysep*(i+1)+Ly*i,xsep*(j+1)+Wx*(j+1),ysep*(i+1)+Ly*(i+1),0,0,500,500 ,null);         
}  
    int Xaux=0;
    int Yaux=0;  
// Se comparan los valores de las matrices para saber si son iguales.
if (Xant<10 && Xsel<10) {
    
    System.out.println("Xsel: "+ Xsel+"Ysel: "+ Ysel);
    System.out.println("Xant: "+ Xant+"Yant: "+ Yant); 
   
    if (Matriz[Xsel][Ysel]==Matriz[Xant][Yant]){
    Xaux=Xsel;
    Yaux=Ysel;    
   
    System.out.println("Al parecer son iguales");
    System.out.println(Matriz[Xsel][Ysel]);
    System.out.println(Matriz[Xant][Yant]);
    Point Pdes1= new  Point(Xant,Yant);
    Point Pdes2= new  Point(Xsel,Ysel);
    this.Aciertos.add(Pdes1);
    this.Aciertos.add(Pdes2);
     }
}
//  Se dibujan chulos en los lugares dónde hay aciertos.
for (int r = 0; r < this.Aciertos.size(); r++) {
  int i=this.Aciertos.get(r).x;
  int j=this.Aciertos.get(r).y;
  g.drawImage(Im7,xsep*(j+1)+Wx*j,ysep*(i+1)+Ly*i,xsep*(j+1)+Wx*(j+1),ysep*(i+1)+Ly*(i+1),0,0,400,400 ,null);     
  
     }

     if (this.bien==columnas*filas*2) {
   
   // Se carga el fondo
   g.drawImage(FIN,0,0,screenSize.width ,screenSize.height, null);       
     // Cargar Pasos     
   g.setColor(Color.WHITE);
   g.setFont( new Font( "Serif", Font.ITALIC, 70 ) );    
   g.drawString("FELICITACIONES!!! ",screenSize.width/2-200 ,screenSize.height/2-100);
  
   this.timer.stop();
     }


   
   
   
   
 
   }
   // Método para cargar imagenes  
   
   public Image loadImage(String imageName) {
   ImageIcon ii = new ImageIcon(imageName);
   Image image = ii.getImage();
   return image;
    }

  // Este es un método que se debe implementar
   //Variable para secuencia
  
  @Override
  public void actionPerformed(ActionEvent e) {
  repaint();
  }
  
 
 // Como Se definió, Implements obliga a definir todos los métodos del
 // Mouse Los primeros se dejan vacíos, el uso está princupalmente en MouseClicked.
  @Override
  public void mouseClicked(MouseEvent e) { 
   if(press!=0){   
    Xant=Xsel;
    Yant=Ysel;
   
   }else{
   Xant=11;
   Yant=11;
   }
  press=press+1;
  
  System.out.println(press);
  
  pxy=e.getLocationOnScreen();
      
     // Reconocer elemento de la matriz
   for ( int i = 0; i <this.filas; i++) {
   for ( int j = 0; j <this.columnas; j++) {
      Xnow=pxy.x;
      Ynow=pxy.y;      
       if (xsep*(j+1)+Wx*j<Xnow && Xnow<xsep*(j+1)+Wx*(j+1)) {
       if (ysep*(i+1)+Ly*i<Ynow && Ynow<ysep*(i+1)+Ly*(i+1)){
         
        
          Xsel=i;
          Ysel=j;
           
           }
       }
      }
     }
      if (press==2) {
          press=0;
      }
       System.out.println("Xsel: "+Xsel+" Ysel: "+Ysel);
       System.out.println("Xant: "+Xant+" Yant: "+Yant);
        //  this.timer.stop(); 
        //  this.timer.start();
       if (Matriz[Xant][Yant]==Matriz[Xant][Yant]) {
          this.bien=this.bien+2;    
          System.out.println(bien);
      }
   
   }
       
        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
           
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }
        @Override
        public void mouseExited(MouseEvent e) {
        }

    /**
     * @return the Imagenes
     */
    public ArrayList<Image> getImagenes() {
        return Imagenes;
    }

    /**
     * @param Imagenes the Imagenes to set
     */
    public void setImagenes(ArrayList<Image> Imagenes) {
        this.Imagenes = Imagenes;
    }
   

   }
    