package com.epam.mjc.io;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class FileReader {
    public Profile getDataFromFile(File file){
        Map map=new HashMap();
        String str;
        BufferedReader bufferedReader= null;
        try {
            bufferedReader = new BufferedReader(new java.io.FileReader(file.getAbsolutePath()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(bufferedReader);
            while (true) {
                try {
                    if (!bufferedReader.ready()) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    str = bufferedReader.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                map.put(str.substring(0,str.indexOf(": ")),str.substring(str.indexOf(": ")+2));
            }
        return new Profile( map.get("Name").toString(), Integer.valueOf(map.get("Age").toString()), (String) map.get("Email"), (Long) map.get("Phone"));
    }
}