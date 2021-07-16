package com.jazz.deck.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.jazz.deck.model.TaskModel;
import com.jazz.deck.resorces.LogController;
import com.jazz.deck.resorces.TaskController;

// @Order(Ordered.HIGHEST_PRECEDENCE)
@Component
public class PrinterTask {
	
	private static final Logger LOG = LoggerFactory.getLogger(PrinterTask.class);
	
    @Autowired
    private TaskController taskController;
	
    @Autowired
    private LogController logController;
	
	@Scheduled(fixedDelay=15000)//15s
	public void print(){
		try {
			TaskModel task = taskController.getFirst();
			if (task != null) {
				LOG.info("Printing " + task.getTitle() + " on " + task.getPrinter());
				taskController.remove(task);
				logController.set("PRINT", task.getTitle());
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
	}
}
