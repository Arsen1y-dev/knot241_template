package lab6.num10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Collections;

public class GameState {
    private final String word;
    private final Set<Character> guessedLetters;
    private final List<Character> currentWordState;
    private int attemptsLeft;

    public GameState(String word, int maxAttempts) {
        this.word = word;
        this.guessedLetters = new HashSet<>();
        this.currentWordState = new ArrayList<>(Collections.nCopies(word.length(), '_'));
        this.attemptsLeft = maxAttempts;
    }

    public boolean guessLetter(char letter) {
        if (guessedLetters.contains(letter)) {
            return false;
        }
        guessedLetters.add(letter);
        return true;
    }

    public boolean isLetterInWord(char letter) {
        boolean found = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                currentWordState.set(i, letter);
                found = true;
            }
        }
        if (!found) {
            attemptsLeft--;
        }
        return found;
    }

    public boolean isWordGuessed() {
        return !currentWordState.contains('_');
    }

    public boolean isGameOver() {
        return attemptsLeft <= 0 || isWordGuessed();
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    public String getCurrentState() {
        StringBuilder state = new StringBuilder();
        for (char ch : currentWordState) {
            state.append(ch).append(" ");
        }
        return state.toString().trim();
    }
}
