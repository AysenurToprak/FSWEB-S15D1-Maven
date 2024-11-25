package org.example.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public void startGrocery() {
    int ch;
    do {
        System.out.println("İşlem seçiniz.0: Çıkış,1: Ekleme,2:Çıkış ");
        ch = scanner.nextInt();
        scanner.nextLine();
        switch (ch){
            case 1:
                System.out.println("Eklenecek elemanı giriniz");
                String itemAdded = scanner.nextLine();
                addItems(itemAdded);
                printSorted();
                break;
            case 2:
                System.out.println("Çıkarılacak elemanı giriniz");
                String itemRemoved = scanner.nextLine();
                removeItems(itemRemoved);
                printSorted();
                break;

        }
    }
    while (ch !=0);
        scanner.close();

    }

    public static void removeItems(String itemRemoved) {
        String [] splited = itemRemoved.split(",");
        for(String item : splited){
            item = item.trim();
            if (!groceryList.contains(item)){
                System.out.println("Girilen değer  listede bulunmuyor: " + item);
            }
            else {
                groceryList.remove(item);
            }
        }
    }

    public static void printSorted() {
        sortItems();
        System.out.println("Mevcut liste: ");
        for (String item: groceryList) {
            System.out.println(item);
        }
    }

    public static void addItems(String itemAdded) {
        String [] splited = itemAdded.split(",");
        for (String item : splited) {
            item = item.trim();
            if(checkItemIsInList(item)){
                System.out.println("Girilen değer listede bulunuyor: " + item);
            }
            else {
                groceryList.add(item);
            }
        }
        sortItems();
    }

    private static boolean checkItemIsInList(String item) {
        return groceryList.contains(item);
    }
    public static void sortItems() {
        Collections.sort(groceryList);
    }
}
