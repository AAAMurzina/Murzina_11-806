package com.company.Task02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PhoneList {
    private List<Phone> pl;

    public PhoneList() {
        pl = new ArrayList<>();
    }
    public boolean add(Phone p){
        return pl.add(p);
    }
    public List<Phone> topN(Comparator<Phone> comparator, int n){
        List<Phone> tempList = new ArrayList<>();
        pl.sort(comparator);
        for (int i = 0; i <  n; i++) {
            tempList.add(pl.get(i));
        }
        return tempList;
    }

}
