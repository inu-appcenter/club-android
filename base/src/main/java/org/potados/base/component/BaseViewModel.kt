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

package org.potados.base.component

import android.content.Context
import androidx.lifecycle.ViewModel
import org.potados.base.R
import org.potados.base.android.appContext
import org.potados.base.exception.CannotTalkToServerException
import org.potados.base.exception.NullBodyException
import org.potados.base.exception.ResponseFailException
import org.potados.base.exception.http.InternalErrorException
import org.potados.base.util.Alert
import org.potados.base.network.NetworkObserver

abstract class BaseViewModel : ViewModel(), ContextOwner, Verbal, NetworkSensitive, FailureFriendly {

    /****************************************************************
     * [ContextOwner]
     ****************************************************************/

    override val context: Context by appContext()

    /****************************************************************
     * [Verbal]
     ****************************************************************/

    override fun notify(message: String?) {
        Alert.show(message)
    }

    override fun notify(message: Int, vararg args: Any?) {
        notify(context.getString(message, *args))
    }

    /****************************************************************
     * [NetworkSensitive]
     ****************************************************************/

    override fun handleIfOffline(): Boolean {
        if (isOffline()) {
            onOffline()
        }

        return isOffline()
    }

    override fun isOnline() = NetworkObserver.isOnline
    override fun isOffline() = !NetworkObserver.isOnline

    /**
     * Override this to change a behavior when the network connection is lost.
     */
    protected fun onOffline() {
        notify(R.string.sorry_to_be_offline)
    }

    /****************************************************************
     * [FailureFriendly]
     ****************************************************************/

    override fun handleFailure(e: Exception) {
        val errorMessage = when (e) {
            // General failures are handled here.
            is CannotTalkToServerException -> context.getString(R.string.fail_connection)
            is InternalErrorException -> context.getString(R.string.fail_server_internal)
            is ResponseFailException -> context.getString(R.string.fail_unsuccessful_response)
            is NullBodyException -> context.getString(R.string.fail_null_body)
            else -> e.message
        }

        notify(errorMessage)
    }

    override fun handleFailure(message: Int, vararg args: Any?) {
        notify(message, args)
    }
}