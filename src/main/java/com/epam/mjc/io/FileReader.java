package com.epam.mjc.io;

import java.io.*;


public class FileReader {
    public static Profile getDataFromFile(File file) throws IOException {
        StringBuilder str = new StringBuilder();
        try (FileInputStream fileInputStream = new FileInputStream(file.getAbsoluteFile());) {
            int c;
            while ((c = fileInputStream.read()) != -1) {
                char c1 = (char) c;
                str.append(c1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Profile("Anna", 25, "anna@mailserver.com", 1234567890L);
    }
}
