package com.coderappco.openmedica.historiaclinica.controllers;

import com.coderappco.openmedica.persistencia.CfgMaestrosClasificaciones;
import com.coderappco.openmedica.historiaclinica.controllers.util.JsfUtil;
import com.coderappco.openmedica.historiaclinica.controllers.util.JsfUtil.PersistAction;
import com.coderappco.openmedica.historiamedica.iejb.ICfgMaestrosClasificacionesFacade;

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

@Named("cfgMaestrosClasificacionesController")
@SessionScoped
public class CfgMaestrosClasificacionesController implements Serializable {

    @EJB
    private ICfgMaestrosClasificacionesFacade ejbFacade;
    private List<CfgMaestrosClasificaciones> items = null;
    private CfgMaestrosClasificaciones selected;

    public CfgMaestrosClasificacionesController() {
    }

    public CfgMaestrosClasificaciones getSelected() {
        return selected;
    }

    public void setSelected(CfgMaestrosClasificaciones selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ICfgMaestrosClasificacionesFacade getFacade() {
        return ejbFacade;
    }

    public CfgMaestrosClasificaciones prepareCreate() {
        selected = new CfgMaestrosClasificaciones();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CfgMaestrosClasificacionesCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CfgMaestrosClasificacionesUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CfgMaestrosClasificacionesDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<CfgMaestrosClasificaciones> getItems() {
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

    public CfgMaestrosClasificaciones getCfgMaestrosClasificaciones(java.lang.String id) {
        return getFacade().find(id);
    }

    public List<CfgMaestrosClasificaciones> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<CfgMaestrosClasificaciones> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = CfgMaestrosClasificaciones.class)
    public static class CfgMaestrosClasificacionesControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CfgMaestrosClasificacionesController controller = (CfgMaestrosClasificacionesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "cfgMaestrosClasificacionesController");
            return controller.getCfgMaestrosClasificaciones(getKey(value));
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
            return key;
        }

        String getStringKey(java.lang.String value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof CfgMaestrosClasificaciones) {
                CfgMaestrosClasificaciones o = (CfgMaestrosClasificaciones) object;
                return getStringKey(o.getMaestro());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CfgMaestrosClasificaciones.class.getName()});
                return null;
            }
        }

    }

}
