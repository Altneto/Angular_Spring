# maxima_avaliacao

BACK

Verficar se o maven está instalado rodando o comando:

nvm --version

Caso contrario instalar.

Verificar se tem o myqsl instalado

Procurar o arquivo application.properties na pasta ./back/avaliacao/src/main/resources e alterar a porta, o usuario, e a senha com a configuração do mysql instalado.

Na pasta do back-end ./back/avalicao encontrar o pom.xml e rodar o comando:

nvm clean package

Na pasta raiz rodar o seguinte comando para criar as imagens do docker a partir do script docker-compose.yml
docker compose up -d --build

O docker vai subir a API automaticamente e se conectar ao container do mysql

Abrir o navegador e digitar:

http://localhost/swagger-ui/index.html

Se aparecer a documentação Swagger da API o docker subiu corretamente

FRONT

Na pasta ./front/avaliacao_front

Verificar se o node.js está instalado.

Caso contrario instalar.

Abra um terminal e rode os comandos:

npm i @angular/cli

npm i

Na pasta ./front/avaliacao_front/src/environments seguir as instruções no arquivo env.example.ts

ng serve -o
