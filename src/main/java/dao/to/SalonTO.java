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
public class SalonTO {
    private int idSalon;
    private String salonTipo;
    private int salonAforo;

    public SalonTO() {
    }

    
    public int getIdSalon() {
        return idSalon;
    }

    public void setIdSalon(int idSalon) {
        this.idSalon = idSalon;
    }

    public String getSalonTipo() {
        return salonTipo;
    }

    public void setSalonTipo(String salonTipo) {
        this.salonTipo = salonTipo;
    }

    public int getSalonAforo() {
        return salonAforo;
    }

    public void setSalonAforo(int salonAforo) {
        this.salonAforo = salonAforo;
    }
    
    
}
