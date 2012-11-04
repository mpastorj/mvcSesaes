/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.VentanaPrincipal;
//import modelo.error;
import modelo.Persona;
import modelo.error;
import vista.VentanaIngreso;

/**
 *
 * @author Milii2
 */
public class controladorPersona implements ActionListener{
    private VentanaPrincipal vista;
    private Persona modelo;
    
    
    public controladorPersona(VentanaPrincipal vista,Persona modelo){
       this.vista=vista;
       this.modelo=modelo;
       this.vista.botoningresar.addActionListener(this);
    }
    public void agregarpersona(String prut, String pnombre, String pfono, int pedad) throws java.lang.ClassNotFoundException,
                                                                                                java.lang.InstantiationException,
                                                                                                java.lang.IllegalAccessException,
                                                                                                java.sql.SQLException
                                                                                               
    {
        Persona p=new Persona(prut,pnombre,pfono,pedad);
        try {
            p.grabar();
        } catch (error ex) {
            Logger.getLogger(controladorPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modificarpersona(String prut, String pnombre, String pfono, String pedad) throws java.lang.ClassNotFoundException,
                                                                                                java.lang.InstantiationException,
                                                                                                java.lang.IllegalAccessException,
                                                                                                java.sql.SQLException,
                                                                                                error
    {
        Persona p=new Persona(prut);
        p.actualizar(pnombre,pfono,pedad);
        p.grabar();
    }
    
    public void eliminarpersona(String prut, String pnombre, String pfono, String pedad) throws java.lang.ClassNotFoundException,
                                                                                                java.lang.InstantiationException,
                                                                                                java.lang.IllegalAccessException,
                                                                                                java.sql.SQLException
                                                                                               
    {
        Persona p;
        p=new Persona(prut);
        try {
            p.borrar();
        } catch (error ex) {
            Logger.getLogger(controladorPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void iniciar_vista(){
        
        vista.botoningresar.setText("Ingresar");
        //vista.botoningresar.action(new VentanaIngreso().setVisible(true));
      
    }
    
    //@Override
    @Override
    public void actionPerformed(ActionEvent e) {
        modelo.setNombre(vista.jtnombre.getText());
        modelo.setRut(vista.jtrut.getText());
       modelo.setFono(vista.jtfono.getText());
       // vista.jtnombre.setText(modelo.getNombre());
    //  modelo.setEdad(Integer.valueOf(vista.jtedad.getText()));
        try {
            modelo.grabar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(controladorPersona.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(controladorPersona.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(controladorPersona.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(controladorPersona.class.getName()).log(Level.SEVERE, null, ex);
        } catch (error ex) {
            Logger.getLogger(controladorPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        VentanaIngreso vista_2=new VentanaIngreso();
        vista_2.setVisible(true);
        
        
        
    }
    
    
    
}
