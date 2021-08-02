package com.company.day1;

import com.company.day1.chips.Chips;
import com.company.day1.chips.Doritos;
import com.company.day1.chips.Lays;
import com.company.day1.chips.Zuzu;
import com.company.day1.chocolade.AlpineGould;
import com.company.day1.chocolade.Chocolate;
import com.company.day1.chocolade.Mercy;
import com.company.day1.chocolade.Snickers;
import com.company.day1.drink.Cola;
import com.company.day1.drink.Drink;
import com.company.day1.drink.Fan;
import com.company.day1.drink.Sprite;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WendingMachine implements Serializable {

    public final HashMap<String, List<Queue<Product>>> hashMap = new HashMap<>();
    final List<Queue<Product>> drinkList = new LinkedList<>();
    final List<Queue<Product>> chipList = new LinkedList<>();
    final List<Queue<Product>> chocolate = new LinkedList<>();

    private List<Queue<Product>> addDrinkList() {
        Queue<Product> queueCola = new LinkedList<>();
        Queue<Product> queueFan = new LinkedList<>();
        Queue<Product> queueSprite = new LinkedList<>();
        for (int i = 0; i < 20; i++) {
            queueCola.add(new Cola("Cola"));
            queueFan.add(new Fan("Fanta"));
            queueSprite.add(new Sprite("sprite"));
        }
        drinkList.add(queueCola);
        drinkList.add(queueFan);
        drinkList.add(queueSprite);
        return drinkList;
    }

    private List<Queue<Product>> addChipsList() {
        Queue<Product> queueDoritos = new LinkedList<>();
        Queue<Product> queueLays = new LinkedList<>();
        Queue<Product> queueZuzu = new LinkedList<>();
        for (int i = 0; i < 20; i++) {
            queueDoritos.add(new Doritos("Doritos"));
            queueLays.add(new Lays("Lays"));
            queueZuzu.add(new Zuzu("Zuzu"));
        }
        chipList.add(queueDoritos);
        chipList.add(queueLays);
        chipList.add(queueZuzu);
        return chipList;
    }

    private List<Queue<Product>> addChocolate() {
        Queue<Product> queueAlpineGould = new LinkedList<>();
        Queue<Product> queueMercy = new LinkedList<>();
        Queue<Product> queueSnickers = new LinkedList<>();
        for (int i = 0; i < 20; i++) {
            queueAlpineGould.add(new AlpineGould("AlpineGould"));
            queueMercy.add(new Mercy("Marcy"));
            queueSnickers.add(new Snickers("Snickers"));
        }
        chocolate.add(queueAlpineGould);
        chocolate.add(queueMercy);
        chocolate.add(queueSnickers);
        return chocolate;
    }

    private void addHashMap() {
        hashMap.put("A", addDrinkList());
        hashMap.put("B", addChipsList());
        hashMap.put("C", addChocolate());
    }

    public void returnProd(Command command) {
        addHashMap();
        command.splint();
        if (command.getProductType().equals("A")) {
            List<Queue<Product>> list = hashMap.get(command.getProductType());
            Queue<Product> queue = list.get(command.getColl());
            for (int i = 0; i < command.getQuantity(); i++) {
                System.out.println(queue.poll());
            }
            System.out.println(queue.size());
            System.out.println(hashMap);
        } else if (command.getProductType().equals("B")) {
            List<Queue<Product>> list = hashMap.get(command.getProductType());
            Queue<Product> queue = list.get(command.getColl());
            for (int i = 0; i < command.getQuantity(); i++) {
                System.out.println("Product " + queue.poll());
            }
            System.out.println(queue.size());
            System.out.println(hashMap);
        } else if (command.getProductType().equals("C")) {
            List<Queue<Product>> list = hashMap.get(command.getProductType());
            Queue<Product> queue = list.get(command.getColl());
            for (int i = 0; i < command.getQuantity(); i++) {
                System.out.println("Product " + queue.poll());
            }
            System.out.println(queue.size());
            System.out.println(hashMap);
        }
    }
}
