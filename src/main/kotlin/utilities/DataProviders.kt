package utilities

import models.CredentialsModel
import models.PersonalInfoModel

class DataProviders {
    fun getValidCredentials() : CredentialsModel? {
        return MapParser().getCredentialsMap()["valid"]
    }

    fun getPersonalInfo(): PersonalInfoModel {
        return PersonalInfoModel()
    }
 }