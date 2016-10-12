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
import javax.persistence.Query;
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
        TypedQuery<Users> q = null;

        // setParameterが何故かうまく動かなかったので、SQL文を直接書くことにする
        String sql = "select c from Users c where c." + field_users + " ";

        if (operator_users.equals("include")) {
            if (field_users.equals("id")) {
                sql += "= " + search_users;
            } else {
                sql += "like '%" + search_users + "%'";
            }
        } else if (operator_users.equals("andover")) {
            sql += ">= " + search_users;
        } else if (operator_users.equals("andless")) {
            sql += "<= " + search_users;
        }

        System.out.println("sql文=" + sql);

        q = em.createQuery(sql, Users.class);
        return q.getResultList();

    }

    public List<Users> getAllUsers() {
        Query q = em.createQuery("select c from Users c");
        List<Users> ls = q.getResultList();
        return ls;
    }
}
