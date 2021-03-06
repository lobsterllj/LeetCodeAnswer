public class Trie {

    public static void main(String[] args) {

    }
    public class TN
    {
        Boolean isEnd;
        TN[] next;
        public TN()
        {
            isEnd = false;
            next=new TN[26];
        }
    }
    public TN root;
    public Trie() {
        root = new TN();

    }



    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TN curr = root;
        if (word.length() > 0) {
            for (int i = 0; i < word.length(); ++i) {
                int ch_int = word.charAt(i) - 'a';
                if (curr.next[ch_int] == null) {
                    curr.next[ch_int] = new TN();
                }
                curr = curr.next[ch_int];
            }
            curr.isEnd = true;
        }

    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TN curr = root;
        if (word.length() == 0) {
            return true;
        } else {
            for (int i = 0; i < word.length(); ++i) {
                int ch_int = word.charAt(i) - 'a';
                if (curr.next[ch_int] == null) {
                    return false;
                } else {
                    curr = curr.next[ch_int];
                }
            }
            return curr.isEnd;
        }

    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TN curr = root;
        if (prefix.length() == 0) {
            return true;
        } else {
            for (int i = 0; i < prefix.length(); ++i) {
                int ch_int = prefix.charAt(i) - 'a';
                if (curr.next[ch_int] == null) {
                    return false;
                }
                curr = curr.next[ch_int];
            }
            return true;
        }
    }
}

