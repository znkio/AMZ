/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.io.znk.ctalin.ws;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import org.apache.commons.httpclient.URI;

public class Tester {

    public static void sendPushTelerik(String message, String telid) {
        try {

            URI uri = new URI("http", "//api.everlive.com/v1/" + telid + "/Push/Notifications", null);
            URL oracle = new URL(uri.getEscapedURI());
            HttpURLConnection conn = (HttpURLConnection) oracle.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept",
                    "text/html,application/xhtml+xml,application/xml;application/json;q=0.9,image/webp,*/*;q=0.8");

            OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
            String data = "{\"Message\":\"" + message + "\"}";
            writer.write(data);
            writer.flush();
            String line;
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            writer.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static class skata {

        public int i = 0;
        public int j = 1;

    }

    public static void main(String args[]) {
//        while (true) {
//
//            try {
//                System.out.println(tester.readPage("//localhost:8080/jPersonnel/secured/personnel/personnel/edit/685", null));
//                tester.readPage("//localhost:8080/jPersonnel/secured/personnel/personnel/edit/685", null);
//                Thread.sleep(100);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(tester.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        sendPushTelerik("ena message", "34t5TpXF6UZmafEg");
    }
}
