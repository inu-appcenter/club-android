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

import android.view.View
import androidx.annotation.CallSuper
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import timber.log.Timber

/**
 * Basic implementation of fundamental adapter features.
 */
abstract class BaseAdapter<T, VH: BaseViewHolder<T>> :
    RecyclerView.Adapter<VH>(),
    BasicAdapterFeatures<T> {

    override var loadingView: View? = null
        set(value) {
            field = value
            updatePeripheralViews()
        }

    override var isLoading: Boolean = false
        set(value) {
            field = value
            Timber.d("set loading $value")
            updatePeripheralViews()
        }

    override var emptyView: View? = null
        set(value) {
            field = value
            updatePeripheralViews()
        }

    override var items: List<T> = listOf()
        set(value) {
            val old = field

            field = value

            onItemsChanged(old, value)
            updatePeripheralViews()
        }

    override fun onItemsChanged(old: List<T>, new: List<T>) {
        notifyDataSetChanged()
    }

    @CallSuper
    protected open fun updatePeripheralViews() {
        emptyView?.isVisible = items.isEmpty() && !isLoading
        loadingView?.isVisible = isLoading
    }

    override fun getItemCount(): Int {
        return items.size
    }
}