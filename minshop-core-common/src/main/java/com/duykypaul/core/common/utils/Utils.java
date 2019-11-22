package com.duykypaul.core.common.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utils {
    // đọc dl từ file
    public static String readContentFromFile(String path) throws IOException {
        List<Character> arrTest = new ArrayList<>();
//        arrTest.add('•');
//        arrTest.add('1');
//        arrTest.add('2');
//        arrTest.add('3');
//        arrTest.add('4');
//        arrTest.add('Đ');
        String str = "";
        CharSequence s = ":";
        try (FileReader fileReader = new FileReader(path);
             BufferedReader br = new BufferedReader(fileReader)) {
            String strInLine;
            Integer count = 1;
            while((strInLine = br.readLine()) != null) {
//                if(strInLine != null && strInLine != "") {
//                    if(!arrTest.contains(strInLine.charAt(0))) {
////                        strInLine = "Ex " + count++ + ". " + strInLine;
//                        str += strInLine + "\n";
//                    }
//                }
//                str += strInLine + "\n";
                if(strInLine.contains(s)) {
                    strInLine = "\"" + strInLine.substring(0, strInLine.indexOf(":")) + "\"" + strInLine.substring(strInLine.indexOf(":"));
                }
                str += strInLine + "\n";
            }
        } catch(FileNotFoundException e){
            System.out.println("FileNotFound");
        }
        return str;
    }

    public static String readContentFromFile1(String path) throws IOException {
        String str1 = "";
        CharSequence s = ":";
        try (FileReader fileReader = new FileReader(path);
             BufferedReader br = new BufferedReader(fileReader)) {
            String strInLine;
            Integer count = 1;
            while((strInLine = br.readLine()) != null) {
                if(strInLine.contains(s)) {
                    strInLine = strInLine.substring(0, strInLine.indexOf(":")) + strInLine.substring(strInLine.indexOf(":"));
                }
                str1 += strInLine + "\n";
            }
        } catch(FileNotFoundException e){
            System.out.println("FileNotFound");
        }
        return str1;
    }

    // ghi vào file (ghi tiếp vào cuối file)
    public static void writeContentToFile2(String path) throws IOException {
        try (FileWriter fileWriter = new FileWriter(path, true)) {
            fileWriter.write((int) (Math.random() * 100));
        }
    }

    // ghi vào file( xóa dl cũ)
    public static void writeContentToFile1(String path, String value) throws IOException {
        FileWriter writer = new FileWriter(path);
        try (BufferedWriter buffer = new BufferedWriter(writer)) {
            buffer.write(value);
        }

    }

    // tìm kiếm file trong thư mục
    public static File findFileByName(String folderPath, String fileName) {
        File file = new File(folderPath);
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.getName().equals(fileName)) {
                return f;
            }
        }
        return null;
    }

    public static void main001(String[] args) {
        String path = "en-VN.json";

        try {
            path = findFileByName("C:\\Users\\DuyKyPaul\\Desktop", "en-VN.json").getPath();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException " + e.getMessage() +"/ " + path);

        }
        try {
            // in ra dl ban đầu
            System.out.println(readContentFromFile(path));
//            writeContentToFile1("C:\\Users\\DuyKyPaul\\Desktop\\en-VN.json", readContentFromFile(path));


        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
