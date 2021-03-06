/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.uva.qcdis.sdia.dao;

import java.util.List;
import nl.uva.qcdis.sdia.model.tosca.Credential;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author S. Koulouzis
 */
@Repository
public interface CredentialDAO extends MongoRepository<Credential, String> {

    List<Credential> findBycloudProviderName(String cloudProviderName);
}
