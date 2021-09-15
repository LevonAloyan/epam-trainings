package com.epam.javatrainings.annotations;

import com.epam.javatrainings.annotations.forAdulthood.Adulthood;
import com.epam.javatrainings.annotations.forDiscountMinMax.Max;
import com.epam.javatrainings.annotations.forDiscountMinMax.Min;
import com.epam.javatrainings.annotations.forEmail.Email;
import com.epam.javatrainings.annotations.forLength.Length;

import java.time.LocalDate;

public class CustomerDto {

    @Length(min = 2, max = 30)
    private String name;

    @Email
    private String email;

    @Adulthood
    private LocalDate birthDay;

    @Min(value = 15)
    @Max(value = 100)
    private int discountRate;

}
