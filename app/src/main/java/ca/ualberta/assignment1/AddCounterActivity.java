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

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddCounterActivity extends AppCompatActivity {

    private EditText name;
    private EditText initialValue;
    private EditText comment;
    private Counter newCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_counter);

        name = (EditText) findViewById(R.id.nameInput);
        initialValue = (EditText) findViewById(R.id.initialValueInput);
        comment = (EditText) findViewById(R.id.commentInput);

        Button saveButton;
        saveButton = (Button) findViewById(R.id.addCounter);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newCounter = new Counter(name.getText().toString(),
                        Integer.parseInt(initialValue.getText().toString()),
                        comment.getText().toString());

                startActivity(new Intent(AddCounterActivity.this,
                        ListCountersActivity.class));
            }
        });
    }
}
