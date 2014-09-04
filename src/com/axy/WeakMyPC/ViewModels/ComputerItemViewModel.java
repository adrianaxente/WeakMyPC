package com.axy.WeakMyPC.ViewModels;

import com.axy.WeakMyPC.Database.Models.ComputerModel;
import com.axy.WeakMyPC.Framework.Events.EventArg;
import com.axy.WeakMyPC.Framework.Events.IEventListener;
import com.axy.WeakMyPC.Framework.Presentation.AbstractItemViewModel;
import org.robobinding.itempresentationmodel.AbstractItemPresentationModel;
import org.robobinding.itempresentationmodel.ItemPresentationModel;

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
