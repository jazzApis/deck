package com.jazz.deck.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.jazz.deck.model.TaskModel;
import com.jazz.deck.resorces.PrinterController;
import com.jazz.deck.resorces.TaskController;

// @Order(Ordered.HIGHEST_PRECEDENCE)
@Component
public class PrinterTask {
	
	private static final Logger LOG = LoggerFactory.getLogger(PrinterTask.class);
	
    @Autowired
    private PrinterController printerController;
	
    @Autowired
    private TaskController taskController;
	
	@Scheduled(fixedDelay=15000)//15s
	public void print(){
		try {
			String printer = printerController.getSelected(); 
			TaskModel task = taskController.get(0);
			LOG.info("Printing " + task.getTitle() + " on " + printer);
			taskController.remove(0);
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
	}
	
	

}
