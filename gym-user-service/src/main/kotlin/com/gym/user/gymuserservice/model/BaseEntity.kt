package com.gym.user.gymuserservice.model

import com.devskiller.friendly_id.FriendlyId
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.Size

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
open class BaseEntity(id: String? = null) : Serializable {
    @Id
    @Column(name = "id")
    var id: @Size(max = 200) String?
        protected set

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    var createdAt: LocalDateTime = LocalDateTime.now()

    @LastModifiedDate
    @Column(name = "updated_at")
    var updatedAt: LocalDateTime = LocalDateTime.now()

    @CreatedBy
    @Column(name = "created_by")
    var createdBy: String = ""

    @LastModifiedBy
    @Column(name = "updated_by")
    var updatedBy: String = ""

    init {
        this.id = id ?: FriendlyId.createFriendlyId()
    }
}