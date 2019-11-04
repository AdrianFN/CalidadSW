/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.component.ISalonAsignadoDAO;
import dao.ds.AccesoDB;
import dao.to.SalonAsignadoTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author USER
 */
public class SalonAsignadoDAOImpl implements ISalonAsignadoDAO {
    
    private AccesoDB db;
    
    public SalonAsignadoDAOImpl(){
        db = new AccesoDB();}
    
    @Override
    public boolean crearSalonAsignado(SalonAsignadoTO salon) {
    int respuesta = 0;
    String rpta = null;
    Connection cn = db.getConnection();
    String procedimientoalmacenado= "{CALL sp_crearSalonAsignado(?,?,?,?,?)}";
    if(cn!=null){
        try{
            CallableStatement cs = cn.prepareCall(procedimientoalmacenado);
            cs.setInt(1, salon.getIdSalon());
            cs.setInt(2, salon.getIdHorario());
            cs.setDate(3, salon.getIdSalonAsignadoDia());           
            cs.setString(4, salon.getIdExpositor());
            cs.setString(5, salon.getIdEvento());
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
    public ArrayList<SalonAsignadoTO> listarSalonAsignado(String idEvento) {
          String rpta = null;
    ArrayList<SalonAsignadoTO> lista = new ArrayList<SalonAsignadoTO>();
    Connection cn = db.getConnection();
    String procedimientoalmacenado= "{CALL sp_listarSalonesAsignadosPorEvento(?,?,?,?,?)}";
    if(cn!=null){
        try{
            CallableStatement cs = cn.prepareCall(procedimientoalmacenado);            
            cs.setString(1, idEvento);
            ResultSet rs= cs.executeQuery();
            while (rs.next()){                
            int idsalon = rs.getInt(1);
            int idhorario = rs.getInt(2);
            Date salonAsignadoDia = rs.getDate(3);
            String idexpositor = rs.getString(4);
            String idevento = rs.getString(5);
            SalonAsignadoTO  salonTO = new SalonAsignadoTO(idsalon, idhorario, salonAsignadoDia, idexpositor, idevento);
            lista.add(salonTO);
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

    @Override
    public boolean terminarSalonAsignado(SalonAsignadoTO salon, boolean asistencia) {
    int respuestaAsistencia;
    int respuesta= 0;
    if(asistencia){
        respuestaAsistencia = 0;
    }else{
        respuestaAsistencia =1;
    }
    String rpta2 = null;    
    Connection cn = db.getConnection();
    String procedimientoalmacenado= "{CALL sp_terminarSalonAsignado(?,?,?,?)}";
    if(cn!=null){
        try{
            CallableStatement cs = cn.prepareCall(procedimientoalmacenado);
            cs.setInt(1, salon.getIdSalon());
            cs.setInt(2, salon.getIdHorario());
            cs.setDate(3, salon.getIdSalonAsignadoDia());                                 
            cs.setInt(4, respuestaAsistencia);
            ResultSet rs= cs.executeQuery();
            while (rs.next()){
               respuesta = rs.getInt(1); //recibir respuesta 0 se logro, 1 no                
            }
        }catch(SQLException ex){
            rpta2 = ex.getMessage();
        }finally{
            try{
                cn.close();
            }catch (SQLException e){
                rpta2 = e.getMessage();
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
    public ArrayList<SalonAsignadoTO> reporteAsistenciaExpositor(String idEvento) {
    String rpta = null;
    ArrayList<SalonAsignadoTO> lista = new ArrayList<SalonAsignadoTO>();
    Connection cn = db.getConnection();
    String procedimientoalmacenado= "{CALL sp_reporteAsistenciaExpositorSalonAsignado(?)}";
    if(cn!=null){
        try{
            CallableStatement cs = cn.prepareCall(procedimientoalmacenado);              
            cs.setString(1, idEvento);            
            ResultSet rs= cs.executeQuery();
            while (rs.next()){                
            int idsalon = rs.getInt(1);
            int idhorario = rs.getInt(2);            
            Date salonAsignadoDia = rs.getDate(3);
            String idexpositor = rs.getString(4);
            String idevento = rs.getString(5);
            int salonAsignadoAsistenciaExpositor=rs.getInt(6);
            int salonAsignadoEstado= rs.getInt(7);
            SalonAsignadoTO  salonTO = new SalonAsignadoTO(idsalon, idhorario, salonAsignadoDia, idexpositor, idevento, salonAsignadoAsistenciaExpositor, salonAsignadoEstado);
            lista.add(salonTO);
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

    @Override
    public boolean registrarParticipante(String idUsuario, SalonAsignadoTO salon) {
     int respuesta = 0;
    String rpta = null;
    Connection cn = db.getConnection();
    String procedimientoalmacenado= "{CALL sp_registrarParticipante(?,?,?,?)}";
    if(cn!=null){
        try{
            CallableStatement cs = cn.prepareCall(procedimientoalmacenado);
            cs.setString(1, idUsuario);
            cs.setInt(2, salon.getIdSalon());
            cs.setInt(3, salon.getIdHorario());
            cs.setDate(4, salon.getIdSalonAsignadoDia());                      
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
    public int verAforo(SalonAsignadoTO idsalon) {
    String rpta = null;
    int respuesta = 0;
    
    Connection cn = db.getConnection();
    String procedimientoalmacenado= "{CALL sp_buscarUsuario(?,?,?)}";
    if(cn!=null){
        try{
            CallableStatement cs = cn.prepareCall(procedimientoalmacenado);            
            cs.setInt(1, idsalon.getIdSalon());
            cs.setInt(2, idsalon.getIdHorario());
            cs.setDate(3, idsalon.getIdSalonAsignadoDia());
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
    return respuesta;    
        }
    
    
}
