//TC- to move words in dicstionary = n*l we are going to height that is length of each and every word
//now split the sentence word by word- number of words m len of each word - l , len of sentence is m*l tc for spliting - m*l
//then tc for searching in tries all m words of len l
//so tc- nl +ml+ml
//sc- nl+ml
//Using trie---------------------------
// class Solution {
//     TrieNode root;
//     class TrieNode{//CREaTING THE trie 
//         boolean isEnd;
//         TrieNode[] children;
//         public TrieNode(){
//             this.children = new TrieNode[26];
//         }
//     }
//     //tc- O(N*l) N- number of words, l- length of each word
//     private void insert(String word){ // insering each words from dictionary into trie,
//         TrieNode curr = root;
//         for(char c : word.toCharArray()){
//             if(curr.children[c-'a'] == null){
//                 curr.children[c-'a'] = new TrieNode();
//             }
//             curr = curr.children[c-'a'];
//         }
//         curr.isEnd = true;
//     }
    
//     public String replaceWords(List<String> dictionary, String sentence) {
//         this.root = new TrieNode();// Initialize root node
//         for(String word : dictionary){
//               insert(word);//calling insert to put words into dictioanry
//         }
//         StringBuilder sb = new StringBuilder();
//         //TC-O(m*l) m- len of sentence, l - len of each word
//         String[] splitArr = sentence.split(" ");//taking out each word from sentense storing in string array
//          //TC-O(m*l)
//         for(int i = 0; i< splitArr.length; i++){
//             if(i>0) sb.append(" ");
//             sb.append(getShortestVersion(splitArr[i]));// calling get shortest version method to get shortest version
//             // for each word
//         }
//         return sb.toString();//adding shortest word to sb
        
//     }

//     private String getShortestVersion(String word){
//         TrieNode curr = root;
//         StringBuilder sb = new StringBuilder();
//         for(char c : word.toCharArray()){//taking each char from word
//             if(curr.children[c-'a'] == null || curr.isEnd){//checking if the char is in children of root, if its null
//             //break because if one char or first char is not there there is no shorter version, also if for curr char we have
//             //reached isend as true that means the shorter version word in trie ends here we can break and return sb till here.
//                 break;
//             }
//             curr = curr.children[c-'a'];// keep going to next char
//             sb.append(c);//add char to sb
//         }
//         if(curr.isEnd){//if isend reached return sb
//             return sb.toString();
//         }
//         return word;//if isend not reached return the original word
//     }
// }

//using hashset------------------------------------

class Solution{
    public String replaceWords(List<String> dictionary, String sentence){
        HashSet<String> set = new HashSet<>(dictionary);
        String[] splitArr = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<splitArr.length; i++){
            if(i>0) sb.append(" ");
            String word= splitArr[i];
            boolean flag = false;
            for(int j = 0; j < word.length(); j++){
                String subStr = word.substring(0, j+1);//in hashset this is the problem, taking substring everytime take time
                //tc- m(words)l(len of wprds)l(substring from words)- mll
                if(set.contains(subStr)){
                    sb.append(subStr);
                    flag = true;
                    break;
                }

            }
            if(!flag){
                sb.append(word);
            }

        }
        return sb.toString();
    }
}