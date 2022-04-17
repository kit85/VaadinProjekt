package com.example.application.Form;


import com.example.application.Entity.Item;
import com.example.application.service.ItemService;
import com.example.application.views.HandleView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import org.springframework.beans.factory.annotation.Autowired;


public class ItemForm extends FormLayout {
    @Autowired
    ItemService itemService;
    TextField product=new TextField("Product");
    TextField brand=new TextField("Brand");
    Button saveButton=new Button("Save");
    Binder<Item> binder=new BeanValidationBinder<>(Item.class);
    HandleView handleView;

    public ItemForm(ItemService itemService, HandleView handleView){
        this.itemService=itemService;
        this.handleView=handleView;
        setVisible(false);

        //binder den här klassen produkt,brand osv
        binder.bindInstanceFields(this);

        saveButton.addClickListener(e->save());


        add(product,brand,saveButton);
    }
    //spara
    //hämta ut fältet
    public void save(){
        Item item=binder.validate().getBinder().getBean();
        if(item.getId()!=0){
            itemService.updateItem(item.getId(),item);
        }else{
            itemService.addItem(item);
        }
        setItem(null);
        handleView.updateItem();

        
    }
    public void setItem(Item item){
       if(item !=null){
           binder.setBean(item);
           setVisible(true);
       }else{
           setVisible(false);
       }
    }




}
