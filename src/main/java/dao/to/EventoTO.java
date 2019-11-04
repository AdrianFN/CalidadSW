/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.to;

/**
 *
 * @author USER
 */
public class EventoTO {
    private String idEvento;
    private String eventoDescripcion;
    private int eventoStatus;

    //Default constructor
    public EventoTO() {
    }
    
    //First constructor
    public EventoTO(String idEvento, String eventoDescripcion, int eventoStatus) {
        this.idEvento = idEvento;
        this.eventoDescripcion = eventoDescripcion;
        this.eventoStatus = eventoStatus;
    }

    //Second constrcutor
    public EventoTO(String idEvento, String eventoDescripcion) {
        this.idEvento = idEvento;
        this.eventoDescripcion = eventoDescripcion;
    }

    //Methods get and set.
    public String getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(String idEvento) {
        this.idEvento = idEvento;
    }

    public String getEventoDescripcion() {
        return eventoDescripcion;
    }

    public void setEventoDescripcion(String eventoDescripcion) {
        this.eventoDescripcion = eventoDescripcion;
    }

    public int getEventoStatus() {
        return eventoStatus;
    }

    public void setEventoStatus(int eventoStatus) {
        this.eventoStatus = eventoStatus;
    }
    
    
}
