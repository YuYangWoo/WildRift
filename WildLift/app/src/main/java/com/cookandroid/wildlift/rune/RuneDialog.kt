package com.cookandroid.wildlift.rune

import android.app.Dialog
import android.content.Context
import com.cookandroid.wildlift.R
import com.cookandroid.wildlift.base.BaseDialog
import com.cookandroid.wildlift.databinding.DialogItemInformationBinding
import com.cookandroid.wildlift.databinding.DialogRuneBinding
import com.cookandroid.wildlift.item.Item

class RuneDialog(context: Context, val item: Rune) : BaseDialog<DialogRuneBinding>(context, R.layout.dialog_rune) {
}