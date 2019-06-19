# java-analyzer

The Java track project-auto-mentor analyzer using abstract syntax trees


## Running in docker

To analyze a solution in docker,
1. Build the image
```
docker build -t exercism/java-analyzer .
```
2. Run the image
```
docker run -v <~/a/local/solution>:/solution exercism/java-analyzer <slug> /solution
```
