package com.interview.java.basics;

import java.util.Optional;

public class OptionalClasses {

    public static String getCred(int i) {
        if (i == 0) {
            return null;
        }
        return "Rahul";
    }

    public static Optional<String> getDb(int i) {
        if (i == 0) {
//            return Optional.empty();
        	return Optional.ofNullable(null);
        }
        return Optional.ofNullable("Rahul");
    }

    public static void main(String[] args) {
//        System.out.println(OptionalClasses.getCred(0));
//        System.out.println(OptionalClasses.getDb(1));

        Optional<String> userName = OptionalClasses.getDb(0);

        userName.ifPresentOrElse(
            (user) -> { System.out.println(user); },
            () -> { System.out.println("user name is not found"); }
        );
        
        if(userName.isPresent())
        {
        	System.out.println(" Value find"+userName.get());
        }else {
        	System.out.println("Null value find ");
        }
    }
}
