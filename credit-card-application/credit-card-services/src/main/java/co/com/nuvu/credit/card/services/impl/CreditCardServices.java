package co.com.nuvu.credit.card.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.nuvu.credit.card.dto.CreditCardDTO;
import co.com.nuvu.credit.card.exception.CreditCardBusinessException;
import co.com.nuvu.credit.card.exception.CreditCardNotExistsExcepction;
import co.com.nuvu.credit.card.model.CreditCard;
import co.com.nuvu.credit.card.repository.ICreditCardRespository;
import co.com.nuvu.credit.card.services.ICreditCardServices;

@Service
public class CreditCardServices implements ICreditCardServices {

	@Autowired
	private ICreditCardRespository repository;

	@Autowired
	private ModelMapper mapper;

	@Override
	@Transactional(readOnly = true)
	public List<CreditCardDTO> findAll() {
		return repository.findAll().stream().map(creditCard -> mapper.map(creditCard, CreditCardDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public CreditCardDTO findById(String id) {

		if ((id == null) || id.isBlank()) {
			throw new CreditCardBusinessException("ID invalido");
		}

		CreditCard creditCard = repository.findById(id).orElseThrow(CreditCardNotExistsExcepction::new);
		return mapper.map(creditCard, CreditCardDTO.class);

	}

	@Override
	@Transactional
	public CreditCardDTO create(CreditCardDTO creditCard) {

		if (Objects.isNull(creditCard)) {
			throw new CreditCardBusinessException("Tarjeta de credito invalida");
		}

		CreditCard obj = repository.insert(mapper.map(creditCard, CreditCard.class));
		return mapper.map(obj, CreditCardDTO.class);

	}

	@Override
	@Transactional
	public CreditCardDTO update(CreditCardDTO creditCard) {

		if (Objects.isNull(creditCard)) {
			throw new CreditCardBusinessException("Tarjeta invalida");
		}

		if (Objects.isNull(creditCard.getId())) {
			throw new CreditCardBusinessException("ID de tarjeta invalido");
		}

		CreditCard obj = repository.save(mapper.map(creditCard, CreditCard.class));
		return mapper.map(obj, CreditCardDTO.class);

	}

	@Override
	@Transactional
	public void delete(String id) {

		if ((id == null) || id.isBlank()) {
			throw new CreditCardBusinessException("ID de tarjeta invalido");
		}

		CreditCard creditCard = repository.findById(id).orElseThrow(CreditCardNotExistsExcepction::new);
		repository.delete(creditCard);

	}

}
