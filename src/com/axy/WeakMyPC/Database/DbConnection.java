package com.axy.WeakMyPC.Database;

import android.content.Context;
import android.util.Log;
import com.axy.WeakMyPC.Misc.ApplicationContext;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

/**
 * Created by adrianaxente on 29.08.2014.
 */
public class DbConnection
{
    // <editor-fold description="Private Fields">

    private static ObjectContainer _objectContainer = null;

    // </editor-fold>

    // <editor-fold description="Constructor">

    private DbConnection()
    {
    }

    // </editor-fold>

    // <editor-fold description="Public Methods">

    public static ObjectContainer getObjectContainer()
    {
        try
        {
            if (_objectContainer == null || _objectContainer.ext().isClosed())
            {
                Context context = ApplicationContext.get();
                DbConfig dbConfig = new DbConfig();
                _objectContainer =
                        Db4oEmbedded.openFile(
                                dbConfig.getConfiguration(context),
                                dbConfig.getDatabasePath(context));
            }

            return _objectContainer;
        }
        catch (Exception ie)
        {
            Log.e(DbConnection.class.getName(), ie.toString());
            return null;
        }
    }

    // </editor-fold>
}
