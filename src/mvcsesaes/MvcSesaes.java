/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *///
package mvcsesaes;

import controlador.controladorPersona;
import modelo.Persona;
import vista.VentanaPrincipal;

/**
 *
 * @author Milii2
 */
//
//
public class MvcSesaes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona modelo = new Persona();
        VentanaPrincipal vista = new VentanaPrincipal(); 
        vista.setVisible(true);
        //try{
        controladorPersona controlador = new controladorPersona( vista,modelo );
    
        //se inicia la vista
        controlador.iniciar_vista();
        // TODO code application logic here
    }
}
