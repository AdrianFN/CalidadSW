/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.component;

import dao.to.HorarioTO;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public interface IHorarioDAO {
    public abstract ArrayList<HorarioTO> filtrarHorarioAsignado( int salon, Date dia);
}
