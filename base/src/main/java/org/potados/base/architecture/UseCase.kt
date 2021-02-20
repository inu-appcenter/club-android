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

package org.potados.base.architecture

import org.potados.base.functional.Result
import kotlinx.coroutines.*
import timber.log.Timber

/**
 * Abstract class for Use Case (Interactor in terms of Clean Architecture).
 * Any use case in this application should implement this.
 *
 * 레이어에 진입하기 위한 DTO의 정의는 해당 레이어에 둡니다.
 * 예를 들어, UseCase(domain 레이어)의 파라미터(input port)는 해당 UseCase 근처에 둡니다.
 * 그리고 presentation 레이어에서 쓰는 view도 해당 레이어 안에 둡니다.
 *
 * 엔티티도 단일 책임 원칙을 준수해야 합니다. 엔티티 변경에 의해 다른 레이어까지 영향이 퍼지는 것은 좋지 않습니다.
 */
abstract class UseCase<in Params, out Type> {
    abstract fun run(params: Params): Result<Type>

    operator fun invoke(params: Params, onResult: (Result<Type>) -> Unit = {}) {

        val className = this::class.java.name

        val job = CoroutineScope(Dispatchers.IO).async {
            Timber.v("UseCase $className running on ${Thread.currentThread().name}")
            run(params)
        }

        MainScope().launch {
            onResult(job.await())
        }
    }
}