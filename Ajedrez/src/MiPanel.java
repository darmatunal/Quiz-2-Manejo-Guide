
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dario Arango
 */
public class MiPanel  extends JPanel implements ActionListener,  MouseListener{
    
    // Se crea la variable timer que será la que va a coordinar los
    // tiempos de ejecucion, esta llama la clase Timer
   private final Timer timer;
   Toolkit t = Toolkit.getDefaultToolkit();
   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
   
  // Variable que habilitará el paint component
  public Boolean HABILITAR=false; 
  
  //Arreglo que guardará imagenes
  private ArrayList<Image>  Imagenes=new ArrayList<>();
  int x=0;
  int xExt=screenSize.width;
  int yExt=screenSize.height;
 
  // Particiones de cuadro
  int dx=(xExt-35)/8;
  int dy=(yExt-110)/8;   
  int X0=30;
  int Y0=30;
  /////
  int filas=4;
  int columnas=3;
  //Solo se edita desde este programa o desde
  
  private int [][] Matriz=new int [8][8];
  int [][] Mant=new int [8][8];;
  
  int tam=filas*columnas/2;
  // Numeros clave para dibujar
  int xsep=xExt/50;
  int Wx=(xExt-(columnas+1)*xsep)/columnas;
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
  Ficha FichaAux;
   
  private ArrayList<Ficha> Fichas=new ArrayList<>();
  // Indicador de turno
  int turno=0;
  String Turn="Juega blanco";
  private String PlayerBlancas;
  private String PlayerNegras;
  // Variables para jaque mate
  boolean Jaque=false;
  boolean Mate=false;
  
  
// Variable de posición del Mouse
 Point pxy;
 int Xnow;
 int Ynow;
 int Xsel=10;
 int Ysel=10;
 int Xfut;
 int Yfut;
 //  
 int press;
 //
  int DER=0;
  int IZQ=0;
  int ARR=0;
  int bajo=0;
  int aux;
  // Variable para identificar los pasos antes de la muerte
  
  int press1=0;
  int press2=0;
  int Inicio=0;
  // Variables para identificar fichas
  int Idficha=0;
  int [][] PosActual;
  int [][] PosFut; 
    //private Object thread;
 ArrayList<Point> Aciertos=new ArrayList<>();
    // Constructor del panel, este tiene como objetivo inicializar el Timer
    // Y agregar el Listener del teclado y del Mouse.
    public void AddFichas(){
        this.getFichas().add(PB);
        this.getFichas().add(PN);
        this.getFichas().add(TB);
        this.getFichas().add(TN);
        this.getFichas().add(CB);
        this.getFichas().add(CN);
        this.getFichas().add(AB);
        this.getFichas().add(AN);
        this.getFichas().add(RB);
        this.getFichas().add(RN);
        this.getFichas().add(ReyB);
        this.getFichas().add(ReyN);

    
    }
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
     if (HABILITAR==true) {
         
    
     if (Inicio==0) {
     this.OrganizarJuego();   
     }

 this.AddFichas();
// ajuste de pantalla y fondo
Image fondo = loadImage("Tablero.PNG");
// Se carga el fondo
g.drawImage(fondo,10,10,screenSize.width-25 ,screenSize.height-100,null);
// Dibujar ficha
Image fichaPrueba= loadImage("AN.png");

// Variable de busqueda de elemento a sibujar en el Arraylist
 int Busqueda=0;
 Ficha Faux;
 Image Iaux;
// Dibujar matrices de acuerdo a las posiciones almacenadas
 for (int i = 0; i < 8; i++) {
       for (int j = 0; j <8; j++) {
           
 // Capta Id que esta en la matriz
  Busqueda=     this.getMatriz()[i][j]; 
           for (int k = 0; k <this.getFichas().size(); k++) {
   Faux=                this.getFichas().get(k);
           
               if (Faux.getId()==Busqueda) {
    Iaux=                   getFichas().get(k).getForma();
    g.drawImage(Iaux,75+154*j,55+i*77,45+(1)*155*(j+1),25+(i+1)*77,5,0,53,47,null);
    k=                      this.getFichas().size();
               }
           }
       }
      } 
 // Se dibuja indicador de turno
   
   g.setColor(Color.BLUE);
   g.setFont( new Font( "Serif", Font.ITALIC, 50 ) );
   g.drawString(this.Turn,10,40);
 
 // Se dibuja Rectangulo indicador
 
   Rectangle R= new Rectangle();
   
   g.setColor(Color.RED);       
   g.drawRect(75+154*Xnow,40+Ynow*77,100,75 );
     
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
  
  
 
  public void OrganizarJuego(){
     
      
      for (int i = 0; i <5; i++) {
          this.getMatriz()[0][i]=i+2; 
          this.getMatriz()[7][i]=i+12;
      }
      for (int i = 0; i <8; i++) {
          this.getMatriz()[1][i]=1; 
          this.getMatriz()[6][i]=11;
      }
      for (int i =0; i <3; i++) {
          this.getMatriz()[0][i+5]=4-i; 
          this.getMatriz()[7][i+5]=14-i;
      }
    
  }
   @Override
  public void mouseClicked(MouseEvent e) { 
 // Variable para controlar inicio del juego     
  Inicio=1; 
  // Se obtiene punt de la pantalla
  pxy=e.getLocationOnScreen();
 
 //Detección de clicks
  press1=press1+1;
       System.out.println(press1);
  if (press1==2) {
      press2=1;   
       }
 // Creación de valores para manejo de posición de fichas 
 int [][] auxPos= new int[1][2];
 // Creación de matriz auxiliar para identificar turnos

 
 // Reconocer posición de matriz del tablero
 
if(press1==1){ 
// Se guarda la primera cara de la matriz.    
 Mant=Matriz;  
 auxPos=this.ReconocerPos(pxy);
 Xnow=auxPos[0][0];
 Ynow=auxPos[0][1];
 
 if( getMatriz()[Ynow][Xnow]!=0){
 Idficha=       getMatriz()[Ynow][Xnow];
 //System.out.println(Idficha);
 
 // Con Id ficha se identifica el elemento
     for (int i = 0; i <this.getFichas().size(); i++) {
     if (           this.getFichas().get(i).getId()==Idficha) {
     this.FichaAux=     this.getFichas().get(i);
     }  
     }
     
 }
 
 
}

 if(press2==1){ 
 
 System.out.println("press2: "+press2);
 auxPos=this.ReconocerPos(pxy);
 Xfut=auxPos[0][0];
 Yfut=auxPos[0][1];
 // Se verifica que la ficha se pueda mover
 Boolean B=this.FichaAux.CanMove(Idficha, Xnow, Ynow, Xfut, Yfut, getMatriz());
///

if (B==true) {
                getMatriz()[Yfut][Xfut]=Idficha;
                getMatriz()[Ynow][Xnow]=0;     
                turno=turno+1;
    if (turno==1) {
        
     this.Jaque= this.ReyN.checkJaque(ReyN.getId(), Matriz);
     
         if(Jaque==true){
    this.Turn="Jaque al Negro, Juega "+this.PlayerNegras;
   
              }
    else{
    this.Turn="Juega " +this.PlayerNegras;
       
    }
      
        
        
    }
    if (turno==2) {
        
    this.Jaque= this.ReyB.checkJaque(ReyB.getId(), Matriz);    
    if(Jaque==true){
         this.Turn="Jaque al blanco, Juega "+this.PlayerBlancas;
        turno=0;
    }
    else{
    this.Turn="Juega "+ this.PlayerBlancas;
        turno=0;
    }
    
    }
     }
// Se reinician las variables de estados 
 press2=0;
 press1=0;
 // Se mira  si hubo movimiento


 }
  
   }
 
  
   //*Retorna los valores de la matriz del tablero cuando le ingresa la coordena leída
  //Por el Mouse*/
  public int [][] ReconocerPos(Point P){
  int x=P.x;
  int y=P.y;
  int [][] Pos=new int[1][2];
   // Reconocer elemento de la matriz
   for ( int i = 0; i <8; i++) {
   for ( int j = 0; j <8; j++) {
          
       if (X0+dx*j<x && x<dx*(j+1)+X0) {
       if (Y0+dy*i<y && y<dy*(i+1)+Y0){
         
          Pos[0][0]=j;
          Pos[0][1]=i;
           
           }
       }
      }
     }
      System.out.println("Xcor: "+Pos[0][0]+"Ycor: "+Pos[0][1]);

  return Pos;
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

    /**
     * @return the Matriz
     */
    public int[][] getMatriz() {
        return Matriz;
    }

    /**
     * @param Matriz the Matriz to set
     */
    public void setMatriz(int[][] Matriz) {
        this.Matriz = Matriz;
    }

    /**
     * @return the HABILITAR
     */
    public Boolean getHABILITAR() {
        return HABILITAR;
    }

    /**
     * @param HABILITAR the HABILITAR to set
     */
    public void setHABILITAR(Boolean HABILITAR) {
        this.HABILITAR = HABILITAR;
    }

    /**
     * @return the Fichas
     */
    public ArrayList<Ficha> getFichas() {
        return Fichas;
    }

    /**
     * @return the PlayerBlancas
     */
    public String getPlayerBlancas() {
        return PlayerBlancas;
    }

    /**
     * @param PlayerBlancas the PlayerBlancas to set
     */
    public void setPlayerBlancas(String PlayerBlancas) {
        this.PlayerBlancas = PlayerBlancas;
    }

    /**
     * @return the PlayerNegras
     */
    public String getPlayerNegras() {
        return PlayerNegras;
    }

    /**
     * @param PlayerNegras the PlayerNegras to set
     */
    public void setPlayerNegras(String PlayerNegras) {
        this.PlayerNegras = PlayerNegras;
    }
   

   }
    