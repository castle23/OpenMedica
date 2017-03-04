/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderappco.historiamedica.ejb;

import com.coderappco.openmedica.historiamedica.iejb.IFacAdministradoraFacade;
import com.coderappco.openmedica.persistencia.FacAdministradora;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author carlos
 */
@Stateless
public class FacAdministradoraFacade extends AbstractFacade<FacAdministradora> implements IFacAdministradoraFacade{

    @PersistenceContext(unitName = "coderappcoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FacAdministradoraFacade() {
        super(FacAdministradora.class);
    }
    
}
