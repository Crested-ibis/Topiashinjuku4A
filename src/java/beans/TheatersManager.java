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
import entity.Theaters;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author melli
 */
@Stateless
public class TheatersManager {

    @PersistenceContext
    EntityManager em;

    public List<Theaters> getFromDb(String field, String search, String operator) {
        TypedQuery<Theaters> q = null;

        String sql = "select c from Theaters c where c." + field + " ";

        if (operator.equals("include")) {
            if (field.equals("id")) {
                sql += "= " + search;
            } else {
                sql += "like '%" + search + "%'";
            }
        } else if (operator.equals("andover")) {
            sql += ">= " + search;
        } else {
            sql += "<=" + search;
        }

        System.out.println("sql文=" + sql);

        q = em.createQuery(sql, Theaters.class);
        return q.getResultList();
    }

    public List<Theaters> getAllTheaters() {
        Query q = em.createQuery("select c from Theaters c");
        return q.getResultList();
    }

}
