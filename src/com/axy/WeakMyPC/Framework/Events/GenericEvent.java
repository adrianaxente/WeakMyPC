package com.axy.WeakMyPC.Framework.Events;

import java.util.LinkedList;

/**
 * Created by adrianaxente on 01.09.2014.
 */
public class GenericEvent<TEventListener extends IGenericEventListener<GenericEventArg<TOutputParam>, TOutputParam>, TOutputParam>
{
    private LinkedList<TEventListener> _listeners;

    public void addEventLister(TEventListener listener)
    {
        if (listener == null)
        {
            throw new NullPointerException("listener is null");
        }

        if (this._listeners == null)
        {
            this._listeners = new LinkedList<TEventListener>();
        }

        this._listeners.add(listener);
    }

    public void removeEventListener(TEventListener listener)
    {
        if (listener == null)
        {
            throw new NullPointerException("listener is null");
        }

        if (this._listeners == null)
        {
            return;
        }

        this._listeners.removeFirstOccurrence(listener);

        if (this._listeners.isEmpty())
        {
            this._listeners = null;
        }
    }

    public void fire(GenericEventArg<TOutputParam> arg)
    {
        if (arg == null)
        {
            throw new NullPointerException("arg is null");
        }

        for(TEventListener listener : this._listeners)
        {
            listener.execute(arg);
        }
    }
}
