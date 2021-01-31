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

package org.potados.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import org.potados.base.extension.observe
import org.potados.network.NetworkObserver

abstract class BaseFragment<T: ViewDataBinding> : BindingOwner<T>, Fragment(), NetworkChangeObserver {

    /** BindingOwner */
    override var binding: T? = null

    /** Fragment */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        observeNetworkStateChange(savedInstanceState == null)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = onCreateView(ViewCreator(this, inflater, container, ::setBindingIfPossible))
        ?: super.onCreateView(inflater, container, savedInstanceState)

    private fun setBindingIfPossible(unknownBinding: ViewDataBinding?) {
        unknownBinding ?: return

        @Suppress("UNCHECKED_CAST")
        val casted = unknownBinding as? T

        if (casted == null) {
            Log.e("BaseFragment", "Wrong binding type!!")
            return
        }

        binding = casted
    }

    protected open fun onCreateView(create: ViewCreator): View? = null

    class ViewCreator(
        val fragment: Fragment,
        val inflater: LayoutInflater,
        val container: ViewGroup?,
        val onFinishBinding: (ViewDataBinding) -> Unit
    ) {
        inline operator fun <reified ReifiedT: ViewDataBinding> invoke(also: ReifiedT.() -> Unit = {}) =
            createView(also)

        inline fun <reified ReifiedT: ViewDataBinding> createView(also: ReifiedT.() -> Unit = {}): View {
            val inflateMethod = ReifiedT::class.java.getMethod(
                "inflate",
                LayoutInflater::class.java,
                ViewGroup::class.java,
                Boolean::class.java
            )

            return (inflateMethod.invoke(null, inflater, container, false) as ReifiedT)
                .apply { lifecycleOwner = fragment }
                .apply { onFinishBinding(this) }
                .apply { also(this) }
                .root
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        binding = null
    }

    /** NetworkChangeObserver */
    private fun isOnline() = NetworkObserver.isOnline

    private fun observeNetworkStateChange(isThisFirstTimeCreated: Boolean) {
        if (isThisFirstTimeCreated) {
            onNetworkStateChange(isOnline())
        }

        observe(NetworkObserver.networkChangeEvent) {
            it?.let(::onNetworkStateChange)
        }
    }

    override fun onNetworkStateChange(available: Boolean) {
        // Make your implementation here.
    }

    @PublishedApi
    internal var accessBinding: T?
        get() = binding
        set(value) {
            binding = value
        }
}