package com.app.mymall.Activities.ProductDetailActivity

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.app.mymall.Adapters.*
import com.app.mymall.R
import com.app.mymall.StaticModelClasses.*
import com.google.android.material.tabs.TabLayout
import me.relex.circleindicator.CircleIndicator
import me.relex.circleindicator.CircleIndicator3

class ProductDetailActivity : AppCompatActivity() {
    private lateinit var activity: Activity
    lateinit var viewpager: ViewPager2
    lateinit var circle_indicator: CircleIndicator3
    lateinit var recyclerview_color: RecyclerView
    lateinit var recyclerview_size: RecyclerView
    lateinit var similaritem_recyclerview: RecyclerView
    lateinit var rating_recyclerview: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
        activity = this
        init()

        var arrayList: ArrayList<ViewPagerModelClass> = ArrayList()
        arrayList.add(ViewPagerModelClass(R.drawable.men))
        arrayList.add(ViewPagerModelClass(R.drawable.dress))
        arrayList.add(ViewPagerModelClass(R.drawable.jacket))
        arrayList.add(ViewPagerModelClass(R.drawable.men))

        setDataList()
        val viewAdapter = ScreenSlidePagerAdapter(activity, arrayList!!)
        viewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewpager.adapter = viewAdapter
        circle_indicator.setViewPager(viewpager)

        //colorRecyclerview
        recyclerview_color.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, true)
        val colorRecyclerViewAdapter = ColorRecyclerViewAdapter(activity, arrayList!!)

        for (i in 1..5) {
            arrayList.add(ViewPagerModelClass(R.drawable.men))
        }
        recyclerview_color.adapter = colorRecyclerViewAdapter

        //Size RecyclerView
        var sizeList: ArrayList<SizeModelClass> = ArrayList()
        sizeList.add(SizeModelClass("S"))
        sizeList.add(SizeModelClass("M"))
        sizeList.add(SizeModelClass("L"))
        sizeList.add(SizeModelClass("L"))
        sizeList.add(SizeModelClass("L"))
        sizeList.add(SizeModelClass("L"))
        sizeList.add(SizeModelClass("L"))
        sizeList.add(SizeModelClass("L"))
        recyclerview_size.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        val sizeAdapter = RecyclerSizeAdapter(activity, sizeList)
        recyclerview_size.adapter = sizeAdapter

        //similaritems RecyclerAdapter
        var similarItemList: ArrayList<SimilarItemsModelClass> = ArrayList()
        similarItemList.add(SimilarItemsModelClass(R.drawable.jacket, "230$", "Lady jaclket"))
        similarItemList.add(SimilarItemsModelClass(R.drawable.jacket, "230$", "Lady jaclket"))
        similarItemList.add(SimilarItemsModelClass(R.drawable.jacket, "230$", "Lady jaclket"))
        similarItemList.add(SimilarItemsModelClass(R.drawable.jacket, "230$", "Lady jaclket"))
        similarItemList.add(SimilarItemsModelClass(R.drawable.jacket, "230$", "Lady jaclket"))
        similarItemList.add(SimilarItemsModelClass(R.drawable.jacket, "230$", "Lady jaclket"))
        similaritem_recyclerview.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        val similaritemAdapter = SimilarItems_RecyclerAdapter(activity, similarItemList)
        similaritem_recyclerview.adapter = similaritemAdapter


        //RattingRecyclerView
        var ratingModelClass: ArrayList<RatingRecyclerModelClass> = ArrayList()
        ratingModelClass.add(
            RatingRecyclerModelClass(
                "Ashish",
                "20MARCH 2020",
                "Looking good but to much costly in comparison of my area market rate"
            )
        )
        ratingModelClass.add(
            RatingRecyclerModelClass(
                "Ashish",
                "20MARCH 2020",
                "Looking good but to much costly in comparison of my area market rate"
            )
        )
        ratingModelClass.add(
            RatingRecyclerModelClass(
                "Ashish",
                "20MARCH 2020",
                "Looking good but to much costly in comparison of my area market rate"
            )
        )
        ratingModelClass.add(
            RatingRecyclerModelClass(
                "Ashish",
                "20MARCH 2020",
                "Looking good but to much costly in comparison of my area market rate"
            )
        )
        ratingModelClass.add(
            RatingRecyclerModelClass(
                "Ashish",
                "20MARCH 2020",
                "Looking good but to much costly in comparison of my area market ratesfdkjkjklsfdhkfsdjfsdjf;kjsd;klfjsdfjsdjfkljsdfsjdfljsdfjklsdjfklsdjfklsjdfklsdjflsjfljflsdjflsdjflsdjfljfjdfljfdkljfkldj"
            )
        )
        rating_recyclerview.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        val ratingRecyclerAdapter = RatingRecyclerAdapter(activity, ratingModelClass!!)
        rating_recyclerview.adapter = ratingRecyclerAdapter

    }

    private fun init() {
        viewpager = findViewById(R.id.viewpager)
        circle_indicator = findViewById(R.id.circle_indicator)
        recyclerview_color = findViewById(R.id.recyclerview_color)
        recyclerview_size = findViewById(R.id.recyclerview_size)
        similaritem_recyclerview = findViewById(R.id.similaritem_recyclerview)
        rating_recyclerview = findViewById(R.id.rating_recyclerview)
    }


    private fun setDataList(): ArrayList<ViewPagerModelClass> {
        var arrayList: ArrayList<ViewPagerModelClass> = ArrayList()
        arrayList.add(ViewPagerModelClass(R.drawable.men))
        arrayList.add(ViewPagerModelClass(R.drawable.men))
        arrayList.add(ViewPagerModelClass(R.drawable.men))
        arrayList.add(ViewPagerModelClass(R.drawable.men))
        return arrayList
    }
}