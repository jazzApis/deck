package com.jazz.deck.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jazz.deck.exception.DeckException;
import com.jazz.deck.model.DeckResponseModel;
import com.jazz.deck.resorces.PrinterController;
import com.jazz.deck.resorces.TaskController;

@RestController
@RequestMapping("printer")
public class PrinterRestController {

    //////////////////////////////////////////////////////////////////////////////////////////////
    // Constructors
    //////////////////////////////////////////////////////////////////////////////////////////////
    public PrinterRestController() {
		super();
	}
    
    //////////////////////////////////////////////////////////////////////////////////////////////
    // Printer endpoints
    //////////////////////////////////////////////////////////////////////////////////////////////
    @Autowired
    private PrinterController printer;

    @RequestMapping(value="list", method=RequestMethod.GET)
    public DeckResponseModel printerList() {
    	try {
	    	return DeckResponseModel.builder()
	    			.withItems(printer.get())
	    			.build();
		} catch (Exception e) {
			return DeckResponseModel.builder()
					.withException(e)
					.build();
		}
    }

    @RequestMapping(value="", method=RequestMethod.GET)
    public DeckResponseModel printerSelected() {
    	try {
	    	return DeckResponseModel.builder()
	    			.withItem(printer.getSelected())
	    			.build();
		} catch (Exception e) {
			return DeckResponseModel.builder()
					.withException(e)
					.build();
		}
    }

    @RequestMapping(value="{name}", method=RequestMethod.PUT)
    public DeckResponseModel selectPrinter(final String name) {
    	try {
	    	return DeckResponseModel.builder()
	    			.withItem(printer.setSelected(name))
	    			.build();
		} catch (Exception e) {
			return DeckResponseModel.builder()
					.withException(e)
					.build();
		}
    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    // Printer endpoints
    //////////////////////////////////////////////////////////////////////////////////////////////
    @Autowired
    private TaskController task;

    @RequestMapping(value="tasks", method=RequestMethod.GET)
    public DeckResponseModel taskList() {
    	try {
	    	return DeckResponseModel.builder()
	    			.withItems(task.get())
	    			.build();
		} catch (Exception e) {
			return DeckResponseModel.builder()
					.withException(e)
					.build();
		}
    }

    @RequestMapping(value="{title}", method=RequestMethod.POST)
    public DeckResponseModel taskQueue(final String title, final @RequestBody String text) {
    	try {
    		return DeckResponseModel.builder()
    				.withItem(task.add(title, text))
    				.build();
    	} catch (DeckException e) {
    		return DeckResponseModel.builder()
    				.withException(e)
    				.build();
    	}
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public DeckResponseModel taskQueue(final @RequestBody String text) {
    	return taskQueue(null, text);
    }

    @RequestMapping(value="{taskId}", method=RequestMethod.DELETE)
    public DeckResponseModel removeTask(final Integer taskId) {
    	try {
    		return DeckResponseModel.builder()
    				.withItem(task.remove(taskId))
    				.build();
    	} catch (DeckException e) {
    		return DeckResponseModel.builder()
    				.withException(e)
    				.build();
    	}
    }
}
