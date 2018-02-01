package com.codecool.michalurban.flattener;

import java.util.List;

public class MyFlattener implements ListFlattener {

    private List<Object> flattenedList;

    @Override
    @SuppressWarnings("unchecked")
    public List<Object> flatten(List<Object> toFlatten) {

        try {
            flattenedList = toFlatten.getClass().newInstance();
            performFlattening(toFlatten);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new IllegalArgumentException("Not a proper list implementation");
        }

        return flattenedList;
    }

    @SuppressWarnings("unchecked")
    private void performFlattening(List<Object> toFlatten) {

        for (Object o : toFlatten) {
            if (o instanceof List) {
                performFlattening((List) o);
            } else {
                flattenedList.add(o);
            }
        }
    }

}
