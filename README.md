
# 💱 Conversor de Monedas en Java

Este es un proyecto básico en **Java** que permite convertir valores entre diferentes monedas mediante un menú interactivo en consola e integración de API. Diseñado como práctica de **POO**, separación por capas y manejo de entrada del usuario.

---

## 🎥 Demostración del Proyecto

En este ejemplo el usuario elige una opción valida y el programa devuelve la conversion. Caso contrario, si el usuario elige una opción por ejemplo: 9. El programa lanza un aviso de "Opción invalida".

![coversor](https://github.com/user-attachments/assets/761f0939-14e2-46df-9e1b-488afe94ba1d)

---

## 📌 Descripción

El programa muestra un menú con **7 tipos de conversión** y una opción **8 para salir**.  
El usuario selecciona una opción, ingresa un monto y el sistema devuelve el valor convertido según tasas fijas establecidas en la capa de servicio.

Estructura implementada:

- Capa de **presentación**: `MenuUsuario`
- Capa de **servicio**: `ServicioDeConversion`
- Clase principal: `Principal`

---

## 🧩 Flujo del Menú

****Seleccione una opción (1-8):****
1. USD → ARS
2. ARS → USD
3. USD → BRL
4. BRL → USD
5. USD → COP"
6. COP → USD"
7. CAD → COP"
8. Salir" 
El menú permanece activo hasta que el usuario elige la opción **8**.
---


## 🛠️ Tecnologías Utilizadas

- **Java 25**
- Entrada por consola (`Scanner`)
- Control con `switch-case`
- Arquitectura por capas
- Conceptos básicos de POO

---

## ▶️ Cómo Ejecutar el Proyecto

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/joe-gmz/challenge-conversor-de-monedas-con-API.git

---

## 🤝 Contribuciones

¡Toda contribución es bienvenida!
Puedes abrir un issue o enviar un pull request.

---

## 📝 Licencia

Este proyecto está bajo la licencia MIT.


