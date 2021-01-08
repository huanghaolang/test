package com.ac.initBinder;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataBinder extends PropertyEditorSupport{

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            //通过两次异常的处理可以，绑定两次日期的格式
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = null;
            try {
                date = format.parse(text);
            } catch (ParseException e) {
                format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                try {
                    date = format.parse(text);
                } catch (ParseException e2) {
                    try {
                        format = new SimpleDateFormat("yyyy-MM-dd");
                        date = format.parse(text);
                    }catch (ParseException e3){
                        e3.printStackTrace();
                    }
                }
            }
            setValue(date);

    }
}
