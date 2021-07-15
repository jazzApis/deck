package com.jazz.deck.resorces;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jazz.deck.model.PrinterModel;

@Repository
public class PrinterController {

	private static final Logger LOG = LoggerFactory.getLogger(PrinterController.class);
	
	private final List<PrinterModel> printers = new ArrayList<>();
	private PrinterModel printer;
	
	public PrinterController() {
		printers.add(new PrinterModel("Xerox", "Xerox Office HUB 1100"));
		printers.add(new PrinterModel("HP5650", "HP DeskJet 5650"));
		printers.add(new PrinterModel("PDF", "PDF Creator"));
		printer = printers.get(0); 
	}
	
	public List<PrinterModel> get() {
		return printers;
	}

	public PrinterModel get(String code) {
		final String normalized = PrinterModel.normalize(code);
		return printers.stream()
				.filter(printer -> printer.getCodeNormalized().equals(normalized))
				.findFirst()
				.orElse(null);		
	}
	public PrinterModel getSelected() {
		return printer;
	}
	
	public PrinterModel setSelected(String code) {
		PrinterModel selected = get(code); 
		if (selected != null) {
			printer = selected ;
		}
		return printer;
	}
}
