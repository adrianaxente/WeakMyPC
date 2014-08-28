package com.axy.WeakMyPC;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.content.Intent;
import com.axy.WeakMyPC.Database.DbConfig;
import com.axy.WeakMyPC.Database.DbConnection;
import com.axy.WeakMyPC.Database.Entities.Computer;
import com.db4o.ObjectContainer;

import java.util.List;

public class Main extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        DbConfig dbConfig = new DbConfig();
        DbConnection dbConnection = new DbConnection(this, dbConfig);
        ObjectContainer dbContainer = dbConnection.getObjectContainer();
        //Computer comp = new Computer("Ion's computer", "192.168.1.3", "ED:AA:12:23:45:56", 7);
        //dbContainer.store(comp);
        List<Computer> allComputers = dbContainer.query(Computer.class);
        dbContainer.close();
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
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_add_new:
                add();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    /**
     * Add action handler
     */
    public void add() {
        Intent intent = new Intent(this, AddEditPC.class);
        intent.putExtra("Operation", "add");
        /*EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);*/
        startActivity(intent);
    }
}
