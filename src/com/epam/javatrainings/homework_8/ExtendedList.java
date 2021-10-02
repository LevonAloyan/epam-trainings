package com.epam.javatrainings.homework_8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ExtendedList<T> extends ArrayList <T> {

    public ExtendedList(){}

    public ExtendedList(List<T> asList) {
        super(asList);
    }

    public <R> ArrayList<R> map(Function <T, R> mapper){
                ArrayList <R> result = new ArrayList<>();
                for(T e : this){
                        result.add((R) mapper.apply(e));
                }
                return result;
        }

        public void fill(Supplier<T> supplier, int count){
               for(int i = 0; i < count; i++){
                   this.add(supplier.get());
               }

        }

        public boolean forAll(Predicate<T> predicate){
            for(T e : this){
                if(!predicate.test(e)){
                    return false;
                }
            }
            return true;
        }

        public ArrayList<T> [] partition(Predicate<T> predicate){
            ArrayList<T> [] result = new ArrayList[2];
            result[0] = new ArrayList<>();
            result[1] = new ArrayList<>();
            for(T e :this){
                if(predicate.test(e)){
                    result[0].add(e);
                } else{
                    result[1].add(e);
                }
            }

            return result;
        }

        public T reduce(T neutralElement, BinaryOperator<T> binaryOperator){
                for(T e :this){
                  neutralElement = binaryOperator.apply(e,neutralElement);
                }
                return neutralElement;
        }
}
