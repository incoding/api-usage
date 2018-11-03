package com.javaapi.test.test.dataStructure.link.reverse;

 public class Node {
    private int Data;// 数据域
    private Node Next;// 指针域
    public Node(int Data) {
        // super();
        this.Data = Data;
    }
    public int getData() {
        return Data;
    }
    public void setData(int Data) {
        this.Data = Data;
    }

    public Node getNext() {
        return Next;
    }
    public void setNext(Node Next) {
        this.Next = Next;
    }

     @Override
     public String toString() {
         final StringBuilder sb = new StringBuilder("Node{");
         sb.append("Data=").append(Data);
         sb.append(", Next=").append(Next);
         sb.append('}');
         return sb.toString();
     }
 }
