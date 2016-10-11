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

    public List<Users> getFromDb(String field_users, String search_users, String operator_users) {
        TypedQuery<Users> query = null;
        if (operator_users.equals("like")) {
             query = em.createNamedQuery("select c from Users c where c.kind=:valueOfKind",Users.class);
        } else {

        }
        query.setParameter("valueOfKind", search_users);
        
        return query.getResultList();

    }
}