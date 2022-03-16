package com.epam.javatrainings;

import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public final class CustomImmutable {
    private final int primType;
    private final Date mutableType;
    private final List<Integer> list;
    private final LocalDate immutableType;

    public CustomImmutable(int primType, Date mutType, LocalDate immutableType, List<Integer> list) {
        this.primType = primType;
        this.immutableType = immutableType;
        this.mutableType = (Date) mutType.clone();


        this.list = new ArrayList<>();
        for (Integer item : list) {
            // ete Integeri pokharen mutable class liner, petq a dranq el deep copy aneinq
            this.list.add(item);
        }
    }

    public int getPrimType() {
        return primType;
    }

    public Date getMutableType() {
        return (Date) mutableType.clone();
    }

    public LocalDate getImmutableType() {
        return immutableType;
    }

    public List<Integer> getList() {
        List<Integer> copy = new ArrayList<>();
        for (Integer item : list) {
            // ete Integeri pokharen mutable class liner, petq a dranq el deep copy aneinq
            copy.add(item);
        }
        return copy;
    }
}
