package org.jh.coach.`data`.local.database

import kotlin.Long
import kotlin.String

public data class GoalDto(
  public val id: Long,
  public val name: String,
  public val frequency: Long,
  public val state: Long,
  public val completions: String,
  public val creationDate: String,
  public val modificationDate: String,
)
