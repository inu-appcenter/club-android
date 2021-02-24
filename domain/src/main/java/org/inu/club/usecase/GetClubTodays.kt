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

package org.inu.club.usecase

import org.inu.club.entity.ClubToday
import org.inu.club.repository.ClubRepository
import org.potados.base.architecture.UseCase
import org.potados.base.functional.Result

/**
 * 동아리 투데이를 모두 가져옵니다.
 */
class GetClubTodays(
    private val clubRepository: ClubRepository
) : UseCase<UseCase.None, List<ClubToday>>() {

    override fun run(params: None) = Result.of {
        clubRepository.getAllClubTodays()
    }
}