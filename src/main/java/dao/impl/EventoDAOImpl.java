/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.component.IEventoDAO;
import dao.ds.AccesoDB;
import dao.to.EventoTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class EventoDAOImpl implements IEventoDAO {
    
    private AccesoDB db;
    
    public EventoDAOImpl(){
        db = new AccesoDB();}

    @Override
    public boolean crearEvento(EventoTO evento) {
     int respuesta = 0;
    String rpta = null;
    Connection cn = db.getConnection();
    String procedimientoalmacenado= "{CALL sp_crearEvento(?,?)}";
    if(cn!=null){
        try{
            CallableStatement cs = cn.prepareCall(procedimientoalmacenado);
            cs.setString(1, evento.getIdEvento());
            cs.setString(2, evento.getEventoDescripcion());           
            
            ResultSet rs= cs.executeQuery();
            while (rs.next()){
          //     respuesta = rs.getInt(1); //recibir respuesta 0 se logro, 1 no
                
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
    public ArrayList<EventoTO> listarEvento() {
     String rpta = null;
    ArrayList<EventoTO> lista = new ArrayList<EventoTO>();
    Connection cn = db.getConnection();
    String procedimientoalmacenado= "{CALL sp_listarEvento()}";
    if(cn!=null){
        try{
            CallableStatement cs = cn.prepareCall(procedimientoalmacenado);            
            ResultSet rs= cs.executeQuery();
            while (rs.next()){                
            String idevento = rs.getString(1);
            String eventoDescripcion = rs.getString(2);           
            EventoTO  salonTO = new EventoTO(idevento, eventoDescripcion);
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
    public ArrayList<EventoTO> historialEvento() {
        String rpta = null;
    ArrayList<EventoTO> lista = new ArrayList<EventoTO>();
    Connection cn = db.getConnection();
    String procedimientoalmacenado= "{CALL sp_listarEvento()}";
    if(cn!=null){
        try{
            CallableStatement cs = cn.prepareCall(procedimientoalmacenado);            
            ResultSet rs= cs.executeQuery();
            while (rs.next()){                
            String idevento = rs.getString(1);
            String eventoDescripcion = rs.getString(2);           
            EventoTO  salonTO = new EventoTO(idevento, eventoDescripcion);
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
    public boolean terminarEvento(EventoTO evento) {   
    int respuesta= 0;
    String rpta2 = null;    
    Connection cn = db.getConnection();
    String procedimientoalmacenado= "{CALL sp_terminarEvento(?)}";
    if(cn!=null){
        try{
            CallableStatement cs = cn.prepareCall(procedimientoalmacenado);
            cs.setString(1, evento.getIdEvento());           
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
 
}
