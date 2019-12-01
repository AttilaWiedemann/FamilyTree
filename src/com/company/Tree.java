package com.company;

import java.util.ArrayList;
import java.util.Scanner;


public class Tree {
    static int counter = -1;
    static ArrayList<Human> humans = new ArrayList<>();
    static int depth = 0;

    private static boolean askInput(){
        Scanner sc = new Scanner(System.in);
        if(sc.next().equals("q")){
            return false;
        }
        return true;
    }

    private static String askInput2(){
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    private static String askName(){
        System.out.println("Add meg a faszi nevét:");
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    private static void generateTree(){
        if(counter == -1){
            System.out.println("A családfa a legfiatalabb tagnál kezdődik.");
            Human youngest = new Human(askName()); humans.add(youngest);
            counter++; generateTree();
        }else {
            System.out.println("Családtagok hozzáadásához nyomj egy billentyűt." +
                    "\nHa nem akarsz hozzáadni több embert, akkor nyomd meg a q gombot");
            if(askInput()){
                System.out.println(humans.get(counter).getName() + " apját(f), anyját(m), vagy mindkét szülejét(b) akarod hozzáadni?");
                switch (askInput2()){
                    case "f":
                        Human father = new Human(askName());
                        humans.get(counter).setFather(father);
                        humans.add(father); counter++;
                        generateTree();
                    case "m":
                        Human mother = new Human(askName());
                        humans.get(counter).setMother(mother);
                        humans.add(mother); counter++;
                        generateTree();
                    case "b":
                        System.out.println("Add meg " + humans.get(counter).getName() + " anyjának, majd apjának nevét:");
                        mother = new Human(askName());
                        father = new Human(askName());
                        humans.get(counter).setFather(father);
                        humans.get(counter).setMother(mother);
                        System.out.println("Apai(q), vagy anyai(bármilyen másik gomb) ágon folytatódjon a családfa?");
                        if(askInput()){
                            humans.add(mother); counter++;
                            generateTree();
                        }else {
                            humans.add(father); counter++;
                            generateTree();
                        }
                    default:
                        System.out.println("Ilyen lehetőség nincsen...");
                        generateTree();
                }
            }else{
                System.out.println("A családfa készen van!");
                printTree();
            }
        }
    }

    private static void printTree(){
        try {
            humans.get(depth).printHuman(depth);
            depth++;

                printTree();


        }catch (IndexOutOfBoundsException e){
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        generateTree();
        printTree();
    }
}
