# variamos_ms_svg2xml

Microservice to convert svg to XML mxshape

Source : https://github.com/process-analytics/mxgraph-svg2shape

## Build the project

Install Maven

`brew install maven`

Build the Project

`mvn package`

Build the image

`docker build -t jasotov/variamos_ms_svg2xml -f Dockerfile .`

Publish the image to Docker hub

`docker push jasotov/variamos_ms_svg2xml:latest`


