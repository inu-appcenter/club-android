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

package org.potados.base.extension

import android.app.Activity
import android.view.View

/**
 * Sets status bar color to [android.R.attr.windowBackground].
 * Status bar UI color will turn black.
 */
fun Activity.setStatusBarLight() {
    window?.statusBarColor = resolveThemeColor(android.R.attr.windowBackground)
    window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
}

/**
 * Sets status bar color to [android.R.attr.statusBarColor].
 *  * Status bar UI color will turn white.
 */
fun Activity.setStatusBarDark() {
    window?.statusBarColor = resolveThemeColor(android.R.attr.statusBarColor)
    window?.decorView?.systemUiVisibility = 0
}