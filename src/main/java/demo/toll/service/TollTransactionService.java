package demo.toll.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import demo.toll.domain.TollTransaction;

public interface TollTransactionService {

	List<TollTransaction> getAll(Integer page, Integer size, String orderBy);

	Collection<TollTransaction> getAllByVehicleSeqNumber(String vehicleSeqNumber);

	void create(TollTransaction transaction);

	void send(TollTransaction transaction);

	void calculateSummary();

	Optional<TollTransaction> getById(Long id);

	void update(TollTransaction transaction);

	void deleteById(Long id);


}
