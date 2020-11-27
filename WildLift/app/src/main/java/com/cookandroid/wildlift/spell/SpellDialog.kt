package com.cookandroid.wildlift.spell

import android.content.Context
import com.cookandroid.wildlift.R
import com.cookandroid.wildlift.base.BaseDialog
import com.cookandroid.wildlift.databinding.DialogSpellBinding

class SpellDialog(context: Context, val spell: SpellItem) : BaseDialog<DialogSpellBinding>(context, R.layout.dialog_spell) {
}