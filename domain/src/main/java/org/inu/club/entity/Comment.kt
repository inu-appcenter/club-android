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
 * 소모임 댓글.
 */
data class Comment(
        val id: Int,
        val content: String,
        val date: Long,
        val user: User,
        val replying: Comment?,
        val replies: List<Comment>
) : Entity {

    fun canWeAddReply(): Boolean {
        /**
         * 대댓글은 1단계만 허용합니다.
         * 이 댓글이 대댓글이 아니어야(=reply하는 댓글이 없어야) 이 댓글에 대댓글을 달 수 있습니다.
         */
        return replying == null
    }
}