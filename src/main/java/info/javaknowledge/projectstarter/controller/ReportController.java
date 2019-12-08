/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.javaknowledge.projectstarter.controller;

import info.javaknowledge.projectstarter.dao.JasperReportDAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import info.javaknowledge.projectstarter.report.ReportInputForm;

/**
 *
 * @author User
 */
@Controller
public class ReportController {

    @RequestMapping(value = "/reportView", method = RequestMethod.GET)
    public String loadSurveyPg(
            @ModelAttribute("reportInputForm") ReportInputForm reportInputForm,
            Model model) {
        model.addAttribute("reportInputForm", reportInputForm);

        return "report";
    }
    @RequestMapping(value = "/reportView", method = RequestMethod.POST)
    public String generateReport(@ModelAttribute("reportInputForm") ReportInputForm reportInputForm,HttpServletRequest request,HttpServletResponse response) throws JRException, IOException, SQLException, NamingException {
        String reportFileName = "tspList";
        JasperReportDAO jrdao = new JasperReportDAO();

        Connection conn = null;

        try {
            conn = jrdao.getConnection();

            String title = reportInputForm.getTitle();

            HashMap<String, Object> hmParams = new HashMap<String, Object>();

            hmParams.put("title", title);

            JasperReport jasperReport = jrdao.getCompiledFile(reportFileName,
                    request);

//            if (rptFormat.equalsIgnoreCase("html")) {
//
//                JasperPrint jasperPrint = JasperFillManager.fillReport(
//                        jasperReport, hmParams, conn);
//                jrdao.generateReportHtml(jasperPrint, request, response); // For
//                // HTML
//                // report
//
//            } else if (rptFormat.equalsIgnoreCase("pdf")) {

                jrdao.generateReportPDF(response, hmParams, jasperReport, conn); // For
                // PDF
                // report

//            }

        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }

        return null;
    }
}
