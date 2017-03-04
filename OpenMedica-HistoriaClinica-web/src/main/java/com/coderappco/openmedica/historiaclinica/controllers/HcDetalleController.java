package com.coderappco.openmedica.historiaclinica.controllers;

import com.coderappco.openmedica.persistencia.HcDetalle;
import com.coderappco.openmedica.historiaclinica.controllers.util.JsfUtil;
import com.coderappco.openmedica.historiaclinica.controllers.util.JsfUtil.PersistAction;
import com.coderappco.openmedica.historiamedica.iejb.IHcDetalleFacade;

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

@Named("hcDetalleController")
@SessionScoped
public class HcDetalleController implements Serializable {

    @EJB
    private IHcDetalleFacade ejbFacade;
    private List<HcDetalle> items = null;
    private HcDetalle selected;

    public HcDetalleController() {
    }

    public HcDetalle getSelected() {
        return selected;
    }

    public void setSelected(HcDetalle selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getHcDetallePK().setIdCampo(selected.getHcCamposReg().getIdCampo());
        selected.getHcDetallePK().setIdRegistro(selected.getHcRegistro().getIdRegistro());
    }

    protected void initializeEmbeddableKey() {
        selected.setHcDetallePK(new com.coderappco.openmedica.persistencia.HcDetallePK());
    }

    private IHcDetalleFacade getFacade() {
        return ejbFacade;
    }

    public HcDetalle prepareCreate() {
        selected = new HcDetalle();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("HcDetalleCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("HcDetalleUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("HcDetalleDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<HcDetalle> getItems() {
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

    public HcDetalle getHcDetalle(com.coderappco.openmedica.persistencia.HcDetallePK id) {
        return getFacade().find(id);
    }

    public List<HcDetalle> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<HcDetalle> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = HcDetalle.class)
    public static class HcDetalleControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            HcDetalleController controller = (HcDetalleController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "hcDetalleController");
            return controller.getHcDetalle(getKey(value));
        }

        com.coderappco.openmedica.persistencia.HcDetallePK getKey(String value) {
            com.coderappco.openmedica.persistencia.HcDetallePK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.coderappco.openmedica.persistencia.HcDetallePK();
            key.setIdRegistro(Integer.parseInt(values[0]));
            key.setIdCampo(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(com.coderappco.openmedica.persistencia.HcDetallePK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdRegistro());
            sb.append(SEPARATOR);
            sb.append(value.getIdCampo());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof HcDetalle) {
                HcDetalle o = (HcDetalle) object;
                return getStringKey(o.getHcDetallePK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), HcDetalle.class.getName()});
                return null;
            }
        }

    }

}
