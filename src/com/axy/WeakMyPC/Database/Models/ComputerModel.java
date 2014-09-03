package com.axy.WeakMyPC.Database.Models;

import com.axy.WeakMyPC.Database.DbConnection;
import com.axy.WeakMyPC.Framework.Events.GenericEvent;
import com.axy.WeakMyPC.Framework.Events.PropertyChangedEvent;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.ext.ObjectInfo;

import java.io.Serializable;

/**
 * Created by adrianaxente on 29.08.2014.
 */
public class ComputerModel extends AbstractModel<ComputerModel> implements Serializable {

    // <editor-fold desc="Static Fields">

    public String Name;
    public String IpAddress;
    public String MacAddress;
    public int Port;

    // </editor-fold>

    // <editor-fold desc="Constructor">

    public ComputerModel()
    {
    }

    /**
     * Constructs and instance of the computer object
     * @param name
     * @param ipAddress
     * @param macAddress
     * @param port
     */
    public ComputerModel(String name, String ipAddress, String macAddress, int port)
    {
        this.Name = name;
        this.IpAddress = ipAddress;
        this.MacAddress = macAddress;
        this.Port = port;
    }

    // </editor-fold>

    // <editor-fold desc="Static Methods">

    /**
     * Configures the database for this entity
     * @param dbConfiguration
     */
    public static void DbConfigure(EmbeddedConfiguration dbConfiguration)
    {
        dbConfiguration.common().objectClass(ComputerModel.class).objectField("Id").indexed(true);
        dbConfiguration.common().objectClass(ComputerModel.class).cascadeOnUpdate(true);
        dbConfiguration.common().objectClass(ComputerModel.class).cascadeOnActivate(true);
        dbConfiguration.common().objectClass(ComputerModel.class).generateUUIDs(true);
    }

    /**
     * Copies the properties of teh source object into this object
     * @param source
     * @throws com.db4o.foundation.ArgumentNullException
     */
    @Override
    public void copyFrom(ComputerModel source) {
        super.copyFrom(source);
        this.Name = source.Name;
        this.IpAddress = source.IpAddress;
        this.MacAddress = source.MacAddress;
        this.Port = source.Port;
    }

    // </editor-fold>
}
