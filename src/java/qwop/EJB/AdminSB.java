/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qwop.EJB;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import qwop.entity.BetsEntity;
import qwop.entity.Games;

/**
 *
 * @author Rufat
 */
@LocalBean
@Stateless
public class AdminSB {
    
    @PersistenceContext
    private EntityManager em;
    public void creategame (Games game){
        try {
            em.persist(game);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public List<Games> getGames(){
        List<Games> game=null;
        try {
            game= (List<Games>) em.createQuery("select g from Games g ORDER BY g.id").getResultList();
        } catch (Exception e) {
        }
        
        return game;
    }
    public void makeBet(BetsEntity bet){
        em.persist(bet);
    }
    
}
