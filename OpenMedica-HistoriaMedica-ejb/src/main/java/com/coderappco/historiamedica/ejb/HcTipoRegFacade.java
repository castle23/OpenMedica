/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderappco.historiamedica.ejb;

import com.coderappco.openmedica.historiamedica.iejb.IHcTipoRegFacade;
import com.coderappco.openmedica.persistencia.HcTipoReg;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author carlos
 */
@Stateless
public class HcTipoRegFacade extends AbstractFacade<HcTipoReg> implements IHcTipoRegFacade{

    @PersistenceContext(unitName = "coderappcoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HcTipoRegFacade() {
        super(HcTipoReg.class);
    }
    
}
