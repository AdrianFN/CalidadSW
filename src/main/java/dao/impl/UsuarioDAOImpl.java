/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.component.IUsuarioDAO;
import dao.ds.AccesoDB;
import dao.to.SalonAsignadoTO;
import dao.to.UsuarioTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class UsuarioDAOImpl implements IUsuarioDAO{
    private AccesoDB db;
    
    public UsuarioDAOImpl(){
        db = new AccesoDB();}
    
    @Override
    public boolean crearUsuario(UsuarioTO usuario) {
        int respuesta = 0;
        String rpta = null;
        Connection cn = db.getConnection();
        String procedimientoalmacenado= "{CALL sp_crearUsuario(?,?,?,?,?)}";
        if(cn!=null){
            try{
                CallableStatement cs = cn.prepareCall(procedimientoalmacenado);
                cs.setString(1, usuario.getIdUsuario());
                cs.setString(2, usuario.getUsuarioPassword());
                cs.setString(3, usuario.getUsuarioNombre());     
                cs.setString(4, usuario.getUsuarioApellidos());
                cs.setString(5, usuario.getUsuarioTelefono());

                ResultSet rs= cs.executeQuery();
                while (rs.next()){
                   respuesta = rs.getInt(1); //recibir respuesta 0 se logro, 1 no
                }
            }catch(SQLException ex){
                rpta = ex.getMessage();
            }finally{
                try{
                    cn.close();
                }catch (SQLException e){
                    rpta = e.getMessage();
                }
            }
        }
        if(respuesta == 0){
            return true;
        }else{
            return false;
        } 
    }

    @Override
    public boolean buscarUsurioPorDNI(String dni) {
      String rpta = null;
      int respuesta = 0;
    
    Connection cn = db.getConnection();
    String procedimientoalmacenado= "{CALL sp_buscarUsuario(?)}";
    if(cn!=null){
        try{
            CallableStatement cs = cn.prepareCall(procedimientoalmacenado);            
            cs.setString(1, dni);
            ResultSet rs= cs.executeQuery();
            while (rs.next()){                
                respuesta = rs.getInt(1);          
            }
        }catch(SQLException ex){
            rpta = ex.getMessage();
        }finally{
            try{
                cn.close();
            }catch (SQLException e){
                rpta = e.getMessage();
            }
        }
    }
    if(respuesta == 0){
        return true;
    }else{
        return false;
    }     
    }

    @Override
    public String ingresarSistemaUsuario(String dni, String password) {
        int respuesta = 0;
        String rpta = null;
        String tipoUsuario = "";
        Connection cn = db.getConnection();
        String procedimientoalmacenado= "{CALL sp_ingresarSistemaUsuario(?,?)}";
        if(cn!=null){
            try{
                CallableStatement cs = cn.prepareCall(procedimientoalmacenado);            
                cs.setString(1, dni);
                cs.setString(2, password);
                ResultSet rs = cs.executeQuery();
                while (rs.next()){                
                    respuesta = rs.getInt(1); 
                    tipoUsuario = rs.getString(2);
                }
            }catch(SQLException ex){
                rpta = ex.getMessage();
            }finally{
                try{
                    cn.close();
                }catch (SQLException e){
                    rpta = e.getMessage();
                }
            }
        }
        if(respuesta == 0){
            return tipoUsuario;
        }else{
            return tipoUsuario;
        }      
    }
    
    /*@Override
    public String obtenerUltimoUsuario(String id){
        String rpta = "";
        String ultimoId = "";
        Connection cn = db.getConnection();
        if(cn != null){
            try{
                CallableStatement cs = cn.prepareCall("select idUsuario from usuario order by idUsuario asc;");
                ResultSet rs = cs.executeQuery();
                while(rs.next()){
                    ultimoId = rs.getString(id);
                }
            }catch(SQLException ex){
                rpta = ex.getMessage();
            }finally{
                try{
                    cn.close();
                }catch (SQLException e){
                    rpta = e.getMessage();
                }
            }    
        }
        return ultimoId;
    }*/
}
