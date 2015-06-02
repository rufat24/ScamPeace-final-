/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qwop.mb;

import java.io.IOException;
import java.util.HashMap;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author Rufat
 */
@ManagedBean
@RequestScoped
public class ReportMB {
    @ManagedProperty(value = "#{profMB}")
    private ProfileMB profmb;

    public ProfileMB getProfmb() {
        return profmb;
    }

    public void setProfmb(ProfileMB profmb) {
        this.profmb = profmb;
    }

    
    JasperPrint jasperPrint;

    public void gassPDF(ActionEvent actionEvent) throws JRException, IOException {
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(profmb.getGamesden());
        jasperPrint = JasperFillManager.fillReport(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reports/games.jasper"), new HashMap(), beanCollectionDataSource);
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=games.pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
        FacesContext.getCurrentInstance().responseComplete();
    }
}

    
