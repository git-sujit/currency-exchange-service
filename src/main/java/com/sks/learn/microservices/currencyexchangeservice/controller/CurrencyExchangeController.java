package com.sks.learn.microservices.currencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sks.learn.microservices.currencyexchangeservice.dao.ExchangeRepository;
import com.sks.learn.microservices.currencyexchangeservice.model.ExchangeValue;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment env;

	@Autowired
	private ExchangeRepository exchangeRepo;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {

		ExchangeValue ev = new ExchangeValue();
		ev.setFromCurrency(from);
		ev.setToCurrency(to);
		ExchangeValue evFound = exchangeRepo.findByFromCurrencyAndToCurrency(from, to);

		evFound.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return evFound;
	}
}
