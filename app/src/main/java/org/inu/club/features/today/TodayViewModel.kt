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

import android.view.MenuItem
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import org.inu.club.R
import org.potados.base.component.BaseViewModel
import org.potados.base.network.util.SingleLiveEvent

class TodayViewModel : BaseViewModel() {

    val navigateEvent = SingleLiveEvent<Int>()

    private val _todayCards = MutableLiveData<List<TodayCard>>()
    val todayCards: LiveData<List<TodayCard>> = _todayCards

    private val _isLoading = MutableLiveData(true)
    val isLoading: LiveData<Boolean> = _isLoading

    fun load() {
        GlobalScope.launch {
            _isLoading.postValue(true)

            delay(1000)
            _todayCards.postValue(listOf()) // TODO: FETCH REAL DATA!

            _isLoading.postValue(false)
        }
    }

    fun onClickOptionsMenu(item: MenuItem) {
        when (item.itemId) {
            R.id.menu_profile -> showProfile()
            R.id.menu_notifications -> showNotifications()
        }
    }

    private fun showProfile() {
        notify("하하 아직 안만들었어요")
        navigateEvent.value = R.id.action_today_dest_to_my_page_dest
    }

    private fun showNotifications() {
        notify("하하 아직이에요!")
    }
}