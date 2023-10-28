public class Main {
    public static void main(String[] args) {
        System.out.println(reverseSubString("abd(jnb)asdf",0));
        System.out.println(reverseSubString("abdjnbasdf",0));
        System.out.println(reverseSubString("dd(df)a(ghhh)",0));

    }

    public static String reverseSubString(String text, int lastIndex) {
        StringBuilder replacement = new StringBuilder();
        int startIndex = text.indexOf('(', lastIndex);
        int endIndex = text.indexOf(')', startIndex);

        if (endIndex != -1) {
            StringBuilder tmp = new StringBuilder(text.substring(startIndex + 1, endIndex));
            System.out.println("tmp = "+tmp);
            tmp.reverse();
            replacement.append(tmp);

            // Create a StringBuilder to build the new text
            StringBuilder newText = new StringBuilder();

            // Append the text before the opening parenthesis
            newText.append(text, 0, startIndex+1);

            // Append the reversed substring
            newText.append(replacement);

            // Append the text after the closing parenthesis
            newText.append(text, endIndex, text.length());

            text = newText.toString();

            if (text.indexOf('(', endIndex) != -1) {
                return reverseSubString(text, endIndex);
            }
        }

        return text;
    }
}