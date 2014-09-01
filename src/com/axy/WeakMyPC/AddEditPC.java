package com.axy.WeakMyPC;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import com.axy.WeakMyPC.Database.Entities.ComputerModel;
import com.axy.WeakMyPC.Framework.Events.EventArg;
import com.axy.WeakMyPC.Framework.Events.IEventListener;
import com.axy.WeakMyPC.ViewModels.AddEditPCViewModel;
import org.robobinding.binder.Binders;

/**
 * Created by adrianaxente on 10.08.2014.
 */
public class AddEditPC extends Activity
{

    // <editor-fold description="Private Fields">

    private AddEditPCViewModel _viewModel;

    private ComputerModel _model;

    // </editor-fold>

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = this.getIntent();
        this._model = (ComputerModel)intent.getSerializableExtra("Model");

        if (this._model == null)
        {
            this._model = new ComputerModel("New Pc", "192.168.1.1", "AA:BB:CC:DD:EE", 23);
        }

        this._viewModel = new AddEditPCViewModel(this._model);
        View rootView = Binders.inflateAndBind(this, R.layout.add_edit_pc, this._viewModel);
        setContentView(rootView);

        IEventListener closeEventListener =
            new IEventListener()
            {
                @Override
                public void execute(EventArg arg)
                {
                    AddEditPC.this.finish();
                }
            };

        this._viewModel.acceptEvent.addEventLister(closeEventListener);
        this._viewModel.cancelEvent.addEventLister(closeEventListener);

        this.setTitle(this._viewModel.getTitle());
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
        Binders.inflateAndBindMenu(menu, inflater, R.menu.add_edit_pc, this._viewModel, this);

        //inflater.inflate(R.menu.add_edit_pc, menu);
        return super.onCreateOptionsMenu(menu);
    }
}