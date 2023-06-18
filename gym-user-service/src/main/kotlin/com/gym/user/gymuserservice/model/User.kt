package com.gym.user.gymuserservice.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "`user`")
class User(
    @Column(name = "full_name")
    var fullName: String = "",

    @Column(name= "phone_number")
    var phoneNumber: String = "",

    @Column(name = "password")
    var password: String = "",

    @Column(name = "email_address")
    var emailAddress: String = "",

    @Column (name = "account_status")
    var accountStatus: String = ""
): BaseEntity() {
}