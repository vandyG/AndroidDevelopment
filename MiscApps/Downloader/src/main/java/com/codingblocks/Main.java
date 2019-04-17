package com.codingblocks;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner s = new Scanner(System.in);

        String link = s.nextLine().trim();
        URL url = new URL(link);

//        for (int i = 0; i < 5; i++) {
//            File file = new File(i + "index.html");
//            FileUtils.copyURLToFile(url, file);
//        }

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            Thread t = new Thread(() -> {

                File f = new File(finalI +"pandaThread.jpg");

                try {
                    FileUtils.copyURLToFile(url,f);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            t.start();
        }
    }
}
