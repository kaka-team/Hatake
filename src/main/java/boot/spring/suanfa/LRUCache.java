package boot.spring.suanfa;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Optional;

/**
 * @program: SSM
 * @description:
 * @author: Hatake
 * @create: 2020-09-20 19:48
 **/
public class LRUCache {
    int capacity;
    int curSize;
    LinkDataNode head,tail;
    HashMap<Integer,LinkDataNode> indexMap = new HashMap<>();

    class LinkDataNode{
        int key;
        int value;
        LinkDataNode pre;
        LinkDataNode next;

        public LinkDataNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new LinkDataNode(0,0);
        tail = new LinkDataNode(0,0);
        head.next = tail;
        tail.pre = head;

    }

    public int get(int key) {
        if(indexMap.containsKey(key)){
            LinkDataNode v = indexMap.get(key);
            //先删除节点
            v.pre.next = v.next;
            v.next.pre = v.pre;
            //加到头部
            v.pre = head;
            v.next = head.next;
            head.next.pre = v;
            head.next = v;
            indexMap.put(key,v);
            return v.value;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        LinkDataNode c = indexMap.get(key);
        if(c == null){
            if(curSize < capacity){
                LinkDataNode newNode = new LinkDataNode(key,value);
                newNode.pre = head;
                newNode.next = head.next;
                head.next.pre = newNode;
                head.next = newNode;
                curSize++;
                indexMap.put(key,newNode);
            }else{
                //删除最后的元素
                indexMap.remove(tail.pre.key);
                tail.pre.pre.next = tail;
                tail.pre = tail.pre.pre;
                curSize--;
                put(key,value);
            }
        }else{
            //先删除节点
            c.value = value;
            c.pre.next = c.next;
            c.next.pre = c.pre;
            //加到头部
            c.pre = head;
            c.next = head.next;
            head.next.pre = c;
            head.next = c;
            indexMap.put(key,c);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4

    }
}
