package com.myx.datestruct.sparsearray

import scala.collection.mutable.ArrayBuffer

object datenStrucktur {
  def main(args: Array[String]): Unit = {
    //1、先创建原始的地图（二维数组）
    val rows = 11;
    val cols = 11;
    val chessMap1 = Array.ofDim[Int](rows,cols)
    chessMap1(1)(2) = 1 //表示黑子
    chessMap1(2)(3) = 2 //表示蓝子
    chessMap1(4)(5) = 2
    chessMap1(5)(6) = 1

    //输出原始的地图
    println("原始的地图如下")
    for (item1 <- chessMap1) {
      for (item2 <- item1) {
        printf("%d\t",item2)
      }
      println()
    }

    //使用稀疏数组来对chessMap1进行压缩
    //思路
    //1、使用ArrayBuffer来保存有效数据
    //2、每一个数据使用Node对象来表示
    //3、Node的结构class Node(val row:Int,val col:Int,val value:Int)

    val sparseArray = ArrayBuffer[Node]()
    val node1 = new Node(rows,cols,2)
    sparseArray.append(node1)


    //遍历chessMap1，每发现一个非0的值，就创建给Node，并加入到sparseArray
    for (i <- 0 until chessMap1.length) {
      for (j <- 0 until chessMap1(i).length) {
        if (chessMap1(i)(j) != 0){  //有效数据，需要保存
          val node2 = new Node(i,j,chessMap1(i)(j))
          sparseArray.append(node2)
        }
      }
    }

    //输出稀疏数组
    println("稀疏数组的情况")
    for (node <- sparseArray){
      printf("%d\t%d\t%d\t\n",node.row,node.col,node.value)
    }

    //将稀疏数组恢复成原始的数组
    //1、先从sparseArray读取第一个node，并创建新的地图
    val firstNode = sparseArray(0)
    val chessMap2 = Array.ofDim[Int](firstNode.row,firstNode.col)

    //2、从sparseArray第二个数组开始遍历，并将数组恢复到chessMap2
    for (i <- 1 until sparseArray.length) {
      val node = sparseArray(i)
      chessMap2(node.row)(node.col) = node.value
    }
    //再次输出恢复后的原始地图
    println("恢复后原始的地图如下")
    for (item1 <- chessMap2) {
      for (item2 <- item1) {
        printf("%d\t",item2)
      }
      println()
    }
  }
}
