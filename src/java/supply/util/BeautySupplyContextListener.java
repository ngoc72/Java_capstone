/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package supply.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author Ngoc
 */
public class BeautySupplyContextListener implements ServletContextListener{
 @Override
  public void contextInitialized(ServletContextEvent event) {
        
        ServletContext sc = event.getServletContext();

        // get the absolute paths for swithing regular and secure connections
        String contextPath = sc.getContextPath();
        String absolutePath = "http://localhost:8084" + contextPath;
        String absolutePathSecure = "https://localhost:8443" + contextPath;
        sc.setAttribute("absolutePath", absolutePath);
        sc.setAttribute("absolutePathSecure", absolutePathSecure);
        // initialize the customer service email address that's used throughout the web site
        String custServEmail = sc.getInitParameter("custServEmail");
        sc.setAttribute("custServEmail", custServEmail);
        
        // initialize the current year that's used in the copyright notice
        GregorianCalendar currentDate = new GregorianCalendar();
        int currentYear = currentDate.get(Calendar.YEAR);
        sc.setAttribute("currentYear", currentYear);

       
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        // no cleanup necessary
    }
}
