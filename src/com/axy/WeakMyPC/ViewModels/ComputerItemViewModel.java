package com.axy.WeakMyPC.ViewModels;

import com.axy.WeakMyPC.Database.Entities.ComputerModel;
import org.robobinding.itempresentationmodel.ItemPresentationModel;

/**
 * Created by adrianaxente on 30.08.2014.
 */
public class ComputerItemViewModel implements ItemPresentationModel<ComputerModel>
{
    private ComputerModel _computerModel;
    private int _index;

    @Override
    public void updateData(int i, ComputerModel computerModel) {
        this._computerModel = computerModel;
        this._index = i;
    }

    public String getName()
    {
        return this._computerModel != null ? this._computerModel.Name : "";
    }
}
