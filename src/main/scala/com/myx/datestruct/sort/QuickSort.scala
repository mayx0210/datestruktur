package com.myx.datestruct.sort

import scala.util.control.Breaks._
object QuickSort {
  def main(args: Array[String]): Unit = {
    val array = Array(6,5,4,7,2,8,3,1)
    quickSort(0,array.length-1,array)
    for (i <- 0 until array.length){
      printf("%d\t",array(i))
    }
  }

  /**
    * 快速排序法
    * @param left 指定从数组的左边的下标0
    * @param right 指定从数组的右边的下标length - 1
    * @param arr 进行排序的数组
    */
  def quickSort(left: Int,right:Int,arr:Array[Int]): Unit ={
    var l = left //左下标
    var r = right //右下标
    var pivot = arr((left + right) / 2)  //以中间值为基准进行分割
    var temp = 0
    breakable{
      //while语句的作用是将比pivot小的数放在左边，将比pivot大的数放在右边
      while (l < r){
        while (arr(l) < pivot){
          l += 1
        }
        while (arr(r) > pivot){
          r -= 1
        }
        if (l >= r){
          break()
        }
        temp = arr(l)
        arr(l) = arr(r)
        arr(r) = temp
      }
    }
    if (l == r){
      l += 1
      r -= 1
    }
    if (left < r){
      quickSort(left,r,arr)
    }
    if (right > l){
      quickSort(right,l,arr)
    }
  }
}
