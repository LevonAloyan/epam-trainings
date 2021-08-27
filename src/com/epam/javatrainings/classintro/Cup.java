package com.epam.javatrainings.classintro;

public class Cup {

    private static int objectCount;
    private double volume;
    private double maxTemperature;
    private String material;
    private boolean hasHandle;

    public Cup (){
      new Cup();
        objectCount++;
    }

    public Cup (double volume){
        this.volume = volume;
    }

    public static int getObjectCount() {
        return objectCount;
    }

    boolean isEmpty(){
        return false;
    }

    public void empty(){

    }

    public void fill(){

    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public boolean isHasHandle() {
        return hasHandle;
    }

    public void setHasHandle(boolean hasHandle) {
        this.hasHandle = hasHandle;
    }
}
