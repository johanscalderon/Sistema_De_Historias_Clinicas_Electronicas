# Sistema_De_Historias_Clinicas_Electronicas

## Descripción
Sistema modular para gestionar pacientes, citas, encuentros clínicos y prescripciones, con integración de telemetría IoT y un motor de reglas para detectar interacciones medicamentosas. Diseñado para ser seguro, trazable y fácil de extender.

## Alcance / MVP
El MVP cubre: CRUD de pacientes, gestión de citas, registro de encuentros clínicos (encounters), prescripciones básicas, ingestión de observaciones IoT simuladas y un motor de reglas simple que genera alertas de interacción. No incluye imágenes DICOM ni integración con sistemas externos reales (se simulan para la entrega).

## Requisitos funcionales
Listado de funcionalidades obligatorias: gestión de usuarios/roles, CRUD pacientes, agenda de citas, creación de encuentros, registro de prescripciones, motor de alertas por interacciones y almacenamiento de telemetría.

## Requisitos no funcionales
Requisitos de calidad: cifrado en tránsito/at-rest, auditoría de accesos, backups diarios, latencia razonable para alertas y despliegue mediante contenedores.

## Arquitectura

El sistema se desarrollará utilizando una arquitectura basada en el patrón **MVC (Model - View - Controller)**, la cual permite una clara separación de responsabilidades y facilita el mantenimiento del sistema.

### Model (Modelo)
Representa la lógica de negocio y la estructura de datos del sistema. Incluye las entidades principales como pacientes, citas, diagnósticos, tratamientos y observaciones médicas, así como la interacción con la base de datos mediante JPA/Hibernate.

### View (Vista)
Corresponde a la interfaz de usuario desarrollada en React. Se encarga de mostrar la información al usuario y capturar sus acciones, enviando solicitudes al backend a través de API REST.

### Controller (Controlador)
Actúa como intermediario entre la vista y el modelo. Recibe las solicitudes HTTP, procesa la lógica necesaria y devuelve respuestas al frontend. Implementado mediante controladores REST en Spring Boot.

---

## Patrones de diseño
Patrones aplicados: Hexagonal (Ports & Adapters) para aislar dominio, Repository y Unit of Work para persistencia, Observer / Pub-Sub para eventos y Strategy para el motor de reglas. Justificación: facilitan pruebas, mantenimiento y evolución.

## Tecnologías
### Backend
- **Java + Spring Boot**
  Framework principal para el desarrollo del backend. Se eligió por su robustez, alto rendimiento, seguridad integrada y amplio uso en sistemas empresariales y del sector salud.

---
### Frontend
- **React + TypeScript**
  Para la construcción de interfaces dinámicas, modernas y escalables.

- **Tailwind CSS
  Para el diseño visual y maquetación rápida de la interfaz.

---

### Base de Datos
- **PostgreSQL**
  Base de datos relacional elegida por su confiabilidad, integridad de datos (ACID) y soporte para estructuras complejas.

---

### Seguridad
- **Keycloak**
  Sistema de gestión de identidades que implementa autenticación y autorización basada en OAuth2 / OpenID Connect.
