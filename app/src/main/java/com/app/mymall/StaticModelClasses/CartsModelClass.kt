package com.app.mymall.StaticModelClasses

class CartsModelClass {
    var img:Int?=null
    var itemname:String?=null
    var color:String?=null
    var size:String?=null
    var quantity:String?=null
    var price:String?=null

    constructor(
        img: Int?,
        itemname: String?,
        color: String?,
        size: String?,
        quantity: String?,
        price: String?
    ) {
        this.img = img
        this.itemname = itemname
        this.color = color
        this.size = size
        this.quantity = quantity
        this.price = price
    }
}