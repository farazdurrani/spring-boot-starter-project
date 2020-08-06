package com.company.score.autoconfigure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "score")
public class ScoreProperties {
    private String filePath;
    private String delimiter;
    private boolean parallel;

    public String getFilePath() {
	return filePath;
    }

    public void setFilePath(String filePath) {
	this.filePath = filePath;
    }

    public String getDelimiter() {
	return delimiter;
    }

    @Value("${score.delimiter:,}")
    public void setDelimiter(String delimiter) {
	this.delimiter = delimiter;
    }

    public boolean isParallel() {
	return parallel;
    }

    public void setParallel(boolean parallel) {
	this.parallel = parallel;
    }
}
