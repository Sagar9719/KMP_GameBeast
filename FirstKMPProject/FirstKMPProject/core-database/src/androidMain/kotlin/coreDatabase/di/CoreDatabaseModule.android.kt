package coreDatabase.di

import org.koin.core.module.Module
import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import coreDatabase.AppDatabase
import coreDatabase.SqlDriverFactory
import org.koin.dsl.module

actual fun getCoreDatabaseModule(): Module {
    return module {
        single { SqlDriverFactory(context = get<Context>()).getSqlDriver() }
        single { AppDatabase.invoke(driver = get<SqlDriver>()) }
    }
}