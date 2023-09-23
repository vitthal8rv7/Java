package com.learn.java.internationalisation.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.stream.Stream;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

@Service
public class InternationalisationService {

	@SuppressWarnings("static-access")
	public void localeFormatDemo1(String lang, String country, String os) {

		System.out.println("Locale.getDefault: " + Locale.getDefault());

		Locale locale = new Locale(lang, country, os); // “en”, “USA”, “win”
		System.out.println("locale: " + locale);
		locale.setDefault(locale);
		System.out.println("locale.setDefault: " + locale.getDefault());
		System.out.println("locale.getCountry: " + locale.getCountry());
		System.out.println("locale.getDisplayCountry: " + locale.getDisplayCountry());
		System.out.println("locale.getLanguage: " + locale.getLanguage());
		System.out.println("locale.getDisplayLanguage: " + locale.getDisplayLanguage());
		System.out.println("locale.getVariant: " + locale.getVariant());
		System.out.println("locale.getDisplayVariant: " + locale.getDisplayVariant());
		System.out.println("locale.getDisplayName: " + locale.getDisplayName());
		System.out.println("locale.getISO3Country: " + locale.getISO3Country());
		System.out.println("locale.getISO3Language: " + locale.getISO3Language());
		Stream.of(locale.getISOCountries()).forEach(System.out::println);
		Stream.of(locale.getISOLanguages()).forEach(System.out::println);
		Stream.of(locale.getAvailableLocales()).forEach(System.out::println);

	}

	@SuppressWarnings("static-access")
	public void currencyFormatDemo1(String lang, String country, String os) {
		Locale locale = new Locale(lang, country, os); // “en”, “USA”, “win”
		Currency c = Currency.getInstance(locale);
		System.out.println("c.getCurrencyCode: " + c.getCurrencyCode()); // INR
		System.out.println("c.getDisplayName: " + c.getDisplayName()); // Bharatıya Rupaiya
		System.out.println("c.getSymbol: " + c.getSymbol()); // //R type Indian rupee sign
		System.out.println("c.getNumericCode: " + c.getNumericCode()); // 356
		System.out.println("c.getDefaultFractionDigits: " + c.getDefaultFractionDigits());
		Stream.of(c.getAvailableCurrencies()).forEach(System.out::println);
	}

	public void numberFormatDemo1(String lang, String country, String os) {
		Locale locale = new Locale(lang, country, os); // “en”, “USA”, “win”

		NumberFormat nf1 = NumberFormat.getInstance();
		NumberFormat nf2 = NumberFormat.getNumberInstance();
		NumberFormat nf3 = NumberFormat.getCurrencyInstance();
		NumberFormat nf4 = NumberFormat.getPercentInstance();
		// Default Locale
		System.out.println("NumberFormat.getInstance(): " + nf1); // method to get normal number instance
		System.out.println("NumberFormat.getNumberInstance(): " + nf2);// method to get normal number instance
		System.out.println("NumberFormat.getCurrencyInstance(): " + nf3);// method to get currency number instance
		System.out.println("NumberFormat.getPercentInstance(): " + nf4);// method to get percentage number instance

		NumberFormat nf5 = NumberFormat.getInstance(locale);
		NumberFormat nf6 = NumberFormat.getNumberInstance(locale);
		NumberFormat nf7 = NumberFormat.getCurrencyInstance(locale);
		NumberFormat nf8 = NumberFormat.getPercentInstance(locale);
		// Custom Locale
		System.out.println("NumberFormat.getInstance(locale): " + nf5); // method to get normal number instance
		System.out.println("NumberFormat.getNumberInstance(locale): " + nf6);// method to get normal number instance
		System.out.println("NumberFormat.getCurrencyInstance(locale): " + nf7);// method to get currency number instance
		System.out.println("NumberFormat.getPercentInstance(locale): " + nf8);// method to get percentage number
																				// instance

		nf1.setMaximumFractionDigits(2);
		nf1.setMinimumFractionDigits(2);
		nf1.setMaximumIntegerDigits(3);
		nf1.setMinimumIntegerDigits(3);

		System.out.println("nf1.format(123456.7890): " + nf1.format(123456.7890));
		System.out.println("nf1.format(6.7): " + nf1.format(6.7));
		System.out.println("nf2.format(123456.7890): " + nf2.format(123456.7890));
		System.out.println("nf3.format(123456.7890): " + nf3.format(123456.7890));
		System.out.println("nf4.format(123456.7890): " + nf4.format(123456.7890));
		System.out.println("nf5.format(123456.7890): " + nf5.format(123456.7890));
		System.out.println("nf6.format(123456.7890): " + nf6.format(123456.7890));
		System.out.println("nf7.format(123456.7890): " + nf7.format(123456.7890));
		System.out.println("nf8.format(123456.7890): " + nf8.format(123456.7890));

		try {
			System.out.println("nf1.parse(\"123456.7890\"): " + nf1.parse("123456.7891"));
			System.out.println("nf2.parse(\"123456.7890\"): " + nf2.parse("123456.7892"));
//			System.out.println("nf3.parse(\"123456.7890\"): "+nf3.parse("$123456.7893")); //Rupee R sign required.
			System.out.println("nf4.parse(\"123456.7890\"): " + nf4.parse("123456.7894%"));
			System.out.println("nf5.parse(\"123456.7890\"): " + nf5.parse("123456.7895"));
			System.out.println("nf6.parse(\"123456.7890\"): " + nf6.parse("123456.7896"));
			System.out.println("nf7.parse(\"123456.7890\"): " + nf7.parse("$123456.7897"));
			System.out.println("nf8.parse(\"123456.7890\"): " + nf8.parse("123456.7898%"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void dateTimeFormatDemo1(String lang, String country, String os) {
		Locale locale = new Locale(lang, country, os); // “en”, “USA”, “win”
		DateFormat df1 = DateFormat.getInstance(); // method to get normal date instance
		DateFormat df2 = DateFormat.getDateInstance();// method to get normal date instance
		DateFormat df3 = DateFormat.getDateInstance(0);// method to get date instance with styles
		// within same country allowed diff date styles
		// DateFormat.FULL // 0 (integer value) // Friday, 10th September 2023
		// DateFormat.LONG // 1 (integer value) // 10th September 2023
		// DateFormat.MEDIUM // 2 (integer value) // 10th Sept 2023
		// DateFormat.SHORT // 3 (integer value) // 10 | 09 | 2023
		DateFormat df4 = DateFormat.getDateInstance(1, locale);// get date instance with styles and locale
		DateFormat df5 = DateFormat.getDateTimeInstance(); // method to get normal date and time instance
		DateFormat df6 = DateFormat.getDateTimeInstance(2, 0, locale); // date time as per locale

		// format() // convert java date to locale specific string
		System.out.println("df1.format(new Date()): " + df1.format(new Date()));
		System.out.println("df2.format(new Date()): " + df2.format(new Date()));
		System.out.println("df3.format(new Date()): " + df3.format(new Date()));
		df3 = DateFormat.getDateInstance(1);
		System.out.println("df3.format(new Date()): " + df3.format(new Date()));
		df3 = DateFormat.getDateInstance(2);
		System.out.println("df3.format(new Date()): " + df3.format(new Date()));
		df3 = DateFormat.getDateInstance(3);
		System.out.println("df3.format(new Date()): " + df3.format(new Date()));
		System.out.println("df4.format(new Date()): " + df4.format(new Date()));
		System.out.println("df5.format(new Date()): " + df5.format(new Date()));
		System.out.println("df6.format(new Date()): " + df6.format(new Date()));

		// parse() // convert locale specific string to java date
		try {
			System.out.println("df1.parse: " + df1.parse("23/09/23, 2:21 pm"));
			System.out.println("df2.parse: " + df2.parse("23-Sep-2023"));
			System.out.println("df3.parse: " + df3.parse("23/09/23"));
			System.out.println("df4.parse: " + df4.parse("September 23, 2023"));
			System.out.println("df5.parse: " + df5.parse("23-Sep-2023, 2:22:48 pm"));
			System.out.println("df6.parse: " + df6.parse("Sep 23, 2023, 2:22:48 PM India Standard Time"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void languageFormatDemo1(String lang, String country, String os) {
		Locale locale = Locale.getDefault();
		if ((!Strings.isBlank(lang)) && (!Strings.isBlank(country))) {
			System.out.println("US locale");
			locale = new Locale(lang, country); // “en”, “USA”, “win”
		}
//		File f = new File("resource/template/lang");
//		System.out.println("File Name: " + f.getPath() + f.getAbsolutePath() + f.getParentFile());
//		FileInputStream fis = null;
//		ResourceBundle resourceBundle = null;
//
//		try {
//			fis = new FileInputStream(
//					"/Users/vitthal/Documents/GitHub/Java/internationalisation-demo/src/main/resources/templates/lang.properties");
//			// new
//			// File("resource/template/lang"));//("resource/template/lang_en_US_win.properties");
//			System.out.println("Test: " + fis.getChannel().toString());
//			resourceBundle = new PropertyResourceBundle(fis);
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("Welcome in " + country + " is : " + resourceBundle.getString("Welcome"));
//		System.out.println("Locale: " + locale);
//		File file = new File("skyscrapper.properties");
//		URL[] urls = {file.toURI().toURL()};
//		ClassLoader loader = new URLClassLoader(urls);
		ResourceBundle resourceBundle2 = ResourceBundle.getBundle("a");
		System.out.println("Welcome in " + country + " is : " + resourceBundle2.getString("Welcome"));

	}

}
