import java.util.Stack;
/*
*
*
*                   二叉树的非递归遍历（面试前 背一下）
*
*
*
* */
public class TestDemo {
    public static class TreeNode{
        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char val){
            this.val = val;
        }
    }



    public static TreeNode bulid(){
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.left = G;
        C.right = F;
        return  A;
    }


    //1. 二叉树的前序遍历，非递归迭代实现 (如二叉树的层序遍历很相似 这里是创建一个栈)
    public static void proOrder(TreeNode root){
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack();
         stack.push(root);
       while (!stack.empty()){
          TreeNode cur = stack.pop( );
           System.out.print(cur.val + " ");
           //先访问右子树
           if (cur.right != null){
               stack.push(cur.right);
           }
           //再访问左子树
           if (cur.left != null){
               stack.push(cur.left);
           }
       }
    }



    //2. 二叉树中序遍历 ，非递归迭代实现。
    public static void inOrder(TreeNode root){
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (true){
            //1.cur一直往左走。循环入栈，直到cur为空
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            //取栈顶元素并访问，如果遇到空栈说明访问完毕
            if (stack.empty()){
                break;
            }
            TreeNode top = stack.pop();
            System.out.print(top.val + " ");

            //3.cur从top的右子树出发，重复1 2 步骤
            cur = top.right;
        }
    }





    //3. 二叉树的后序遍历 ，非递归迭代实现。
    public static void postOrder(TreeNode root){
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (true){
            //1.cur循环往左找，遇到的非空节点都入栈
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            //2.取栈顶元素，看看能不能访问这个元素
            //满足一下两个条件才能访问
            //a.右子树为空
            //b.右子树被访问过
            if (stack.empty()){
                break;
            }
            //只是取栈顶元素判断一下 ，只有这个节点被访问过才可以出栈
            TreeNode top = stack.peek();
            if (top.right == null || top.right == prev){
                //满足上面条件 就可以访问top了
                System.out.print(top.val + " ");
                stack.pop();
                prev = top;
            }else {
                //3.让cur从top.right出发，继续循环1  2 步骤
                cur = top.right;
            }

        }
    }



    public static void main(String[] args) {
        TreeNode root = bulid();
        postOrder(root);
    }


}
