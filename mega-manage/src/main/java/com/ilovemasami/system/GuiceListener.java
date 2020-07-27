package com.ilovemasami.system;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.google.inject.struts2.Struts2GuicePluginModule;
import com.ilovemasami.service.StudentService;
import com.ilovemasami.service.UserService;
import com.ilovemasami.service.impl.StudentServiceImpl;
import com.ilovemasami.service.impl.UserServiceImpl;
import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

/**
 * @author yuzhezhu
 * @date 2020/07/27
 **/
public class GuiceListener extends GuiceServletContextListener {

  @Override
  public Injector getInjector() {
    return Guice.createInjector(
        new Struts2GuicePluginModule(),
        new ServletModule() {
          @Override
          protected void configureServlets() {
            // Struts 2 setup
            bind(StrutsPrepareAndExecuteFilter.class).in(Singleton.class);
            filter("/*").through(StrutsPrepareAndExecuteFilter.class);

            // Our app-specific code
            bind(UserService.class).to(UserServiceImpl.class);
            bind(StudentService.class).to(StudentServiceImpl.class);
          }
        });
  }
}
