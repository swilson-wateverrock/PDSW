package org.pdsw.pbt.registry;


import org.junit.Test;
import org.pdsw.pbt.PBTClassifier;

import static org.quicktheories.QuickTheory.qt;

import java.util.Optional;

import java.util.regex.*;
public class RegistryTest {

    @Test
    public void validateRegistryResult() {
    	Registry registry = new Registry();
    	PBTClassifier pbtClassifier = new PBTClassifier("validateRegistryResult");
        qt()
            .forAll(PersonGenerator.persons())
            .check(voter ->  {
            	Pattern patron = Pattern.compile("[^A-Za-z ]");
            	RegisterResult result = registry.registerVoter(voter);
            	if( voter.getName().length() < 15 || voter.getName().length() > 30 || patron.matcher(voter.getName()).find()){
            		pbtClassifier.collect("Invalid for vote");
            		return result == RegisterResult.INVALID_NAME;
            	}
            	if( voter.getAge() < 18 ){
            		pbtClassifier.collect("Invalid for vote");

            		return result == RegisterResult.INVALID_AGE;
            	}
            	if( voter.getAge() > 120 ){
            		pbtClassifier.collect("Invalid for vote");

            		return result == RegisterResult.PERSONDEAD;
            	}
            	if( voter.getId() < 100000 || voter.getId() > 999999999 ){
            		pbtClassifier.collect("Invalid for vote");

            		return result == RegisterResult.INVALID_ID;
            		
            	}else{
            		pbtClassifier.collect("Valid for vote");
            		return result == RegisterResult.VALID;
            	}
           
        
      
            });
        pbtClassifier.results();
    }

@Test
public void validateCertificate() {
		Registry registry = new Registry();
		PBTClassifier pbtClassifier = new PBTClassifier("validateRegistryResult");
        qt()
            .forAll(PersonGenerator.persons())
            .check(voter ->  {
            	 RegisterResult result = registry.registerVoter(voter);
	                Optional<String> certificate = registry.generateCertificate(voter);
	            	
	                if (result == RegisterResult.VALID) {
	                	pbtClassifier.collect("Certificate valid");
	                	return certificate.isPresent() == true;
	                }else {
	                	pbtClassifier.collect("Certificate invalid");
	                	return certificate.isPresent() == false;
	                }
	            });
        pbtClassifier.results();
    }
}