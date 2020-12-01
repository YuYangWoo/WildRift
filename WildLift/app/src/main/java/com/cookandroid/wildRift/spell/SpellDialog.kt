package com.cookandroid.wildRift.spell

import android.content.Context
import com.cookandroid.wildRift.R
import com.cookandroid.wildRift.base.BaseDialog
import com.cookandroid.wildRift.databinding.DialogSpellBinding

class SpellDialog(context: Context, val spell: SpellItem) : BaseDialog<DialogSpellBinding>(context, R.layout.dialog_spell) {
}