package main;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class ReadWithScanner {

	private static Path filePath;
	private final static Charset ENCODING = StandardCharsets.UTF_8;

	public ReadWithScanner(String string) {
		filePath = Paths.get(string);
	}

	public static void main(String args[]) throws IOException {
		ReadWithScanner readWithScanner = new ReadWithScanner(
				"/data/Programs/Programs/samplePrograms/main/aristacvpcommons.log");
		readWithScanner.processLineByLine();
		System.out.println("-------------------");
	}

	private void processWithRegex(String line) {
		String[] pattern = Pattern.compile("\\|").split(line);
		System.out.println(pattern.toString());

	}

	private void processLineByLine() throws IOException {
		try (Scanner sc = new Scanner(filePath, ENCODING.name())) {
			while (sc.hasNext()) {
				proccessLine(sc.nextLine());
				processWithRegex(sc.nextLine());
			}
		}
	}

	private void proccessLine(String line) {
		try (Scanner sc = new Scanner(line)) {
			sc.useDelimiter("\\|");
			if (sc.hasNext()) {
				LogFile logFile = new LogFile();
				logFile.setDate(sc.next().trim());
				logFile.setTime(sc.next().trim());
				logFile.setThreadName(sc.next().trim());
				logFile.setLogLevel(sc.next().trim());
				logFile.setMethodName(sc.next().trim());
				logFile.setLineNumber(sc.next().trim());
				logFile.setMessage(sc.next().trim());
				System.out.println(logFile.toString());
			} else
				System.out.println("Unable to process");
		}
	}

}
