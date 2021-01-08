package com.ac.entity;

public class Sb {
    private static Sb instance =null;
    private Sb(){}


    public static Sb getInstance() {
        if(instance==null){
           synchronized (Sb.class){
               instance = new Sb();
            }
        }
        return instance;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;



}
