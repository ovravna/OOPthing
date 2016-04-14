package Person2;

//import java.util.*;

import java.util.ArrayList;

public class Person {
    private String name;
    private char gender;
    private ArrayList<Person> children;
    private Person mother, father;

    public Person(String name, char gender) {
        this.name = name;
        if (gender == 'M' || gender == 'F') this.gender = gender;
        else throw new IllegalArgumentException("Invalid gender");
        children = new ArrayList<>();
    }



    //~~~~~~~~~~~~~~~~~ Setters ~~~~~~~~~~~~~~~~~~~~


    public void addChild(Person child) {
        if (!this.children.contains(child)) this.children.add(child);
//        else throw new IllegalArgumentException("Already existing child");
        if (this.gender == 'M' && child.getFather() != this) {
            child.setFather(this);
        } else if (this.gender == 'F' && child.getMother() != this) child.setMother(this);
    }


    public void removeChild(Person child) {
        this.children.remove(child);
        if (this.gender == 'M' && child.getFather() != null) {
            child.setFather(null);
        } else if (child.getMother() != null) child.setMother(null);

    }

    public void setMother(Person mother) {
        if (mother == null) {
            this.mother = null;
        } else if (mother.getGender() == 'F' && mother != this && this.mother == null) {
            this.mother = mother;
            int i = mother.getChildCount();
            if (i == 0 || mother.getChild(i-1) != this) mother.addChild(this);
        } else if (mother.getGender() == 'F' && mother != this) {
            Person child;
            for (int i = 0;i < this.mother.getChildCount();i++) {
                child = this.mother.getChild(i);
                this.mother.removeChild(child);
                mother.addChild(child);
            }
            this.mother = mother;
        } else throw new IllegalArgumentException("Male mother");
    }

    public void setFather(Person father) {
        if (father == null) {
            this.father = null;
        } else if (father.getGender() == 'M' && father != this && this.father == null)  {
            this.father = father;
            int i = father.getChildCount();
            if (i == 0 || father.getChild(i-1) != this) father.addChild(this);
        } else if (father.getGender() == 'M' && father != this) {
            Person child;
            for (int i = 0;i < this.father.getChildCount();i++) {
                child = this.father.getChild(i);
                this.father.removeChild(child);
                father.addChild(child);
            }
            this.father = father;
        } else throw new IllegalArgumentException("Female father");
    }




    //~~~~~~~~~~~~~~~~~ Getters ~~~~~~~~~~~~~~~~~~~~


    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public Person getChild(int i) {
        try {
            return children.get(i);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid index");
        }
    }

    public int getChildCount() {
        return children.size();
    }



    @Override
    public String toString() {
        return String.format("Name: %s  \nGender: %s\nFather: %s\nMother: %s\n"+
                "Children: %s\n", name, gender, father != null ? 1:0, mother != null ? 1:0, getChildCount());
    }


}
