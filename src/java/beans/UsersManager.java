/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entity.Users;
import javax.persistence.TypedQuery;
/**
 *
 * @author melli
 */

@Stateless
public class UsersManager {
    @PersistenceContext
    EntityManager em;
    
    public List<Users> getFromDb (String field_users, String search_users, String operator_users){
        String sql = "select c from Users c where " + field_users + " = " + search_users
        
        TypedQuery<Users> query = null;
        
    }
}
