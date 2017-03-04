/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderappco.historiamedica.ejb;

import com.coderappco.openmedica.historiamedica.iejb.ICfgCentroCostoFacade;
import com.coderappco.openmedica.persistencia.CfgCentroCosto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author carlos
 */
@Stateless
public class CfgCentroCostoFacade extends AbstractFacade<CfgCentroCosto> implements ICfgCentroCostoFacade{

    @PersistenceContext(unitName = "coderappcoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CfgCentroCostoFacade() {
        super(CfgCentroCosto.class);
    }
    
}
