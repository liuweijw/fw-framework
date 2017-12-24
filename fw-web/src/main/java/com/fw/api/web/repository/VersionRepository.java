package com.fw.api.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.fw.api.web.domain.Version;

public interface VersionRepository extends JpaRepository<Version, Long>, QueryDslPredicateExecutor<Version> {

	Version findByType(Integer type);
}
