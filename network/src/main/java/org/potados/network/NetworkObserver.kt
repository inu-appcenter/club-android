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

package org.potados.network

import android.content.Context
import android.net.ConnectivityManager
import org.potados.network.repository.DeviceStatusRepository
import org.potados.network.util.PublicLiveEvent

object NetworkObserver {

    private var deviceStatusRepository: DeviceStatusRepository? = null

    fun start(context: Context) {
        deviceStatusRepository = DeviceStatusRepository(
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        ).apply {
            initialize()
        }
    }

    val isOnline: Boolean
        get() = deviceStatusRepository?.isOnline()
            ?: throw IllegalStateException("NetworkObserver not started yet!")

    val networkChangeEvent: PublicLiveEvent<Boolean>
        get() = deviceStatusRepository?.networkStateChangeEvent()
            ?: throw IllegalStateException("NetworkObserver not started yet!")

}