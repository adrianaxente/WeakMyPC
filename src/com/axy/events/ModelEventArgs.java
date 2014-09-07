package com.axy.events;

import com.axy.presentation.events.EventArgs;

/**
 * Created by adrianaxente on 07.09.2014.
 */
public class ModelEventArgs<TModel> extends EventArgs
{
    private TModel _model;

    public ModelEventArgs(TModel model) {
        this._model = model;
    }

    public ModelEventArgs(Object sender, TModel model)
    {
        super(sender);
        this._model = model;
    }

    public TModel getModel()
    {
        return _model;
    }
}
