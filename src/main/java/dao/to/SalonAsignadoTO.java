/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.to;

import java.sql.Date;

/**
 *
 * @author USER
 */
public class SalonAsignadoTO {
    private int idSalon;
    private int idHorario;
    private Date idSalonAsignadoDia; 
    private String idExpositor;
    private String idEvento;
    private int salonAsignadoAsistenciaExpositor;
    private int salonAsignnadoEstado;

    public SalonAsignadoTO(int idSalon, int idHorario, Date idSalonAsignadoDia, String idExpositor, String idEvento) {
        this.idSalon = idSalon;
        this.idHorario = idHorario;
        this.idSalonAsignadoDia = idSalonAsignadoDia;
        this.idExpositor = idExpositor;
        this.idEvento = idEvento;
        this.salonAsignadoAsistenciaExpositor = 0;
        this.salonAsignnadoEstado = 0;
    }

    public SalonAsignadoTO(int idSalon, int idHorario, Date idSalonAsignadoDia, String idExpositor, String idEvento, int salonAsignadoAsistenciaExpositor, int salonAsignnadoEstado) {
        this.idSalon = idSalon;
        this.idHorario = idHorario;
        this.idSalonAsignadoDia = idSalonAsignadoDia;
        this.idExpositor = idExpositor;
        this.idEvento = idEvento;
        this.salonAsignadoAsistenciaExpositor = salonAsignadoAsistenciaExpositor;
        this.salonAsignnadoEstado = salonAsignnadoEstado;
    }
    
    public SalonAsignadoTO() {
    }

    public int getIdSalon() {
        return idSalon;
    }

    public void setIdSalon(int idSalon) {
        this.idSalon = idSalon;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public Date getIdSalonAsignadoDia() {
        return idSalonAsignadoDia;
    }

    public void setIdSalonAsignadoDia(Date idSalonAsignadoDia) {
        this.idSalonAsignadoDia = idSalonAsignadoDia;
    }

    public String getIdExpositor() {
        return idExpositor;
    }

    public void setIdExpositor(String idExpositor) {
        this.idExpositor = idExpositor;
    }

    public String getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(String idEvento) {
        this.idEvento = idEvento;
    }

    public int getSalonAsignadoAsistenciaExpositor() {
        return salonAsignadoAsistenciaExpositor;
    }

    public void setSalonAsignadoAsistenciaExpositor(int salonAsignadoAsistenciaExpositor) {
        this.salonAsignadoAsistenciaExpositor = salonAsignadoAsistenciaExpositor;
    }

    public int getSalonAsignnadoEstado() {
        return salonAsignnadoEstado;
    }

    public void setSalonAsignnadoEstado(int salonAsignnadoEstado) {
        this.salonAsignnadoEstado = salonAsignnadoEstado;
    }
    
    
}
