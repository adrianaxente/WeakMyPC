package com.axy.WeakMyPC.ViewModels;

import com.axy.WeakMyPC.Database.Models.ComputerModel;
import com.axy.events.ModelEventArgs;
import com.axy.presentation.events.*;
import org.robobinding.annotation.ItemPresentationModel;
import org.robobinding.aspects.PresentationModel;
import org.robobinding.presentationmodel.AbstractPresentationModel;
import org.robobinding.widget.adapterview.ItemClickEvent;

import java.util.List;

/**
 * Created by adrianaxente on 30.08.2014.
 */

public class ComputerListViewModel extends AbstractPresentationModel
{

    // <editor-fold description="Fields">

    private List<ComputerModel> _model;

    public final Event<ModelEventArgs<ComputerModel>> editEvent =
        new Event<ModelEventArgs<ComputerModel>>();

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
        ModelEventArgs<ComputerModel> args = new ModelEventArgs<ComputerModel>(this, computerModel);
        this.editEvent.fire(args);
    }

    // </editor-fold>
}
