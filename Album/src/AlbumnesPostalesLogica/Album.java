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
public class Album {
    public String nombre;
    public int id;
    public int numeroDePostales;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroDePostales() {
        return numeroDePostales;
    }

    public void setNumeroDePostales(int numeroDePostales) {
        this.numeroDePostales = numeroDePostales;
    }

    public Album(String nombre, int id, int numeroDePostales) {
        this.nombre = nombre;
        this.id = id;
        this.numeroDePostales = numeroDePostales;
    }
}
