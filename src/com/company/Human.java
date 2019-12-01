package com.company;

public class Human {
    private String name;
    private Human mother;
    private Human father;

    public Human(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void printHuman(int depth){
        for (int i = 0; i <= depth; i++){
            if(i == 0){
                System.out.println();
            }
            System.out.print("-");
        }System.out.print(name);
        for(int i = 0; i <= depth + 1; i++){
            if(i == 0){
                System.out.println();
            }
            System.out.print("-");
        }try{System.out.print("Apa: " + father.getName());}
        catch (NullPointerException e){System.out.print("Ismeretlen");}
        for(int i = 0; i <= depth + 1; i++){
            if(i == 0){
                System.out.println();
            }
            System.out.print("-");
        }try{System.out.print("Anya: " + mother.getName());}
        catch (NullPointerException e){System.out.print("Ismeretlen");}
    }
}
