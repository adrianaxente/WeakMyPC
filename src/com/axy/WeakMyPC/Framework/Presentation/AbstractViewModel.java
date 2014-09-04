package com.axy.WeakMyPC.Framework.Presentation;

import com.axy.WeakMyPC.Framework.Model.AbstractModel;
import com.axy.WeakMyPC.Framework.Events.IPropertyChangedListener;
import com.axy.WeakMyPC.Framework.Events.PropertyChangedEventArg;
import com.db4o.foundation.ArgumentNullException;
import org.robobinding.presentationmodel.AbstractPresentationModel;

/**
 * Created by adrianaxente on 04.09.2014.
 */
//todo: implement property maps
public abstract class AbstractViewModel<TModel extends AbstractModel<TModel>> extends AbstractPresentationModel implements IPropertyChangedListener<TModel>
{

    // <editor-fold description="Private Fields">

    private TModel _model;

    private TModel _backupModel;

    // </editor-fold>

    // <editor-fold description="Constructor">

    /**
     * Constructs an instance of the com.axy.WeakMyPC.Framework.Presentation.AbstractViewModel
     * @param model
     * @throws ArgumentNullException
     */
    public AbstractViewModel(TModel model) throws ArgumentNullException
    {
        super();

        if (model == null)
        {
            throw new ArgumentNullException("model");
        }

        this._model = model;
        this._model.propertyChangedEvent.addEventLister(this);
    }

    // </editor-fold>

    // <editor-fold description="Getters & Setters">

    public TModel getModel(){ return  this._model; }

    public boolean getIsInTransaction()
    {
        return this._backupModel != null;
    }

    // </editor-fold>

    // <editor-fold description="Public Methods">

    public void startTransaction()
    {
        this._backupModel = this._model;
        this._model = this._model.createClone();
    }

    public void commitTransaction()
    {
        this._backupModel.copyFrom(this._model);
        this._model = this._backupModel;
        this._backupModel = null;

        //todo: fire property changes if any
    }

    public void rollbackTransaction()
    {
        this._model = this._backupModel;
        this._backupModel = null;

        //todo: fire property changes if any
    }

    // </editor-fold>

    @Override
    public void execute(Object sender, PropertyChangedEventArg<TModel> arg)
    {
        if (sender != this) {
            this.refreshPresentationModel();
            //this.firePropertyChange(arg.getPropertyName());
        }
    }
}
