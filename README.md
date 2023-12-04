# RabbitMQ-API

Projeto de estudo de RabbitMQ, criando uma API que recebe requisições REST via HTTP e as encaminha para uma fila para serem processadas por um outro projeto BROKER, quando concluído o processamento feito no broker, ele encaminhara uma requisição para outra fila que este projeto irá estar ouvindo e quando chegar requisições ele deve receber e gravar no banco de dados.

```
docker compose up -d
```

[Painel do RabbitMQ](http://localhost:15672/)
**User:** admin
**Password** 123456