package com.example.application.views;

import ch.qos.logback.core.BasicStatusManager;
import com.example.application.Entity.Item;
import com.example.application.LoginView.LoginView;
import com.example.application.Security.PrincipalUtils;
import com.example.application.service.ItemService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import org.springframework.security.core.context.SecurityContextHolder;


public class MainView extends AppLayout {



    public MainView(){

        HorizontalLayout navbar=new HorizontalLayout();
        H1 navbarList=new H1(" My Item List");
        navbar.add(new DrawerToggle(),navbarList);
        Button loginButton=new Button("Logout",e-> UI.getCurrent().navigate(LoginView.class));
        loginButton.addThemeVariants(ButtonVariant.LUMO_ICON);

        Button LogoutButton=new Button("Login",e->PrincipalUtils.logout());
        LogoutButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        navbar.add(PrincipalUtils.isAuthenticated()?loginButton:loginButton);



        navbar.setWidthFull();
        navbar.setMargin(true);
        navbar.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
        navbar.setAlignItems(FlexComponent.Alignment.CENTER);


        addToNavbar(navbar);

       //WRAPA IHOP 2 KLASSER TILL 1
        RouterLink itemViewLink=new RouterLink("View Product", ItemView.class);
        RouterLink handleLink=new RouterLink("handle Product",HandleView.class);
       //visas detta  framsida
        addToDrawer(new VerticalLayout(itemViewLink,handleLink));






    }


}
