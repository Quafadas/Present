package webapp

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
// import webapp.hljs.highlightAll

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
      val deck = Reveal.initialize(
        options
        // js.Dynamic.literal(
        //   beforeHighlight = (hljs: js.Dynamic) => hljs.registerLanguage("scala")
        // )
      )

      val container = dom.document.getElementById("slides")
      container.innerHTML = generatePres.render
      // viz.js.showChartJs(chart, dom.document.getElementById("chart"))
      val c1 = dom.document.getElementById("chart").asInstanceOf[HTMLDivElement]

      // deck.initialize()

      println(Reveal.hasPlugin("highlight"))

      makeEchart("bar.echart.json", c1, 50)
    }
  }
)

def generatePres =
  val chartDiv = div(
    id := "chart",
    width := "100vw",
    height := "100vh"
  )

  frag(
    section(
      section(
        h1(
          "Hello, world!",
          marginTop := "30vh"
        ),
        p(),
        p("Write a presentation in scala"),
        a(href := "#2", "Slide 3"),
        p("Set the URL to #2 to live reload that slide")
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
      "We calculed 3 * 2 - amazing"
    ),
    section(
      h3("A cat picture"),
      img(
        src := "Cat.jpg",
        alt := "A cat",
        height := "25vh" // Set a maximum width for the image
      )
    ),
    section(
      chartDiv
    ),
    section(
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
      pre(
        code(
          `class` := "language-html",
          "<h1> Hello, world!</h1>"
        ),
        code(
          `class` := "language-html",
          "<h1> Hello, world!</h1>"
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
