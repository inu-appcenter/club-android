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

package org.inu.club.feature.today

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import org.inu.club.R
import org.inu.club.databinding.TodayFragmentBinding
import org.potados.base.component.BaseFragment
import org.potados.base.extension.observeNotNull
import org.potados.base.extension.setSupportActionBar
import org.potados.base.extension.setupToolbarForNavigation
import org.potados.base.extension.setupToolbarMenu
import org.potados.base.util.Alert

class TodayFragment : BaseFragment<TodayFragmentBinding>() {

    private val viewModel: TodayViewModel by viewModels()

    override fun onCreateBinding(create: BindingCreator) = create<TodayFragmentBinding> {
        observeNotNull(viewModel.navigateEvent) {
            findNavController().navigate(it)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.home_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        viewModel.onClickOptionsMenu(item)
        return true
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)

        setSupportActionBar(R.id.toolbar)
        setupToolbarForNavigation(R.id.toolbar)
    }

}