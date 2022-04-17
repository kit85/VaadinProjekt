package com.example.application.Security;

import com.example.application.views.ItemView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.VaadinServletRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

//håller koll på inlogniong och utlogningen
public class PrincipalUtils {
    public static String getName(){
        return SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
    }
    public static boolean isAuthenticated(){
        return  SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName()
                .equalsIgnoreCase("anoymoususer");
    }
    public static void logout(){
        new SecurityContextLogoutHandler()
                .logout(VaadinServletRequest.getCurrent()
                .getHttpServletRequest(),null,null);
        UI.getCurrent().navigate(ItemView.class);

    }
}
