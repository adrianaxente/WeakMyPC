package com.axy.WeakMyPC.Framework.Events;

public class GenericEventArg<TOutput> extends EventArg
{
    public TOutput output;

    public GenericEventArg()
    {
    }

    public GenericEventArg(TOutput output)
    {
        this.output = output;
    }
}
