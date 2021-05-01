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

package org.inu.club.features.main

import android.content.Context
import android.content.Intent
import org.inu.club.R
import org.potados.base.component.NavigationActivity
import org.potados.base.component.NavigationHostFragment

class MainActivity : NavigationActivity() {

    override val menuRes: Int = R.menu.bottom_menu
    override val layoutRes: Int = R.layout.main_activity
    override val mainPagerRes: Int = R.id.main_pager
    override val bottomNavRes: Int = R.id.bottom_nav

    override val fragmentArguments: List<NavigationHostFragment.Arguments> = listOf(

        /** Today(Home) */
        NavigationHostFragment.createArguments(
            layoutRes = R.layout.content_today_base,
            toolbarId = -1, // Unmanaged toolbar.
            navHostId = R.id.nav_host_today,
            tabItemId = R.id.tab_today
        ),

        /** Suggestions */
        NavigationHostFragment.createArguments(
            layoutRes = R.layout.content_suggestions_base,
            toolbarId = -1, // Unmanaged toolbar.
            navHostId = R.id.nav_host_suggestions,
            tabItemId = R.id.tab_suggestions
        ),

        /** Search */
        NavigationHostFragment.createArguments(
            layoutRes = R.layout.content_search_base,
            toolbarId = -1, // Unmanaged toolbar.
            navHostId = R.id.nav_host_search,
            tabItemId = R.id.tab_search
        ),

        /** Categories */
        NavigationHostFragment.createArguments(
            layoutRes = R.layout.content_categories_base,
            toolbarId = -1, // Unmanaged toolbar.
            navHostId = R.id.nav_host_categories,
            tabItemId = R.id.tab_categories
        ),

        /** Gathering */
        NavigationHostFragment.createArguments(
            layoutRes = R.layout.content_gatherings_base,
            toolbarId = R.id.toolbar,
            navHostId = R.id.nav_host_gatherings,
            tabItemId = R.id.tab_gatherings
        )
    )

    companion object {
        fun callingIntent(context: Context) = Intent(context, MainActivity::class.java)
    }
}