import java.util.Collection;

class BTree<G extends Comparable<G>> {

    // Корень и степень дерева
    private BTNode<G> root;
    private int order;
    private int size;

    BTree(int order) {
        this.order = order;
        root = new BTNode<>(order);
        size = 0;
    }

    void insert(Collection<G> data) {
        for(G elem: data) {
            insert(elem);
        }
    }

    // Возвращает true если элемент есть в дереве, иначе false
    boolean contains(BTNode<G> currentNode, G key) {
        if (currentNode == null) {
            currentNode = root;
        }
        // Булева переменная, которая хранит результат функции
        boolean wasFound = false;
        // Если искомый ключ меньше первого ключа, то проверяем существование первого узла
        // Если узла нет, то искомого ключа нет в дереве
        if (key.compareTo(currentNode.keys.get(0)) < 0) {
            if (currentNode.nodes.get(0) == null) {
                wasFound = contains(currentNode.nodes.get(0), key);
            }
        } else {
            // Если искомый ключ больше, то ищем его или узел, где он может быть
            int i = 0;
            while (i < currentNode.keys.size() && key.compareTo(currentNode.keys.get(i)) >= 0) {
                if (key.compareTo(currentNode.keys.get(i)) == 0) {
                    wasFound = true;
                }
                i++;
            }
            // Если его нет в текущем узле, то спускаемся в i-тый узел
            if (!wasFound) {
                if (currentNode.nodes.get(i) != null) {
                    wasFound = contains(currentNode.nodes.get(i), key);
                }
            }
        }

        return wasFound;
    }

    BTNode<G> find(BTNode<G> currentNode, G key) {
        if (currentNode == null) {
            currentNode = root;
        }
        // Bool value, which show us, was key found or not
        // If key less, then 1st key, go the 1st child, if it exists, otherwise, key is not in tree
        if (key.compareTo(currentNode.keys.get(0)) < 0) {
            if (currentNode.nodes.get(0) == null) {
                return null;
            } else {
                return find(currentNode.nodes.get(0), key);
            }
        } else {
            // Else, go find key in node, or interval where it might be
            int i = 0;
            while (i < currentNode.keys.size() && key.compareTo(currentNode.keys.get(i)) >= 0) {
                if (key.compareTo(currentNode.keys.get(i)) == 0) {
                    return currentNode;
                }
                i++;
            }
            // If it was not found in node, go find in the i-th child, if it exists
            if (currentNode.nodes.get(i) == null) {
                return null;
            } else {
                return find(currentNode.nodes.get(i), key);
            }
        }
    }

    // Вставка элемента в дерево
    void insert(G key) {
        size += 1;
        BTNode<G> currentNode = root;
        boolean wasInserted = false;

        // Ищем лист, в который мы сможем вставить ключ, спускаясь по дереву вниз
        while (!currentNode.isLeaf()) {
            int index = 0;
            while (index < currentNode.keys.size() && key.compareTo(currentNode.keys.get(index)) > 0) {
                index += 1;
            }
            currentNode = currentNode.nodes.get(index);
        }

        // Если ключей в листе меньше чем (t*2-1), то просто добавляем его и сортируем узел
        if (currentNode.keys.size() < order * 2 - 1) {
            currentNode.keys.add(key);
            currentNode.sort();
        } else {
            // Иначе разбиваем узел на два
            while (currentNode.keys.size() == order * 2 - 1) {
                BTNode<G> leftNode = new BTNode<>(order);
                BTNode<G> rightNode = new BTNode<>(order);
                // Медианный элемент
                G midElement = currentNode.keys.get(order - 1);

                // Если узел - корень, то создаём новый корень
                if (currentNode == root) {
                    root = new BTNode<>(order);
                    currentNode.parent = root;
                }
                leftNode.parent = currentNode.parent;
                rightNode.parent = currentNode.parent;

                // Вставляем (t - 1) первых ключей в левый новый узел и (t - 1) последних в правый
                for (int i = 0; i < order - 1; i++) {
                    leftNode.keys.add(currentNode.keys.get(i));
                }
                for (int i = order; i < currentNode.keys.size(); i++) {
                    rightNode.keys.add(currentNode.keys.get(i));
                }
                leftNode.sort();
                rightNode.sort();
                // Если текуший узел не лист, то вставляем t первых узлов в левый новый лист и t последних в правый
                if (!currentNode.isLeaf()) {
                    for (int i = 0; i < order; i++) {
                        BTNode<G> node = currentNode.nodes.get(i);
                        leftNode.nodes.add(node);
                        node.parent = leftNode;
                    }
                    for (int i = order; i < currentNode.nodes.size(); i++) {
                        BTNode<G> node = currentNode.nodes.get(i);
                        rightNode.nodes.add(node);
                        node.parent = rightNode;
                    }
                    leftNode.notLeaf();
                    rightNode.notLeaf();
                }

                // Далее вставляем медаинный элемент и новые узлы в родительский узел
                int nodeIndex = currentNode.parent.nodes.indexOf(currentNode);
                int midIndex = nodeIndex > 0 ? nodeIndex : 0;
                currentNode.parent.keys.add(midIndex, midElement);

                if (currentNode.parent.nodes.isEmpty()) {
                    currentNode.parent.nodes.add(midIndex, rightNode);
                } else {
                    currentNode.parent.nodes.set(midIndex, rightNode);
                }
                currentNode.parent.nodes.add(midIndex, leftNode);

                // Если первая итерация вставки, то вставляем наш элемент в один из новых узлов
                if (!wasInserted) {
                    if (key.compareTo(midElement) < 0) {
                        leftNode.keys.add(key);
                        leftNode.sort();
                    } else {
                        rightNode.keys.add(key);
                        rightNode.sort();
                    }
                    wasInserted = true;
                }

                // Проосматриваем родительский узел для балансировки и помечаем его не листом
                currentNode = currentNode.parent;
                currentNode.notLeaf();
            }
        }

    }

    // Удаление элемента из дерева
    G remove(G key) {
        // Ищем узел где находится удаляемый элемент
        BTNode<G> node = find(root, key);

        // Если такого узла нет, значит элемента нет в дереве
        if (node == null) {
            return null;
        }

        // Если нашли, то проверяем лист ли этот узел
        if (node.isLeaf()) {
            // Если лист, то смотрим на количество ключей в нем
            // Если оно больше (t - 1), то просто удаляем его
            if (node.keys.size() > order - 1) {
                node.keys.remove(key);
            } else {
                // Иначе смотрим, можем ли мы переместить ключи для балансировки из узлов-соседей
                BTNode<G> leftSibling = node.getLeftSibling();
                BTNode<G> rightSibling = node.getRightSibling();

                if (leftSibling != null && leftSibling.keys.size() > order - 1) {
                    G keyReplacer = leftSibling.keys.remove(leftSibling.keys.size() - 1);
                    G keyDivider = leftSibling.parent.keys.get(leftSibling.parent.nodes.indexOf(leftSibling));
                    replaceKey(key, keyReplacer, keyDivider, node);
                } else if (rightSibling != null && rightSibling.keys.size() > order - 1) {
                    G keyReplacer = rightSibling.keys.remove(0);
                    G keyDivider = rightSibling.parent.keys.get(rightSibling.parent.nodes.indexOf(rightSibling) - 1);
                    replaceKey(key, keyReplacer, keyDivider, node);
                } else {
                    // Если нет, то объединяем текущий узел и один из узлов-соседей
                    node.keys.remove(key);
                    if (leftSibling != null) {
                        mergeNodes(leftSibling, node);
                    } else if (rightSibling != null) {
                        mergeNodes(node, rightSibling);
                    }
                }
            }
        } else {
            // Если узел внутренний, то
            // Находим позицию элемента во внутреннем узле
            int index = node.keys.indexOf(key);
            BTNode<G> prevNode = node.nodes.get(index);
            BTNode<G> nextNode = node.nodes.get(index + 1);

            // Проверяем, можем ли мы забрать один из ключей у соседних узлов-потомков
            if (prevNode != null && prevNode.keys.size() > order - 1) {
                // Извлекаем последний ключ у предшествующего узла и вставляем вместо удаляемого
                node.keys.set(index, prevNode.keys.remove(prevNode.keys.size() - 1));
            } else if (nextNode != null && nextNode.keys.size() > order - 1) {
                // Извлекаем первый ключ у следующего узла и вставляем вместо удаляемого
                node.keys.set(index, nextNode.keys.remove(0));
            } else {
                // Если оба потомка имеют меньше t - 1 ключей, то удаляем нужный ключ и объединяем их
                node.keys.remove(key);
                if (prevNode != null && nextNode != null)
                    mergeNodes(prevNode, nextNode);
            }
        }

        return key;
    }

    private void replaceKey(G key, G keyReplacer, G keyDivider, BTNode<G> node) {
        node.keys.remove(key);
        node.keys.add(keyDivider);
        node.sort();
        node.parent.keys.remove(keyDivider);
        node.parent.keys.add(keyReplacer);
        node.parent.sort();
    }

    private void mergeNodes(BTNode<G> node1, BTNode<G> node2) {
        // Находим индексы элементов для слияния в родительском узле
        int node1Index = node1.parent.nodes.indexOf(node1);
        int node2Index = node2.parent.nodes.indexOf(node2);

        // Проверяем являются ли они соседями
        if (node1Index == node2Index - 1) {
            G keyDivider = node1.parent.keys.get(node1Index);
            BTNode<G> newNode = new BTNode<>(order);

            // Объединяем все ключи
            newNode.keys.addAll(node1.keys);
            newNode.keys.add(keyDivider);
            newNode.keys.addAll(node2.keys);

            // Объединяем все узлы
            for (BTNode<G> node : node1.nodes) {
                newNode.nodes.add(node);
                node.parent = newNode;
            }
            for (BTNode<G> node : node2.nodes) {
                newNode.nodes.add(node);
                node.parent = newNode;
            }
            newNode.parent = node1.parent;

            // Удаляем старые узлы и вставляем новый
            newNode.parent.nodes.set(node1Index, newNode);
            newNode.parent.nodes.remove(node2Index);
            newNode.parent.keys.remove(node1Index);
        } else {
            System.out.println("Wrong nodes are tried to be merged");
        }


    }

    // Возвращает отсортированную последовательность в дереве в виде строки
    String getSortedSequence(BTNode<G> node, String answer) {
        if (node == null) {
            node = root;
        }
        if (!node.isLeaf()) {
            StringBuilder answerBuilder = new StringBuilder(answer);
            for (int i = 0; i < node.keys.size(); i++) {
                // Посещаем и-тый узел и ключ
                if (i < node.nodes.size()) {
                    answerBuilder.append(getSortedSequence(node.nodes.get(i), ""));
                }
                answerBuilder.append(node.keys.get(i)).append(" ");
            }
            answer = answerBuilder.toString();
            // Затем посещаем последний узел
            answer += getSortedSequence(node.nodes.get(node.nodes.size() - 1), "");
        } else {
            StringBuilder answerBuilder = new StringBuilder(answer);
            for (int i = 0; i < node.keys.size(); i++) {
                answerBuilder.append(node.keys.get(i)).append(" ");
            }
            answer = answerBuilder.toString();
        }

        return answer;
    }


}
