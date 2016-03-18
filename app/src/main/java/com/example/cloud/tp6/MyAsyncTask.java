package com.example.cloud.tp6;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class MyAsyncTask extends AsyncTask<Object, Void, String> {
    private BufferedReader input;
    private TextView tvDate;
    private String host;

    @Override
    public String doInBackground(Object... params) {
            /*
            This function is used to :
            1.Open an Http connect of type HttpUrlConnection,
            2.Open an Input flow and retrieve the string send by the server,
            3.Close the flow and the connection
             */
        String json="", str;
        host = (String)params[0];
        tvDate = (TextView) params[1];
        try {

            URL url = new URL(host);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            if(urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK){
                input = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                json = input.readLine();
                Log.d("AsyncTask", "Flow =" + json);
                input.close();
            }
            urlConnection.disconnect();
        }catch (IOException ioe){
            ioe.printStackTrace();
            Log.d("AsyncTask", "Error connecion");
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {

        }// we will always pass here

        return json;
    }

    protected void onProgressUpdate(Integer... progress) {
    }

    protected void onPostExecute(String result) {
        /*
        Display in the date and time string given by the server
         */
        tvDate.setText(result);
    }

}
