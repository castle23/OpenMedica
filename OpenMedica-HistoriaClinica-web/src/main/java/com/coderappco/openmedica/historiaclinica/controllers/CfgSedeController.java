package com.coderappco.openmedica.historiaclinica.controllers;

import com.coderappco.openmedica.persistencia.CfgSede;
import com.coderappco.openmedica.historiaclinica.controllers.util.JsfUtil;
import com.coderappco.openmedica.historiaclinica.controllers.util.JsfUtil.PersistAction;
import com.coderappco.openmedica.historiamedica.iejb.ICfgSedeFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("cfgSedeController")
@SessionScoped
public class CfgSedeController implements Serializable {

    @EJB
    private ICfgSedeFacade ejbFacade;
    private List<CfgSede> items = null;
    private CfgSede selected;

    public CfgSedeController() {
    }

    public CfgSede getSelected() {
        return selected;
    }

    public void setSelected(CfgSede selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ICfgSedeFacade getFacade() {
        return ejbFacade;
    }

    public CfgSede prepareCreate() {
        selected = new CfgSede();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CfgSedeCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CfgSedeUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CfgSedeDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<CfgSede> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public CfgSede getCfgSede(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<CfgSede> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<CfgSede> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = CfgSede.class)
    public static class CfgSedeControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CfgSedeController controller = (CfgSedeController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "cfgSedeController");
            return controller.getCfgSede(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof CfgSede) {
                CfgSede o = (CfgSede) object;
                return getStringKey(o.getIdSede());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CfgSede.class.getName()});
                return null;
            }
        }

    }

}
