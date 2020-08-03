package com.company.score.autoconfigure;

import java.io.IOException;
import java.util.Map;

public interface Score {

    public static final char ALPHABETS[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
        'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

    public Map<String, Integer> findScores() throws IOException;

}
