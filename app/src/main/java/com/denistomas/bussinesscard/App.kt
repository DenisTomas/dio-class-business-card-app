package com.denistomas.bussinesscard

import android.app.Application
import com.denistomas.bussinesscard.data.AppDataBase
import com.denistomas.bussinesscard.data.BusinessCardRepository

class App : Application() {

    val dataBase by lazy { AppDataBase.getDataBase(this) }
    val repository by lazy { BusinessCardRepository(dataBase.businessDao()) }

}