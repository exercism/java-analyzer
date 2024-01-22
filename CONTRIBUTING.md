# Contributing

Thank you so much for contributing! 🎉

We welcome contributions of all sorts and sizes, from reporting issues to submitting patches, as well as joining discussions on the [Java forum][java-forum].

Unprompted (without an issue) PRs with small bugfixes are welcome.
However, if you want to propose bigger changes, make sure to post on the [forum][java-forum] first so that we can discuss it.

## Code of Conduct

Help us keep Exercism welcoming.
Please read and abide by the [Code of Conduct][coc].

## How does this project work?

Start by reading up on Exercism analyzers:

- [The analyzer interface][analyzer-docs-interface]
- [Guidance on implementing analyzers][analyzer-docs-guidance]

To learn how the Java Analyzer works:

- Browse [existing exercise analyzer implementations][browse-analyzers].

### Writing comments

All the Analyzer comments for all tracks are stored together in [exercism/website-copy][analyzer-comments].
When adding a new Analyzer check with a new comment, you need to open a corresponding PR in [exercism/website-copy][analyzer-comments] with that comment's content.

See [the Analyzer comment guidelines][analyzer-comments-guidelines] for guidance on how to write friendly and constructive Analyzer comments.

[coc]: https://github.com/exercism/java-analyzer/blob/main/CODE_OF_CONDUCT.md
[analyzer-comments]: https://github.com/exercism/website-copy/tree/main/analyzer-comments
[analyzer-comments-guidelines]: https://exercism.org/docs/building/tooling/analyzers/comments
[java-forum]: https://forum.exercism.org/c/programming/java/91
[browse-analyzers]: https://github.com/exercism/java-analyzer/tree/main/src/main/java/analyzer/exercises/
[analyzer-docs-guidance]: https://exercism.org/docs/building/tooling/analyzers/guidance
[analyzer-docs-interface]: https://exercism.org/docs/building/tooling/analyzers/interface