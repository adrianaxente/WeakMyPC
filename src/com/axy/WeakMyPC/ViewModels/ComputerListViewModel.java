package com.axy.WeakMyPC.ViewModels;

import com.axy.WeakMyPC.Database.Entities.ComputerModel;
import org.robobinding.annotation.ItemPresentationModel;
import org.robobinding.aspects.PresentationModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adrianaxente on 30.08.2014.
 */
@PresentationModel
public class ComputerListViewModel
{

    // <editor-fold description="Fields">

    private List<ComputerModel> _model;

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
}
