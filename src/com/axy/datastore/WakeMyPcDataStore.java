package com.axy.datastore;

import com.axy.WeakMyPC.Models.ComputerModel;
import com.axy.WeakMyPC.Models.RootModel;
import com.axy.environment.ApplicationEnvironment;
import com.axy.presentation.model.observable.ObservableModel;
import com.axy.presentation.observable.colections.ListObservableWrapper;
import com.db4o.ObjectContainer;
import com.db4o.ext.ExtObjectContainer;

import java.util.List;

/**
 * Created by adrianaxente on 08.09.2014.
 */
public class WakeMyPcDataStore extends DB4ODataStore {

    private RootModel _root = null;

    public WakeMyPcDataStore(DB4OConfiguration configuration) throws IllegalArgumentException {

        super(configuration);

        RootModel.DbConfigure(this.getConfiguration().getDB4OConfiguration());
        ComputerModel.DbConfigure(this.getConfiguration().getDB4OConfiguration());
    }

    public RootModel getRoot()
    {
        if (this._root == null)
        {
            ObjectContainer container = ApplicationEnvironment.getInstance().getDataStore().getObjectContainer();
            ExtObjectContainer extContainer = container.ext();

            try
            {
                List<RootModel> roots = container.query(RootModel.class);
                this._root = roots != null && roots.size() > 0
                                ? roots.get(0)
                                : null;
            }
            catch (Exception ex)
            {
                //todo: log the exception
            }

            if (this._root == null)
            {
                this._root = new RootModel();
                extContainer.store(this._root);
                extContainer.commit();
            }
        }

        return this._root;
    }
}
