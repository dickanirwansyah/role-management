package com.arms.app.service;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arms.app.model.Log;
import com.arms.app.repository.LogRepository;
import com.arms.app.util.ConstantaVariable;

@Service
public class LogService {
@Autowired
private LogRepository logRepository;

private static final Logger LOGGER = LoggerFactory.getLogger(ConstantaVariable.LOG.UPLOADJOB);

public Log insertLog(String message) {
	Log log=new Log();
	log.setDtmCreate(new Date());
	log.setIp("0.0.0.0");
	log.setMac("abc.abc.abc");
	log.setUserId("user");
	log.setStatus(1);
	log.setMessage(message);
	return logRepository.save(log);
}

public Log insertLogError(String message) {
	LOGGER.debug("ERROR : " + message);
	Log log=new Log();
	log.setDtmCreate(new Date());
	log.setIp("0.0.0.0");
	log.setMac("abc.abc.abc");
	log.setUserId("user");
	log.setMessage(message);
	log.setStatus(2);
	return logRepository.save(log);
}
}
