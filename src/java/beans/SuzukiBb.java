/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author melli
 */
@Named
@SessionScoped
public class SuzukiBb implements Serializable{
    
    public String goRegister(){
        return "db/register.xhtml";
    }
    
}
