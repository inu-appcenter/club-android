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

package org.inu.club.entity

import org.inu.club.entity.base.Entity

/**
 * 동아리 추천입니다.
 *
 * 아래와 같은 형태를 가집니다:
 * ClubSuggestions {
 *     theme: "새내기를 위한 추천",
 *     clubs: [동아리1, 동아리2]
 * }
 *
 * "인기", "추천"과 같이 추천 동아리를 분류하는 기준은 이 엔티티 안에 나타나지 않습니다.
 */
data class ClubSuggestions(
    val theme: String,
    val clubs: List<Club>
) : Entity