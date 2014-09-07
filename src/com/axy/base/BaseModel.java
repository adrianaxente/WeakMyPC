package com.axy.base;

import com.axy.WeakMyPC.Database.DbConnection;
import com.axy.presentation.model.observable.ObservableModel;
import com.db4o.ext.ObjectInfo;

/**
 * Created by adrianaxente on 06.09.2014.
 */
public abstract class BaseModel<TThis extends BaseModel<TThis>> extends ObservableModel<TThis>
{
    @Override
    public long getId()
    {
        ObjectInfo objectInfo = DbConnection.getObjectContainer().ext().getObjectInfo(this);
        return objectInfo != null ? objectInfo.getInternalID() : (long)0;
    }
}
