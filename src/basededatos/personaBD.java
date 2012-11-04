/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.error;
import modelo.unicaconexion;
//import modelo.conexion;
import modelo.Persona;
import modelo.conexion;
import vista.VentanaPrincipal;

/**
 *
 * @author Milii2
 */
public class personaBD {
    
    private Persona p;
    String jtnombre;
    public personaBD(Persona p)
    {
        this.p=p;
    }

  
    
    public void grabar() throws java.lang.ClassNotFoundException, 
                         java.lang.InstantiationException,
                         java.lang.IllegalAccessException, 
                         java.sql.SQLException
    {
        //conexion cdb=unicaconexion.getInstancia().getConexionDb();
        conexion cdb=new conexion();
        cdb.setEsSelect(false);
        cdb.setComandoSQL("insert into persona(rut,nombre,fono,edad) values('"+p.getRut()+"','"+p.getNombre()+"','"+p.getFono()+"','"+p.getEdad()+"')");
        cdb.conectar();
        //try {
        //
         //   while(cdb.getRst().next()) {
         //       jtnombre=cdb.getRst().getString("nombre");
                //p.setNombre(jtnombre);
                //p.setFono("hola");
                
         //   }
            
         //   } catch (SQLException ex) {
         //   Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, "Error al asignar codigo de carrera", ex);
         //   }
            cdb.cerrarConexion();
            p.setNombre(jtnombre);
       // cdb.resultado=cdb.un_st.executeQuery(cdb.un_sql);
     

        
}
    
    /**
     *
     * @return
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws java.sql.SQLException
     */
    public Persona leer() throws java.lang.ClassNotFoundException, 
                         java.lang.InstantiationException,
                         java.lang.IllegalAccessException, 
                         java.sql.SQLException,
                         error
    {
       conexion cdb=unicaconexion.getInstancia().getConexionDb();
     //  cdb.un_sql="SELECT * FROM persona WHERE rut='"+p.getRut()+"'";
     //  cdb.resultado=cdb.un_st.executeQuery(cdb.un_sql);
       
     //  if(cdb.resultado!=null){
       //    if(cdb.resultado.next()){
         //      p.setNombre(cdb.resultado.getString("nombre"));
           //    p.setFono(cdb.resultado.getString("fono"));
             //  p.setEdad(cdb.resultado.getInt("edad"));
          // }
          // else {
             //  throw new error(-1,"Registro "+p.getRut()+"no encontrado en tabla persona. Ubicacion="+this.getClass().getName());
         //  }
        return null;
       }
     //   return p;
    
    
    public void borrar() throws java.lang.ClassNotFoundException, 
                         java.lang.InstantiationException,
                         java.lang.IllegalAccessException, 
                         java.sql.SQLException
    {
        conexion cdb=unicaconexion.getInstancia().getConexionDb();
        
      //  cdb.un_sql="DELETE FROM persona WHERE rut='"+p.getRut()+"'";
      //  cdb.un_st.executeUpdate(cdb.un_sql);
    }
    
    
}
