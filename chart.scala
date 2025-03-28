package webapp

import viz.vega.plots.{BarChart, given}
import org.scalajs.dom.Element
import org.scalajs.dom
import scala.util.Random
import scala.scalajs.js
import scala.scalajs.js.JSON
import org.scalajs.dom.HTMLDivElement
import viz.Spec

val chart = BarChart(
  List(
    viz.Utils.fillDiv
  )
)

object showChartJs:
  def apply[C <: Spec](chart: C, node: Element, width: Int = 50) =
    val child = dom.document.createElement("div")
    val anId = "vega" + Random.alphanumeric.take(8).mkString("")
    child.id = anId
    child.setAttribute("style", s"width:${width}vmin;height:${width}vmin")
    node.appendChild(child)
    child.asInstanceOf[HTMLDivElement]
    val opts = viz.vega.facades.EmbedOptions()
    val parsed = JSON.parse(chart.spec)
    viz.vega.facades.embed.embed(s"#${child.id}", parsed, opts)
    ()
  end apply
end showChartJs
