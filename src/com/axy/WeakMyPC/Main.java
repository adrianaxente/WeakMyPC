package com.axy.WeakMyPC;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.content.Intent;
import android.view.View;
import com.axy.WeakMyPC.Database.DbConnection;
import com.axy.WeakMyPC.Database.Models.ComputerModel;
import com.axy.events.ModelEventArgs;
import com.axy.events.ModelEventListener;
import com.axy.presentation.events.IEventListener;
import com.axy.WeakMyPC.Misc.ApplicationContext;
import com.axy.WeakMyPC.ViewModels.ComputerListViewModel;
import com.axy.presentation.observable.colections.CollectionChangedEventArgs;
import com.axy.presentation.observable.colections.ICollectionChangedEventListener;
import com.axy.presentation.observable.colections.ListObservableWrapper;
import com.db4o.ObjectContainer;
import org.robobinding.binder.Binders;

import java.util.List;

public class Main extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        ApplicationContext.getInstance().init(getApplicationContext());

        super.onCreate(savedInstanceState);

        ObjectContainer objectContainer = DbConnection.getObjectContainer();

        ListObservableWrapper<ComputerModel> model =
                new ListObservableWrapper<ComputerModel>(
                    objectContainer.query(ComputerModel.class));

        final ComputerListViewModel viewModel = new ComputerListViewModel(model);

        View rootView = Binders.inflateAndBind(this, R.layout.computers, viewModel);
        setContentView(rootView);

        viewModel.editEvent.addEventLister(new ModelEventListener<ComputerModel>() {
            @Override
            public void onExecute(ModelEventArgs<ComputerModel> args) {
                Intent intent = new Intent(Main.this, AddEditPC.class);
                intent.putExtra("ModelId", args.getModel().getId());
                startActivity(intent);
            }
        });

        model.getCollectionChangedEvent().addEventLister(new ICollectionChangedEventListener() {
            @Override
            public void onExecute(CollectionChangedEventArgs args) {
                viewModel.refreshPresentationModel();
            }
        });
    }

    /**
     * Called when the options menu is created
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.computers, menu);
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
        ComputerModel model = new ComputerModel();
        Intent intent = new Intent(this, AddEditPC.class);
        /*EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);*/
        startActivity(intent);
    }
}
