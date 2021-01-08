package com.ac.entity;

public class Sc {
    private static Sc in =null;
    private Sc(){}

    public static Sc getIn() {
        if(in==null){
            System.out.println("init");
               synchronized (Sc.class) {
                  in = new Sc();
              }
            //in = new Sc();
        }
        return in;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;


    public static  void main(String[] args){
        Sc sc1= Sc.getIn();
        Sc sc2= Sc.getIn();
        sc1.setId(3);
        sc2.setId(4);
        System.out.println(sc1.getId());
        System.out.println(sc2.getId());
    }

}
