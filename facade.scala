package webapp

import scala.scalajs.js
import scala.scalajs.js.annotation._
import org.scalajs.dom.Element
import org.scalajs.dom.HTMLDivElement

@js.native
@JSGlobal("Reveal")
class Reveal(options: js.Dynamic) extends js.Object {
  def initialize(): Unit = js.native
}

@js.native
@JSImport(
  "https://cdn.jsdelivr.net/npm/echarts@5.6.0/dist/echarts.esm.js",
  JSImport.Namespace
)
object echarts extends js.Object:
  def init(dom: Element): EChartInstance = js.native
  def init(dom: Element, theme: String): EChartInstance = js.native

@js.native
trait EChartInstance extends js.Object:
  def setOption(option: js.Dynamic): Unit = js.native
  def resize(): Unit = js.native

@js.native
@JSImport(
  "https://cdn.jsdelivr.net/npm/highlightjs@9.16.2/+esm",
  JSImport.Namespace
)
object highlightjs extends js.Object:
  def highlightElement(element: Element): Unit = js.native
  def configure(options: js.Dynamic): Unit = js.native
  def highlightAll(): Unit = js.native
