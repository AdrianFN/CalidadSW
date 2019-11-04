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
public class HorarioTO {
    private int idHorario;
    private String horarioHoraInicio;
    private String horarioHoraFin;

    public HorarioTO() {
    }

    public HorarioTO(int idHorario, String horarioHoraInicio, String horarioHoraFin) {
        this.idHorario = idHorario;
        this.horarioHoraInicio = horarioHoraInicio;
        this.horarioHoraFin = horarioHoraFin;
    }

    
    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public String getHorarioHoraInicio() {
        return horarioHoraInicio;
    }

    public void setHorarioHoraInicio(String horarioHoraInicio) {
        this.horarioHoraInicio = horarioHoraInicio;
    }

    public String getHorarioHoraFin() {
        return horarioHoraFin;
    }

    public void setHorarioHoraFin(String horarioHoraFin) {
        this.horarioHoraFin = horarioHoraFin;
    }
    
    
}
