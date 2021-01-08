package com.ac;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootTest
public class Test2 {

        @Test
        public void DateFormatUtilsTest(){
            Long a = 22222222222L,b =Long.valueOf("1588227710000"),c= Long.valueOf("1588227710")*1000 ;

            System.out.println(a.compareTo(b));
            System.out.println(a.compareTo(c));
            System.out.println(c.compareTo(b));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date date = new Date(Long.valueOf("222222222222"));
            System.out.println(simpleDateFormat.format(date));
        }

        @Test
        public void test2(){

            int count = 0;
            for(int i = 0; i < 10; i++) {
                count = count++;
            }
            System.out.println(count);
        }
        @Test
        public void Test(){
           Integer[] arr = new Integer[]{1,2,2,1,1,3};
            Map<Integer,Integer> map = new HashMap<>();

            boolean flag = true;
            if(arr!=null){
                for(Integer i : arr){
                    Integer count =  map.get(i);
                    map.put(i,count==null?1:count+1);
                }
                /*Set set = map.entrySet();
                Iterator iterator = set.iterator();
                while (iterator.hasNext()){

                }*/
               // List<Integer> list2 = map.entrySet().stream().forEach(e -> list2.add(e.getValue()));
                //map.entrySet().stream((k,v)-> {System.out.println(1);} );
                List<Integer> list = new ArrayList<>();
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
                    if(list.contains(entry.getValue())){
                        flag =false;
                        break;
                    }else {
                        list.add(entry.getValue());
                    }
                }
                System.out.println("有无重复:"+flag);
            }

        }
}
