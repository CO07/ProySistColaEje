/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlbumnesPostalesLogica;

import com.sun.javafx.geom.transform.BaseTransform;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author Cristian
 */
public class NodoA {
    public Album album; 
    ArrayList<Integer> postales;
    ArrayList<Integer> postalesRepetidas;
    ArrayList<Integer> postalesFaltantes;
    public NodoA ant;
    public NodoA sgt;
    
    public NodoA(Album album) {
        postales = new ArrayList<Integer>();
        postalesRepetidas = new ArrayList<Integer>();
        postalesFaltantes = new ArrayList<Integer>();
        this.album = album;
        this.ant = null;
        this.sgt = null;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public ArrayList<Integer> getPostales() {
        return postales;
    }

    public void setPostales(ArrayList<Integer> postales) {
        this.postales = postales;
    }

  public String mostrarPostales(){
   int espacios = 0;
   String postalesAlbumS = "";   
   String postalesRepetidasS= "";  
   String postalesFaltantesS = "";  
   String totalS = "";  
             
   
  if(postales.size() == 0){
    //System.out.print("No hay postales en este album... \n");
      postalesAlbumS = postalesAlbumS + "No hay postales en este album... \n";
  }else if(postales.size() == album.getNumeroDePostales()){
            postalesAlbumS = postalesAlbumS + "Felecidades has completado este album :D!!!!! \n";
  }
  if(postales.size() != 0){
  Iterator it = postales.iterator();
   //System.out.print("Las postales de este album son: \n");
  postalesAlbumS = postalesAlbumS + "Las postales de este album son: \n";
      while (it.hasNext()) {
          //System.out.print(" - " + it.next());
          postalesAlbumS =  postalesAlbumS + " - " + it.next();
          if (espacios == 10){
              postalesAlbumS  =  postalesAlbumS + "\n";  
              espacios = 0;
          }else{
              espacios ++;
          }
      }
  }
   postalesAlbumS =  postalesAlbumS + "\n"+ "\n";
   espacios = 0;
  
  if(postalesRepetidas.size() == 0){
    //System.out.print("No hay postales repetidas en este album... \n");
      postalesRepetidasS = postalesRepetidasS + "No hay postales repetidas en este album... \n";
  }else{
  Iterator itR = postalesRepetidas.iterator(); 
   //System.out.print("Las postales repetidas son: \n" );
  postalesRepetidasS = postalesRepetidasS + "Las postales repetidas son: \n";
      while (itR.hasNext()) {
          //System.out.print( " - " + itR.next());
          postalesRepetidasS = postalesRepetidasS + " - " + itR.next();
          if (espacios == 10){
              postalesRepetidasS  =  postalesRepetidasS + "\n";  
              espacios = 0;
          }else{
              espacios ++;
          }
      }
  }
   postalesRepetidasS = postalesRepetidasS + "\n"+ "\n"; 
   espacios = 0; 
   
  //System.out.print("Las postales faltantes son: \n" );
postalesFaltantesS =  postalesFaltantesS = "Las postales faltantes son: \n";
    for (int i = 1; i <= album.getNumeroDePostales(); i++) {
         if(postales.contains(i) == false){
            postalesFaltantes.add(i);
            }
        }
          
  if (postalesFaltantes.size() == 0){
       postalesFaltantesS =  postalesFaltantesS + "\\033[34mLo lograste has completado este album!!!!";
  }
  else{
  Iterator itF = postalesFaltantes.iterator(); 
      while (itF.hasNext()) {
          //System.out.print( " - " + itF.next());
          postalesFaltantesS =  postalesFaltantesS + " - " + itF.next();
          if (espacios == 10){
              postalesFaltantesS  =  postalesFaltantesS + "\n";  
              espacios = 0;
          }else{
              espacios ++;
          }
      }
  }
      //System.out.print("\n");
      postalesFaltantesS =  postalesFaltantesS + "\n"+"\n" ;
      totalS = postalesAlbumS + postalesRepetidasS + postalesFaltantesS + "-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*"+"\n"+"\n";
      postalesFaltantes.clear();
      espacios = 0;
      //System.out.print( postalesAlbumS + postalesRepetidasS + postalesFaltantesS);
      return totalS;
  }
  
  
  
  public boolean añadirPostal(int numeroPostal){
  if(numeroPostal > album.getNumeroDePostales()){
      return false;
  }else if(postales.contains(numeroPostal) == true){
            postalesRepetidas.add(numeroPostal);
            Collections.sort(postales); //para ordenar el arraylist de postales
            Collections.sort(postalesRepetidas); //para ordenar el arraylist de postales repetidas
            return true;
  }else {
       postales.add(numeroPostal);
       Collections.sort(postales); //para ordenar el arraylist de postales
       Collections.sort(postalesRepetidas); //para ordenar el arraylist de postales repetidas
       return true;
  }
  }
}
