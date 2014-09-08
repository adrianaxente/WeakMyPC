package com.axy.WeakMyPC.Models;

import com.axy.misc.IGetObject;
import com.axy.presentation.observable.colections.ListObservableWrapper;
import com.db4o.config.EmbeddedConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adrianaxente on 08.09.2014.
 */
public class RootModel extends BaseModel<RootModel>
{
    private List<ComputerModel> _computers;

    private transient ListObservableWrapper<ComputerModel> _observableComputers;

    public ListObservableWrapper<ComputerModel> getComputers()
    {
        if (this._observableComputers == null)
        {
            this._observableComputers = new ListObservableWrapper<ComputerModel>(new IGetObject<List<ComputerModel>>() {
                @Override
                public List<ComputerModel> getObject() {
                    return RootModel.this.getInternalComputers();
                }
            });
        }

        return this._observableComputers;
    }

    protected List<ComputerModel> getInternalComputers()
    {
        if (this._computers == null)
        {
            this._computers = new ArrayList<ComputerModel>();
        }

        return this._computers;
    }

    public static void DbConfigure(EmbeddedConfiguration dbConfiguration)
    {
        //dbConfiguration.common().objectClass(ComputerModel.class).objectField("Id").indexed(true);
        dbConfiguration.common().objectClass(RootModel.class).cascadeOnUpdate(true);
        dbConfiguration.common().objectClass(RootModel.class).cascadeOnActivate(true);
        dbConfiguration.common().objectClass(RootModel.class).generateUUIDs(false);
    }
}
