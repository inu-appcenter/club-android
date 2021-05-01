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

package org.inu.club.features.today

import android.os.Bundle
import android.view.View
import androidx.databinding.BindingAdapter
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import org.inu.club.R
import org.inu.club.databinding.TodayFragmentBinding
import org.potados.base.component.BaseFragment
import org.potados.base.extension.observeNotNull
import org.potados.base.extension.setupToolbarForNavigation
import org.potados.base.extension.setupToolbarMenu
import timber.log.Timber

class TodayFragment : BaseFragment<TodayFragmentBinding>() {

    private val viewModel: TodayViewModel by viewModels()

    override fun onCreateBinding(create: BindingCreator) = create<TodayFragmentBinding> {
        with(todayCardsRecycler) {
            adapter = TodayCardsAdapter().apply {
                emptyView = emptyCardsView
                loadingView = loadingCardsView
            }
        }

        with(viewModel) {
            vm = this

            observeNotNull(navigateEvent) {
                findNavController().navigate(it)
            }

            load()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbarForNavigation(R.id.toolbar)
        setupToolbarMenu(R.id.toolbar, R.menu.home_menu) {
            viewModel.onClickOptionsMenu(it)
            true
        }
    }

    companion object {
        @JvmStatic
        @BindingAdapter("todayCards")
        fun setTodayCards(view: RecyclerView, cards: List<TodayCard>?) {
            cards ?: return

            (view.adapter as? TodayCardsAdapter)?.items = cards
        }

        @JvmStatic
        @BindingAdapter("isTodayCardsLoading")
        fun setTodayCardsLoading(view: RecyclerView, isLoading: Boolean?) {
            isLoading ?: return

            (view.adapter as? TodayCardsAdapter)?.isLoading = isLoading
        }
    }
}