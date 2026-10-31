# Documentação da API - Clientes

Base URL: `http://192.168.0.9/clientes` (via Nginx Proxy)

### 1. Listar Clientes
* **Método:** `GET`
* **Rota:** `/`
* **Descrição:** Retorna a lista de todos os clientes registados na base de dados.
* **Resposta de Sucesso (200 OK):**
  ```json
  [
    {
      "id": 1,
      "nome": "João Silva",
      "email": "joao.silva@email.com"
    }
  ]
  ```

### 2. Criar Cliente
* **Método:** `POST`
* **Rota:** `/`
* **Descrição:** Regista um novo cliente na base de dados.
* **Corpo da Requisição (JSON):**
  ```json
  {
    "nome": "Maria Santos",
    "email": "maria.santos@email.com"
  }
  ```
* **Resposta de Sucesso (200 OK):** Retorna o objeto do cliente criado com o ID gerado pelo PostgreSQL.

### 3. Atualizar Cliente
* **Método:** `PUT`
* **Rota:** `/{id}`
* **Descrição:** Atualiza os dados de um cliente existente com base no ID passado no endereço.
* **Corpo da Requisição (JSON):**
  ```json
  {
    "nome": "Maria Santos Atualizada",
    "email": "maria.nova@email.com"
  }
  ```

### 4. Apagar Cliente
* **Método:** `DELETE`
* **Rota:** `/{id}`
* **Descrição:** Remove permanentemente um cliente da base de dados através do seu ID.
* **Resposta de Sucesso (204 No Content):** Sem corpo de resposta.