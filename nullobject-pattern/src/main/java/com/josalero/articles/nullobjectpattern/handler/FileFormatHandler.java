package com.josalero.articles.nullobjectpattern.handler;

import java.util.Arrays;

import com.josalero.articles.nullobjectpattern.contract.FileFormat;
import com.josalero.articles.nullobjectpattern.factory.FileFormatFactory;


/**
 * 
 * @author josealeman
 *
 */
public class FileFormatHandler {

	public static void main(String args[]) {
		
		FileFormatHandler handler = new FileFormatHandler();
		
		handler.handle(Arrays.asList("xml: <xml/>", "json: {}", null));

	}

	public void handle(Iterable<String> contents) {
		for (String content : contents) {
			FileFormat format = FileFormatFactory.getFileFormatForContent(content);
			format.print(content);
		}
	}
}
