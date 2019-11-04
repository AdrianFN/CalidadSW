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
public class ExpositorTO {
    private String idExpositor;
    private String expositorNombre;

    public ExpositorTO(String idExpositor, String expositorNombre) {
        this.idExpositor = idExpositor;
        this.expositorNombre = expositorNombre;
    }

    public ExpositorTO() {
    }

    public String getIdExpositor() {
        return idExpositor;
    }

    public void setIdExpositor(String idExpositor) {
        this.idExpositor = idExpositor;
    }

    public String getExpositorNombre() {
        return expositorNombre;
    }

    public void setExpositorNombre(String expositorNombre) {
        this.expositorNombre = expositorNombre;
    }
    
}
