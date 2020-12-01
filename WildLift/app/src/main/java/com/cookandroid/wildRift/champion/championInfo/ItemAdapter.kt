package com.cookandroid.wildRift.champion.championInfo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cookandroid.wildRift.R
import com.cookandroid.wildRift.item.Item
import com.cookandroid.wildRift.item.dialog.ItemInformationDialog
import com.cookandroid.wildRift.rune.Rune
import com.cookandroid.wildRift.rune.RuneDialog
import com.cookandroid.wildRift.singleton.FirebaseSingleton
import com.cookandroid.wildRift.spell.SpellDialog
import com.cookandroid.wildRift.spell.SpellFactory
import com.cookandroid.wildRift.spell.SpellItem

class ItemAdapter constructor() : RecyclerView.Adapter<ItemAdapter.CustomViewHolder>() {

    var itemList = ArrayList<ItemType>()

    constructor(itemList: ArrayList<ItemType>) : this() {
        this.itemList = itemList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item_spell_rune, parent, false)

        return when(viewType) {
            ItemType.ITEM -> {
                ItemViewHolder(view)
            }
            ItemType.RUNE -> {
                RuneViewHolder(view)
            }
            ItemType.SPELL -> {
                SpellViewHolder(view)
            }
            else -> {
                CustomViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: ItemAdapter.CustomViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemViewType(position: Int): Int {
        return itemList[position].type
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    data class ItemType(
        var type: Int,
        var url: String
    ) {
        companion object {
            const val ITEM = 0
            const val RUNE = 1
            const val SPELL = 2
        }
    }

    open class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img = itemView.findViewById<ImageView>(R.id.imgItem)
        lateinit var itemType: ItemType

        fun bind(itemType: ItemType) {
            this.itemType = itemType
            Glide.with(itemView).load(itemType.url).into(img)
        }
    }

    class ItemViewHolder(itemView: View) : CustomViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                val item = run{
                    FirebaseSingleton.itemList.forEach {
                        if (itemType.url == it.imageURL) {
                            return@run it
                        }
                    }

                    return@run Item()
                }

                ItemInformationDialog(itemView.context, item).show()
            }
        }
    }

    class RuneViewHolder(view: View) : CustomViewHolder(view) {
        init {
            itemView.setOnClickListener {
                val rune = run{
                    FirebaseSingleton.runeList.forEach {
                        if (itemType.url == it.image) {
                            return@run it
                        }
                    }

                    return@run Rune()
                }

                RuneDialog(itemView.context, rune).show()
            }
        }
    }

    class SpellViewHolder(view: View) : CustomViewHolder(view) {
        init {
            itemView.setOnClickListener {
                val spell = run{
                    SpellFactory.spellList.forEach {
                        if (itemType.url == it.image) {
                            return@run it
                        }
                    }

                    return@run SpellItem()
                }

                SpellDialog(itemView.context, spell).show()
            }
        }
    }
}