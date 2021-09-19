package com.epam.javatrainings.validation;

public class NewTestDto {

    @Length(min = 2, max = 30)
    private String name;

    @Email
    private String email;

    public NewTestDto(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
