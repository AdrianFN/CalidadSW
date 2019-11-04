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
public class UsuarioTO {
    private String idUsuario;
    private String usuarioPassword;
    private String usuarioNombre;
    private String usuarioApellidos;
    private String usuarioTelefono;
    private String usuarioTipo;

    public UsuarioTO() {
        
    }

    public UsuarioTO(String idUsuario, String usuarioPassword, String usuarioNombre, String usuarioApellidos, String usuarioTelefono) {
        this.idUsuario = idUsuario;
        this.usuarioPassword = usuarioPassword;
        this.usuarioNombre = usuarioNombre;
        this.usuarioApellidos = usuarioApellidos;
        this.usuarioTelefono = usuarioTelefono;
    }

    
    
    
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuarioPassword() {
        return usuarioPassword;
    }

    public void setUsuarioPassword(String usuarioPassword) {
        this.usuarioPassword = usuarioPassword;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public String getUsuarioApellidos() {
        return usuarioApellidos;
    }

    public void setUsuarioApellidos(String usuarioApellidos) {
        this.usuarioApellidos = usuarioApellidos;
    }

    public String getUsuarioTelefono() {
        return usuarioTelefono;
    }

    public void setUsuarioTelefono(String usuarioTelefono) {
        this.usuarioTelefono = usuarioTelefono;
    }

    public String getUsuarioTipo() {
        return usuarioTipo;
    }

    public void setUsuarioTipo(String usuarioTipo) {
        this.usuarioTipo = usuarioTipo;
    }
   
    
}
