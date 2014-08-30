package com.axy.WeakMyPC.ViewModels;

//import javax.annotation.concurrent.ThreadSafe;

import android.view.MenuItem;
import com.axy.WeakMyPC.Database.DbConnection;
import com.axy.WeakMyPC.Database.Entities.ComputerModel;
import com.axy.WeakMyPC.Interfaces.IAcceptCancelView;
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

   private IAcceptCancelView _acceptCancelActivity;

    // </editor-fold>

    // <editor-fold description="Constructor">

    public AddEditPCViewModel(ComputerModel model, IAcceptCancelView acceptCancelActivity) throws NullPointerException
    {
        super();

        if (model == null)
        {
            throw new NullPointerException();
        }

        this._model = model;
        this._acceptCancelActivity = acceptCancelActivity;

        acceptCancelActivity.setTitle(
                this._model.Id == null
                    ? "Add Computer"
                    : "Edit Computer");
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

    // </editor-fold>

    // <editor-fold description="Actions">

    public void accept(MenuItem menuItem)
    {
        //todo: Add the validation

        ObjectContainer objContainer = DbConnection.getObjectContainer();
        objContainer.store(this._model);
        objContainer.commit();

        if (this._acceptCancelActivity != null)
        {
            this._acceptCancelActivity.accept();
        }
    }

    public void cancel(MenuItem menuItem)
    {
        if (this._acceptCancelActivity != null)
        {
            this._acceptCancelActivity.cancel();
        }
    }

    // </editor-fold>
}
