/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//
package modelo;
import basededatos.personaBD;
/**
 *
 * @author Milii2
 */
public class Persona {
 
    public String Rut;
    public String Nombre;
    public String Fono;

    public Persona(String Rut, String Nombre, String Fono, int Edad) {
        this.Rut = Rut;
        this.Nombre = Nombre;
        this.Fono = Fono;
        this.Edad = Edad;
    }

    public Persona(){
        
    }
    public Persona(String Rut) {
        this.Rut=Rut;
    }

   



    public String getFono() {
        return Fono;
    }

    public void setFono(String Fono) {
        this.Fono = Fono;
    }
    public int Edad;

    public String getRut() {
        return Rut;
    }

    public void setRut(String Rut) {
        this.Rut = Rut;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }



    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }
    
    
    public void grabar() throws java.lang.ClassNotFoundException,
                                java.lang.InstantiationException,
                                java.lang.IllegalAccessException,
                                java.sql.SQLException,
                                error
    {
        personaBD pdb=new personaBD(this);
        pdb.grabar();
    }
    
    public Persona leer() throws java.lang.ClassNotFoundException,
                                java.lang.InstantiationException,
                                java.lang.IllegalAccessException,
                                java.sql.SQLException,
                                error
    {
        personaBD pdb=new personaBD(this);
        return pdb.leer();
    }
    
    public void borrar() throws java.lang.ClassNotFoundException,
                                java.lang.InstantiationException,
                                java.lang.IllegalAccessException,
                                java.sql.SQLException,
                                error
    {
        personaBD pdb=new personaBD(this);
        pdb.borrar();
    }

    public void actualizar(String pnombre, String pfono, String pedad) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

 
    
}
