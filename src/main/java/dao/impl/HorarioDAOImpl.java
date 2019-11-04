/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.component.IHorarioDAO;
import dao.ds.AccesoDB;
import dao.to.HorarioTO;
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
public class HorarioDAOImpl implements IHorarioDAO {
    private AccesoDB db;
    
    public HorarioDAOImpl(){
        db = new AccesoDB();}
    
    @Override
    public ArrayList<HorarioTO> filtrarHorarioAsignado(int salon, Date dia) {
    String rpta = null;
    ArrayList<HorarioTO> lista = new ArrayList<HorarioTO>();
    Connection cn = db.getConnection();
    String procedimientoalmacenado= "{CALL sp_filtrarHorarioAsignado(?,?)}";
    if(cn!=null){
        try{
            CallableStatement cs = cn.prepareCall(procedimientoalmacenado);              
            cs.setInt(1, salon);
            cs.setDate(2, dia);           
            ResultSet rs= cs.executeQuery();
            while (rs.next()){                
            int idHorario = rs.getInt(1);                      
            String horarioHoraInicio = rs.getString(2);
            String horarioHoraFin = rs.getString(3);            
            HorarioTO  salonTO = new HorarioTO(idHorario, horarioHoraInicio, horarioHoraFin);
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
    
}
