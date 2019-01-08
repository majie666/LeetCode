import java.util.*;

public class Test {
    public static class CommonTreeNode{
        public char val;
        //单链表 next ; 二叉树 left,right ； 多叉树 List<Node>
        public List<CommonTreeNode> children;
        public CommonTreeNode(char val){
            this.val = val;
            children = new LinkedList<>();
        }
        public void addChildren(CommonTreeNode... children){
            for(CommonTreeNode child:children)
                this.children.add(child);
        }
    }
    // 3.1所述的解法
//    public static CommonTreeNode getLastParent1(CommonTreeNode root,CommonTreeNode node1,CommonTreeNode node2){
//        if(root==null || node1==null || node2==null || !isInSubTree(root,node1,node2))
//            return null;
//        CommonTreeNode curNode = root;
//        while (true){
//            for(CommonTreeNode child:curNode.children){
//                if(isInSubTree(child,node1,node2)){
//                    curNode = child;
//                    break;
//                }
//                if(child==curNode.children.get(curNode.children.size()-1))
//                    return curNode;
//            }
//        }
//    }
//    public static boolean isInSubTree(CommonTreeNode root,CommonTreeNode node1,CommonTreeNode node2){
//        Queue<CommonTreeNode> queue = new LinkedList<>();
//        CommonTreeNode temp = null;
//        int count = 0;
//        queue.add(root);
//        while (count!=2 && !queue.isEmpty()){
//            temp = queue.poll();
//            if(temp==node1||temp==node2)
//                count++;
//            if(!temp.children.isEmpty())
//                queue.addAll(temp.children);
//        }
//        if(count==2)
//            return true;
//        return false;
//    }
    // 3.2所述的解法
    public static CommonTreeNode getLastParent2(CommonTreeNode root,CommonTreeNode node1,CommonTreeNode node2){
        List<CommonTreeNode> path1 = new ArrayList<>();
        List<CommonTreeNode> path2 = new ArrayList<>();
        getPath(root,node1,path1);
        getPath(root,node2,path2);
        CommonTreeNode lastParent = null;
        for(int i=0;i<path1.size()&&i<path2.size();i++){
            if(path1.get(i)==path2.get(i))
                lastParent = path1.get(i);
            else
                break;
        }
        return lastParent;
    }
    public static boolean getPath(CommonTreeNode root,CommonTreeNode node,List<CommonTreeNode> curPath){
        if(root==node)
            return true;//不用将node加入路径
        curPath.add(root);
        for(CommonTreeNode child:root.children){
            if(getPath(child,node,curPath))
                return true;
        }
        curPath.remove(curPath.size()-1);//该节点的children中找不到路径，删除该节点
        return false;
    }

    public static void main(String[] args){
        CommonTreeNode root = new CommonTreeNode('A');
        CommonTreeNode b = new CommonTreeNode('B');
        CommonTreeNode c = new CommonTreeNode('C');
        CommonTreeNode d = new CommonTreeNode('D');
        CommonTreeNode e = new CommonTreeNode('E');
        CommonTreeNode f = new CommonTreeNode('F');
        CommonTreeNode g = new CommonTreeNode('G');
        CommonTreeNode h = new CommonTreeNode('H');
        CommonTreeNode i = new CommonTreeNode('I');
        CommonTreeNode j = new CommonTreeNode('J');
        root.addChildren(b,c);
        b.addChildren(d,e);
        d.addChildren(f,g);
        e.addChildren(h,i,j);
//        System.out.println(getLastParent1(root,f,h).val);
        System.out.println(getLastParent2(root,f,h).val);
//        System.out.println(getLastParent1(root,h,i).val);
        System.out.println(getLastParent2(root,h,i).val);
    }
}