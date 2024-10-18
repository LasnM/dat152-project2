/**
 * 
 */
package no.hvl.dat152.rest.ws.repository;

import org.springframework.data.repository.CrudRepository;

import no.hvl.dat152.rest.ws.model.Role;

import java.util.Set;

/**
 * 
 */
public interface RoleRepository extends CrudRepository<Role, Integer> {
	
	Role findByName(String name);
}
