package org.example;

public class Age {
   public String age(Object a){
       int s=checkAge(a);
       if(s<=0){
           return "Too low";
       }else if(s>120){
           return "Too high";
       }else{
           return "Success";
       }
    }


    private int checkAge(Object value) {
        if(value instanceof Number){
            return ((Number)value).intValue();
        }    if (value instanceof String){
            try{
                return Integer.parseInt((String)value);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Enter Numbers");
            }
        }throw new IllegalArgumentException("Enter Numbers");
    }
    }


