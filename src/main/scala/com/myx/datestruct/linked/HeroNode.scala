package com.myx.datestruct.linked

class HeroNode(hNo:Int,hName:String,hNickname:String) {
  val no = hNo
  var name = hName
  var nickname = hNickname
  var next:HeroNode = null
}
