package com.axy.WeakMyPC.ViewModels;

import com.axy.WeakMyPC.Database.Models.ComputerModel;
import com.axy.WeakMyPC.Framework.Events.EventArg;
import com.axy.WeakMyPC.Framework.Events.IEventListener;
import org.robobinding.itempresentationmodel.AbstractItemPresentationModel;
import org.robobinding.itempresentationmodel.ItemPresentationModel;

/**
 * Created by adrianaxente on 30.08.2014.
 */
public class ComputerItemViewModel extends AbstractItemPresentationModel<ComputerModel>
{
    private ComputerModel _computerModel;
    private int _index;

    @Override
    protected void doUpdateData(int i, ComputerModel computerModel) {
        this._computerModel = computerModel;
        this._index = i;
        /*this._computerModel.changedEvent.addEventLister(new IEventListener() {
            @Override
            public void execute(EventArg arg) {
                ComputerItemViewModel.this.firePropertyChange("name");
            }
        });*/
    }

    public String getName()
    {
        return this._computerModel != null ? this._computerModel.Name : "";
    }
}
