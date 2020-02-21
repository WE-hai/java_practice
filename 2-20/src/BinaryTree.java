import java.util.Scanner;

public class BinaryTree {
    static int i = 0;
    public static Node buildTree(String s){
        if(s.charAt(i) != '#'){
            Node root = new Node(s.charAt(i));
            ++i;
            root.left = buildTree(s);
            ++i;
            root.right = buildTree(s);
            return root;
        }
        return null;
    }

    public static void inOrder(Node root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.value + " ");
            inOrder(root.right);
        }
    }

    public static void main(String[] args) {
        //获取输入
        //Scanner scanner = new Scanner(System.in);
        //String line = scanner.nextLine();

        String line = "cf#g#ny#h#t##hpg##h#e##oebr####h##r##";
        //建树
        Node root = buildTree(line);
        //中序遍历
        inOrder(root);
        System.out.println();
    }
}
