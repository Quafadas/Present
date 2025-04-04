package presentation

import org.scalajs.dom
import scalatags.Text.all._
import scalatags.Text.tags2.math

import scalatags.Text.tags2.section

import scala.scalajs.js
import scala.scalajs.js.annotation._
import org.scalajs.dom.Element
import org.scalajs.dom.HTMLDivElement
import scala.util.Random
import org.scalajs.dom.XMLHttpRequest
import scala.scalajs.js.JSON
import scala.scalajs.js.annotation.JSImport.Namespace

@main def main: Unit = dom.document.addEventListener(
  "DOMContentLoaded",
  { (_: dom.Event) =>
    {

      val options = js.Dynamic.literal(
        plugins = js.Array(Highlight),
        slideNumber = "h.v",
        progress = true,
        center = false,
        hash = true,
        disableLayout = true
      )
      Reveal.initialize(options)

      val container = dom.document.getElementById("slides")
      container.innerHTML = generatePres.render

      /** Render charts into the div with id chart */
      val c1 = dom.document.getElementById("chart").asInstanceOf[HTMLDivElement]
      makeEchart("bar.echart.json", c1, 50)

      /** Highlight.js
        */
      hljs.registerLanguage("scala", hljsGrammar)
      hljs.highlightAll()
    }
  }
)

val chartDiv = div(
  id := "chart",
  width := "100vw",
  height := "100vh"
)

def generatePres =
  frag(
    section(
      section(
        h1(
          "Hello, world!",
          marginTop := "30vh"
        ),
        p(),
        p("Goal: write a presentation in scala.js"),
        p("Check links"),
        a(href := "#2", "Slide 3"),
        p("Note: Set the URL to (e.g.) #2 to live reload that slide on change")
      ),
      section(
        h3("Vertical Slide"),
        p("This is the content of the new slide.")
      )
    ),
    section(
      div(
        3 * 2
      ),
      "We calculated 3 * 2 - amazing"
    ),
    section(
      h3("A cat picture"),
      img(
        src := "Cat.jpg",
        alt := "A cat",
        height := "50vh"
      )
    ),
    section(
      chartDiv
    ),
    section(
      h2("Check math ML"),
      p(
        math(
          raw(
            """<mi>π<!-- p --></mi>
        <mo>⁢<!-- &InvisibleTimes; --></mo>
        <msup>
          <mi>r</mi>
          <mn>2</mn>
        </msup>"""
          )
        )
      )
    ),
    section(
      h3("Some code"),
      p("Simple code"),
      div(
        pre(
          code(
            `class` := "language-html",
            "<h1> Hello, world!</h1>"
          )
        ),
        pre(
          code(
            `class` := "language-scala",
            // I think this doesn't work, because i'm using highlight directly
            attr("data-line-numbers") := "2",
            raw"""val x = 1
val y = 2
def add(a: Int, b: Int): Int = a + b"""
          )
        )
      )
    )
  )

def makeEchart(path: String, node: Element, width: Int = 50): Unit =
  val myChart = echarts.init(node)

  val xhr = new XMLHttpRequest()
  xhr.open("GET", s"$path", false)
  xhr.send()
  val text = xhr.responseText
  val parsed = JSON.parse(text)
  myChart.setOption(parsed)
