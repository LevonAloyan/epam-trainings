package com.epam.javatrainings.AnnotationsHomework;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CustomerDto{

    @Length(min = 2,max=30)
    private String name;

    @Email
    private String Email;

    @Adulthood
    private LocalDate birthday;

    @Min(0)
    @Max(100)
    private int discountRate;

    public CustomerDto(String name, String email, LocalDate birthday, int discountRate){
        this.name=name;
        this.Email=email;
        this.birthday=birthday;
        this.discountRate=discountRate;
    }
    public static Boolean isValidName(String name){
        boolean isValid=false;
        try {
            Field f = CustomerDto.class.getDeclaredField("name");
            Length anno = f.getAnnotation(Length.class);
            if (name.length() >= anno.min() && name.length() <= anno.max()) {
                isValid=true;
            }
            else{
                System.out.println("Warning! Name's length must be beetwen 2 and 30!");
            }
        }catch ( NoSuchFieldException exc){
            System.out.println("No such field!");
        }
        return isValid;
    }
    public static Boolean isValidEmail(String email){
        boolean isValid=false;
        try {
            Field f = CustomerDto.class.getDeclaredField("Email");
            Email anno = f.getAnnotation(Email.class);
            Pattern p=Pattern.compile(anno.regex(),Pattern.CASE_INSENSITIVE);
            Matcher m=p.matcher(email);
            isValid=m.matches();
            if(!isValid){
                System.out.println("Warning! Wrong email format!");
            }
        }catch ( NoSuchFieldException exc){
            System.out.println("No such field!");
        }
        return isValid;
    }
    public static Boolean isValidBirthday(LocalDate birthday){
        boolean isValid=false;
        try {
            Field f = CustomerDto.class.getDeclaredField("birthday");
            Adulthood anno = f.getAnnotation(Adulthood.class);
            Period period=Period.between(birthday,LocalDate.now());
            if(period.getYears()>=anno.value()) {
                isValid=true;
            }else{
                System.out.println("Warning! The customer must be 18+!");
            }
        }catch ( NoSuchFieldException exc){
            System.out.println("No such field!");
        }
        return isValid;
    }
    public static Boolean isValidDiscount(int discount){
        boolean isValid=false;
        try {
            Field f = CustomerDto.class.getDeclaredField("discountRate");
            Min anno1 = f.getAnnotation(Min.class);
            Max anno2 = f.getAnnotation(Max.class);
            if(discount>=anno1.value()&&discount<=anno2.value()){
                isValid=true;
            }else{
                System.out.println("Warning! The discount must be between 0 and 100!");
            }
        }catch ( NoSuchFieldException exc){
            System.out.println("No such field!");
        }
        return isValid;
    }
}

