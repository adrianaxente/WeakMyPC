package com.axy.datastore;

import android.util.Log;
import com.axy.misc.ICloseable;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ext.ExtObjectContainer;
import com.db4o.ext.ObjectInfo;
import com.db4o.foundation.NotImplementedException;

import java.util.List;

/**
 * Created by adrianaxente on 08.09.2014.
 */
public class DB4ODataStore implements IDataStore<Long>, ICloseable
{
    protected final DB4OConfiguration _configuration;

    private ObjectContainer _objectContainer = null;

    public DB4ODataStore(DB4OConfiguration configuration)
            throws IllegalArgumentException
    {
        if (configuration == null)
            throw new IllegalArgumentException("configuration is null");

        this._configuration = configuration;
    }

    @Override
    public <T> T store(T entity)
    {
        if (entity == null)
            throw new IllegalArgumentException("entity is null");

        ObjectContainer container = this.getObjectContainer();
        container.store(entity);
        container.commit();
        return  entity;
    }

    @Override
    public <T> T delete(T entity)
    {
        if (entity == null)
            throw new IllegalArgumentException("entity is null");

        ObjectContainer container = this.getObjectContainer();
        container.delete(entity);
        container.commit();

        return  entity;
    }

    @Override
    public <T> List<T> getAll()
    {
        return this.getObjectContainer().query().execute();
    }

    @Override
    public <T> T getById(Long id)
    {
        if (id == null || id == 0)
        {
            return null;
        }

        ExtObjectContainer extObjectContainer = this.getObjectContainer().ext();
        T result = (T)extObjectContainer.getByID(id.longValue());
        extObjectContainer.activate(result);

        return  result;
    }

    @Override
    public <T> Long getId(T entity)
    {
        ObjectInfo objectInfo = this.getObjectContainer().ext().getObjectInfo(entity);
        long result = objectInfo != null ? objectInfo.getInternalID() : (long)0;
        return new Long(result);
    }

    @Override
    public DB4OConfiguration getConfiguration() {
        return this._configuration;
    }

    @Override
    public void close() throws Exception {
        if (this._objectContainer != null && !this._objectContainer.ext().isClosed())
            this.getObjectContainer().close();

        this._objectContainer = null;
    }

    protected ObjectContainer getObjectContainer()
    {
        try
        {
            if (this._objectContainer == null || this._objectContainer.ext().isClosed())
            {
                this._objectContainer =
                        Db4oEmbedded.openFile(
                                this._configuration.getDB4OConfiguration(),
                                this._configuration.getConnectionString());
            }

            return this._objectContainer;
        }
        catch (Exception ie)
        {
            Log.e(DB4ODataStore.class.getName(), ie.toString());
            return null;
        }
    }
}
