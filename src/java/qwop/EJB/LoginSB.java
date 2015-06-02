/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qwop.EJB;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import qwop.entity.LoginEntity;

/**
 *
 * @author Rufat
 */
@LocalBean
@Stateless
public class LoginSB {
    @PersistenceContext
    private EntityManager rom;
    
    public void login (LoginEntity user){
        try {
            rom.persist(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public LoginEntity logining(String username, String password){
        LoginEntity rubbish=null;
         rubbish = (LoginEntity) rom.createQuery("select u from LoginEntity u where u.login=:username AND u.password=:password ").setParameter("username", username).setParameter("password",password).getSingleResult();  
        return rubbish;
        
    }
     public void editUser(LoginEntity user){
        rom.merge(user);
    }
}
