public class _58LengthLastWord {
    public int lengthOfLastWord(String s) {
        String words[] = s.split("\\s+");
        if(words.length<=1)return 0;
        return words[words.length-1].length();
    }
}
