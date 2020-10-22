package com.josalero.articles.nullobjectpattern.factory;

import java.util.Optional;

import com.josalero.articles.nullobjectpattern.contract.FileFormat;
import com.josalero.articles.nullobjectpattern.implementation.JsonFileFormat;
import com.josalero.articles.nullobjectpattern.implementation.NullFileFormat;
import com.josalero.articles.nullobjectpattern.implementation.XmlFileFormat;

/**
 * 
 * @author josealeman
 *
 */
public final class FileFormatFactory {

	private FileFormatFactory() {

	}

	public static FileFormat getFileFormatForContent(String content) {

		if (Optional.ofNullable(content).isEmpty()) {
			return new NullFileFormat();
		}

		String format = content.contains("xml") ? "xml" : "json";

		switch (format) {
		case "xml":
			return new XmlFileFormat();
						
		case "json":
			return new JsonFileFormat();
			
		default:
			return new NullFileFormat();
		}
	}

}
