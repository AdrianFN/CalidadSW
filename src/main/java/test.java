
import dao.component.IEventoDAO;
import dao.factory.DAOFactory;
import dao.to.EventoTO;
import dao.to.UsuarioTO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adrián
 */
public class test {
    public static void main(String[] args) {
//        EventoTO usuarioReceptor = new EventoTO("Evento z" ,"Descripcion del evento z");
        IEventoDAO eventoDAO = DAOFactory.getInstance().getEventoDAO();
        EventoTO eventoReceptor = new EventoTO("Nuevo evento", "Nueva descripcion");

        boolean respuesta = eventoDAO.crearEvento(eventoReceptor);
        if(respuesta){
            System.out.println("Evento creado");
        }
        else{
            System.out.println("Evento no creado");
        }
        
        
    }
}
