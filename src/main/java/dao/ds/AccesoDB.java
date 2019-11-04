/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.ds;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class AccesoDB {
    
    
public Connection getConnection(){
        Connection cn = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            cn= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/gestordeeventos",
                    "root","root");
            
        }catch(SQLException e){
        }catch(Exception e){                      
        }
        
        return cn;
        
    }
    
    public AccesoDB(){
        
    }
    
    
     
}