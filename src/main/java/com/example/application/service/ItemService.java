package com.example.application.service;

import com.example.application.Entity.Item;
import com.example.application.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


//returnera till BlogPostRepository
@Service
public class ItemService {
    @Autowired
    ItemRepository shoppingListRepository;

    //visa upp alla item
    public List<Item> findALLItem(){
        return shoppingListRepository.findAll();
    }
    //hitta alla item via  id

    public Item findById(int id){
        return shoppingListRepository.findById(id).orElseThrow();
    }

    public int antal (){

        return (int) shoppingListRepository.count();
    }

    public void addCount(int id,int tal){
      Item item = shoppingListRepository.findById(id).orElseThrow();
      item.setAntal(tal);
      shoppingListRepository.save(item);
    }


    //Post till item
    public Item addItem(Item item){
        return shoppingListRepository.save(item);
    }


    // Delete
    public void delete(int id){
        shoppingListRepository.deleteById(id);
    }

    //put
    public Item updateItem(int id,Item changeItem){

        Item item=shoppingListRepository.findById(id).orElseThrow();

        if(changeItem.getProduct()!=null)
            item.setProduct(changeItem.getProduct());
        if(changeItem.getBrand()!=null)
            item.setBrand(changeItem.getBrand());
        shoppingListRepository.save(item);

      return item;
    }



}
