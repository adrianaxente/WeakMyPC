package com.axy.Base;

import com.axy.WeakMyPC.Database.DbConnection;
import com.axy.presentation.model.AbstractModel;
import com.db4o.ext.ObjectInfo;

/**
 * Created by adrianaxente on 06.09.2014.
 */
public abstract class BaseModel<TThis extends BaseModel<TThis>> extends AbstractModel<TThis>
{
    @Override
    public long getId()
    {
        ObjectInfo objectInfo = DbConnection.getObjectContainer().ext().getObjectInfo(this);
        return objectInfo != null ? objectInfo.getInternalID() : 0;
    }
}
