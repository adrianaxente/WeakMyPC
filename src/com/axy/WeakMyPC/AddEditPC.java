package com.axy.WeakMyPC;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

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

    /**
     * Called when the options menu is created
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_edit_pc, menu);
        return super.onCreateOptionsMenu(menu);
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