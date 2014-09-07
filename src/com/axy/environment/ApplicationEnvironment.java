package com.axy.environment;

import android.content.Context;
import com.axy.datastore.DB4OConfiguration;
import com.axy.datastore.DB4ODataStore;

/**
 * Created by adrianaxente on 08.09.2014.
 */
public class ApplicationEnvironment
{
    private static ApplicationEnvironment _instance;

    private final String DATABASE_FILE_NAME = "WakeMyPc.db4o";

    private DB4ODataStore _dataStore = null;

    private Context _applicationContext = null;

    private ApplicationEnvironment()
    {
    }

    public void init(Context context){
        if(_applicationContext == null){
            _applicationContext = context;
        }
    }

    public DB4ODataStore getDataStore()
    {
        if (_dataStore == null)
        {
            String dataBasePath = _applicationContext.getDir("data", 0) + "/" + DATABASE_FILE_NAME;
            DB4OConfiguration db4OConfiguration = new DB4OConfiguration(dataBasePath);
            this._dataStore = new DB4ODataStore(db4OConfiguration);
        }

        return  this._dataStore;
    }

    public static ApplicationEnvironment getInstance()
    {
        return _instance == null
                 ? (_instance = new ApplicationEnvironment())
                 : _instance;
    }
}
