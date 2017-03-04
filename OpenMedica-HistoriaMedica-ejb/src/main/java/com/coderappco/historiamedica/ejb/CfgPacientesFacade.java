/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderappco.historiamedica.ejb;

import com.coderappco.openmedica.historiamedica.iejb.ICfgPacientesFacade;
import com.coderappco.openmedica.persistencia.CfgPacientes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author carlos
 */
@Stateless
public class CfgPacientesFacade extends AbstractFacade<CfgPacientes> implements ICfgPacientesFacade{

    @PersistenceContext(unitName = "coderappcoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CfgPacientesFacade() {
        super(CfgPacientes.class);
    }
    
}
