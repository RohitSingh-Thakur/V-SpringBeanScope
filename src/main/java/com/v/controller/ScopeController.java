package com.v.controller;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.v.service.PrototypeService;
import com.v.service.RequestService;
import com.v.service.SingletonService;

@RestController
public class ScopeController {

	@Autowired
	private SingletonService singletonService;

	@Autowired
	private ObjectProvider<PrototypeService> prototypeServiceProvider;

	@Autowired
	private RequestService requestService;

	@GetMapping("/scopes")
	public String getScopes() {
		PrototypeService prototypeService = prototypeServiceProvider.getObject();
		return singletonService.getMessage() + "\n" + prototypeService.getMessage() + "\n"
				+ requestService.getMessage();
	}

}

/*
 		When you inject an ObjectProvider for a bean, Spring gives you a special object that can get the actual bean when you ask for it. 
 		This special object is like a helper that gets the real bean only when you need it, instead of getting it right away.

		So, instead of getting the actual bean immediately, you get a helper object. When you want the real bean, you ask the helper, 
		and it gets it for you. This helps your application start faster and use less memory because it only creates beans when they're actually needed.


When you call a method like getObject() on the ObjectProvider, it internally performs the necessary operations to obtain the actual bean instance from the Spring application context.

Here's a simplified explanation of what happens when you call getObject():

1) You call getObject() on the ObjectProvider.
2) Behind the scenes, Spring's proxy object intercepts this call.
3) The proxy object checks if the actual bean instance has already been created. If it hasn't, it asks the Spring container to create it.
4) The Spring container then creates the bean instance if needed, based on its scope and other configuration.
5) Finally, the proxy object returns the actual bean instance to you.
In summary, the ObjectProvider acts as a bridge between your code and the Spring container, allowing you to lazily obtain bean instances only when necessary. 
This lazy initialization helps improve application performance and resource utilization.

*/


