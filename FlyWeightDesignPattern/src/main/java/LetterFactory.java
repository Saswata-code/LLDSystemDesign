import java.util.HashMap;
import java.util.Map;

public class LetterFactory {

    private static Map<Character, DocumentCharacter> characterCache = new HashMap<>();

    public static DocumentCharacter createCharacter(Character character){

        if(characterCache.containsKey(character)){
            return characterCache.get(character);
        }
        else{
            DocumentCharacter documentCharacter = new DocumentCharacter(character,"ARIEL",20);
            characterCache.put(character,documentCharacter);
            return characterCache.get(character);
        }
    }
}
