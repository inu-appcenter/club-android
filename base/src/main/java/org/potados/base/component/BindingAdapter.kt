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

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * An adapter with generic data binding.
 */
abstract class BindingAdapter<T, BindingT: ViewDataBinding>(
    private val bindingVariableId: Int /* BR.item maybe */
    ) : BaseAdapter<T, BindingAdapter<T, BindingT>.BindingViewHolder>() {

    /**
     * Use this to add an item click listener.
     */
    var onClickRootLayout: (item: T) -> Unit = {}

    /**
     * Override this to let the adapter know which layout to inflate.
     */
    abstract fun getLayoutIdForPosition(position: Int): Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = DataBindingUtil.inflate<BindingT>(inflater, viewType, parent, false)

        return BindingViewHolder(binding)
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        val item = items[position]

        holder.bind(item)

        onBindFinished(item, holder)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    /**
     * Override this to do additional jobs not done with data binding.
     * e.g. setting click listeners.
     */
    open fun onBindFinished(item: T, holder: BindingViewHolder) {}

    inner class BindingViewHolder(val binding: BindingT) : BaseViewHolder<T>(binding.root) {

        override fun bind(item: T) {
            with(this.binding) {
                setVariable(bindingVariableId, item)
                executePendingBindings()
            }

            with(this.binding.root) {
                setOnClickListener { onClickRootLayout(item) }
            }
        }
    }
}