package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.exception.TouristNotFoundException;
import in.ineuron.model.Tourist;
import in.ineuron.repo.ITouristRepo;

@Service
public class TouristMangServiceImpl implements ITouristMangService {

	@Autowired
	private ITouristRepo repo;

	@Override
	public String saveTouristData(Tourist tourist) {
		Integer tid = repo.save(tourist).getTid();
		return "Tourist Data is saved with id :: " + tid;
	}

	@Override
	public List<Tourist> fetchTouristsData() {
		List<Tourist> touristList = (List<Tourist>) repo.findAll();
		touristList.sort((t1, t2) -> t1.getTid().compareTo(t2.getTid()));
		return touristList;
	}

	@Override
	public Tourist findTouristById(Integer id) {
		return repo.findById(id)
				.orElseThrow(() -> new TouristNotFoundException("Tourist data is not found with this id " + id));
	}

	@Override
	public String updateTouristDataByID(Tourist tourist) {
		Optional<Tourist> info = repo.findById(tourist.getTid());
		if (info.isPresent()) {
			Tourist updatedInfo = repo.save(tourist);
			return "Tourist data is updated for the id " + updatedInfo.getTid();
		} else {
			throw new TouristNotFoundException("Tourist Data is not found with the given id " + tourist.getTid());
		}
	}

	@Override
	public String updateTouristBudgetById(Integer id, Float hikePer) {

		Optional<Tourist> touristInfo = repo.findById(id);
		if (touristInfo.isPresent()) {
			Tourist data = touristInfo.get();
			data.setBudget(data.getBudget() + (data.getBudget()) / 100);
			repo.save(data);
			return "Tourist Data is updated with id" + id;
		} else {
			throw new TouristNotFoundException("Tourist Data is not found with the given id " + id);
		}

	}

	@Override
	public String deleteTouristById(Integer id) {

		Optional<Tourist> touristInfo = repo.findById(id);
		if (touristInfo.isPresent()) {
			repo.delete(touristInfo.get());
			return "Tourist Data is deleted for id" + id;
		} else {
			throw new TouristNotFoundException("Tourist Data is not found with the given id " + id);
		}

	}

}
