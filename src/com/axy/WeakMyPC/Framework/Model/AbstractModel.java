package com.axy.WeakMyPC.Framework.Model;

import com.axy.WeakMyPC.Database.DbConnection;
import com.axy.WeakMyPC.Framework.Events.PropertyChangedEvent;
import com.axy.WeakMyPC.Framework.Events.PropertyChangedEventArg;
import com.db4o.ext.ObjectInfo;
import com.db4o.foundation.ArgumentNullException;

/**
 * Created by adrianaxente on 03.09.2014.
 */
public abstract class AbstractModel<TThis extends AbstractModel<TThis>> implements Cloneable
{

    public transient PropertyChangedEvent<TThis> propertyChangedEvent = new PropertyChangedEvent<TThis>();

    public long getId()
    {

        //todo: find a better way to abstract the id, is too coupled with the db4o engine
        ObjectInfo objectInfo = DbConnection.getObjectContainer().ext().getObjectInfo(this);
        return objectInfo != null ? objectInfo.getInternalID() : 0;
    }

    /**
     * Copies the properties of teh source object into this object
     * @param source
     * @throws ArgumentNullException
     */
    public void copyFrom(TThis source) throws ArgumentNullException
    {
        if (source == null)
        {
            throw new ArgumentNullException("source");
        }
    }

    /**
     * Clones the object into a new instance
     * @return the cloned object
     */
    public TThis createClone()
    {
        try
        {
            return (TThis)this.clone();
        }
        catch (CloneNotSupportedException ex)
        {
            //todo: log the exception
            return null;
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }


    protected boolean RaisePropertyChanged(Object sender, String propertyName, Object oldValue, Object newValue)
    {
        if (oldValue != newValue) {
            this.propertyChangedEvent.fire(
                    sender,
                    new PropertyChangedEventArg<TThis>((TThis) this, propertyName, oldValue, newValue));
            return true;
        }

        return false;
    }
}
