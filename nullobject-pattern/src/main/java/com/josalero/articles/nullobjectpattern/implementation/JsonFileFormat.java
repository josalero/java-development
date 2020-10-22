package com.josalero.articles.nullobjectpattern.implementation;

import com.josalero.articles.nullobjectpattern.contract.FileFormat;

public class JsonFileFormat implements FileFormat {

	public void print(String content) {
	
		System.out.println("Json Content " + content.substring("json:".length()));

	}

}
