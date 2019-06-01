package com.myx.datestruct.sort

import com.myx.datestruct.sort.QuickSort.quickSort

object MergeSort {
  def main(args: Array[String]): Unit = {
    val array = Array(6,5,4,7,2,8,3,1)
    quickSort(0,array.length-1,array)
    for (i <- 0 until array.length){
      printf("%d\t",array(i))
    }
  }

  def mergeSort(array: Array[Int], left: Int, right:Int, temp:Array[Int]): Unit ={
    if (left < right){
      //取中间值
      val mid:Int = (left + right) / 2
      //分过程：向左递归
      mergeSort(array,left,mid,temp)
      //分过程：向右递归
      mergeSort(array,mid + 1,right,temp)
      //合并两个有序数组
      merge(array,left,mid,right,temp)
    }
  }
  def merge(arr: Array[Int], left: Int, mid: Int, right: Int, temp: Array[Int]) {
    var i:Int = left
    var j:Int = mid + 1
    var t = 0
    while (i <= mid && j <= right){
      if (arr(i) <= arr(j)) {
        temp(t) = arr(i)
        t += 1
        i += 1
      }else{
        temp(t) = arr(j)
        t += 1
        j += 1
      }
    }
    while (i <= mid){
      temp(t) = arr(i)
      t += 1
      i += 1
    }
    while (j <= right){
      temp(t) = arr(i)
      t += 1
      i += 1
    }
    t = 0
    var tempLeft:Int = left
    while (tempLeft <= left){
      arr(tempLeft) = temp(t)
      t += 1
      tempLeft += 1
    }
  }
}
