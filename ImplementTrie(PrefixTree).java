//we use tries to store string; used as dicstionary, also called as prefix tree
//inittial tri node storing array of characters
//tri node is empty pointer, it points to another array of 26 character, called child node, than from each node
//from from that 26 char array there is child of 26char array and so on, so chile is also treeNode children
//to end the word we have boolean variable isend.
//tries have advantage over hashset when looking for prefix, in hashset it occupies redundant space, but ties reuse
//space
//for very large data tries work better, for sparse data space occupied will be too high for ties, but for dense data
//tries works better
//for TC, for hashmap, if we wanna look for work catch- first it will convert it to hashcode that will require time
//of l len of word, we will look for that code in memomry register for the word, we consider it o(1) because its constant len
//tc for tries- O(l) len of word
//TC- nl^2 for hashset, we have to check for all the words the prefix but in tries, TC is O(l) just check that word

class Trie {
    TrieNode root;
    

    class TrieNode{//creating trie node
        Boolean isEnd;//one trie node will contain an isend and a children what will be a trienode 
        TrieNode[] children;

        public TrieNode(){
             this.children = new TrieNode[26]; // whenever initiasing the trienode initializing the children
             //it wil null initially
             this.isEnd = false;
        }
    }

    public Trie() {
       
     this.root = new TrieNode(); // first child from root initialised with 26 char space
    }
    
    public void insert(String word) {//tc- O(l) sC- 26*l each character occupies 26 len of charin trie
        TrieNode curr = root;

        for(char c : word.toCharArray()){
            if(curr.children[c-'a'] == null){//going to root's child node's that letter index, if thats null
                curr.children[c-'a'] = new TrieNode();// creating a trie node at that index of children 
            }
            curr = curr.children[c-'a'];// moving  pointer to next

        }
        curr.isEnd = true;//after the loop the word has finished making the last letter also as isend true.
        
    }
    
    public boolean search(String word) {//tc-O(l), no extra space its constant

         TrieNode curr = root;

        for(char c : word.toCharArray()){
            if(curr.children[c-'a'] == null){
                return false;//we check if curr node value do ot match return false
            }
            curr = curr.children[c-'a'];

        }
        return curr.isEnd;//if everything mached we are at end of the word return isend
        
    }
    
    public boolean startsWith(String prefix) {//tc - O(l) i is len of prefix here, no extra space its constant

         TrieNode curr = root;

        for(char c : prefix.toCharArray()){
            if(curr.children[c-'a'] == null){
                return false;//we check if prefix baby value do is there if not return false
            }
            curr = curr.children[c-'a'];

        }
        return true;//if all the words in the prefix matched and word ended just return true
        
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */