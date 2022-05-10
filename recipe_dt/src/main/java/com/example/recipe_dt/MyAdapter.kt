package com.example.recipe_dt

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyAdapter(private val list: List<Model>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view : View?
        return when (viewType) {
            Model.RECIP_INGRE -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.recip_ingre, parent, false)
                IngreTypeViewHolder(view)
            }
            Model.REP_MENU -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.activity_main, parent, false)
                MenuTypeViewHolder(view)
            }
            Model.EXPLAIN_RECIPE -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.explain_recipe, parent, false)
                ExplainTypeViewHolder(view)
            }
            else -> throw RuntimeException("알 수 없는 뷰 타입 에러")
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        Log.d("Adapter", "Hi, onBindViewHolder")
        val obj = list[position]
        when (obj.type) {
            Model.RECIP_INGRE -> {
                (holder as IngreTypeViewHolder).ingreName.text = obj.text
                holder.ingrePhoto.setImageResource(obj.data)
                holder.ingreName.text = obj.contentString
            }
            Model.REP_MENU -> {
                (holder as MenuTypeViewHolder).menuName.text = obj.text
                holder.menuPhoto.setImageResource(obj.data)
                holder.menuName.text = obj.contentString
            }
            Model.EXPLAIN_RECIPE -> {
                (holder as ExplainTypeViewHolder).explainText.text = obj.text
                holder.explainPhoto.setImageResource(obj.data)
                holder.explainText.text = obj.contentString
            }
        }
    }

    // 여기서 받는 position은 데이터의 index다.
    override fun getItemViewType(position: Int): Int {
        Log.d("Adapter", "Hi, getItemViewType")
        return list[position].type
    }

    inner class IngreTypeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ingrePhoto: ImageButton = itemView.findViewById(R.id.ingreImg)
        val ingreName: TextView = itemView.findViewById(R.id.ingreName)
    }

    inner class MenuTypeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val menuPhoto: ImageView = itemView.findViewById(R.id.menuImage)
        val menuName: TextView = itemView.findViewById(R.id.menuName)
    }

    inner class ExplainTypeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val explainPhoto: ImageView = itemView.findViewById(R.id.courseImg)
        val explainText: TextView = itemView.findViewById(R.id.courseExp)
    }

}



//}