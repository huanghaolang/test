package com.ac;

import com.ac.entity.Sc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class init2Test {


    public static  void main(String[] args){
        Sc sc1= Sc.getIn();
        Sc sc2= Sc.getIn();
        sc1.setId(5);
        sc2.setId(6);
        System.out.println(sc1.getId());
        System.out.println(sc2.getId());
    }


}
