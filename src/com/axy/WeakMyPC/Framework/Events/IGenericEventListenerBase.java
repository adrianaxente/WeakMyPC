package com.axy.WeakMyPC.Framework.Events;

/**
 * Created by adrianaxente on 01.09.2014.
 */
public interface IGenericEventListenerBase<TSource, TEventArg extends GenericEventArg<TSource>>
{
    void execute(TEventArg arg);
}

