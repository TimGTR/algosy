package task7;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    // Корень дерева
    private final Node root = new Node();
    public Boolean search(String word) {
        Node current = root;
        // Проходим по каждому символу слова
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            // Если путь не существует — слова нет
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        // Слово найдено, если текущий узел помечен как конец слова
        return current.isEndOfWord;
    }

    public List<String> startWith(String prefix) {
        List<String> result = new ArrayList<>();
        Node current = root;
        // 1. Сначала находим узел, соответствующий последнему символу префикса
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                // Если префикс отсутствует — возвращаем пустой список
                return result;
            }
            current = current.children[index];
        }
        // 2. Запускаем DFS от найденного узла,
        //    чтобы собрать все возможные продолжения
        collectWords(current, prefix, result);
        return result;
    }

    private void collectWords(Node node, String currentWord, List<String> result) {
        // Если узел является концом слова — добавляем слово в результат
        if (node.isEndOfWord) {
            result.add(currentWord);
        }
        // Проходим по всем возможным буквам
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                // Восстанавливаем символ (0 -> 'a', 1 -> 'b', ...)
                char nextChar = (char) ('a' + i);
                // Рекурсивно продолжаем обход
                collectWords(node.children[i], currentWord + nextChar, result);
            }
        }
    }

    public void insert(String word) {
        Node current = root;
        // Проходим по каждому символу слова
        for (char ch : word.toCharArray()) {
            // Определяем индекс (a = 0, b = 1, ..., z = 25)
            int index = ch - 'a';
            // Если узел для символа отсутствует — создаём его
            if (current.children[index] == null) {
                current.children[index] = new Node();
            }
            // Переходим к следующему узлу
            current = current.children[index];
        }
        // Помечаем последний узел как конец слова
        current.isEndOfWord = true;
    }

    private static class Node {
        // Массив потомков (по одной позиции на каждую букву a-z)
        Node[] children = new Node[26];
        // Флаг окончания слова
        boolean isEndOfWord;
    }
}
