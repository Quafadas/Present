## A presentation written in Scala JS

For reload on change locally;

```shell
just present
```
Or, if you don't use just, you'll have to alter the path to know about your index.html file.

```shell
coursier launch io.github.quafadas::sjsls:0.2.5 -- --path-to-index-html /Users/simon/Code/Present/assets
```
Push to main will publish to github pages.

All dependancies are ESModules loaded out of JSDelivr. No toolchain :-), very quick to get started.

## Notes

### Index.html
`index.html` intentionally loads two scripts. One for development (`main.js`) and one when deployed `/Present/main.js`. It will always throw one script not found error in browser. Maybe there is a better way...

Note: Change the `Present` part of that path to follow the name of your github page if you fork / use this.

### Themes

Can be changed in `index.html`

### Checks

- [x] Slides
- [x] Vertical Slides
- [x] Pictures
- [x] Result of Code execution
- [x] Syntax Highlighting
- [x] Math
- [x] Links
- [x] Plotting