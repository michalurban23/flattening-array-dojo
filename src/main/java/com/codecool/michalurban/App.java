package com.codecool.michalurban;

import com.codecool.michalurban.flattener.ListFlattener;
import com.codecool.michalurban.flattener.MyFlattener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class App {

    private static List<Object> toFlatten;

    public static void main(String[] args) {

        ListFlattener flattener = new MyFlattener();

        createList1();
        // createList2();

        List<Object> flattened = flattener.flatten(toFlatten);

        System.out.println(toFlatten);
        System.out.println(flattened);
    }

    private static void createList1() {

        toFlatten = new ArrayList<>();
        toFlatten.add(1);
        toFlatten.add(3);
        toFlatten.add(createSubList("age", 5));
        toFlatten.add("Kraków");
        toFlatten.add(createSubList(1, createSubList(3, createSubList(4, 5), "codecool"), 6, 7));
    }

    private static void createList2() {

        toFlatten = new LinkedList<>();

        toFlatten.addAll(Arrays.asList(1, 3, "codecool", 5, 8));
    }

    private static List<Object> createSubList(Object... objects) {

        List<Object> sublist = new ArrayList<>();

        sublist.addAll(Arrays.asList(objects));
        return sublist;
    }

}
