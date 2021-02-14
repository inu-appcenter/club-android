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

package org.potados.base.extension

import org.potados.base.exception.*
import org.potados.base.exception.http.*
import org.potados.base.functional.Result
import retrofit2.Call
import timber.log.Timber
import java.io.IOException

/**
 * Get a response from a request as a [Result].
 * Throws nothing.
 * Body could be null.
 */
fun <T> Call<T>.getResult(): Result<T?> {
    try {
        val result = execute()

        return when {
            result.isSuccessful -> {
                Result.Success(result.body())
            }
            result.code() == 400 /* Bad request */ -> {
                Result.Error(BadRequestException(result.errorBody()?.string() ?: ""))
            }
            result.code() == 401 /* Unauthorized */ -> {
                Result.Error(UnauthorizedException(result.errorBody()?.string() ?: ""))
            }
            result.code() == 403 /* Forbidden */ -> {
                Result.Error(ForbiddenException(result.errorBody()?.string() ?: ""))
            }
            result.code() == 404 /* Not found */ -> {
                Result.Error(NotFoundException(result.errorBody()?.string() ?: ""))
            }
            result.code() == 500 /* Internal error */ -> {
                Result.Error(InternalErrorException(result.errorBody()?.string() ?: ""))
            }
            else -> {
                Timber.w(result.errorBody()?.string())
                Timber.w("Response failed with unhandled status code ${result.code()}.")
                Result.Error(ResponseFailException(result.code(), result.message()))
            }
        }
    } catch (e: IOException) {
        Timber.e(e)
        Timber.w("Server not responding.")

        return Result.Error(CannotTalkToServerException())
    } catch (e: Exception) {
        Timber.e(e)
        Timber.w("Unexpected exception during synchronous execution..")

        return Result.Error(e)
    }
}

/**
 * Get a response from a request and throw if it failed.
 * Might throw one of exceptions in [org.potados.base.exception.http],
 * or [CannotTalkToServerException] and [Exception].
 * Body could be null.
 */
fun <T> Call<T>.getOrThrow(): T? {
    when (val result = getResult()) {
        is Result.Success -> {
            return result.data
        }
        is Result.Error -> {
            throw result.exception
        }
    }
}