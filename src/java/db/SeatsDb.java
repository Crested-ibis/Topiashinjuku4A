/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import javax.ejb.Stateless;
import util.TryCatchDb;
import entity.Seats;

/**
 *
 * @author melli
 */
@Stateless
public class SeatsDb extends TryCatchDb{
    
    public SeatsDb() {
        super(Seats.class);
    }
}
