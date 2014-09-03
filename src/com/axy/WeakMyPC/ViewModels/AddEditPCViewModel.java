package com.axy.WeakMyPC.ViewModels;

//import javax.annotation.concurrent.ThreadSafe;

import android.view.MenuItem;
import com.axy.WeakMyPC.Database.DbConnection;
import com.axy.WeakMyPC.Database.Models.ComputerModel;
import com.axy.WeakMyPC.Framework.Events.Event;
import com.axy.WeakMyPC.Framework.Events.EventArg;
import com.db4o.ObjectContainer;
import org.robobinding.aspects.PresentationModel;

/**
 * Created by adrianaxente on 30.08.2014.
 */
@PresentationModel
public class AddEditPCViewModel
{
    // <editor-fold description="Fields">

    public final Event acceptEvent = new Event();
    public final Event cancelEvent = new Event();
    private ComputerModel _sourceModel;
    private ComputerModel _model;


    // </editor-fold>

    // <editor-fold description="Constructor">

    public AddEditPCViewModel(ComputerModel model) throws NullPointerException
    {
        super();

        if (model == null)
        {
            throw new NullPointerException();
        }

        this._sourceModel = model;
        this._model = model.createClone();
    }

    // </editor-fold>

    // <editor-fold description="Setters & Getters">

    public String getName() { return  this._model.Name; }
    public void setName(String name) { this._model.Name = name; }

    public String getIpAddress() { return  this._model.IpAddress; }
    public void setIpAddress(String ipAddress) { this._model.IpAddress = ipAddress; }

    public String getMacAddress() { return  this._model.MacAddress; }
    public void setMacAddress(String macAddress) { this._model.MacAddress = macAddress; }

    public String getPort() { return  String.valueOf(this._model.Port); }
    public void setPort(String port) { this._model.Port = Integer.parseInt(port); }


    public String getTitle()
    {
        //todo: add localized string resource
        return this._model.getId() == 0
                    ? "Add Computer"
                    : "Edit Computer";
    }

    // </editor-fold>

    // <editor-fold description="Actions">

    public void accept(MenuItem menuItem)
    {
        //todo: Add the validation

        this._sourceModel.copyFrom(this._model);

        ObjectContainer objContainer = DbConnection.getObjectContainer();
        objContainer.store(this._sourceModel);
        objContainer.commit();
        //this._sourceModel.changedEvent.fire(EventArg.EMPTY);
        this.acceptEvent.fire(EventArg.EMPTY); 

    }

    public void cancel(MenuItem menuItem)
    {

        this.cancelEvent.fire(EventArg.EMPTY);
    }

    // </editor-fold>
}
