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

package org.inu.club.common

import android.app.Application
import org.inu.club.injection.myModules
import org.koin.android.ext.koin.androidContext
import org.potados.base.android.ContextHolder
import org.potados.network.NetworkObserver
import timber.log.Timber

class ThisApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startBaseModule()
        startTimber()
        startKoin()
        startNetworkObserver()
    }

    private fun startBaseModule() {
        ContextHolder.setApplicationContext(this)
    }

    private fun startTimber() {
        Timber.plant(Timber.DebugTree())
    }

    private fun startKoin() {
        org.koin.core.context.startKoin {
            androidContext(this@ThisApplication)
            modules(myModules)
        }
    }

    private fun startNetworkObserver() {
        NetworkObserver.start(this)
    }
}