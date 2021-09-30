package com.epam.javatrainings.functionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExtendedList <T> extends ArrayList<T> {

    public <R> List<R> map(Function<T, R> myFunction) {
        return this.stream().map(myFunction).collect(Collectors.toList());
    }

    public <T> List<T> fill(Supplier<T> mySupplier,int sizeOfList) {

       return Stream.generate(mySupplier).limit(sizeOfList).collect(Collectors.toList());
    }

    public boolean forAll(Predicate<T> myPredicate) {
        return this.stream().allMatch(myPredicate);
    }

    public List<T> partition(Predicate<T> myPredicate) {
        return this.stream().filter(myPredicate).collect(Collectors.toList());
    }

    public  T reduce(T neutral,BinaryOperator<T> myBinary) {
        T result= myBinary.apply(this.get(0),neutral);
        for(int j=1; j<this.size(); j++){
            result=myBinary.apply(result,this.get(j));
        }
        return result;
    }
}
class ExtendedListTest {
    public static  void main(String[] args) {
        ExtendedList<Integer> list=new ExtendedList<>();
        list.addAll(List.of(1,2,3,4,5,6,7,8,9,10));
        mapTest(list);
        fillTest();
        forAllTest(list);
        partitionTest(list);
        reduceTest(list);
    }
    public static void mapTest(ExtendedList<Integer> list){
        System.out.print(("Initial list with values: "));
        showList(list);
        List<Integer> newList=list.map((a)->(a*a));
        System.out.print(("New list with squared values: "));
        showList(newList);
    }
    public static void fillTest(){
        Random random=new Random();
        ExtendedList<Integer> list=new ExtendedList<>();
        System.out.print(("New list assigned with random values (0-100): "));
        List<Integer> newlist= list.fill(()->((new Random()).nextInt(100)),10);
        showList(newlist);
    }
    public static void forAllTest(ExtendedList<Integer> list){
        System.out.print("Are all values of list even: ");
        System.out.println(list.forAll((a) -> (a % 2 == 0)));
    }

    public static void partitionTest(ExtendedList<Integer> list){
        System.out.print(("New list with only even values: "));
        List<Integer> newList=list.partition((a)->(a%2==0));
        showList(newList);
        System.out.print(("New list with only odd values: "));
        List<Integer> newList1=list.partition((a)->(a%2==1));
        showList(newList1);
    }
    public static void reduceTest(ExtendedList<Integer> list){
        System.out.print(("Sum of list values: "));
        System.out.println(list.reduce(0, (a, b) -> (a + b)));
    }
    public static void showList(List<Integer> list){
        for(var value: list){
            System.out.print(value+", ");
        }
        System.out.println();
    }

}

