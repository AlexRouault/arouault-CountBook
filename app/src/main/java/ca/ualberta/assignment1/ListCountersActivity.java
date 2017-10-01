/*
 * project: @app_name
 * class: @file_name
 * Author: Alex Rouault
 * Date: Oct 2, 2017
 *
 * Copyright (c) Alex Rouault, CMPUT301, University of Alberta - All Rights
 * Reserved. You may use, distribute, or modify this code under terms and
 * conditions of the Code of Students Behavior at University of Alberta
 */

package ca.ualberta.assignment1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ListCountersActivity extends AppCompatActivity {

    private static final String FILENAME = "file.sav";
    private ListView countersListView;

    private ArrayList<Counter> counterList = new ArrayList<>();
    private ArrayAdapter<Counter> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_counters);

        Button addButton;
        addButton = (Button) findViewById(R.id.addCounter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListCountersActivity.this,
                        AddCounterActivity.class));
            }
        });
    }

    /**
     * Runs when app is launched
     */

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        loadFromFile();
        adapter = new ArrayAdapter<Counter>(this,
                R.layout.list_item, counterList);
        countersListView.setAdapter(adapter);
    }

    /**
     * loads save data from Gson
     */

    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();

            Type listType = new TypeToken<ArrayList<Counter>>(){}.getType();
            counterList = gson.fromJson(in, listType);
            //https://github.com/google/gson/blob/master/UserGuide.md#TOC-Collections-Examples


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            counterList = new ArrayList<Counter>();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Saves data with Gson
     */

    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    Context.MODE_PRIVATE);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(counterList, writer);
            writer.flush();
            fos.close();




        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }

    public void addCounter(Counter newCounter) {
        counterList.add(newCounter);
    }
}
