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

        new AlertDialog.Builder(this)
                .setTitle("title")
                .setMessage("message:aaaaaaaa/bbbbbbbb/cccccccccccc")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();

                    }
                })
                .create()
                .show();

    }

    public void test() {
        //CABBB BABDA D

    }

    public void wrong() {
        //1、10、
    }
}
