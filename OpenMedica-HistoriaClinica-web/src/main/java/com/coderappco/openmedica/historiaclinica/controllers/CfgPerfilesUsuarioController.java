package com.coderappco.openmedica.historiaclinica.controllers;

import com.coderappco.openmedica.persistencia.CfgPerfilesUsuario;
import com.coderappco.openmedica.historiaclinica.controllers.util.JsfUtil;
import com.coderappco.openmedica.historiaclinica.controllers.util.JsfUtil.PersistAction;
import com.coderappco.openmedica.historiamedica.iejb.ICfgPerfilesUsuarioFacade;

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

@Named("cfgPerfilesUsuarioController")
@SessionScoped
public class CfgPerfilesUsuarioController implements Serializable {

    @EJB
    private ICfgPerfilesUsuarioFacade ejbFacade;
    private List<CfgPerfilesUsuario> items = null;
    private CfgPerfilesUsuario selected;

    public CfgPerfilesUsuarioController() {
    }

    public CfgPerfilesUsuario getSelected() {
        return selected;
    }

    public void setSelected(CfgPerfilesUsuario selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ICfgPerfilesUsuarioFacade getFacade() {
        return ejbFacade;
    }

    public CfgPerfilesUsuario prepareCreate() {
        selected = new CfgPerfilesUsuario();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CfgPerfilesUsuarioCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CfgPerfilesUsuarioUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CfgPerfilesUsuarioDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<CfgPerfilesUsuario> getItems() {
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

    public CfgPerfilesUsuario getCfgPerfilesUsuario(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<CfgPerfilesUsuario> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<CfgPerfilesUsuario> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = CfgPerfilesUsuario.class)
    public static class CfgPerfilesUsuarioControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CfgPerfilesUsuarioController controller = (CfgPerfilesUsuarioController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "cfgPerfilesUsuarioController");
            return controller.getCfgPerfilesUsuario(getKey(value));
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
            if (object instanceof CfgPerfilesUsuario) {
                CfgPerfilesUsuario o = (CfgPerfilesUsuario) object;
                return getStringKey(o.getIdPerfil());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CfgPerfilesUsuario.class.getName()});
                return null;
            }
        }

    }

}
