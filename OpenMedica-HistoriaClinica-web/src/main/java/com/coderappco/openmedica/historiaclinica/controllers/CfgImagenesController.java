package com.coderappco.openmedica.historiaclinica.controllers;

import com.coderappco.openmedica.persistencia.CfgImagenes;
import com.coderappco.openmedica.historiaclinica.controllers.util.JsfUtil;
import com.coderappco.openmedica.historiaclinica.controllers.util.JsfUtil.PersistAction;
import com.coderappco.openmedica.historiamedica.iejb.ICfgImagenesFacade;

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

@Named("cfgImagenesController")
@SessionScoped
public class CfgImagenesController implements Serializable {

    @EJB
    private ICfgImagenesFacade ejbFacade;
    private List<CfgImagenes> items = null;
    private CfgImagenes selected;

    public CfgImagenesController() {
    }

    public CfgImagenes getSelected() {
        return selected;
    }

    public void setSelected(CfgImagenes selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ICfgImagenesFacade getFacade() {
        return ejbFacade;
    }

    public CfgImagenes prepareCreate() {
        selected = new CfgImagenes();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CfgImagenesCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CfgImagenesUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CfgImagenesDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<CfgImagenes> getItems() {
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

    public CfgImagenes getCfgImagenes(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<CfgImagenes> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<CfgImagenes> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = CfgImagenes.class)
    public static class CfgImagenesControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CfgImagenesController controller = (CfgImagenesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "cfgImagenesController");
            return controller.getCfgImagenes(getKey(value));
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
            if (object instanceof CfgImagenes) {
                CfgImagenes o = (CfgImagenes) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CfgImagenes.class.getName()});
                return null;
            }
        }

    }

}
