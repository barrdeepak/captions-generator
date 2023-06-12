package com.captions;

import java.io.*;
import java.util.*;
import java.net.*;

public class DataManager {

    private static DataManager instance;

    private Map<String, Set<String>> captionMap = new HashMap();

    private DataManager() {
        String dataUrl = "https://raw.githubusercontent.com/barrdeepak/captions_flutter/master/data/captions.psv";

        try {
            // Get the input stream of the file from the resources folder
            InputStream inputStream = getClass().getResourceAsStream("captions.psv");
            URL url = new URL(dataUrl);

            // Create a BufferedReader to read the content
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = reader.readLine()) != null) {

                String[] parts = line.split("\\|");
                String[] keywords = parts[0].split(",");
                for (String kw : keywords) {
                    kw = kw.trim();
                    if (!captionMap.containsKey(kw))
                        captionMap.put(kw, new HashSet());
                    Set<String> captionSet = captionMap.get(kw);
                    captionSet.add(parts[1].trim());
                }
                for (String key : captionMap.keySet())
                    System.out.println(" Keyword = " + key);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Set<String> get(String keyword) {
        return captionMap.getOrDefault(keyword, new HashSet());
    }

    public static synchronized DataManager getInstance() {
        if (instance == null)
            instance = new DataManager();
        return instance;
    }
}
