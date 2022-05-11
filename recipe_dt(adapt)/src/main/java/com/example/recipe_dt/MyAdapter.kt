package com.example.recipe_dt

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class MyAdapter(private val list: MutableList<MultiData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view : View?
        return when (viewType) {
            Model.REP_MENU -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.rep_menu, parent, false)
                MenuTypeViewHolder(view)
            }
            Model.RECIP_INGRE -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.recip_ingre, parent, false)
                IngreTypeViewHolder(view)
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
        when (list[position].type) {
            Model.RECIP_INGRE -> {
                (holder as IngreTypeViewHolder).bind(list[position])
                holder.setIsRecyclable(false)
            }
            Model.REP_MENU -> {
                (holder as MenuTypeViewHolder).bind(list[position])
                holder.setIsRecyclable(false)
            }
            Model.EXPLAIN_RECIPE -> {
                (holder as ExplainTypeViewHolder).bind(list[position])
                holder.setIsRecyclable(false)
            }
        }
    }

    // 여기서 받는 position은 데이터의 index다.
    override fun getItemViewType(position: Int): Int {
        Log.d("Adapter", "Hi, getItemViewType")
        return list[position].type
    }

    inner class MenuTypeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val menuPhoto: ImageView = view.findViewById(R.id.menuImage)
        val menuName: TextView = view.findViewById(R.id.menuName)

        fun bind(item: MultiData) {
            menuName.text = item.name
            Glide.with(itemView).load(item.photo).into(menuPhoto)
        }
    }

    inner class IngreTypeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ingrePhoto: ImageButton = view.findViewById(R.id.ingreImg)
        val ingreName: TextView = view.findViewById(R.id.ingreName)

        fun bind(item: MultiData) {
            ingreName.text = item.name
            Glide.with(itemView).load(item.photo).into(ingrePhoto)
        }
    }

    inner class ExplainTypeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val explainPhoto: ImageView = itemView.findViewById(R.id.courseImg)
        val explainText: TextView = itemView.findViewById(R.id.courseExp)

        fun bind(item: MultiData) {
            explainText.text = item.explain
            Glide.with(itemView).load(item.photo).into(explainPhoto)
        }
    }

}



//}