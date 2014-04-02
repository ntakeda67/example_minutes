package org.example;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.example.minutes.JacksonConfig;
import org.example.minutes.facade.MeetingFacade;
import org.example.minutes.facade.MeetingTypeFacade;
import org.example.minutes.facade.MemberFacade;
import org.example.minutes.facade.system.LoginFacade;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@ApplicationPath("/rest")
public class RestApplication extends Application {

    @Override
    public Set<Object> getSingletons() {
        HashSet<Object> singletons = new HashSet<Object>();
        singletons.add(new JacksonJsonProvider());
        return singletons;
        
    }

	
  @Override
  public Set<Class<?>> getClasses() {
    Set<Class<?>> s = new HashSet<Class<?>>();
    // FIXME
    s.add(MemberFacade.class);
    s.add(LoginFacade.class);
    s.add(MeetingFacade.class);
    s.add(MeetingTypeFacade.class);
    s.add(JacksonJsonProvider.class);
    s.add(JacksonConfig.class);
    return s;
  }	
}
