public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            deque.addLast(c);
        }
        return deque;
    }

    public boolean isPalindrome(String word) {
        Deque d = this.wordToDeque(word);
        return isPalindrome(d);
    }

    private boolean isPalindrome(Deque d) {
        if (d.size() <= 1) {
            return true;
        }
        if (d.removeFirst() == d.removeLast()) {
            return isPalindrome(d);
        }
        return false;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque d = this.wordToDeque(word);
        return isPalindrome(d, cc);
    }

    private boolean isPalindrome(Deque d, CharacterComparator cc) {
        if (d.size() <= 1) {
            return true;
        }
        char x = (char) d.removeFirst();
        char y = (char) d.removeLast();
        if (cc.equalChars(x, y)) {
            return isPalindrome(d, cc);
        }
        return false;
    }
}
