/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.factory;

import dao.component.IEventoDAO;
import dao.component.IExpositorDAO;
import dao.component.IHorarioDAO;
import dao.component.ISalonAsignadoDAO;
import dao.component.ISalonDAO;
import dao.component.IUsuarioDAO;
import dao.impl.EventoDAOImpl;
import dao.impl.ExpositorDAOImpl;
import dao.impl.HorarioDAOImpl;
import dao.impl.SalonAsignadoDAOImpl;
import dao.impl.SalonDAOImpl;
import dao.impl.UsuarioDAOImpl;

/**
 *
 * @author USER
 */
public class DAOFactory {
    private static DAOFactory daoFac;
    
    static{
        daoFac = new DAOFactory();
    }
    
    public static DAOFactory getInstance(){
        return daoFac;
    }
  
    public IUsuarioDAO getUsuarioDAO(){
        return new UsuarioDAOImpl();
    }
    public IEventoDAO getEventoDAO(){
        return new EventoDAOImpl();
    }
    public ISalonDAO getSalonDAO(){
        return new SalonDAOImpl();
    }
    public IExpositorDAO getExpositorDAO(){
        return new ExpositorDAOImpl();
    }
    public IHorarioDAO getHorarioDAO(){
        return new HorarioDAOImpl();
    }
    public ISalonAsignadoDAO getSalonAsignadoDAO(){
        return new SalonAsignadoDAOImpl();
    }
}
