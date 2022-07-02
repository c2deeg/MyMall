package com.app.mymall.StaticModelClasses

class FurnitureModelClass {
    var description:String?=null
    var discount :String?=null
    var date:String?=null
    var img:Int?=0

    constructor(description: String?, discount: String?, date: String?, img: Int?) {
        this.description = description
        this.discount = discount
        this.date = date
        this.img = img
    }
}