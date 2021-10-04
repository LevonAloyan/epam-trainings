package com.epam.javatrainings.classdecomposition.order.orderitem;

import com.epam.javatrainings.classdecomposition.pizza.Pizza;

public enum QuantityUnit {
    WHOLE("whole", 10),
    SLICE("pcs", 10 * Pizza.SLICE_COUNT);

    public final String label;
    public final int maxCount;

    QuantityUnit(String label, int maxCount) {
        this.label = label;
        this.maxCount = maxCount;
    }
}
