package com.cookandroid.wildlift.singleton

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.cookandroid.wildlift.R
import com.cookandroid.wildlift.item.Item
import com.cookandroid.wildlift.rune.Rune
import com.cookandroid.wildlift.spell.SpellItem

object DataBindingAdapter {
    @JvmStatic
    @BindingAdapter("itemImage")
    fun setItemImage(view: ImageView, item: Item) {
        Glide.with(view.context)
            .load(item.imageURL)
            .placeholder(R.drawable.ic_coin)
            .error(R.drawable.ic_menu_send)
            .into(view)
    }

    @JvmStatic
    @BindingAdapter("itemImage")
    fun setRuneImage(view: ImageView, rune: Rune) {
        Glide.with(view.context)
            .load(rune.image)
            .error(R.drawable.ic_menu_send)
            .into(view)
    }

    @JvmStatic
    @BindingAdapter("itemImage")
    fun setRuneImage(view: ImageView, spell: SpellItem) {
        Glide.with(view.context)
            .load(spell.image)
            .error(R.drawable.ic_menu_send)
            .into(view)
    }

    @JvmStatic
    @BindingAdapter("cost")
    fun setTotalCost(view: TextView, item: Item) {
        view.text = "${view.context.getString(R.string.total_cost)} : ${String.format("%,d", item.cost)} "
    }

    @JvmStatic
    @BindingAdapter("image")
    fun setImage(view: ImageView, image: String) {
        Glide.with(view)
            .load(image)
            .error(R.drawable.ic_menu_send)
            .into(view)
    }

    @JvmStatic
    @BindingAdapter("hp")
    fun setHP(view: TextView, hp: String) {
        view.text = "${view.context.getString(R.string.hp)} : $hp "
    }

    @JvmStatic
    @BindingAdapter("mp")
    fun setMP(view: TextView, mp: String) {
        view.text = "${view.context.getString(R.string.mp)} : $mp "
    }

    @JvmStatic
    @BindingAdapter("attack")
    fun setAttack(view: TextView, attack: String) {
        view.text = "${view.context.getString(R.string.attack)} : $attack "
    }

    @JvmStatic
    @BindingAdapter("spell_power")
    fun setSpellPower(view: TextView, spellPower: String) {
        view.text = "${view.context.getString(R.string.spell_power)} : $spellPower "
    }

    @JvmStatic
    @BindingAdapter("armor")
    fun setArmor(view: TextView, armor: String) {
        view.text = "${view.context.getString(R.string.armor)} : $armor "
    }

    @JvmStatic
    @BindingAdapter("magic_resistance")
    fun setMagicResistance(view: TextView, magicResistance: String) {
        view.text = "${view.context.getString(R.string.magic_resistance)} : $magicResistance "
    }

    @JvmStatic
    @BindingAdapter("attack_speed")
    fun setAttackSpeed(view: TextView, attackSpeed: String) {
        view.text = "${view.context.getString(R.string.attack_speed)} : $attackSpeed "
    }

    @JvmStatic
    @BindingAdapter("cooltime")
    fun setCoolTime(view: TextView, cooltime: String) {
        view.text = "${view.context.getString(R.string.cooltime)} : $cooltime"
    }

    @JvmStatic
    @BindingAdapter("critical_chance")
    fun setCriticalChance(view: TextView, criticalChance: String) {
        view.text = "${view.context.getString(R.string.critical_chance)} : $criticalChance"
    }

    @JvmStatic
    @BindingAdapter("critical_damage")
    fun setCriticalDamage(view: TextView, criticalDamage: String) {
        view.text = "${view.context.getString(R.string.critical_damage)} : $criticalDamage"
    }
}