package org.pdsw.pbt.registry;

import java.util.Optional;
import java.util.regex.*;
public class Registry {
    public RegisterResult registerVoter(Person p) {
    	Pattern patron = Pattern.compile("[^A-Za-z ]");
    	/**
    	 * Se verifica que el nombre solo este compuesto por letras.
    	 */
    	if( p.getName().length() < 15 ||p.getName().length() > 30 || patron.matcher(p.getName()).find() ){
    		return RegisterResult.INVALID_NAME;
    	}
    	if( p.getAge() < 18 ){
    		return RegisterResult.INVALID_AGE;
    	}
    	if( p.getAge() > 120 ){
    		return RegisterResult.PERSONDEAD;
    	}
    	if( p.getId() < 100000|| p.getId() > 999999999 ){
    		return RegisterResult.INVALID_ID;
    		
    	}
   
    	return RegisterResult.VALID;
    	
    	
        
    }

    public Optional<String> generateCertificate(Person person) {

    	Optional<String> certificate;
    	String certification = person.getName() + " is certicated.";
    	
    	if (registerVoter(person) == RegisterResult.VALID) {
    		//System.out.println(certification);
    		certificate = Optional.of(certification);
    	}else {
    		certificate = Optional.empty();
    	}
    	
    	return certificate;
    }
    	
    	
      
    
}