package com.sks.learn.microservices.currencyexchangeservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sks.learn.microservices.currencyexchangeservice.model.ExchangeValue;

@Repository
public interface ExchangeRepository extends JpaRepository<ExchangeValue, Long> {
	ExchangeValue findByFromCurrencyAndToCurrency(String fromCurrency, String toCurrency);
}
