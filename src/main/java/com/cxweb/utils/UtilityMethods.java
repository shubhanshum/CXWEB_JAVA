package com.cxweb.utils;

import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;

public class UtilityMethods {

	public static int generateRandomNumber(int min, int max) {
		int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		return randomNum;
	}

	public static String getTimeStamp() {
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new java.util.Date());
		return timeStamp;
	}

	public static String getMailcatcherOtp() {
		String otp = "";
		HttpClient client = new DefaultHttpClient();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		HttpGet exeRequest = new HttpGet(UtilityMethods.getPropFileData("mailcatcher")+"/messages");
		try {
			HttpResponse response = client.execute(exeRequest);
			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
			String output = "";
			int lenOfMails = 0;
			while ((output = br.readLine()) != null) {
				JSONArray array = new JSONArray(output);
				lenOfMails = array.length();
				HttpGet exeRequest1 = new HttpGet(
						UtilityMethods.getPropFileData("mailcatcher")+"/messages/" + lenOfMails + ".plain");
				HttpResponse response1 = client.execute(exeRequest1);
				BufferedReader br1 = new BufferedReader(new InputStreamReader((response1.getEntity().getContent())));
				String output1 = "";
				while ((output1 = br1.readLine()) != null) {
					String[] arrOfStr = output1.split("is:");
					if (arrOfStr.length == 2) {
						otp = arrOfStr[1].trim();
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return otp;
	}
	
	public static String getPropFileData(String strKey) {
		FileInputStream fileInputStream = null;
		String value = "";
		if (fileInputStream == null) {
			try {
				fileInputStream = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//com//cxweb//config//TestData.properties");
				Properties properties = new Properties();
				properties.load(fileInputStream);
				value = properties.getProperty(strKey);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return value;
	};

}
