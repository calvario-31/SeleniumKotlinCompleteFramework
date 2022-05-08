package utilities

import models.CredentialsModel

class MapParser {
    fun getCredentialsMap() : HashMap<String, CredentialsModel> {
        val hashMap = HashMap<String, CredentialsModel>()
        val credentialList = ExcelReader().getCredentialsList()

        credentialList.forEach{
            hashMap[it.key] = it
        }
        return hashMap
    }
}