/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.component.IExpositorDAO;
import dao.ds.AccesoDB;
import dao.to.ExpositorTO;
import dao.to.SalonAsignadoTO;
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
public class ExpositorDAOImpl implements IExpositorDAO{
    private AccesoDB db;
    
    public ExpositorDAOImpl(){
        db = new AccesoDB();}
    
    @Override
    public boolean crearExpositor(ExpositorTO expositor) {
    int respuesta = 0;
    String rpta = null;
    Connection cn = db.getConnection();
    String procedimientoalmacenado= "{CALL sp_crearExpositor(?,?)}";
    if(cn!=null){
        try{
            CallableStatement cs = cn.prepareCall(procedimientoalmacenado);
            cs.setString(1, expositor.getIdExpositor());
            cs.setString(2, expositor.getExpositorNombre());
            
            
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
    public ArrayList<ExpositorTO> listarExpositor() {
     String rpta = null;
    ArrayList<ExpositorTO> lista = new ArrayList<ExpositorTO>();
    Connection cn = db.getConnection();
    String procedimientoalmacenado= "{CALL sp_listarExpositor()}";
    if(cn!=null){
        try{
            CallableStatement cs = cn.prepareCall(procedimientoalmacenado);                        
            ResultSet rs= cs.executeQuery();
            while (rs.next()){                
            String idExpositor = rs.getString(1);
            String expositorNombre = rs.getString(2);
            ExpositorTO expositorTO = new ExpositorTO(idExpositor, expositorNombre);           
            lista.add(expositorTO);
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
    return lista;    
    }
    
}
