package 자료구조;

public class HashMap {
    
    final Node[] nodes = new Node[100000];

    public void put(int key, int val){
        int index = key % nodes.length;

        if(nodes[index] == null){
            nodes[index] = new Node(key, val);
            return;
        }

        Node node = nodes[index];
        while(node != null){
            if(node.key == key){
                node.val = val;
                return;
            }

            if(node.next == null){
                break;
            }
            node = node.next;
        }
        node.next = new Node(key, val);
    }

    public int get(int key){
        int index = key % nodes.length;
        if(nodes[index] == null){
            return -1;
        }

        Node node = nodes[index];
        while (node != null){
            if(node.key == key){
                return node.val;
            }
            node = node.next;
        }
        return -1;
    }

    public void remove(int key){
        int index = key % nodes.length;
        if(nodes[index] == null){
            return;
        }

        Node node = nodes[index];
        if(node.key == key){
            if(node.next == null){
                nodes[index] = null;
            }else{
                nodes[index] = node.next;
            }
        }

        Node prev = node;
        while(node != null){
            if(node.key == key){
                prev.next = node.next;
                return;
            }

            prev = node;
            node = node.next;
        }
    }

    static class Node {
        int key, val;
        Node next;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
}
