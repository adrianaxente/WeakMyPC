package com.axy.WeakMyPC.Database.Entities;

import com.db4o.config.EmbeddedConfiguration;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by adrianaxente on 29.08.2014.
 */
public class ComputerModel implements Serializable {

    // <editor-fold desc="Static Fields">

    public UUID Id;
    public String Name;
    public String IpAddress;
    public String MacAddress;
    public int Port;

    // </editor-fold>

    // <editor-fold desc="Constructor">

    protected ComputerModel()
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
    }

    // </editor-fold>
}
