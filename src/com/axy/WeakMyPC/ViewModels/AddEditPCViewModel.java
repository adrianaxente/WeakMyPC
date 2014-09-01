package com.axy.WeakMyPC.ViewModels;

//import javax.annotation.concurrent.ThreadSafe;

import android.view.MenuItem;
import com.axy.WeakMyPC.Database.DbConnection;
import com.axy.WeakMyPC.Database.Entities.ComputerModel;
import com.axy.WeakMyPC.Framework.Events.Event;
import com.axy.WeakMyPC.Framework.Events.EventArg;
import com.db4o.ObjectContainer;
import org.robobinding.aspects.PresentationModel;
import org.robobinding.presentationmodel.AbstractPresentationModel;

/**
 * Created by adrianaxente on 30.08.2014.
 */
@PresentationModel
public class AddEditPCViewModel
{
    // <editor-fold description="Fields">

    private ComputerModel _model;

    public final Event acceptEvent = new Event();

    public final Event cancelEvent = new Event();


    // </editor-fold>

    // <editor-fold description="Constructor">

    public AddEditPCViewModel(ComputerModel model) throws NullPointerException
    {
        super();

        if (model == null)
        {
            throw new NullPointerException();
        }

        this._model = model;
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
        return this._model.Id == null
                    ? "Add Computer"
                    : "Edit Computer";
    }

    // </editor-fold>

    // <editor-fold description="Actions">

    public void accept(MenuItem menuItem)
    {
        //todo: Add the validation

        ObjectContainer objContainer = DbConnection.getObjectContainer();
        objContainer.store(this._model);
        objContainer.commit();

        this.acceptEvent.fire(EventArg.EMPTY);

    }

    public void cancel(MenuItem menuItem)
    {
        this.cancelEvent.fire(EventArg.EMPTY);
    }

    // </editor-fold>
}
