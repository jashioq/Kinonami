package org.jh.coach.`data`.local.database

import app.cash.sqldelight.Transacter
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import kotlin.Unit
import org.jh.coach.`data`.local.database.composeApp.newInstance
import org.jh.coach.`data`.local.database.composeApp.schema

public interface Database : Transacter {
  public val databaseQueries: DatabaseQueries

  public companion object {
    public val Schema: SqlSchema<QueryResult.Value<Unit>>
      get() = Database::class.schema

    public operator fun invoke(driver: SqlDriver): Database = Database::class.newInstance(driver)
  }
}
