package com.myx.datestruct.sparsearray

import scala.collection.mutable.ArrayBuffer

object SparseArrayDemo {
  def main(args: Array[String]): Unit = {
    //先试用二维数组映射棋
    val rows = 11;
    val cols = 11;
    val chessMap1 = Array.ofDim[Int](rows,cols)
    //初始化
    chessMap1(1)(2) = 1;//1代表白子
    chessMap1(2)(3) = 2;//2代表黑子
    chessMap1(2)(2) = 1;
    chessMap1(3)(2) = 2;
    //输出原始棋盘
    println("原始的棋盘")
    for (row <- chessMap1){
      for (item <- row) {
        printf("%d ",item)
      }
      println()
    }
    //对原始的数组进行压缩
    //1、创建一个ArrayBuffer，可以动态的添加数据
    //2、使用Node对象，表示一行数据
    val sparseArray = ArrayBuffer[Node]()
    sparseArray.append(new Node(rows,cols,2))
    //遍历chessMap1，如果发现非0的值，就创建一个Node
    for (i <- 0 until chessMap1.length) {
      for (j <- 0 until chessMap1(1).length) {
        if (chessMap1(i)(j)!=0){
          sparseArray.append(new Node(i,j,chessMap1(i)(j)))
        }
      }
    }
    println("稀疏数组的情况是")
    for (i <- 0 until sparseArray.length) {
      val node = sparseArray(i)
      printf("%d\t%d\t%d\t\n",node.row,node.col,node.value)
    }

    //将稀疏数组恢复成原始棋盘
    //思路
    //1、读取稀疏数组的第一行，创建一个二维棋盘chessMap2
    //2、遍历（从稀疏数组的第二行），每读到一个Node，就将对应的值恢复到chessMap2
   /* val node = sparseArray(0)
    val chessMap2 = Array.ofDim[Int](node.row,node.col)
    for (i <- 1 until sparseArray.length){

    }*/
  }
}
