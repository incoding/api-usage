package com.javaapi.test.util.math.datastruct.tree;

import org.junit.Test;

import java.util.LinkedList;

public class LevelTraverse2Test {

    @Test
    public void test() {
        // N层 ， N+1层也知道
        LevelTraverse2Test client = new LevelTraverse2Test();
        Btree btree = client.initTree();
        client.printLevel(btree);
    }

    public void printLevel(Btree btree) {
        if (btree == null){
            return ;
        }
        System.out.println("btree level is " + btree.getLevel());
        levelIterator(btree);
    }


    public Btree initTree(){
        Btree level4Left = new Btree(4,41,null,null);
        Btree level4Right = new Btree(4,42,null,null);

        Btree level51Left = new Btree(4,51,null,null);
        Btree level52Right = new Btree(4,52,null,null);

        Btree level3Left = new Btree(3,31,level4Left,level4Right);

        Btree level3Right = new Btree(3,32,level51Left,level52Right);

        Btree level21 = new Btree(2,2,level3Left,level3Right);
        Btree level22 = new Btree(2,3,null,null);

        Btree root = new Btree(1,1,level21,level22);

        return root;
    }

    public void levelIterator(Btree root)
    {
        if(root == null)
        {
            return ;
        }
        LinkedList<Btree> queue = new LinkedList<Btree>();
        Btree current = null;
        queue.offer(root);//将根节点入队
        while(!queue.isEmpty())
        {
            current = queue.poll();//出队队头元素并访问
            System.out.print(current.getValue() +"-->");
            if(current.getLeft() != null)//如果当前节点的左节点不为空入队
            {
                queue.offer(current.getLeft());
            }
            if (current.getRight() != null)//如果当前节点的右节点不为空，把右节点入队
            {
                queue.offer(current.getRight());
            }
        }

    }


    public static class Btree {

        /**
         * 层级
         */
        private Integer level;

        /**
         * 具体的值
         */
        private Integer value;

        /**
         * 左节点
         */
        private Btree left;

        /**
         * 右节点
         */
        private Btree right;

        public Btree() {
        }

        public Btree(Btree left, Btree right) {
            this.left = left;
            this.right = right;
        }

        public Btree(Integer level, Integer value, Btree left, Btree right) {
            this.level = level;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Btree getLeft() {
            return left;
        }

        public void setLeft(Btree left) {
            this.left = left;
        }

        public Btree getRight() {
            return right;
        }

        public void setRight(Btree right) {
            this.right = right;
        }

        public Integer getLevel() {
            return level;
        }

        public void setLevel(Integer level) {
            this.level = level;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }
    }
}
