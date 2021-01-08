package com.ac;

import com.ac.entity.Page;
import com.ac.entity.Sc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class initTest {


    public static  void main(String[] args){
        Sc sc1= Sc.getIn();
        Sc sc2= Sc.getIn();
        sc1.setId(1);
        sc2.setId(2);
        System.out.println(sc1.getId());
        System.out.println(sc2.getId());
    }


}
