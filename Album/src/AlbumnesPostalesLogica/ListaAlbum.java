/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlbumnesPostalesLogica;

/**
 *
 * @author Cristian
 */
public class ListaAlbum {
    public NodoA primero;
    public NodoA ultimo;

    public ListaAlbum() {
        primero = null;
        ultimo = null;
    }
    
    public boolean EstaVacio(){
    if(primero == null)
        return true;
    else
        return false;
    }
    
   
  public void enlazar(NodoA nodoa, NodoA nodob){
      nodoa.sgt = nodob;
      nodob.ant = nodoa;
  }
  public void insertar(Album a){
      NodoA nuevo = new NodoA(a);
      if (EstaVacio()){
          primero = nuevo;
          ultimo = nuevo;
      }else
      {
          enlazar(nuevo, primero);
          primero = nuevo;
      }
  }
  
  public void eliminar(int i){
      //proximamente!! :P
  }
  
  public NodoA buscarAlmbum (int id_alb){
      NodoA buscado = null;
      NodoA iterador = primero;
      while(buscado == null && iterador != null){
            if(iterador.getAlbum().getId() == id_alb){
                buscado = iterador;
            }
            iterador = iterador.sgt;
      }
     return buscado;
}
  
  public boolean insertarPostal (int id_alb, int numeroPostal){
      NodoA alb = buscarAlmbum(id_alb);
      if (alb == null){
          return false;
      }else{
          alb.añadirPostal(numeroPostal);
          return true;
      }
  }
  
   public boolean VenderPostal (int id_alb, int numeroPostal){
      NodoA alb = buscarAlmbum(id_alb);
      if (alb == null){
          return false;
      }else if(alb.postalesRepetidas.contains(numeroPostal) == true){
                alb.postalesRepetidas.remove(alb.postalesRepetidas.indexOf(numeroPostal));
          return true;
      }else{
      return false;
      }
  }
  
  public String mostrar(){
  String album = "";
  NodoA iterador = primero;
  if(EstaVacio()){
   //System.out.print("No hay almbunes por coleccionar ;(");
      album =  album + "No hay almbunes por coleccionar ;(";
  }
  while (iterador != null){
      //System.out.print("\n" + iterador.getAlbum().getId() + " - " + iterador.getAlbum().getNombre()+ "\n");
      album = album +  iterador.getAlbum().getId() + " - " + iterador.getAlbum().getNombre()+ "\n" + 
              iterador.mostrarPostales();
      //iterador.mostrarPostales();
      iterador = iterador.sgt;
  }
  return album;
  }
}
