package com.axy.WeakMyPC.Database;

import android.content.Context;
import android.util.Log;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

/**
 * Created by adrianaxente on 29.08.2014.
 */
public class DbConnection
{
    // <editor-fold description="Private Fields">

    private Context _context;
    private DbConfig _dbConfig;
    private ObjectContainer _objectContainer;

    // </editor-fold>

    // <editor-fold description="Constructor">

    public DbConnection(Context context, DbConfig dbConfig)
    {
        this._context = context;
        this._dbConfig = dbConfig;
    }

    // </editor-fold>

    // <editor-fold description="Public Methods">

    public ObjectContainer getObjectContainer()
    {
        try
        {
            if (this._objectContainer == null || this._objectContainer.ext().isClosed())
            {
                this._objectContainer =
                        Db4oEmbedded.openFile(
                                this._dbConfig.getConfiguration(this._context),
                                this._dbConfig.getDatabasePath(this._context));
            }
            return this._objectContainer;
        }
        catch (Exception ie)
        {
            Log.e(DbConnection.class.getName(), ie.toString());
            return null;
        }
    }

    // </editor-fold>
}
