package com.shell.markethub.base.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.shell.markethub.base.util.config.BaseDataConstants;


public class BaseLogManager extends LogManager {	
	
	public BaseLogManager(String name){
		super();		
		//PropertyConfigurator.configure(BaseDataConstants.PROJECT_ROOT_LOCATION + BaseDataConstants.LOG_PROPERTIES_FILE);			
	}

}
