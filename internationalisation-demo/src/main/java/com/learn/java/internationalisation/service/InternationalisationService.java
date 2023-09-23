package com.learn.java.internationalisation.service;

import java.util.Currency;
import java.util.Locale;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

@Service
public class InternationalisationService {

	@SuppressWarnings("static-access")
	public void localeFormatDemo1(String lang, String country, String os) {

		System.out.println("Locale.getDefault: "+Locale.getDefault());

		Locale locale = new Locale(lang, country, os); //“en”, “USA”, “win”
		System.out.println("locale: "+locale);
		locale.setDefault(locale);
		System.out.println("locale.setDefault: "+locale.getDefault());
		System.out.println("locale.getCountry: "+locale.getCountry());
		System.out.println("locale.getDisplayCountry: "+locale.getDisplayCountry());
		System.out.println("locale.getLanguage: "+locale.getLanguage());
		System.out.println("locale.getDisplayLanguage: "+locale.getDisplayLanguage());
		System.out.println("locale.getVariant: "+locale.getVariant());
		System.out.println("locale.getDisplayVariant: "+locale.getDisplayVariant());
		System.out.println("locale.getDisplayName: "+locale.getDisplayName());
		System.out.println("locale.getISO3Country: "+locale.getISO3Country());
		System.out.println("locale.getISO3Language: "+locale.getISO3Language());
		Stream.of(locale.getISOCountries()).forEach(System.out::println);
		Stream.of(locale.getISOLanguages()).forEach(System.out::println);
		Stream.of(locale.getAvailableLocales()).forEach(System.out::println);
		
	}

	@SuppressWarnings("static-access")
	public void currencyFormatDemo1(String lang, String country, String os) {
		Locale locale = new Locale(lang, country, os); //“en”, “USA”, “win”
		Currency c = Currency.getInstance(locale); 
		System.out.println("c.getCurrencyCode: "+c.getCurrencyCode()); // INR
		System.out.println("c.getDisplayName: "+c.getDisplayName()); // Bharatıya Rupaiya
		System.out.println("c.getSymbol: "+c.getSymbol()); // //R type Indian rupee sign
		System.out.println("c.getNumericCode: "+c.getNumericCode()); // 356
		System.out.println("c.getDefaultFractionDigits: "+c.getDefaultFractionDigits());
		Stream.of(c.getAvailableCurrencies()).forEach(System.out::println);
	}

}
