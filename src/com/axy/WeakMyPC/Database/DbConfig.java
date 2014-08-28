package com.axy.WeakMyPC.Database;

import android.content.Context;
import com.axy.WeakMyPC.Database.Entities.Computer;
import com.db4o.Db4oEmbedded;
import com.db4o.config.EmbeddedConfiguration;

/**
 * Created by adrianaxente on 29.08.2014.
 */
public final class DbConfig
{
    private final String DATABASE_FILE_NAME = "WakeMyPc.db4o";

    public EmbeddedConfiguration getConfiguration(Context ctx)
    {
        EmbeddedConfiguration result = Db4oEmbedded.newConfiguration();
        Computer.DbConfigure(result);

        return result;
    }

    public String getDatabasePath(Context ctx)
    {
        return ctx.getDir("data", 0) + "/" + DATABASE_FILE_NAME;
    }
}
