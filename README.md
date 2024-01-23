# Java Analyzer [![Coverage Status](https://coveralls.io/repos/github/exercism/java-analyzer/badge.svg?branch=main)](https://coveralls.io/github/exercism/java-analyzer?branch=main)

The Java analyzer uses [Abstract Syntax Trees][ast-wiki] (ASTs) to analyze submitted solutions using the [`javaparser`][javaparser] library.

The documentation for this project can be found at [exercism.github.io/java-analyzer/][documentation].

## Contributing

If you want to contribute to the Java analyzer, please refer to the [Contributing Guide][contributing-guide].

## Usage

### Running directly

Start by building the JAR using Gradle:

```sh
./gradlew build
```

Then, run the Java analyzer using `build/libs/java-analyzer.jar`.
For example, to analyze a solution for the `leap` exercise, run:

```sh
java -jar build/libs/java-analyzer.jar leap /path/to/leap/ /path/to/output/folder/
```

The analyzer output is written to `analysis.json` and `tags.json` in `/path/to/output/folder/`.

### Running with Docker

To run the Java analyzer using Docker, first build and tag the Docker image:

```sh
docker build -t exercism/java-analyzer .
```

Then, run the image and mount the directory of the solution to analyze.
For example, to analyze a solution for the `leap` exercise located at `~/exercism/java/leap`, run:

```sh
docker run -v /path/to/leap:/input -v /path/to/output/folder:/output exercism/java-analyzer leap /input/ /output/
```

The analyzer output is written to `analysis.json` and `tags.json` in `/path/to/output/folder/`.

## Tests

### Unit tests

To run the unit tests:

```sh
./gradlew test
```

### Smoke tests

To run the smoke tests using Docker:

```sh
bin/run-tests-in-docker.sh
```

[ast-wiki]: https://en.wikipedia.org/wiki/Abstract_syntax_tree
[contributing-guide]: https://github.com/exercism/java-analyzer/blob/main/CONTRIBUTING.md
[documentation]: https://exercism.github.io/java-analyzer/
[javaparser]: https://github.com/javaparser/javaparser
