package com.myx.datestruct.linked

object DoubleLinkedListDemo {
  def main(args: Array[String]): Unit = {
    val node1 = new HeroNode1(1,"宋江","及时雨")
    val node2 = new HeroNode1(2,"卢俊义","玉麒麟")
    val node3 = new HeroNode1(3,"吴用","智多星")
    val node4 = new HeroNode1(4,"林冲","豹子头")

    val doubleLinkedList = new DoubleLinkedList
    doubleLinkedList.add(node1)
    doubleLinkedList.add(node3)
    doubleLinkedList.add(node4)
    doubleLinkedList.add(node2)
    doubleLinkedList.show()

    println("===================")

    val node5 = new HeroNode1(2,"武松","行者")
    doubleLinkedList.update(node5)
    doubleLinkedList.show()

    doubleLinkedList.delete(3)
    doubleLinkedList.delete(4)
    doubleLinkedList.delete(2)
    println("双向链表删除结点后")
    doubleLinkedList.show()
    println("=================")

    doubleLinkedList.add(node3)
    doubleLinkedList.show()

  }
}
