package com.example.application.views;

import com.example.application.Entity.Item;
import com.example.application.service.ItemService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "/Product", layout = MainView.class)
@AnonymousAllowed
public class ItemView extends VerticalLayout {

    ItemService itemService;

    public ItemView(ItemService itemService){
        this.itemService=itemService;
        setAlignItems(Alignment.CENTER);

        itemService.findALLItem().forEach(item->{
            Paragraph id=new Paragraph(String.valueOf(item.getId()));
            Paragraph items=new Paragraph(item.getProduct());
            Paragraph brand=new Paragraph(item.getBrand());
            Paragraph antal=new Paragraph(String.valueOf(item.getAntal()));


            add(id,items,brand,antal, new Hr());

        });
    }

}
