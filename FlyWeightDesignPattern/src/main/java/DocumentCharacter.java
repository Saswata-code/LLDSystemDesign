// Immutable class
public class DocumentCharacter implements ILetter {

    private Character character;
    private String font;
    private int size;

    public DocumentCharacter(Character character, String font, int size) {
        this.character = character;
        this.font = font;
        this.size = size;
    }

    public Character getCharacter() {
        return character;
    }

    public String getFont() {
        return font;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void display(int x, int y) {
        // implement display
        System.out.println("Row: " + x + " Column: " + y + " Character is: " + this.character + " Font is: " + this.font + " Size is: " + this.size);
    }
}
