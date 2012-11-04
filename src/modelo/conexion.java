/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Milii2
 */

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class conexion {
    private Connection cnn;
    private Statement stm;
    private ResultSet rst;

    private String driver;
    private String nombreBase;
    private String nombreTabla;
    private String user;
    private String password;
    private String comandoSQL;
    private boolean esSelect;


    public conexion() {
        this.driver = "com.mysql.jdbc.Driver";
        this.nombreBase = "jdbc:mysql://localhost:3306/persona";
        this.nombreTabla = "persona";
        this.user = "root";
        this.password = "";
        this.comandoSQL = "";
        this.esSelect = false;
    }

    public Connection getCnn() {
        return cnn;
    }

    public void setCnn(Connection cnn) {
        this.cnn = cnn;
    }

    public Statement getStm() {
        return stm;
    }

    public void setStm(Statement stm) {
        this.stm = stm;
    }

    public ResultSet getRst() {
        return rst;
    }

    public void setRst(ResultSet rst) {
        this.rst = rst;
    }

        public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
    public String getNombreBase() {
        return nombreBase;
    }

    public void setNombreBase(String nombreBase) {
        this.nombreBase = nombreBase;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getComandoSQL() {
        return comandoSQL;
    }

    public void setComandoSQL(String comandoSQL) {
        this.comandoSQL = comandoSQL;
    }

    public boolean isEsSelect() {
        
        return esSelect;
    }

    public void setEsSelect(boolean esSelect) {
        this.esSelect =  esSelect;
        
    }

    public void cerrarConexion()
    {
        try {
            this.getCnn().close();
        } catch (SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Metodo Principal para Conectarse
    public void conectar()
    {
     
         try {
            //Cargar Driver
            Class.forName(this.getDriver());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        try {
            this.setCnn(DriverManager.getConnection(this.getNombreBase(),
                    this.getUser(),
                    this.getPassword()));
            this.setStm(this.getCnn().createStatement());
           // setEsSelect(stm.execute(getComandoSQL()));
        } catch (SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        //Verificar si es una QUERY o un UPDATE
      if(this.isEsSelect() == true)
        {
            try {
                //Ejecutar una QUERY
                
                this.setRst(this.getStm().executeQuery(this.getComandoSQL()));
            } catch (SQLException ex) {
                Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                                   
        else
        {
        try {
                //Ejecutar un UPDATE
                setEsSelect(this.getStm().execute(this.getComandoSQL()));
            } catch (SQLException ex) {
                Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
