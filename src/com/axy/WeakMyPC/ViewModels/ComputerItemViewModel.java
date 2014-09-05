package com.axy.WeakMyPC.ViewModels;

import com.axy.WeakMyPC.Database.Models.ComputerModel;
import com.axy.presentation.events.EventArg;
import com.axy.presentation.events.IEventListener;
import com.axy.presentation.presentationModel.AbstractItemViewModel;

/**
 * Created by adrianaxente on 30.08.2014.
 */
public class ComputerItemViewModel extends AbstractItemViewModel<ComputerModel>
{
    public String getName()
    {
        ComputerModel model = this.getModel();
        return model != null ? model.getName() : "";
    }
}
