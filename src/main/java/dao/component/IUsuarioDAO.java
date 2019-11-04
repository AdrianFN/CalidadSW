/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.component;

import dao.to.UsuarioTO;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public interface IUsuarioDAO {
    public abstract boolean crearUsuario(UsuarioTO usuario);
    public abstract boolean buscarUsurioPorDNI(String dni);
    public abstract String ingresarSistemaUsuario(String dni, String password);
    /*public abstract ArrayList<UsuarioTO> listarUsuario();*/
    /*public abstract String obtenerUltimoUsuario(String id);*/
}
