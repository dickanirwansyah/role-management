package com.arms.app.config;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.arms.app.util.ConstantaVariable;



@Component
public class StartUpInit {
	private static final Logger LOGGER = LoggerFactory.getLogger(StartUpInit.class);


  @PostConstruct
  public void init(){

	  
     // init code goes here
  }

}