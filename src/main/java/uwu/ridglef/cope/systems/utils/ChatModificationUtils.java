package uwu.ridglef.cope.systems.utils;

public class ChatModificationUtils {
    public static String setEmojis(String input){
        String part = input;
        part = part.replace(":skull:", "☠");
        part = part.replace(":meteor:", "☄");
        part = part.replace(":fire:", "🔥");
        part = part.replace(":check:", "✓");
        return part;
    }
}
