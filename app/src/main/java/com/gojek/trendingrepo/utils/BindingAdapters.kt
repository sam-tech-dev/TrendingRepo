package com.gojek.trendingrepo.utils

import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_main.*


@BindingAdapter("adapter")
fun setAdapter(view: androidx.recyclerview.widget.RecyclerView, adapter: androidx.recyclerview.widget.RecyclerView.Adapter<*>?) {
     view.layoutManager= LinearLayoutManager(view.context)
     view.adapter = adapter
}

@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: View, visibility: MutableLiveData<Int>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && visibility != null) {
        visibility.observe(parentActivity, Observer { value ->
            view.visibility = value ?: View.VISIBLE
        })
    }
}

@BindingAdapter("mutableText")
fun setMutableText(view: TextView, text: MutableLiveData<String>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && text != null) {
        text.observe(parentActivity, Observer { value -> view.text = value ?: "" })
    }
}

@BindingAdapter("mutableText")
fun setMutableText(view: TextView, text: String?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && text != null) {
        view.text = text
    }
}


@BindingAdapter("mutableText")
fun setMutableText(view: TextView, text: Int) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && text != null) {
        view.text = text.toString()
    }
}


@BindingAdapter("bindImageUrl")
fun loadImage(view: CircleImageView, imageUrl: MutableLiveData<String?>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && imageUrl != null) {
        imageUrl.observe(parentActivity, Observer {value ->
            if(value!=null && value.isNotEmpty()){
                Glide.with(view.context).load(value).into(view)
            }
        })
    }
}

@BindingAdapter("bindImageUrl")
fun loadImage(view: CircleImageView, imageUrl: String?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && imageUrl != null) {
        if(imageUrl.isNotEmpty()){
            Glide.with(view.context).load(imageUrl).into(view)
        }
    }
}



