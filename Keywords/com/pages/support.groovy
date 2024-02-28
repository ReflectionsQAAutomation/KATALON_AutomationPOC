package com.pages

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class support {
	@Keyword
	def  checkResponsiveAndClickToggle() {
		int aScreen = WebUI.getPageWidth()
		println(aScreen)
		if (aScreen < 1000) {
			println('Entered the resposive web ')
			WebUI.delay(5)
			println('before toggle ')
			try {
				WebUI.click(findTestObject('Page_Homepage/span_Hand Tools_navbar-toggler-icon'))
			} catch(Exception e) {
				println(e)
			}
			println('clicked toggle icon ')
			WebUI.delay(5)
		}
	}

	@Keyword
	def  nameGenerator(){
		def  adjs = [
			"autumn",
			"hidden",
			"bitter",
			"misty",
			"silent",
			"empty",
			"dry",
			"dark",
			"summer",
			"icy",
			"delicate",
			"quiet",
			"white",
			"cool",
			"spring",
			"winter",
			"patient",
			"twilight",
			"dawn",
			"crimson",
			"wispy",
			"weathered",
			"blue",
			"billowing",
			"broken",
			"cold",
			"damp",
			"falling",
			"frosty",
			"green",
			"long",
			"late",
			"lingering",
			"bold",
			"little",
			"morning",
			"muddy",
			"old",
			"red",
			"rough",
			"still",
			"small",
			"sparkling",
			"throbbing",
			"shy",
			"wandering",
			"withered",
			"wild",
			"black",
			"young",
			"holy",
			"solitary",
			"fragrant",
			"aged",
			"snowy",
			"proud",
			"floral",
			"restless",
			"divine",
			"polished",
			"ancient",
			"purple",
			"lively",
			"nameless"
		]

		def nouns = [
			"waterfall",
			"river",
			"breeze",
			"moon",
			"rain",
			"wind",
			"sea",
			"morning",
			"snow",
			"lake",
			"sunset",
			"pine",
			"shadow",
			"leaf",
			"dawn",
			"glitter",
			"forest",
			"hill",
			"cloud",
			"meadow",
			"sun",
			"glade",
			"bird",
			"brook",
			"butterfly",
			"bush",
			"dew",
			"dust",
			"field",
			"fire",
			"flower",
			"firefly",
			"feather",
			"grass",
			"haze",
			"mountain",
			"night",
			"pond",
			"darkness",
			"snowflake",
			"silence",
			"sound",
			"sky",
			"shape",
			"surf",
			"thunder",
			"violet",
			"water",
			"wildflower",
			"wave",
			"water",
			"resonance",
			"sun",
			"wood",
			"dream",
			"cherry",
			"tree",
			"fog",
			"frost",
			"voice",
			"paper",
			"frog",
			"smoke",
			"star"
		];

		return adjs[Math.floor(Math.random()*((adjs.size())-1))]+nouns[Math.floor(Math.random()*((nouns.size())-1))];
	}
}
