/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.component;

import dao.to.SalonAsignadoTO;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public interface ISalonAsignadoDAO {
    public abstract boolean crearSalonAsignado(SalonAsignadoTO salon);
    public abstract ArrayList<SalonAsignadoTO> listarSalonAsignado(String idEvento);
    public abstract boolean terminarSalonAsignado(SalonAsignadoTO salon, boolean asistencia);
    public abstract ArrayList<SalonAsignadoTO> reporteAsistenciaExpositor(String idEvento);
    public abstract boolean registrarParticipante(String idUsuario, SalonAsignadoTO salon);
    public abstract int verAforo(SalonAsignadoTO idsalon);
}
