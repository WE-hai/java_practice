package 合并两个排序的链表;

public class Main {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null ){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1 == null && list2 == null){
            return null;
        }
        //传入任意值初始化pre1，避免空指针异常。用于记录list1的前一个结点地址
        ListNode pre1 = new ListNode(-1);
        //用于记录list2的下一个结点地址
        ListNode p2 = null;
        //用于记录合并后链表的头结点。
        ListNode head = null;
        //如果list1的第一个结点值比list2第一个结点值小则用list1做表头
        if(list1.val < list2.val){
            head = list1;
        }else{
            //否则用list2做表头
            head = list2;
        }
        //当链表1和链表2都不为空时
        while(list1 != null && list2 != null){
            //如果list2的值小于等于list1则往list1前面插
            if(list2.val <= list1.val){
                p2 = list2.next;        //用p2保存list2的下一个结点
                list2.next = list1;     //把list2与list1相连
                pre1.next = list2;      //让list1的前一个结点指向list2
                pre1 = list2;           //此时list1的前一个结点变成list，更新pre1
                list2 = p2;             //list2指向下一个结点
            }else {                     //否则list1指向下一个结点
                pre1 = list1;
                list1 = list1.next;
            }
        }
        if(list2 != null){       //插完需要判断list2是否还有值，将list2剩余值插入
            pre1.next = list2;
        }
        return head;
    }
}
