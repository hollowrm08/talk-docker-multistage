FROM golang:1.8-alpine AS builder
WORKDIR /go/src/app
COPY main.go .
RUN go build -o webserver .

FROM alpine AS alp
COPY --from=builder /go/src/app/ /app/
ENTRYPOINT [ "./app/webserver" ]