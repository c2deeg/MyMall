package com.app.mymall.StaticModelClasses

import kotlin.properties.Delegates

class CartModelClasses {
     var imgae:Int?= 0
     var percentage :String?= null

     constructor(imgae: Int?, percentage: String?) {
          this.imgae = imgae
          this.percentage = percentage
     }
}