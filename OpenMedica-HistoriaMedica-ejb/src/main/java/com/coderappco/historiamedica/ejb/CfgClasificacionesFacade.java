/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderappco.historiamedica.ejb;

import com.coderappco.openmedica.historiamedica.iejb.ICfgClasificacionesFacade;
import com.coderappco.openmedica.persistencia.CfgClasificaciones;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author carlos
 */
@Stateless
public class CfgClasificacionesFacade extends AbstractFacade<CfgClasificaciones> implements ICfgClasificacionesFacade{

    @PersistenceContext(unitName = "coderappcoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CfgClasificacionesFacade() {
        super(CfgClasificaciones.class);
    }
    
}
