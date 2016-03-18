package com.example.cloud.tp6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    public TextView tvDate;
    public WebView displayhtml;
    public void onClickDate(View view){
        /*
        This function call when we click on the button DATA-HEURES, it used
        to retrive from a distant server a date and time string and
        display it in the TextView Time
        */
        tvDate = (TextView) findViewById(R.id.timeTxt);
        new MyAsyncTask().execute("http://www.timeapi.org/utc/now", tvDate);//use .execute to run the thread
    }

    public void onClickTxtHtml(View view){
        /*
        This function display, when we click on the button TxtHtmlBtn, the string below.
        */
        String strHtml = "<html><body><b> Ceci est un text au format Troll </b></br><b>mais bon il s'affiche</b></body></html>";
        displayhtml.loadData(strHtml, "text/html; charset = utf-8", "UTF-8");

    }

    public void onClicLoadUrl(View view){
         /*
        This function display, when we click on the button LoadurlBtn,
        the brut RSS flow from the Amercian governement's web site.
        */
        displayhtml.loadUrl("http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/4.5_day.geojson");
    }

    public void onClickLoadData(View view){
        new MyWebViewAsyncTask().execute("http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/4.5_day.geojson",displayhtml);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayhtml = (WebView) findViewById(R.id.webView);

        /*

        String reponse = null;
        URL url = null;
        try {
            url = new URL();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }*/
    }
}
