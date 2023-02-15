package com.epam.mjc.io;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class FileReader {
    public Profile getDataFromFile(File file) {
        Map map=new HashMap();
        String str;
        BufferedReader bufferedReader= null;
        try {
            bufferedReader = new BufferedReader(new java.io.FileReader(file.getAbsolutePath()));
            while (bufferedReader.ready()) {
                str = bufferedReader.readLine();
                map.put(str.substring(0,str.indexOf(": ")),str.substring(str.indexOf(": ")+2));
            }
            return new Profile( map.get("Name").toString(), Integer.valueOf(map.get("Age").toString()), (String) map.get("Email"), Long.valueOf((String) map.get("Phone")));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}