#FinançasAPI
---

## **Mensalidade**

**POST - Salvar →** http://localhost:8080/mensalidade

**Body** raw (json)

**json**

```json
{
    "mes": "junho",
    "ano": 2027,
    "dividas": [
        {
            "nome": "Agua",
            "valor": 25.50,
            "dataVencimento": "2026-06-07"
        }
    ]
}
```

**PUT - Atualizar →** http://localhost:8080/mensalidade/8

**Body** raw (json)

```json
{
    "mes": "junho",
    "ano": 2027,
    "dividas": [
        {
            "nome": "Luz",
            "valor": 25.50,
            "dataVencimento": "2026-06-07"
        }
    ]
}
```

**GET - Buscar tudo →** http://localhost:8080/mensalidade/all

**GET - Buscar por Id →** http://localhost:8080/mensalidade/junho/2027

**GET - Buscar por periodo →** http://localhost:8080/mensalidade/9

**DELETE - deletar →** http://localhost:8080/mensalidade/8

---

## **Divida**

**GET - Buscar divida →** http://localhost:8080/divida/9

**PUT - Atualizar divida →** http://localhost:8080/divida/9

**Body** raw (json)
```json
{
    "nome": "AguaATT",
    "valor": 250.5,
    "dataVencimento": "2026-06-07"
}
```
