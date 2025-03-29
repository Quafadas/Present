## A presentation written in Scala JS

```shell
just present
```
Or, if you don't use just;

```shell
coursier launch io.github.quafadas::sjsls:0.2.5 -- --path-to-index-html {{invocation_directory()}}/assets
```

## Notes

### Index.html
`index.html` intentionally loads two scripts. One for development (`main.js`) and one when deployed `/Present/main.js`. It will always throw one script not found error in browser. Maybe there is a better way...

Change the `Present` part, to follow the name of your github page if you fork / use this.


### ESM
All dependancies are ESModules loaded out of JSDelivr. No toolchain :-), very quick to get started.

### Themes

Can be changed in `index.html`

###