package com.lexicalintelligence.util.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;

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
	 * @see java.nio.charset.CharsetDecoder
	 * @see java.nio.charset.StandardCharsets#UTF_8
	 * @see java.nio.charset.CodingErrorAction#REPLACE
	 */
	public static BufferedWriter newBufferedWriter(String name) throws FileNotFoundException {
		return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(name), StandardCharsets.UTF_8.newEncoder()
				.onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE)));
	}

	/**
	 * Creates a buffering character-input stream that uses a UTF-8 charset decoder
	 * and a default replace action for malformed-input errors.
	 *
	 * @param name the system-dependent file name.
	 * 
	 * @see java.nio.charset.CharsetEncoder
	 * @see java.nio.charset.StandardCharsets#UTF_8
	 * @see java.nio.charset.CodingErrorAction#REPLACE
	 */
	public static BufferedReader newBufferedReader(String name) throws FileNotFoundException {
		return new BufferedReader(new InputStreamReader(new FileInputStream(name),
				StandardCharsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPLACE)));
	}
}
