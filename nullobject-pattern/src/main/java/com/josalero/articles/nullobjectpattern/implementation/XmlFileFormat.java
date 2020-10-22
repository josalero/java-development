package com.josalero.articles.nullobjectpattern.implementation;

import com.josalero.articles.nullobjectpattern.contract.FileFormat;

public class XmlFileFormat implements FileFormat {

	public void print(String content) {
	
		System.out.println("Xml Content " + content.substring("xml:".length()));

	}

}
