package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Map<String, Integer> map = new SimpleMap<>(1);
        Scanner st = new Scanner(new File("st.txt"));
        while(st.hasNext()){
            String str = st.next();
            str = str.replaceAll("//.","");
            str = str.replaceAll("//,| ?,","");
            str = str.replaceAll("//: | ?:","");
            if(map.get(str) == null)
                map.put(str, 1);
            else
                map.put(str, map.get(str) + 1);
        }
        st.close();
        map.printMap();
    }
}