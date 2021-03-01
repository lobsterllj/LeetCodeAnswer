import java.util.LinkedList;
import java.util.List;

public class Solution {
    public tn root = new tn();

    public static void main(String[] args) {
        Solution aa = new Solution();
        char[][] board={{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};;
        String[] words={"oath","pea","eat","rain"};
        List<String> res=aa.findWs(board, words);
        for(String it:res)
        {
            System.out.println(it);
        }


    }

    public static class tn {
        boolean isEnd;
        tn[] next;
        String val;
        public tn() {
            isEnd = false;
            next = new tn[26];
            val="";
        }
    }

    public void insertTrie(String word, tn curr) {
        if (word.length() > 0) {
            for (int i = 0; i < word.length(); ++i) {
                int char2int = word.charAt(i) - 'a';
                if (curr.next[char2int] == null) {
                    curr.next[char2int] = new tn();
                }
                curr = curr.next[char2int];
            }
            curr.isEnd = true;
            curr.val=word;
        }
    }

    public boolean search(String word, tn curr) {
        if (word.length() == 0) {
            return true;
        } else {
            for (int i = 0; i < word.length(); ++i) {
                int char2int = word.charAt(i) - 'a';
                if (curr.next[char2int] == null) {
                    return false;
                } else {
                    curr = curr.next[char2int];
                }
            }
            return curr.isEnd;
        }
    }

    public boolean startwith(String word, tn curr) {
        if (word.length() == 0) {
            return true;
        } else {
            for (int i = 0; i < word.length(); ++i) {
                int char2int = word.charAt(i) - 'a';
                if (curr.next[char2int] == null) {
                    return false;
                }
                curr = curr.next[char2int];
            }
            return true;
        }
    }

    public List<String> findWs(char[][] board, String[] words) {
        List<String> res = new LinkedList<>();


        if (words.length != 0) {
            for (int i = 0; i < words.length; ++i) {
                insertTrie(words[i], root);
            }
            if (board.length != 0) {
                if (board[0].length != 0) {
                    int x_len = board.length;
                    int y_len = board[0].length;
                    boolean[][] visited=new boolean[x_len][y_len];
                    //回溯法查找是否存在以（i,j）处为首字母，并存在于words内的单词
                    for (int i = 0; i < x_len; ++i) {
                        for (int j = 0; j < y_len; ++j) {
                            inWords(board,visited,root,i,j,x_len,y_len,res);
                        }
                    }
                }
            }
        }
        return res;
    }

    public void inWords(char[][] board,boolean[][] visited, tn root, int x_index, int y_index, int x_len, int y_len, List<String> result) {
        if(x_index<0||x_index>=x_len||y_index<0||y_index>=y_len||visited[x_index][y_index])
        {
            return;
        }
        root=root.next[board[x_index][y_index]-'a'];
        if(root==null)
        {
            return;
        }
        visited[x_index][y_index]=true;
        if(root.isEnd)
        {
            result.add(root.val);
            root.isEnd=false;
        }
        inWords(board,visited,root,x_index+1,y_index,x_len,y_len,result);
        inWords(board,visited,root,x_index,y_index+1,x_len,y_len,result);
        inWords(board,visited,root,x_index-1,y_index,x_len,y_len,result);
        inWords(board,visited,root,x_index,y_index-1,x_len,y_len,result);
        visited[x_index][y_index]=false;

    }


}
