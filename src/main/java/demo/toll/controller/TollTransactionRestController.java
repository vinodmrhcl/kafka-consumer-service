package demo.toll.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.toll.domain.TollTransaction;
import demo.toll.service.TollTransactionService;

@RestController
@RequestMapping("/transactions")
public class TollTransactionRestController {

	@Autowired
	private TollTransactionService transactionService;
	
	@GetMapping
	public Collection<TollTransaction> getAll() {
		return this.transactionService.getAll();
	}

	@GetMapping("/vehicle/{vehicleSeqNumber}")
	public Collection<TollTransaction> getAllByVehicleSeqNumber(String vehicleSeqNumber) {
		return this.transactionService.getAllByVehicleSeqNumber(vehicleSeqNumber);
	}

	@PostMapping
	public void create(@RequestBody TollTransaction transaction) {
		this.transactionService.create(transaction);
	}
	
	@PostMapping("/calcSum")
	public void calculateSummary() {
		this.transactionService.calculateSummary();
	}

	@GetMapping("/{id}")
	public TollTransaction getById(Long id) {
		return this.transactionService.getById(id).get();
	}
	
	@PutMapping
	public void update(@RequestBody TollTransaction transaction) {
		this.transactionService.update(transaction);
	}

	@DeleteMapping("/{id}")
	public void delete(Long id) {
		this.transactionService.deleteById(id);
	}

}