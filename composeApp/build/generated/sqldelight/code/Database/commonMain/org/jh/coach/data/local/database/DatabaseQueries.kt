package org.jh.coach.`data`.local.database

import app.cash.sqldelight.ExecutableQuery
import app.cash.sqldelight.Query
import app.cash.sqldelight.TransacterImpl
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlCursor
import app.cash.sqldelight.db.SqlDriver
import kotlin.Any
import kotlin.Long
import kotlin.String

public class DatabaseQueries(
  driver: SqlDriver,
) : TransacterImpl(driver) {
  public fun selectLastInsertedRowId(): ExecutableQuery<Long> = Query(-421_880_656, driver,
      "database.sq", "selectLastInsertedRowId", "SELECT last_insert_rowid()") { cursor ->
    cursor.getLong(0)!!
  }

  public fun <T : Any> selectAllGoals(mapper: (
    id: Long,
    name: String,
    frequency: Long,
    state: Long,
    completions: String,
    creationDate: String,
    modificationDate: String,
  ) -> T): Query<T> = Query(1_464_967_990, arrayOf("GoalDto"), driver, "database.sq",
      "selectAllGoals",
      "SELECT GoalDto.id, GoalDto.name, GoalDto.frequency, GoalDto.state, GoalDto.completions, GoalDto.creationDate, GoalDto.modificationDate FROM GoalDto") {
      cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getLong(2)!!,
      cursor.getLong(3)!!,
      cursor.getString(4)!!,
      cursor.getString(5)!!,
      cursor.getString(6)!!
    )
  }

  public fun selectAllGoals(): Query<GoalDto> = selectAllGoals { id, name, frequency, state,
      completions, creationDate, modificationDate ->
    GoalDto(
      id,
      name,
      frequency,
      state,
      completions,
      creationDate,
      modificationDate
    )
  }

  public fun <T : Any> selectGoalById(id: Long, mapper: (
    id: Long,
    name: String,
    frequency: Long,
    state: Long,
    completions: String,
    creationDate: String,
    modificationDate: String,
  ) -> T): Query<T> = SelectGoalByIdQuery(id) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getLong(2)!!,
      cursor.getLong(3)!!,
      cursor.getString(4)!!,
      cursor.getString(5)!!,
      cursor.getString(6)!!
    )
  }

  public fun selectGoalById(id: Long): Query<GoalDto> = selectGoalById(id) { id_, name, frequency,
      state, completions, creationDate, modificationDate ->
    GoalDto(
      id_,
      name,
      frequency,
      state,
      completions,
      creationDate,
      modificationDate
    )
  }

  public fun insertGoal(
    name: String,
    frequency: Long,
    state: Long,
    completions: String,
  ) {
    driver.execute(1_837_471_335,
        """INSERT INTO GoalDto (name, frequency, state, completions) VALUES (?, ?, ?, ?)""", 4) {
          bindString(0, name)
          bindLong(1, frequency)
          bindLong(2, state)
          bindString(3, completions)
        }
    notifyQueries(1_837_471_335) { emit ->
      emit("GoalDto")
    }
  }

  public fun updateGoal(
    name: String,
    frequency: Long,
    state: Long,
    completions: String,
    id: Long,
  ) {
    driver.execute(575_374_455,
        """UPDATE GoalDto SET name = ?, frequency = ?, state = ?, completions = ?, modificationDate = datetime('now') WHERE id = ?""",
        5) {
          bindString(0, name)
          bindLong(1, frequency)
          bindLong(2, state)
          bindString(3, completions)
          bindLong(4, id)
        }
    notifyQueries(575_374_455) { emit ->
      emit("GoalDto")
    }
  }

  public fun deleteGoal(id: Long) {
    driver.execute(-1_659_072_423, """DELETE FROM GoalDto WHERE id = ?""", 1) {
          bindLong(0, id)
        }
    notifyQueries(-1_659_072_423) { emit ->
      emit("GoalDto")
    }
  }

  private inner class SelectGoalByIdQuery<out T : Any>(
    public val id: Long,
    mapper: (SqlCursor) -> T,
  ) : Query<T>(mapper) {
    override fun addListener(listener: Query.Listener) {
      driver.addListener("GoalDto", listener = listener)
    }

    override fun removeListener(listener: Query.Listener) {
      driver.removeListener("GoalDto", listener = listener)
    }

    override fun <R> execute(mapper: (SqlCursor) -> QueryResult<R>): QueryResult<R> =
        driver.executeQuery(1_417_370_140,
        """SELECT GoalDto.id, GoalDto.name, GoalDto.frequency, GoalDto.state, GoalDto.completions, GoalDto.creationDate, GoalDto.modificationDate FROM GoalDto WHERE id == ?""",
        mapper, 1) {
      bindLong(0, id)
    }

    override fun toString(): String = "database.sq:selectGoalById"
  }
}
