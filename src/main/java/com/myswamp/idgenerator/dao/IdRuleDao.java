package com.myswamp.idgenerator.dao;

import com.myswamp.idgenerator.domain.IdRule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdRuleDao extends JpaRepository<IdRule, Integer> {

    IdRule getByBusinessTag(String businessTag);
}