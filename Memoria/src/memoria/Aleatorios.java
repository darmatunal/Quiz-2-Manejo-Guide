/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

/**
 *
 * @author Dario Arango
 */
public class Aleatorios {

int i=0;
int cantidad;
int max;
public  int[]  Generar(int Cantidad, int max){

this.cantidad=Cantidad;
this.max=max;
int tam=this.cantidad*2;
int [] Arreglo= new int[tam];

    for (int j =0; j <cantidad; j++) {
    
    Arreglo[j]=(int)(Math.random()*max);        
   
    for (int k = 0; k <j; k++) {
    if(Arreglo[j]==Arreglo[k]){
    j=j-1;
                              }
                               }   
    }
for (int j =cantidad; j <2*cantidad; j++) {
    
    Arreglo[j]=(int)(Math.random()*max);        
   
    for (int k =cantidad; k <j; k++) {
    if(Arreglo[j]==Arreglo[k]){
    j=j-1;
                              }
                               }   
    }
    
  return Arreglo;  
}   
    
}
