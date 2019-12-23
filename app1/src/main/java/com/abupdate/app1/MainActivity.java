package com.abupdate.app1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void click1(View view) {
//        striking/gradual growth/decline;
//        significant/slight decline/growth
//        （） takes th
        //        e percentage of (), ranging for the close/distant second.
        new AlertDialog.Builder(this)
                .setTitle("title")
                .setMessage("message:aaaaaaaa/bbbbbbbb/cccccccccccc")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .setCancelable(true)
                .create()
                .show();
    }

    public void test() {

        //CABBB BABDA D
    }

    public void wrong() {
        //1、10、people ch

        // 1.major differences detected in terms of the proportions of () among distinct groups.
        //2.Based on the statistics of the chart, () occupy the dominant position, accounting for ().
        //3.() take the percentage of 5%, ranging for the close/distant second.
        //4. While () comprise a relatively small proportion of 10%, coming to the last one.
    }
}
