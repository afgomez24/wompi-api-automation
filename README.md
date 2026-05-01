# 🧪 Wompi API Automation

Proyecto de automatización de pruebas para la API de pagos **Wompi**, implementado con **Java, Maven, Cucumber (BDD) y RestAssured**, aplicando el patrón **POM adaptado a API**.

---

## 📌 Objetivo

Validar el correcto funcionamiento de la API de transacciones de Wompi mediante pruebas automatizadas, cubriendo:

* ✔ Flujo de creación de transacciones
* ✔ Validaciones de negocio
* ✔ Manejo de errores

---

## 🧰 Tecnologías utilizadas

* ☕ Java 17
* 📦 Maven
* 🥒 Cucumber (BDD)
* 🌐 RestAssured
* 🧪 Postman (validación inicial)

---

## 🧩 Arquitectura del proyecto

Se implementa el patrón **Page Object Model (POM)** adaptado a API:

```plaintext
Feature (Gherkin)
   ↓
Step Definitions
   ↓
Services (WompiService)
   ↓
BaseAPI (configuración)
```

### 📁 Estructura

```plaintext
src/test/java
│
├── base/              → Configuración base del API
├── services/          → Consumo de endpoints
├── models/            → Estructura de requests
├── utils/             → Constantes y utilidades
├── stepdefinitions/   → Implementación de pasos BDD
├── runners/           → Ejecución de pruebas
│
src/test/resources
└── features/          → Escenarios en Gherkin
```

---

## 🧪 Estrategia de pruebas

### ✅ Escenarios positivos

* Creación de transacción con método de pago PSE

### ❌ Escenarios negativos

* Monto inválido
* Falta de autenticación
* Datos incompletos

---

## ⚠️ Hallazgo importante

Durante las pruebas se identificó que:

> La API retorna **HTTP 422 (Unprocessable Entity)** cuando la solicitud no cumple con las validaciones de negocio requeridas.

Esto indica que el error no es técnico, sino de validación de datos.

---

## 🔍 Validación previa

Antes de automatizar, se realizaron pruebas manuales utilizando **Postman** para:

* Verificar endpoints
* Validar estructura de requests/responses
* Identificar posibles errores

---

## ▶️ Ejecución del proyecto

### 1. Clonar repositorio

```bash
git clone https://github.com/tu-usuario/wompi-api-automation.git
```

### 2. Ingresar al proyecto

```bash
cd wompi-api-automation
```

### 3. Ejecutar pruebas

```bash
mvn clean test
```

---

## 🔐 Configuración

Editar el archivo:

```plaintext
utils/Constants.java
```

Agregar la llave privada:

```java
public static final String PRIVATE_KEY = "TU_PRV_KEY";
```

> ⚠️ Nota: En un entorno real, las llaves deben manejarse mediante variables de entorno.

---

## 🥒 Ejemplo de escenario (BDD)

```gherkin
Scenario: Transacción con monto inválido
  Given que tengo datos de pago válidos
  When envío una transacción con monto 0
  Then el código de respuesta debe ser 422
```

---

## 👨‍💻 Autor

Andres Gomez -
Ingeniero de Sistemas -
QA Analyst.

---

## ⭐ Conclusión

Se implementó un framework escalable, mantenible y alineado con buenas prácticas de automatización, permitiendo validar tanto flujos funcionales como reglas de negocio en la API de Wompi.

