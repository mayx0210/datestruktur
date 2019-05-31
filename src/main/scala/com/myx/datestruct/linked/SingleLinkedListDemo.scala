package com.myx.datestruct.linked

object SingleLinkedListDemo {
  def main(args: Array[String]): Unit = {
    val node1 = new HeroNode(1,"宋江","及时雨")
    val node2 = new HeroNode(2,"卢俊义","玉麒麟")
    val node3 = new HeroNode(3,"吴用","智多星")
    val node4 = new HeroNode(4,"林冲","豹子头")

    //创建一个单向链表
    val singleLinkedList = new SingleLinkedList()
    /*singleLinkedList.addList(node1)
    singleLinkedList.addList(node2)
    singleLinkedList.addList(node4)
    singleLinkedList.addList(node3)*/

    singleLinkedList.addBySort(node1)
    singleLinkedList.addBySort(node3)
    singleLinkedList.addBySort(node2)
    singleLinkedList.addBySort(node4)

    singleLinkedList.showList()

    println("========================")
    val node5 = new HeroNode(3,"武松","行者")
    singleLinkedList.updateList(node5)
    singleLinkedList.showList()

    println("========================")
    val node6 = new HeroNode(1,"宋江","及时雨")
    singleLinkedList.deleteList(node6)
    singleLinkedList.showList()
  }
}
