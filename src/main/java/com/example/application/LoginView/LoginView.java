package com.example.application.LoginView;

import com.example.application.service.UserDetailsServiceImp;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("/login")
public class LoginView  extends VerticalLayout implements BeforeEnterObserver {
    @Autowired
    UserDetailsServiceImp userDetailsServiceImp;
    LoginForm loginForm=new LoginForm();

    public LoginView(UserDetailsServiceImp userDetailsServiceImp){
    addClassName("login-View");
    setSizeFull();

    setJustifyContentMode(JustifyContentMode.CENTER);
    setAlignItems(Alignment.CENTER);
    loginForm.setAction("login");
    add(new H1("Welcome"),loginForm);



    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if(beforeEnterEvent
                .getLocation()
                .getQueryParameters()
                .getParameters()
                .containsKey("error")){
            loginForm.setError(true);
        }

    }
    

}
