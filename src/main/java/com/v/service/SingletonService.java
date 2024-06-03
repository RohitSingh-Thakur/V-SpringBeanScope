package com.v.service;

import org.springframework.stereotype.Service;

@Service
public class SingletonService {
	  public String getMessage() {
	        return "Singleton Service: " + this.hashCode();
	    }
}
