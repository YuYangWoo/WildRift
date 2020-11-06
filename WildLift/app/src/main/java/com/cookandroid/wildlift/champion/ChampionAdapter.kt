package com.cookandroid.wildlift.champion

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cookandroid.wildlift.R
import com.cookandroid.wildlift.R.drawable.ic_launcher_background

class CustomAdapter(private val championList: ArrayList<ChampionItem>, private val context: Context) : RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {

    // 실제 리스트뷰가 어댑터에 연결된 다음에 뷰 홀더를 최초로 만들어낸다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_log, parent, false)
        return CustomViewHolder(view)
    }

    // ImageView를 Glide를 사용하여 로드하고 info와 time도 대입시킨다.
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
//        var photoList = logList[position].logPhoto!!.split(",".toRegex()).toTypedArray()
//        var imageReference = Firebase.storage("gs://cerberus-592f9.appspot.com").reference.child("cerb1/" + photoList[0])
//        imageReference.downloadUrl.addOnSuccessListener { Uri ->
//            val imageURL = Uri.toString()
//            Glide.with(holder.itemView) // 띄어줄 뷰를 명시
//                .load(imageURL) // 이미지 주소
//                .into(holder.photo) // list_log의 imageView에 띄우기
//        }
//        holder.info.text = logList[position].logInfo
//        holder.time.text = logList[position].logTime


                    Glide.with(holder.itemView) // 띄어줄 뷰를 명시
                .load(R.drawable.ic_menu_send) // 이미지 주소
                .into(holder.photo) // list_log의 imageView에 띄우기
        holder.txtChampionName.text = championList[position].championName
        holder.txtChampionPosition.text = championList[position].championPosition
        holder.txtChampionIP.text = championList[position].ip
        holder.txtChampionRp.text = championList[position].rp
    }

    // ViewHolder를 만들어 list_log.xml의 아이템들을 정의한다.
    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var photo: ImageView = itemView.findViewById(R.id.imgChampion)
        var txtChampionName: TextView   = itemView.findViewById(R.id.txtName)
        var txtChampionPosition: TextView   = itemView.findViewById(R.id.txtPosition)
        var txtChampionIP:TextView = itemView.findViewById(R.id.txtIP)
        var txtChampionRp:TextView = itemView.findViewById(R.id.txtRp)

//        init {
//            itemView.setOnClickListener {
//                var pos = adapterPosition
//                if (pos != RecyclerView.NO_POSITION) {
//                    var item = logList[pos]
//                    var photoList = logList[pos].logPhoto!!.split(",".toRegex()).toTypedArray()
//                    var intent = Intent(itemView.context, LogFunction::class.java)
//                    intent.putExtra("logPhoto", photoList)
//                    intent.putExtra("logTime", item.logTime)
//                    ContextCompat.startActivity(itemView.context, intent, null)
//                }
//            }
//        }
    }

    // arrayList의 크기를 가져온다
    override fun getItemCount(): Int {
        return championList.size
    }
}