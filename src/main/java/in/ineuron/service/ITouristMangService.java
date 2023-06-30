package in.ineuron.service;

import java.util.List;

import in.ineuron.model.Tourist;

public interface ITouristMangService {

	public String saveTouristData(Tourist tourist);

	public List<Tourist> fetchTouristsData();

	public Tourist findTouristById(Integer id);

	public String updateTouristDataByID(Tourist tourist);

	public String updateTouristBudgetById(Integer id, Float hikePer);

	public String deleteTouristById(Integer id);

}
