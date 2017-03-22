package com.gordarg.gpstracker;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by admin on 10/20/2016.
 */
public class WebClient {
    String Post(String Url, List<NameValuePair> nameValuePairs) throws ClientProtocolException, IOException {

        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(new String());
        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        HttpResponse response = httpClient.execute(httpPost);
        return response.toString();

    }


    String Get(String Url) throws ClientProtocolException, IOException {
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(Url);
        HttpResponse response = httpClient.execute(httpGet);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        return result.toString();
    }
}

class POST extends AsyncTask<List<NameValuePair>, String, String> {

    static public String Url;

    public POST(String URL) {
        Url = URL;
    }

    @Override
    protected String doInBackground(List<NameValuePair>... NameValuePairs) {
        WebClient webClient = new WebClient();
        try {
            return webClient.Post(Url, NameValuePairs[0]);
        } catch (Exception e) {
            return null;
        }
    }

}

class GET extends AsyncTask<String, String, String> {
    @Override
    protected String doInBackground(String... Params) {

        WebClient client = new WebClient();
        try {
            return client.Get(Params[0]);
        } catch (Exception e) {
            return null;
        }
    }
}