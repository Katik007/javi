package org.knit.solutions.lab5.n16;

import java.util.HashMap;
import java.util.Map;

public class CharacterFactory {
    private Map<Character, CharacterFlyweight> characterCache = new HashMap<>();

    public CharacterFlyweight getCharacter(char characterCode) {
        return characterCache.computeIfAbsent(characterCode, code -> new ConcreteCharacter(code));
    }

    public int getTotalCharactersCreated() {
        return characterCache.size();
    }
}
