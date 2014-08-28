package com.axy.WeakMyPC.Database.Entities;

import com.db4o.config.EmbeddedConfiguration;

/**
 * Created by adrianaxente on 29.08.2014.
 */
public class Computer {

    // <editor-fold desc="Static Fields">

    public String Name;
    public String IpAddress;
    public String MacAddress;
    public int Port;

    // </editor-fold>

    // <editor-fold desc="Constructor">

    /**
     * Constructs and instance of the computer object
     * @param name
     */
    public Computer(String name)
    {
        this.Name = name;
    }

    /**
     * Constructs and instance of the computer object
     * @param name
     * @param ipAddress
     * @param macAddress
     * @param port
     */
    public Computer(String name, String ipAddress, String macAddress, int port)
    {
        this(name);
        this.IpAddress = ipAddress;
        this.MacAddress = macAddress;
        this.Port = port;
    }

    // </editor-fold>

    // <editor-fold desc="Static Methods">

    /**
     * Confiures the database for this entity
     * @param dbConfiguration
     */
    public static void DbConfigure(EmbeddedConfiguration dbConfiguration)
    {
        dbConfiguration.common().objectClass(Computer.class).objectField("Name").indexed(true);
        dbConfiguration.common().objectClass(Computer.class).cascadeOnUpdate(true);
        dbConfiguration.common().objectClass(Computer.class).cascadeOnActivate(true);
    }

    // </editor-fold>
}
