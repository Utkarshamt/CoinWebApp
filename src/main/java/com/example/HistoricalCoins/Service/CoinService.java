package com.example.HistoricalCoins.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HistoricalCoins.Repo.CoinRepo;
import com.example.HistoricalCoins.model.Coin;


@Service
public class CoinService {
	
	@Autowired
	CoinRepo repo;

	public List<Coin> getAllCoins() {
		ArrayList<Coin> coinList = new ArrayList<>();
		repo.findAll().forEach(coin -> coinList.add(coin));
		
		return coinList;
	}
	
	public Coin getCoinById(Long id) {
		return repo.findById(id).get();
	}
	
	public boolean saveOrUpdateCoin(Coin coin) {
		Coin updatedObj = repo.save(coin);
		
		if (getCoinById(updatedObj.getId()) != null) {
			return true;
		}
		
		return false;
	}
	
	public boolean deleteCoin(Long id) {
		repo.deleteById(id);
		
		if (repo.findById(id).isEmpty()) {
			return true;
		}
		
		return false;
	}

}
