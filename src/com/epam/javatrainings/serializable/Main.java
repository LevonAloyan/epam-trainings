package com.epam.javatrainings.serializable;

public class Main {
    public static void main(String[] args) {
        String serializationFile = "C:\\GEV\\Java Projects\\epam-trainings\\src\\resources\\serialized files.ser";
        Customer customer1 = new Customer("Customer One", "+37499555555", 8, "1111-2222-3333-4444");
        Customer customer2 = new Customer("Customer Two", "+37499777777", 12, "5555-6666-7777-8888");

        System.out.println("Files before serialization\n" + customer1 + "\n" + customer2);

        SerializationManager.write(customer1, serializationFile, "cardNumber");
        SerializationManager.write(customer2, serializationFile, "cardNumber");

        customer2 = SerializationManager.read(serializationFile, "cardNumber");
        customer1 = SerializationManager.read(serializationFile, "cardNumber");

        //tel-s are null here in output
        System.out.println("Files after serialization\n" + customer1 + "\n" + customer2);

    }
}
