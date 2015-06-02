/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qwop.mb;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import qwop.EJB.LoginSB;
import qwop.entity.LoginEntity;

/**
 *
 * @author Rufat
 */
@ManagedBean(name="loginMBB")
@RequestScoped
public class LoginMB {

    @EJB
    private LoginSB loginsb;
    @ManagedProperty(value="#{profMB}")
    private ProfileMB profMB;
    private String login;
    private String password;
    private LoginEntity log = new LoginEntity();

    public ProfileMB getProfMB() {
        return profMB;
    }

    public void setProfMB(ProfileMB profMB) {
        this.profMB = profMB;
    }
    

    public LoginEntity getLog() {
        return log;
    }

    public void setLog(LoginEntity log) {
        this.log = log;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void loginb() {
        log.setPriv(2);
        loginsb.login(log);
    }
    public String logina() {
        LoginEntity rubbishlad=loginsb.logining(login, password);
        if(rubbishlad!=null){
            profMB.setUser(rubbishlad);
            if(profMB.getUser().getPriv()==1){
                return "admin?faces-redirect=true";
            }
            else if(profMB.getUser().getPriv()==2){
                return "rubbish?faces-redirect=true";
            }
            
        }
        return null;
    }
    
}
 