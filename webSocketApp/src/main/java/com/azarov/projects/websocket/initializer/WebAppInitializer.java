package com.azarov.projects.websocket.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRegistration.Dynamic;

import org.apache.jasper.servlet.JspServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import com.azarov.projects.websocket.configure.AppWebConfig;

/**
 * Created by AzarovD on 23.08.2016.
 */

public class WebAppInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(AppWebConfig.class);
        ctx.setServletContext(servletContext);

//        addStaticHtmlFilesHandlingServlet(servletContext);
        addDispatcherServlet(servletContext, ctx);
    }

    private void addDispatcherServlet(ServletContext servletContext, AnnotationConfigWebApplicationContext ctx) {
        Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
        dynamic.addMapping("/");
        dynamic.setLoadOnStartup(2);
        dynamic.setAsyncSupported(true);
    }

    private void addStaticHtmlFilesHandlingServlet(ServletContext servletContext) {
        ServletRegistration.Dynamic servlet = servletContext.addServlet("HtmlsServlet", new JspServlet());
        servlet.setLoadOnStartup(1);
        servlet.addMapping("*.html");
    }
} 