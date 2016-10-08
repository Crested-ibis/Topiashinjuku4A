/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import util.TryCatchDb;
import entity.Users;
import javax.ejb.Stateless;

/**
 *
 * @author melli
 */
@Stateless
public class UsersDb extends TryCatchDb{
    
    public UsersDb() {
        super(Users.class);
    }
    
    
}
