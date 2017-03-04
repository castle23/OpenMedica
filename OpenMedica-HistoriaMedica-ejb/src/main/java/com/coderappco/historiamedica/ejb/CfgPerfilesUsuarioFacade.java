/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderappco.historiamedica.ejb;

import com.coderappco.openmedica.historiamedica.iejb.ICfgPerfilesUsuarioFacade;
import com.coderappco.openmedica.persistencia.CfgPerfilesUsuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author carlos
 */
@Stateless
public class CfgPerfilesUsuarioFacade extends AbstractFacade<CfgPerfilesUsuario> implements ICfgPerfilesUsuarioFacade{

    @PersistenceContext(unitName = "coderappcoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CfgPerfilesUsuarioFacade() {
        super(CfgPerfilesUsuario.class);
    }
    
}
