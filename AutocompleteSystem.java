import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isWord = false;
    int frequency = 0;
}

public class AutocompleteSystem {
    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            curr = curr.children.computeIfAbsent(ch, c -> new TrieNode());
        }
        curr.isWord = true;
        curr.frequency++;
    }

    public List<String> suggest(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            if (!node.children.containsKey(ch)) return new ArrayList<>();
            node = node.children.get(ch);
        }
        List<String> results = new ArrayList<>();
        dfs(node, prefix, results);
        return results;
    }

    private void dfs(TrieNode node, String word, List<String> list) {
        if (node.isWord) list.add(word);
        for (char ch : node.children.keySet()) {
            dfs(node.children.get(ch), word + ch, list);
        }
    }

    public static void main(String[] args) {
        AutocompleteSystem ac = new AutocompleteSystem();
        ac.insert("cat");
        ac.insert("car");
        ac.insert("cart");
        ac.insert("camera");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter prefix: ");
        String pre = sc.nextLine();
        List<String> out = ac.suggest(pre);
        System.out.println("Suggestions:");
        for (String word : out) System.out.println(word);
    }
}