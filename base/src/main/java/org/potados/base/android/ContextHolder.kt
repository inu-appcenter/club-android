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

package org.potados.base.android

import android.content.Context

/**
 * A context holder.
 * Some components in this module require application context.
 * This holder supplies an application-level context, therefore you MUST set it up.
 */
object ContextHolder {

    private var appContext: Context? = null

    /**
     * YOU MUST CALL IT!!
     * Call it in [android.app.Application.onCreate].
     */
    fun setApplicationContext(context: Context) {
        appContext = context
    }

    val applicationContext: Context
        get() {
            return appContext ?: throw Exception("setApplicationContext must be called before use.")
        }
}

/**
 * Use this like below:
 * val context: Context by appContext()
 */
fun appContext(): Lazy<Context> {
    return lazy {
        ContextHolder.applicationContext
    }
}