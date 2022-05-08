package models

import com.github.javafaker.Faker

class PersonalInfoModel {
    val firstname: String
    val lastname: String
    val zipCode: String

    init {
        val faker = Faker()
        firstname = faker.name().firstName()
        lastname = faker.name().lastName()
        zipCode = faker.address().zipCode()
    }
}