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
        arrTest.add('•');
//        arrTest.add('1');
//        arrTest.add('2');
//        arrTest.add('3');
//        arrTest.add('4');
        arrTest.add('Đ');
        String str = "";
        try (FileReader fileReader = new FileReader(path);
             BufferedReader br = new BufferedReader(fileReader)) {
            String str1;
            Integer count = 1;
            while((str1 = br.readLine()) != null) {
                if(str1 != null && str1 != "") {
                    if(!arrTest.contains(str1.charAt(0))) {
//                        str1 = "Ex " + count++ + ". " + str1;
                        str += str1 + "\n";
                    }
                }
//                str += str1 + "\n";
            }
        } catch(FileNotFoundException e){
            System.out.println("FileNotFound");
        }
        return str;
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
        String path = "read.txt";

        try {
            path = findFileByName("C:\\Users\\DuyKyPaul\\Desktop", "tuloai.toeic-Copy1.txt").getPath();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException " + e.getMessage() +"/ " + path);

        }
        try {
            // in ra dl ban đầu
            System.out.println(readContentFromFile(path));
            writeContentToFile1("C:\\Users\\DuyKyPaul\\Desktop\\tuloai.toeic-Copy.txt", readContentFromFile(path));


        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
