package in.ineuron.repo;

import org.springframework.data.repository.CrudRepository;

import in.ineuron.model.Tourist;

public interface ITouristRepo extends CrudRepository<Tourist, Integer> {

}
