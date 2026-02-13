package coreDatabase.di

import app.cash.sqldelight.db.SqlDriver
import coreDatabase.AppDatabase
import coreDatabase.SqlDriverFactory
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun getCoreDatabaseModule(): Module {
    return module {
        single { SqlDriverFactory().getSqlDriver() }
        single { AppDatabase.invoke(driver = get<SqlDriver>()) }
    }
}