package com.axy.WeakMyPC.ViewModels;

import com.axy.WeakMyPC.Database.Entities.ComputerModel;
import com.axy.WeakMyPC.Framework.Events.*;
import com.db4o.ext.Db4oUUID;
import org.robobinding.annotation.ItemPresentationModel;
import org.robobinding.aspects.PresentationModel;
import org.robobinding.widget.adapterview.ItemClickEvent;

import java.util.List;

/**
 * Created by adrianaxente on 30.08.2014.
 */
@PresentationModel
public class ComputerListViewModel
{

    // <editor-fold description="Fields">

    private List<ComputerModel> _model;

    public final GenericEvent<ComputerModel> editEvent = new GenericEvent<ComputerModel>();

    // </editor-fold>

    // <editor-fold description="Constructor">

    public ComputerListViewModel(List<ComputerModel> model) throws NullPointerException
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

    @ItemPresentationModel(ComputerItemViewModel.class)
    public List<ComputerModel> getComputerList()
    {
        return this._model;
    }

    // </editor-fold>

    // <editor-fold description="Actions">

    public void editComputer(ItemClickEvent event) {
        ComputerModel computerModel =  this._model.get(event.getPosition());
        GenericEventArg<ComputerModel> args = new GenericEventArg<ComputerModel>(computerModel);
        this.editEvent.fire(args);
    }

    // </editor-fold>
}
