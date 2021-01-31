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

import android.content.pm.PackageManager
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import org.potados.base.extension.observe
import org.potados.network.NetworkObserver

/**
 * A base activity that handles:
 * - network changes
 * - permission requests
 */
abstract class BaseActivity :
    AppCompatActivity(),
    NetworkChangeObserver,
    PermissionFighter {

    /** AppCompatActivity */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        observeNetworkStateChange(savedInstanceState == null)
        getRuntimePermissions()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode != REQUEST_CODE_PERMISSIONS) {
            return
        }

        if (allPermissionsGranted()) {
            onAllPermissionsGranted()
        } else {
            onPermissionNotGranted()
        }
    }

    /** NetworkChangeObserver */
    protected fun isOnline() = NetworkObserver.isOnline

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

    /** PermissionFighter */
    override val requiredPermissions: Array<String> = arrayOf()

    override fun onAllPermissionsGranted() {}

    override fun onPermissionNotGranted() {}

    override fun allPermissionsGranted(): Boolean {
        return requiredPermissions.all {
            isPermissionGranted(it)
        }
    }

    private fun isPermissionGranted(permission: String): Boolean {
        return ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
    }

    private fun getRuntimePermissions() {
        val allNeededPermissions = requiredPermissions
            .filter { !isPermissionGranted(it) }
            .toTypedArray()

        if (allNeededPermissions.isNotEmpty()) {
            ActivityCompat.requestPermissions(this, allNeededPermissions, REQUEST_CODE_PERMISSIONS)
        }
    }

    companion object {
        private const val REQUEST_CODE_PERMISSIONS = 10
    }
}