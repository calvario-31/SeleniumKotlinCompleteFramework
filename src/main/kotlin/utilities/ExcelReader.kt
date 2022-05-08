package utilities

import com.poiji.bind.Poiji
import models.CredentialsModel
import java.io.File

class ExcelReader {
    private val excelPath = "src/test/resources/data/data.xlsx"

    fun getCredentialsList(): List<CredentialsModel> {
        return Poiji.fromExcel(File(excelPath), CredentialsModel::class.java)
    }
}