/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qwop.mb;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.context.RequestContext;
import qwop.EJB.AdminSB;
import qwop.EJB.LoginSB;
import qwop.entity.BetsEntity;
import qwop.entity.Games;
import qwop.entity.LoginEntity;

/**
 *
 * @author Rufat
 */
@ManagedBean(name="profMB")
@SessionScoped
public class ProfileMB {
    @EJB
    private LoginSB logos;
    @EJB
    private AdminSB adminos;
    private LoginEntity User;
    private Games game= new Games();
    private BetsEntity bet=new BetsEntity();

    public BetsEntity getBet() {
        return bet;
    }

    public void setBet(BetsEntity bet) {
        this.bet = bet;
    }
    

    public LoginSB getLogos() {
        return logos;
    }

    public void setLogos(LoginSB logos) {
        this.logos = logos;
    }

    public Games getGame() {
        return game;
    }

    public void setGame(Games game) {
        this.game = game;
    }

    public LoginEntity getUser() {
        return User;
    }

    public void setUser(LoginEntity User) {
        this.User = User;
    }
    public void createGame(){
        
        game.setAd_id(User.getId());
        adminos.creategame(game);
        int h=User.getMoney()-game.getJackpot();
        User.setMoney(h);
        logos.editUser(User);
        game=new Games();
    }
    public void makeBet(){
        bet.setGame_id(game.getId());
        bet.setUser_id(User.getId());
        adminos.makeBet(bet);
        int hu=User.getMoney()-bet.getCashin();
        User.setMoney(hu);
        logos.editUser(User);
        bet=new BetsEntity();
        
    }
    public List<Games> getGamesden() {
        List<Games> gamer = adminos.getGames();
        return gamer;
    }
    
   
}
