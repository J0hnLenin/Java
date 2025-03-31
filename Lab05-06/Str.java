import java.util.Random;

public abstract class Str {
    public static String getRandomString(int leftBound, int rightBound, int length){
        Random random = new Random(); 
        return random.ints(leftBound, rightBound)
        .limit(length)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
    }
}
