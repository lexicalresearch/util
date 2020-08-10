package com.lexicalintelligence.util.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * This class consists of static methods that operate on files with defaults for
 * UTF-8 character encoding and error handling
 */
public class LexicalIO {
	/**
	 * Creates a buffering character-input stream that uses a UTF-8 charset encoder
	 * and a default replace action for malformed-input errors.
	 *
	 * @param name the system-dependent file name.
	 * 
	 * @return a new buffered writer with UTF-8 encoding
	 * 
	 * @throws IOException if an I/O error occurs opening the file
	 * 
	 * @see java.nio.charset.CharsetEncoder
	 * @see java.nio.charset.StandardCharsets#UTF_8
	 * @see java.nio.charset.CodingErrorAction#REPLACE
	 */
	public static BufferedWriter newBufferedWriter(String name) throws IOException {
		if (name.endsWith(".gz")) {
			return newGzipBufferedWriter(name);
		}
		return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(name), StandardCharsets.UTF_8.newEncoder()
				.onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE)));
	}

	private static BufferedWriter newGzipBufferedWriter(String name) throws IOException {
		return new BufferedWriter(new OutputStreamWriter(new GZIPOutputStream(new FileOutputStream(name)),
				StandardCharsets.UTF_8.newEncoder().onMalformedInput(CodingErrorAction.REPLACE)
						.onUnmappableCharacter(CodingErrorAction.REPLACE)));
	}

	/**
	 * Creates a buffering character-input stream that uses a UTF-8 charset decoder
	 * and a default replace action for malformed-input errors.
	 *
	 * @param name the system-dependent file name.
	 * 
	 * @return a new buffered reader with UTF-8 encoding
	 * @throws IOException
	 * 
	 * @see java.nio.charset.CharsetDecoder
	 * @see java.nio.charset.StandardCharsets#UTF_8
	 * @see java.nio.charset.CodingErrorAction#REPLACE
	 */
	public static BufferedReader newBufferedReader(String name) throws IOException {
		if (name.endsWith(".gz")) {
			return newGzipBufferedReader(name);
		}
		return newBufferedReader(new FileInputStream(name));
	}

	public static BufferedReader newBufferedReader(InputStream is) {
		return new BufferedReader(new InputStreamReader(is,
				StandardCharsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPLACE)));
	}

	public static BufferedReader newGzipBufferedReader(String name) throws IOException {
		return newGzipBufferedReader(new FileInputStream(name));
	}

	public static BufferedReader newGzipBufferedReader(InputStream is) throws IOException {
		return new BufferedReader(new InputStreamReader(new GZIPInputStream(is),
				StandardCharsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPLACE)));
	}

	private LexicalIO() {

	}

}
