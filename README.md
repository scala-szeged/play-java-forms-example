# play-java-forms-example-bootstrap-sass

[<img src="https://travis-ci.org/scala-szeged/play-java-forms-example.svg?branch=2.7.x"/>](https://travis-ci.org/scala-szeged/play-java-forms-example)

Example code showing form processing and form helper handling in Play.
This modified version has SASS and Bootstrap configured. Please see the screenshot below

[<img src="https://github.com/scala-szeged/play-java-forms-example/raw/2.7.x/public/images/selfie-1.png"/>](https://github.com/scala-szeged/play-java-forms-example/tree/2.7.x/public/images)
 
## Example reusable block

Declaration:

```html 
@tableRow(columns: Any*) = {
    <tr>
    @for(c <- columns) {
        <td>@c</td>
    }
    </tr>
}

```

Usage:
```html
<table class="table">
    <thead>
        <tr><th>Name</th><th>Price</th>
    </thead>
    <tbody>
    @for(w <- widgets) {@tableRow(w.name, w.price)}
    </tbody>
</table>
```

## How to run

Start the Play app:

```bash
sbt run
```

And open <http://localhost:9000/>

## Documentation

Please see <https://playframework.com/documentation/latest/JavaForms>.

## Additional information

https://index.scala-lang.org/irundaia/sbt-sassify

