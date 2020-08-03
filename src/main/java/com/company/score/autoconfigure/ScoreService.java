package com.company.score.autoconfigure;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ScoreService implements Score {

    private String filePath;
    private String delimeter;

    /**
     * Main method that finds score for each name
     * 
     * @return Map containing names as keys and scores for each name as values.
     */
    @Override
    public Map<String, Integer> findScores() throws IOException {
	List<String> names = readFile();
	Collections.sort(names);
	Map<String, Integer> scores = new LinkedHashMap<>();
	int position = 0;
	for (String name : names) {
	    scores.put(name, calculateScore(name) * ++position);
	}
	return scores;
    }

    /**
     * It iterates over each character and appends score and returns the total score
     * for a given name
     * 
     * @param name
     * @return total score
     */
    private int calculateScore(String name) {
	int score = 0;
	for (char c : name.toCharArray()) {
	    score = score + findPosition(c);
	}
	return score;
    }

    /**
     * Finds the position of a given char in the Alphabets. Returns the position
     * plus 1 since it's 1-based.
     * 
     * @param single char from a name
     * @return the position plus 1
     */
    private int findPosition(char c) {
	for (int i = 0; i < ALPHABETS.length; i++) {
	    if (c == ALPHABETS[i])
		return i + 1;
	}
	return -1;
    }

    /**
     * Reads the file, replaces double-quotes, seperates names through a delimeter.
     * 
     * @return names in a list.
     * @throws IOException
     */
    private List<String> readFile() throws IOException {
	return Files.readAllLines(Paths.get(filePath)).stream()
	    .map(line -> line.replaceAll("\"", "").split(this.delimeter))
	    .flatMap(arr -> Arrays.stream(arr)).collect(Collectors.toList());
    }

    public void setFilePath(String filePath) {
	this.filePath = filePath;
    }

    public void setDelimeter(String delimeter) {
	this.delimeter = delimeter;
    }

}
