package co.com.nuvu.credit.card.services.impl;

import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.nuvu.credit.card.exception.CreditCardBusinessException;
import co.com.nuvu.credit.card.properties.CreditCardProperties;
import co.com.nuvu.credit.card.services.ICreditCardEncriptServices;
import co.com.nuvu.person.commons.dto.PersonDTO;

@Service
public class CreditCardEncriptServices implements ICreditCardEncriptServices {

	@Autowired
	private CreditCardProperties properties;

	@Override
	public String encryptCreditCardNumber(PersonDTO person) {

		try {

			Cipher cipher = Cipher.getInstance(properties.getAlgorithm());

			byte[] key = getKey(
					person.getId() + properties.getSalt() + person.getDocument() + person.getCreditCard().getCvv());
			IvParameterSpec iv = new IvParameterSpec(key);
			SecretKeySpec keySpec = getSecretKey(key);

			cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);
			return Base64.getEncoder().encodeToString(
					cipher.doFinal(person.getCreditCard().getNumber().getBytes(StandardCharsets.UTF_8)));

		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException
				| BadPaddingException | InvalidAlgorithmParameterException e) {
			throw new CreditCardBusinessException(e.getMessage());
		}

	}

	@Override
	public String decriptCreditCardNumber(PersonDTO person) {

		try {

			Cipher cipher = Cipher.getInstance(properties.getAlgorithm());

			byte[] key = getKey(
					person.getId() + properties.getSalt() + person.getDocument() + person.getCreditCard().getCvv());
			IvParameterSpec iv = new IvParameterSpec(key);
			SecretKeySpec keySpec = getSecretKey(key);

			cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);
			return new String(cipher.doFinal(Base64.getDecoder().decode(person.getCreditCard().getNumber())));

		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException
				| BadPaddingException | InvalidAlgorithmParameterException e) {
			e.printStackTrace();
			throw new CreditCardBusinessException(e.getMessage());
		}

	}

	private byte[] getKey(String myKey) {
		MessageDigest sha = null;
		try {

			byte[] key = myKey.getBytes(StandardCharsets.UTF_8);

			sha = MessageDigest.getInstance("SHA-1");
			key = sha.digest(key);
			return Arrays.copyOf(key, 16);

		} catch (NoSuchAlgorithmException e) {
			throw new CreditCardBusinessException();
		}
	}

	private SecretKeySpec getSecretKey(byte[] key) {
		return new SecretKeySpec(key, "AES");
	}

}
