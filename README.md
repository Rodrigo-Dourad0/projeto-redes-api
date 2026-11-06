# Projeto de Infraestrutura de Redes e API Rest

## 👥 Identificação dos Integrantes
* Rodrigo Almeida Dourado


## 🖥️ Descrição dos IPs em cada VM
* **VM 1 (Proxy Reverso - Nginx):** `192.168.0.9`
  * É a única máquina exposta ao cliente. Recebe requisições HTTP na porta 80 e atua como proxy, redirecionando o tráfego para a VM 2.
* **VM 2 (Back-End e Banco de Dados):** `192.168.0.10`
  * Máquina isolada que hospeda a API REST em Spring Boot (rodando na porta 8080) e o banco de dados PostgreSQL (porta 5432).

## ⚙️ Configuração do Proxy (Onde colocar o arquivo do Nginx)
O arquivo de configuração do proxy (presente na pasta `/nginx` deste repositório) não deve substituir o padrão. Ele deve ser configurado como um NOVO virtual host na **VM 1** da seguinte forma:

1. Coloque o arquivo de configuração no diretório de sites disponíveis:
   `/etc/nginx/sites-available/api`
2. Crie o link simbólico para ativar a configuração:
   `sudo ln -s /etc/nginx/sites-available/api /etc/nginx/sites-enabled/`
3. Remova o virtual host padrão (conforme exigência do projeto):
   `sudo rm /etc/nginx/sites-enabled/default`
4. Reinicie o serviço do Nginx:
   `sudo systemctl restart nginx`

## 🚀 Guia de Execução: Como rodar a API
Para colocar a API em funcionamento na **VM 2**, siga os passos abaixo:

**Passo 1: Banco de Dados**
1. Acesse a VM 2 e logue no PostgreSQL (`sudo -u postgres psql`).
2. Execute os comandos SQL presentes no arquivo `/database/setup.sql` para criar o banco de dados e dar permissão ao usuário.

**Passo 2: Compilar a API**
1. Clone este repositório na VM 2 e navegue até a pasta da API:
   ```bash
   cd pasta-do-repositorio/api
   ```
2. Utilize o Maven para compilar o projeto e gerar o arquivo `.jar`:
   ```bash
   mvn clean package -DskipTests
   ```

**Passo 3: Executar a API**
1. Com a compilação finalizada, inicie o servidor Spring Boot executando o arquivo gerado:
   ```bash
   java -jar target/clientes-0.0.1-SNAPSHOT.jar
   ```

**Passo 4: Testar o Fluxo Completo**
* A partir da máquina hospedeira (Seu PC Cliente), acesse o IP da VM 1 pelo navegador ou ApiDog: 
  `http://192.168.0.9/clientes`
* O tráfego passará pelo Nginx (VM 1) e baterá na API (VM 2), validando o fluxo.
