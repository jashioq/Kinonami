@file:OptIn(org.jetbrains.compose.resources.InternalResourceApi::class)

package coach.composeapp.generated.resources

import kotlin.OptIn
import kotlin.String
import kotlin.collections.MutableMap
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.InternalResourceApi

private object CommonMainDrawable0 {
  public val blob: DrawableResource by 
      lazy { init_blob() }

  public val check_mark: DrawableResource by 
      lazy { init_check_mark() }

  public val circle_arrow: DrawableResource by 
      lazy { init_circle_arrow() }

  public val dot_fill: DrawableResource by 
      lazy { init_dot_fill() }

  public val dot_hollow: DrawableResource by 
      lazy { init_dot_hollow() }

  public val dot_hollow_crossed: DrawableResource by 
      lazy { init_dot_hollow_crossed() }
}

@InternalResourceApi
internal fun _collectCommonMainDrawable0Resources(map: MutableMap<String, DrawableResource>) {
  map.put("blob", CommonMainDrawable0.blob)
  map.put("check_mark", CommonMainDrawable0.check_mark)
  map.put("circle_arrow", CommonMainDrawable0.circle_arrow)
  map.put("dot_fill", CommonMainDrawable0.dot_fill)
  map.put("dot_hollow", CommonMainDrawable0.dot_hollow)
  map.put("dot_hollow_crossed", CommonMainDrawable0.dot_hollow_crossed)
}

internal val Res.drawable.blob: DrawableResource
  get() = CommonMainDrawable0.blob

private fun init_blob(): DrawableResource = org.jetbrains.compose.resources.DrawableResource(
  "drawable:blob",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/coach.composeapp.generated.resources/drawable/blob.png", -1, -1),
    )
)

internal val Res.drawable.check_mark: DrawableResource
  get() = CommonMainDrawable0.check_mark

private fun init_check_mark(): DrawableResource = org.jetbrains.compose.resources.DrawableResource(
  "drawable:check_mark",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/coach.composeapp.generated.resources/drawable/check_mark.xml", -1, -1),
    )
)

internal val Res.drawable.circle_arrow: DrawableResource
  get() = CommonMainDrawable0.circle_arrow

private fun init_circle_arrow(): DrawableResource =
    org.jetbrains.compose.resources.DrawableResource(
  "drawable:circle_arrow",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/coach.composeapp.generated.resources/drawable/circle_arrow.xml", -1, -1),
    )
)

internal val Res.drawable.dot_fill: DrawableResource
  get() = CommonMainDrawable0.dot_fill

private fun init_dot_fill(): DrawableResource = org.jetbrains.compose.resources.DrawableResource(
  "drawable:dot_fill",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/coach.composeapp.generated.resources/drawable/dot_fill.xml", -1, -1),
    )
)

internal val Res.drawable.dot_hollow: DrawableResource
  get() = CommonMainDrawable0.dot_hollow

private fun init_dot_hollow(): DrawableResource = org.jetbrains.compose.resources.DrawableResource(
  "drawable:dot_hollow",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/coach.composeapp.generated.resources/drawable/dot_hollow.xml", -1, -1),
    )
)

internal val Res.drawable.dot_hollow_crossed: DrawableResource
  get() = CommonMainDrawable0.dot_hollow_crossed

private fun init_dot_hollow_crossed(): DrawableResource =
    org.jetbrains.compose.resources.DrawableResource(
  "drawable:dot_hollow_crossed",
    setOf(
      org.jetbrains.compose.resources.ResourceItem(setOf(),
    "composeResources/coach.composeapp.generated.resources/drawable/dot_hollow_crossed.xml", -1, -1),
    )
)
