

present:
  coursier launch io.github.quafadas::sjsls:0.2.5 -- --path-to-index-html {{invocation_directory()}}/assets

prodBuild:
  scala-cli --power package . --js -o ./assets/main.js --js-mode full --js-module-split-style fewestmodules