package com.axy.WeakMyPC.Framework.Events;

public class GenericEventArg<TSource> extends EventArg
{
    public TSource _source;

    public GenericEventArg()
    {
    }

    public GenericEventArg(TSource source)
    {
        this._source = source;
    }

    public TSource getSource() {return  this._source; }
}
