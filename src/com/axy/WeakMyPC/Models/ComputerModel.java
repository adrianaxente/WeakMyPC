package com.axy.WeakMyPC.Models;

import com.db4o.config.EmbeddedConfiguration;

import java.io.Serializable;

/**
 * Created by adrianaxente on 29.08.2014.
 */
public class ComputerModel extends BaseModel<ComputerModel> implements Serializable {

    // <editor-fold desc="Static Fields">

    private String Name;
    private String IpAddress;
    private String MacAddress;
    private int Port;

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
        //dbConfiguration.common().objectClass(ComputerModel.class).objectField("Id").indexed(true);
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

    // <editor-fold desc="Getters & Setters">

    public String getName() {
        return Name;
    }

    public void setName(String newValue, Object sender) {
        String oldValue = this.Name;
        this.Name = newValue;
        this.RaisePropertyChanged(sender, "name", newValue, oldValue);
    }

    public String getIpAddress() {
        return IpAddress;
    }

    public void setIpAddress(String newValue, Object sender) {
        String oldValue = this.IpAddress;
        this.IpAddress = newValue;
        this.RaisePropertyChanged(sender, "ipAddress", newValue, oldValue);
    }

    public String getMacAddress() {
        return MacAddress;
    }

    public void setMacAddress(String newValue, Object sender) {
        String oldValue = this.MacAddress;
        this.MacAddress = newValue;
        this.RaisePropertyChanged(sender, "macAddress", newValue, oldValue);
    }

    public int getPort() {
        return Port;
    }

    public void setPort(int newValue, Object sender) {
        int oldValue = this.Port;
        this.Port = newValue;
        this.RaisePropertyChanged(sender, "port", newValue, oldValue);
    }

    // </editor-fold>
}
