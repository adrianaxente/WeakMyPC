package com.axy.datastore;

import com.axy.WeakMyPC.Models.ComputerModel;
import com.db4o.Db4oEmbedded;
import com.db4o.config.EmbeddedConfiguration;

/**
 * Created by adrianaxente on 08.09.2014.
 */
public class DB4OConfiguration implements IDataStoreConfiguration
{
    private String _databasePath;

    private final EmbeddedConfiguration _db4oConfiguration;

    public DB4OConfiguration(String _databasePath)
            throws IllegalArgumentException
    {
        if (_databasePath == null || _databasePath == "")
            throw new IllegalArgumentException("fileName");

        this._databasePath = _databasePath;

        this._db4oConfiguration = Db4oEmbedded.newConfiguration();
        //todo: move this to an external class
        ComputerModel.DbConfigure(this._db4oConfiguration);
    }

    @Override
    public String getConnectionString() {
        return this._databasePath;
    }

    public EmbeddedConfiguration getDB4OConfiguration()
    {
        return this._db4oConfiguration;
    }
}
