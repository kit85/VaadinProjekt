package com.example.application.views;

import com.example.application.Entity.Item;
import com.example.application.Form.ItemForm;
import com.example.application.Security.PrincipalUtils;
import com.example.application.service.ItemService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.security.PermitAll;

@Route(value = "/HandleList", layout = MainView.class)
@PermitAll
public class HandleView extends VerticalLayout {
    @Autowired
    ItemService itemService;
    //för att få tillgång på min grid i mina metoder
    Grid<Item> grid = new Grid<>(Item.class, false);
    Button button=new Button();


    public HandleView(ItemService itemService) {
        this.itemService = itemService;
        setAlignItems(Alignment.CENTER);
        grid.setItems(itemService.findALLItem());
        ItemForm itemForm= new ItemForm(itemService, this);



        grid.addColumn(Item::getId).setHeader("id").setSortable(true);
        grid.addColumn(Item::getProduct).setHeader("Product").setSortable(true);
        grid.addColumn(Item::getBrand).setHeader("Brand").setSortable(true);
        grid.addColumn(Item::getAntal).setHeader("count").setSortable(true).setKey("antal");

        grid.asSingleSelect().addValueChangeListener(e->{
            itemForm.setItem(e.getValue());
            System.out.println("clicked");
        });


        //knyter item och grid
        HorizontalLayout wrapper=new HorizontalLayout(grid, itemForm);
        wrapper.setSizeFull();
        add(wrapper);

        Button button=new Button("Add", e->{
            itemForm.setItem(new Item());
        });
        add(button);

        deleteItem();
        saveIncrease();
        saveDecrease();


    }

    private Button saveDecrease() {
        grid.addComponentColumn(item->new Button(new Icon(VaadinIcon.MINUS),e->{

            item.setAntal(item.getAntal()-1);
            itemService.addItem(item);
            updateItem();
        }));
        return button;

    }


    private Button deleteItem() {
        grid.addComponentColumn(item->new Button(new Icon(VaadinIcon.CLOSE), e ->{
            itemService.delete(item.getId());
            updateItem();
        }));

        return button;
    }


    private Button saveIncrease(){
    grid.addComponentColumn(item -> new Button(new Icon(VaadinIcon.PLUS), e->{
        item.setAntal(item.getAntal()+1);
        itemService.addItem(item);
        updateItem();
    }));
        return button;
    }

    public void updateItem() {
        grid.setItems(itemService.findALLItem());
    }


}
