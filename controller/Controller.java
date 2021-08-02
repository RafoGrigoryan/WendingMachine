package com.company.day1.controller;

import com.company.day1.Command;
import com.company.day1.Product;
import com.company.day1.WendingMachine;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Stream;

public class Controller {
    public static void start() {
        File file = new File("fileWend.txt");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        Command comm = new Command(input);
        WendingMachine wendingMachine = null;
        if (!file.exists() || file.length() == 0) {
            try {
                file.createNewFile();
                wendingMachine = new WendingMachine();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
                wendingMachine = (WendingMachine) objectInputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        wendingMachine.returnProd(comm);
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(wendingMachine);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (List<Queue<Product>> queueList :wendingMachine.hashMap.values()) {
            for (Queue<Product> productQueue: queueList){
                if(productQueue.size() < 3){
                   try {
                       Files.deleteIfExists(Paths.get("fileWend.txt"));
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
                }
            }
        }
    }
}
