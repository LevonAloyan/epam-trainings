package com.epam.javatrainings.AnnotationsHomework;

import java.time.LocalDate;

public class Validation {
   public static boolean validateAll(String name, String email, LocalDate birthday, int discountRate) {
      boolean isRightName = CustomerDto.isValidName(name);
      boolean isRigthEmail = CustomerDto.isValidEmail(email);
      boolean isRightBirthday=CustomerDto.isValidBirthday(birthday);
      boolean isRightDiscount=CustomerDto.isValidDiscount(discountRate);
      if(isRightName && isRigthEmail && isRightBirthday && isRightDiscount){
         CustomerDto customer= new CustomerDto(name,email, birthday, discountRate);
         System.out.println("Customer is created!");
         return false;
      } else{
         System.out.println("Try again!");
         return  true;
      }
   }
}
