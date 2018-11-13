package com.aquascore.api.controllers;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URL;

import java.io.*;
import java.net.*;
import org.json.JSONObject;
import org.json.XML;

@RestController
@RequestMapping("/news/")
public class RSSFeedController {

    @RequestMapping(value = "/", produces = "applications/json")
    @ResponseBody
    private String readRSSFeed() throws IOException, FeedException {
        String xmlString = readUrlToString("http://feeds.bbci.co.uk/sport/formula1/rss.xml?edition=uk");
        JSONObject xmlJSONObj = XML.toJSONObject(xmlString);

        return xmlJSONObj.toString();
    }

    public String readUrlToString(String url) {
        BufferedReader reader = null;
        String result = null;
        try {
            URL u = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) u.openConnection();
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");
            conn.setRequestMethod("GET");
            conn.setDoOutput(true);
            conn.setReadTimeout(2 * 1000);
            conn.connect();
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }
            result = builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try { reader.close(); } catch (IOException ignoreOnClose) { }
            }
        }
        return result;
    } 
}
