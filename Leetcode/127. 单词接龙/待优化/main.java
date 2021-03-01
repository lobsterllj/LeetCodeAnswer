import java.util.*;

public class main {
    public static void main(String[] args) {
        main main = new main();
//        String beginWord = "a";
//        String endWord = "c";
//        String[] word=new String[]{"a","b","c"};
        String beginWord = "hit";
        String endWord = "cog";
        String[] word=new String[]{"hot","dot","dog","lot","log","cog"};
        List<String> wordList=Arrays.asList(word);
        System.out.println(main.ladderLength(beginWord,endWord,wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() == 0 || !wordList.contains(endWord)) {
            return 0;
        }
        Queue<String> to_search=new LinkedList();
        Queue<String> layer_last_queue=new LinkedList();
        boolean[] isVisited=new boolean[wordList.size()];

        to_search.add(beginWord);
        int distance=1;

        String layer_last_string;
        while (!to_search.isEmpty()){

            //System.out.println(to_search);
            for(int j = to_search.size(); j > 0; --j)
            //for(int k = 0; k < to_search.size(); ++k)
                {
                String cache=to_search.poll();
//                System.out.println("出队点:" + cache + " 出队点distance:" + distance);

                for (int i = 0; i < wordList.size(); ++i) {
                    if (!isVisited[i] && isLinked(cache, wordList.get(i))) {
                        //System.out.println("cache:"+cache);
//                        System.out.println("邻接点:" + wordList.get(i));
                        layer_last_string = wordList.get(i);
                        if (wordList.get(i).equals(endWord)) {
                            return distance + 1;
                        }
                        to_search.add(wordList.get(i));
                        isVisited[i] = true;
                    }
                }



            }
            distance++;
        }
        return 0;
    }

    public boolean isLinked(String a,String b){
        int res=0;
        for(int i=0;i<a.length();++i){
            if(a.charAt(i)!=b.charAt(i)){
                res++;
            }
        }
        return res==1;
    }
}





