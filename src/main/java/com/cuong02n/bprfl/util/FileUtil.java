package com.cuong02n.bprfl.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileUtil {
    public static String getAllFile(String filePath) {
        try {
            StringBuilder res = new StringBuilder();
            File f = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line;
            while ((line = reader.readLine()) != null) {
                res.append(line);
            }
            return res.toString();
        } catch (Exception e) {
            return e.toString();
        }
    }
}
