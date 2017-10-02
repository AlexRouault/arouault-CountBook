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

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/*
 * This activity allows the user to modify an existing counter.
 * ListCountersActivity creates this when an existing counter from the list
 * is clicked
 */

public class EditCounterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_counter);
    }
}
