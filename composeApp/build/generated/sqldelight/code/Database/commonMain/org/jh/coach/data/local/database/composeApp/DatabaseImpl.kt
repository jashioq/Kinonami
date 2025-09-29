package org.jh.coach.`data`.local.database.composeApp

import app.cash.sqldelight.TransacterImpl
import app.cash.sqldelight.db.AfterVersion
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import kotlin.Long
import kotlin.Unit
import kotlin.reflect.KClass
import org.jh.coach.`data`.local.database.Database
import org.jh.coach.`data`.local.database.DatabaseQueries

internal val KClass<Database>.schema: SqlSchema<QueryResult.Value<Unit>>
  get() = DatabaseImpl.Schema

internal fun KClass<Database>.newInstance(driver: SqlDriver): Database = DatabaseImpl(driver)

private class DatabaseImpl(
  driver: SqlDriver,
) : TransacterImpl(driver), Database {
  override val databaseQueries: DatabaseQueries = DatabaseQueries(driver)

  public object Schema : SqlSchema<QueryResult.Value<Unit>> {
    override val version: Long
      get() = 1

    override fun create(driver: SqlDriver): QueryResult.Value<Unit> {
      driver.execute(null, """
          |CREATE TABLE GoalDto (
          |    id INTEGER PRIMARY KEY AUTOINCREMENT,
          |    name TEXT NOT NULL,
          |    frequency INTEGER NOT NULL,
          |    state INTEGER NOT NULL,
          |    completions TEXT NOT NULL,
          |    creationDate TEXT DEFAULT (datetime('now')) NOT NULL,
          |    modificationDate TEXT DEFAULT (datetime('now')) NOT NULL
          |)
          """.trimMargin(), 0)
      driver.execute(null, "PRAGMA user_version = 1", 0)
      return QueryResult.Unit
    }

    override fun migrate(
      driver: SqlDriver,
      oldVersion: Long,
      newVersion: Long,
      vararg callbacks: AfterVersion,
    ): QueryResult.Value<Unit> = QueryResult.Unit
  }
}
