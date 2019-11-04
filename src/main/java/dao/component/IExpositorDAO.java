/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.component;

import dao.to.ExpositorTO;

import java.util.ArrayList;

/**
 *
 * @author USER
 */
public interface IExpositorDAO {
    public abstract boolean crearExpositor(ExpositorTO expositor);
    public abstract ArrayList<ExpositorTO> listarExpositor();
    
}
