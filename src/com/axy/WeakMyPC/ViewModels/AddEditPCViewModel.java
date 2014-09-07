package com.axy.WeakMyPC.ViewModels;

//import javax.annotation.concurrent.ThreadSafe;

import android.view.MenuItem;
import com.axy.WeakMyPC.Database.DbConnection;
import com.axy.WeakMyPC.Database.Models.ComputerModel;
import com.axy.presentation.events.Event;
import com.axy.presentation.events.EventArgs;
import com.axy.presentation.presentationModel.AbstractViewModel;
import com.db4o.ObjectContainer;

/**
 * Created by adrianaxente on 30.08.2014.
 */
public class AddEditPCViewModel extends AbstractViewModel<ComputerModel>
{
    // <editor-fold description="Fields">

    public final Event acceptEvent = new Event();
    public final Event cancelEvent = new Event();


    // </editor-fold>

    // <editor-fold description="Constructor">

    public AddEditPCViewModel(ComputerModel model) throws NullPointerException
    {
        super(model);
        this.beginEdit();
    }

    // </editor-fold>

    // <editor-fold description="Setters & Getters">

    public String getName() { return  this.getModel().getName(); }
    public void setName(String name) { this.getModel().setName(name, this); }

    public String getIpAddress() { return  this.getModel().getIpAddress(); }
    public void setIpAddress(String ipAddress) { this.getModel().setIpAddress(ipAddress, this); }

    public String getMacAddress() { return  this.getModel().getMacAddress(); }
    public void setMacAddress(String macAddress) { this.getModel().setMacAddress(macAddress, this); }

    public String getPort() { return  String.valueOf(this.getModel().getPort()); }
    public void setPort(String port) { this.getModel().setPort(Integer.parseInt(port), this); }


    public String getTitle()
    {
        //todo: add localized string resource
        return this.getModel().getId() == 0
                    ? "Add Computer"
                    : "Edit Computer";
    }

    // </editor-fold>

    // <editor-fold description="Actions">

    public void accept(MenuItem menuItem)
    {
        this.endEdit(true);
        //todo: Add the validation

        ObjectContainer objContainer = DbConnection.getObjectContainer();
        objContainer.store(this.getModel());
        objContainer.commit();
        //this._sourceModel.changedEvent.fire(EventArg.EMPTY);
        this.acceptEvent.fire(EventArgs.EMPTY);
    }

    public void cancel(MenuItem menuItem)
    {
        this.endEdit(false);
        this.cancelEvent.fire(EventArgs.EMPTY);
    }

    // </editor-fold>
}
