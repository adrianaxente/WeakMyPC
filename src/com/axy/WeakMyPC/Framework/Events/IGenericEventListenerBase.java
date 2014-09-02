package com.axy.WeakMyPC.Framework.Events;

/**
 * Created by adrianaxente on 01.09.2014.
 */
public interface IGenericEventListenerBase<TEventArg extends GenericEventArg<TOutputParam>, TOutputParam>
{
    void execute(TEventArg arg);
}

