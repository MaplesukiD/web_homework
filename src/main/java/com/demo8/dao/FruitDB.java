package com.demo5.dao;

import com.demo5.entity.Fruit;

import java.util.ArrayList;
import java.util.List;

public class FruitDB {
    private static List<Fruit> fruitList=new ArrayList<>();
    static{
        fruitList.add(new Fruit(1,"苹果",1.5f,10,"很红的青苹果"));
        fruitList.add(new Fruit(2,"香蕉",1.6f,10,"绿色的熟香蕉"));
        fruitList.add(new Fruit(3,"菠萝",1.7f,10,"不叫凤梨的菠萝"));
        fruitList.add(new Fruit(4,"水蜜桃",1.8f,10,"需要补水"));
        fruitList.add(new Fruit(5,"草莓",1.9f,10,"士多啤梨"));
        fruitList.add(new Fruit(6,"山竹",2.0f,10,"很大的台风"));
    }
    public static List<Fruit> getFruitList(){
        return fruitList;
    }

    public static void setFruitList(List<Fruit> fruitList){
        FruitDB.fruitList = fruitList;
    }

    public static Fruit getById(Integer id){
        for(Fruit fruit:fruitList){
            if(fruit.getId().equals(id)){
                return fruit;
            }
        }
        return null;
    }

    public static List<Fruit> getAll(){
        return fruitList;
    }

    public static List<Fruit>getAll(String keyword){
        List<Fruit> list=new ArrayList<>();
        fruitList.forEach(item->{
            if(item.getName().contains(keyword)){
                list.add(item);
            }
        });
        return list;
    }

    public static void update(Fruit fruit){
        fruitList.forEach(item->{
            if(item.getId().equals(fruit.getId())){
                item.setName(fruit.getName());
                item.setCount(fruit.getCount());
                item.setPrice(fruit.getPrice());
                item.setRemark(fruit.getRemark());
            }
        });
    }

    public static void delete(Integer id){
        try{
            fruitList.forEach(item->{
                if(item.getId().equals(id)){
                    fruitList.remove(item);
                }
            });
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public static int getNum(){
        return fruitList.size();
    }
}
