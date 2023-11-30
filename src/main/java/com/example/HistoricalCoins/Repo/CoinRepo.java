package com.example.HistoricalCoins.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.HistoricalCoins.model.Coin;

@Repository
public interface CoinRepo extends JpaRepository<Coin, Long>{

}
