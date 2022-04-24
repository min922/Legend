package com.example.recipe_dt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(val context: Context, val recipeingreList: ArrayList<RecipeIngre>, val explainList: ArrayList<Explain>):
    RecyclerView.Adapter<Adapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.recip_ingre, parent, false)
        return Holder(view)
    }
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(recipeingreList[position], context)
    }

    override fun getItemCount(): Int {
        return recipeingreList.size
    }
    inner class Holder(itemView: View?): RecyclerView.ViewHolder(itemView!!){
        val ingrePhoto = itemView?.findViewById<ImageView>(R.id.ingreImg)
        val ingreName = itemView?.findViewById<TextView>(R.id.ingreName)
        val expPhoto = itemView?.findViewById<ImageView>(R.id.courseImg)
        val expName = itemView?.findViewById<TextView>(R.id.courseExp)

        fun bind(recipeIngre: RecipeIngre, context: Context) {
            if (recipeIngre.photo != "") {
                val resourceId = context.resources.getIdentifier(recipeIngre.photo, "drawable", context.packageName)
                ingrePhoto?.setImageResource(resourceId)
            } else {
                ingrePhoto?.setImageResource(R.mipmap.ic_launcher)
            }
            /* 나머지 TextView와 String 데이터를 연결한다. */
            //ingreName?.text = ingreName.name
            //foodTime?.text = food.time

            }
        }
//        fun bind(explain: Explain, context: Context) {
//            if (explain.photo != "") {
//                val resourceId = context.resources.getIdentifier(explain.photo, "drawable", context.packageName)
//                expPhoto?.


        }


//    }
//    }
//}