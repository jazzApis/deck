package com.jazz.deck.resorces;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PrinterController {

	private static final Logger LOG = LoggerFactory.getLogger(PrinterController.class);
	private static final int DEFAULT_PRINTER = 0;
	
	private final List<String> printers = new ArrayList<>();
	private int printerId = DEFAULT_PRINTER;
	
	public PrinterController() {
		printers.add("Xerox");
		printers.add("HP DeskJet 5650");
		printers.add("PDF Creator");
	}
	
	public List<String> get() {
		return printers;
	}

	public String getSelected() {
		return printers.get(getPrinterId());
	}
	
	public int setSelected(String printer) {
		LOG.debug("Select printer " + printer);
		setPrinterId(printers.indexOf(printer));
		return getPrinterId();
	}
	
	private int getPrinterId() {
		return printerId;
	}

	private void setPrinterId(int printerId) {
		if (printerId >= 0 && printerId < printers.size()) {
			this.printerId = printerId;
		} else {
			LOG.error("Wrong printerId " + printerId);
		}
	}
}
