package com.weather;


import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Collection;


public class HttpClient {
    public static JSONObject sendRequest(String url_parameter, String token) throws IOException {
        String fullUrl = url_parameter + "&APPID=" + token;
        URL url = new URL(fullUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();
        return getJsonFromString(content.toString());
    }

    private static JSONObject getJsonFromString(String text)
    {
        JSONObject json = new JSONObject(text);
        return json;
    }
}
