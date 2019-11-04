/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.component.ISalonDAO;
import dao.ds.AccesoDB;
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
public class SalonDAOImpl implements ISalonDAO {
    private AccesoDB db;
    
    public SalonDAOImpl(){
        db = new AccesoDB();}
    
    @Override
    public ArrayList<Integer> filtrarTipoSalon(String salon) {
        //validar por front gaaaaaaaaaa
    
    String rpta=null;
    ArrayList<Integer> listaInt = new ArrayList<Integer>();
    Connection cn = db.getConnection();
    String procedimientoalmacenado= "{CALL sp_filtrarTipoSalon(?)}";
    if(cn!=null){
        try{
            CallableStatement cs = cn.prepareCall(procedimientoalmacenado);              
            cs.setString(1, salon);            
            ResultSet rs= cs.executeQuery();
            while (rs.next()){                
            int idsalon = rs.getInt(1);                      
            listaInt.add(idsalon);
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
    return listaInt;         
    }
               
}
