/*
 * Copyright (c) 2020 jesusd0897.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jesusd0897.sheety

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.LinearLayoutCompat
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.jesusd0897.sheety.util.setSafeOnClickListener

class SheetyBuilder(private val context: Context) {

    private var title: String? = null
    private var items = mutableListOf<SheetyItem>()

    private val root: View =
        LayoutInflater.from(context).inflate(R.layout.sheety_dialog_layout, null)
    private var sheetDialog: BottomSheetDialog? = null

    private fun bind(): View {
        root.findViewById<AppCompatTextView>(R.id.title).text = title
        val container: LinearLayoutCompat = root.findViewById(R.id.container)
        items.forEach { item ->
            val itemView = LayoutInflater.from(context)
                .inflate(R.layout.shety_item, null) as AppCompatButton
            itemView.id = View.generateViewId()
            itemView.text = item.label
            item.icon?.let { icon ->
                itemView.setCompoundDrawablesWithIntrinsicBounds(icon, 0, 0, 0)
            }
            itemView.setSafeOnClickListener { v: View ->
                item.clickListener?.onClick(v)
                if (sheetDialog != null) sheetDialog!!.dismiss()
            }
            container.addView(itemView)
        }
        return root
    }

    fun build(): BottomSheetDialog {
        sheetDialog = BottomSheetDialog(context).apply {
            setContentView(bind())
        }
        return sheetDialog!!
    }

    fun show() = build().show()

    fun title(title: String?): SheetyBuilder {
        this.title = title
        return this
    }

    fun title(@StringRes title: Int): SheetyBuilder {
        this.title = context.getString(title)
        return this
    }

    fun item(
        @StringRes label: Int,
        @DrawableRes icon: Int? = null,
        clickListener: View.OnClickListener? = null
    ): SheetyBuilder {
        val item = SheetyItem(context.getString(label), icon, clickListener)
        this.items.add(item)
        return this
    }

    fun item(
        label: String,
        @DrawableRes icon: Int? = null,
        clickListener: View.OnClickListener? = null
    ): SheetyBuilder {
        val item = SheetyItem(label, icon, clickListener)
        this.items.add(item)
        return this
    }

}