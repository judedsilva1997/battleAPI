package com.got.battleAPI.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.got.battleAPI.model.Battle;

public interface BattleRepository extends CrudRepository<Battle, Integer> {

	
}
