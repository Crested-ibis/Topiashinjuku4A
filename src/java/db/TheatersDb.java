/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import javax.ejb.Stateless;
import util.TryCatchDb;
import entity.Theaters;

/**
 *
 * @author melli
 */
@Stateless
public class TheatersDb extends TryCatchDb{

    public TheatersDb() {
        super(Theaters.class);
    }
}
