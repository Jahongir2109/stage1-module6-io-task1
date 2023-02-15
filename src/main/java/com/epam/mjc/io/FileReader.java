package com.epam.mjc.io;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
public class FileReader {
    public Profile getDataFromFile(File file) {
        Map<String,Object> map=new HashMap();
        try(BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file.getAbsolutePath()));){
            String str;
            while (bufferedReader.ready()) {
                str = bufferedReader.readLine();
                map.put(str.substring(0,str.indexOf(": ")),str.substring(str.indexOf(": ")+2));
            }
            return new Profile( map.get("Name").toString(), Integer.valueOf(map.get("Age").toString()), (String) map.get("Email"), Long.valueOf((String) map.get("Phone")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}