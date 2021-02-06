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

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.Toolbar
import androidx.navigation.ui.NavigationUI
import androidx.navigation.fragment.findNavController

fun Fragment.setupToolbarForNavigation(toolbar: Toolbar) {
    val navController = findNavController()

    NavigationUI.setupWithNavController(toolbar, navController)
}

fun Fragment.setupToolbarForNavigation(@IdRes toolbarId: Int) {
    val toolbar = view?.findViewById<Toolbar>(toolbarId) ?: return

    setupToolbarForNavigation(toolbar)
}