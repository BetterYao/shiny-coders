import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by shily on 2014/9/15.
 */
public class MMTreeNum {

        public static void main(String[] args) throws Exception{
            Node<Integer> node1 = new Node<Integer>(null,2,null);
            Node<Integer> node2 = new Node<Integer>(null,5,null);
            Node<Integer> node3 = new Node<Integer>(node1,9,node2);
            Node<Integer> node4 = new Node<Integer>(null,1,null);
            Node<Integer> node5 = new Node<Integer>(null,5,null);
            Node<Integer> node6 = new Node<Integer>(node4,9,node5);
            Node<Integer> node7 = new Node<Integer>(node6,9,node3);
            Node<Integer> node8 = new Node<Integer>(null,-1000,null);
            Node<Integer> head = new Node<Integer>(node7,9,node8);

            System.out.print(findMax(null));
        }

        private static Integer findMax(Node<Integer> head) throws Exception{//函数返回二叉树中相差最大的两个节点间的差值绝对值
            if(head == null){
                throw new Exception("head is null!!");
            }
            List<Node<Integer>> list = new ArrayList<Node<Integer>>();
            int max = head.value;
            int min = head.value;
            changeList(list,head);
            while(list != null&&list.size()>0){
                Node<Integer> node = list.remove(0);
                if(node.value < min){
                    min = node.value;
                }else if(node.value > max){
                    max = node.value;
                }
                changeList(list,node);
            }
            return Math.abs(max - min);
        }

        private static void changeList(List list,Node<Integer> head){
            if(head.left != null){
                list.add(head.left);
            }
            if(head.right != null){
                list.add(head.right);
            }
        }

        private static class Node<E>{//省略get、put 方法
            E value;
            Node<E> left;
            Node<E> right;
            Node(Node<E> left,E value,Node<E> right){
                this.left = left;
                this.right = right;
                this.value = value;
            }
        }
}
