package presentation

import scala.scalajs.js
import scala.scalajs.js.annotation._
import org.scalajs.dom.Element
import org.scalajs.dom.HTMLDivElement

@js.native
@JSImport(
  "https://cdn.jsdelivr.net/npm/reveal.js/dist/reveal.esm.js",
  JSImport.Default
)
object Reveal extends js.Object {
  def initialize(
      options: js.Dynamic,
      highlight: js.UndefOr[js.Dynamic] = js.undefined
  ): Unit = js.native
  def initialize(): Unit = js.native
  def hasPlugin(name: String): Boolean = js.native
  def getPlugin(name: String): js.Dynamic = js.native
}

@js.native
@JSImport(
  "https://cdn.jsdelivr.net/npm/reveal.js/plugin/highlight/highlight.esm.js",
  JSImport.Default
)
object Highlight extends js.Object

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
object Highlightjs extends Highlightjs

@js.native
@JSGlobal
object hljs extends Highlightjs

@js.native
@JSImport(
  "https://unpkg.com/@highlightjs/cdn-assets@11.11.1/es/languages/scala.min.js",
  JSImport.Default
)
object hljsGrammar extends js.Object

@js.native
trait Highlightjs extends js.Object:
  def highlightElement(element: Element): Unit = js.native
  def configure(options: js.Dynamic): Unit = js.native
  def highlightAll(): Unit = js.native
  def registerLanguage(name: String, language: js.Object): Unit = js.native
