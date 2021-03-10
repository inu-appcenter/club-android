/**
 * This file is part of INU Club.
 *
 * Copyright (C) 2021 INU Global App Center <potados99@gmail.com>
 *
 * INU Club is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * INU Club is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.potados.base.util

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import org.potados.base.android.ContextHolder

object Alert {
    fun show(
        text: CharSequence?,
        duration: Int = Toast.LENGTH_SHORT,
        context: Context? = ContextHolder.applicationContext
        ) {
        Toast.makeText(context, text, duration).show()
    }

    fun show(
        @StringRes resId: Int,
        duration: Int = Toast.LENGTH_SHORT,
        context: Context? = ContextHolder.applicationContext
        ) {
        Toast.makeText(context, resId, duration).show()
    }
}