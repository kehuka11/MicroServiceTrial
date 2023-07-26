package net.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

  public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(Application.class, args);

    DispatcherServlet dispatcherServlet = (DispatcherServlet) context.getBean("dispatcherServlet");
    dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(Application.class);
  }
}
