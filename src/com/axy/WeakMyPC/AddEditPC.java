package com.axy.WeakMyPC;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by adrianaxente on 10.08.2014.
 */
public class AddEditPC extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_edit_pc);
        setupInterface();
    }

    public void setupInterface()
    {
        Intent intent = this.getIntent();
        String operation = intent.getStringExtra("Operation");

        String title = "";

        if (operation.equals("add"))
        {
            title = "Add new PC";
        }
        else if (operation.equals("edit"))
        {
            title = "Edit PC";
        }

        this.setTitle(title);
    }
}