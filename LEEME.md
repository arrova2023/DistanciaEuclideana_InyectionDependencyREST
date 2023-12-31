# Distancia Euclidiana RESTful API con Inyección de Dependencias

Este proyecto implementa un servicio RESTful en Spring Boot para calcular la distancia euclidiana entre dos puntos en un plano. Utiliza la inyección de dependencias y el manejo de errores para brindar una experiencia de usuario confiable y eficiente.

La distancia euclidiana en dos dimensiones es una medida de la longitud entre dos puntos en un plano cartesiano. Imagina que tienes un plano con dos ejes perpendiculares: el eje horizontal (llamado eje "x") y el eje vertical (llamado eje "y"). Cada punto en este plano puede representarse mediante un par ordenado de coordenadas (x, y), donde "x" es la posición en el eje horizontal y "y" es la posición en el eje vertical.

La fórmula para calcular la distancia euclidiana entre dos puntos P(x1, y1) y Q(x2, y2) en un plano cartesiano es la siguiente:

distancia = √((x2 - x1)^2 + (y2 - y1)^2)

Vamos a descomponer esta fórmula paso a paso:

Resta de coordenadas: Primero, calculamos la diferencia entre las coordenadas "x" de los dos puntos (x2 - x1) y la diferencia entre las coordenadas "y" (y2 - y1).

Elevación al cuadrado: Luego, elevamos al cuadrado estas diferencias. Esto asegura que las diferencias sean positivas, ya que un número negativo elevado al cuadrado se convierte en positivo.

Suma de cuadrados: Sumamos las diferencias elevadas al cuadrado de las coordenadas "x" y "y".

Raíz cuadrada: Finalmente, tomamos la raíz cuadrada de la suma de cuadrados. Esto nos da la longitud de la línea recta que conecta los dos puntos en el plano. Es la distancia euclidiana.

En resumen, la distancia euclidiana en dos dimensiones mide la longitud de la línea recta entre dos puntos en un plano cartesiano. Es una medida de "distancia directa" que sigue el camino más corto entre los puntos. Se utiliza en diversos campos como matemáticas, física, análisis de datos y geometría para medir la separación entre puntos en un espacio bidimensional.

## Patrones de Diseño

### Inyección de Dependencias (Dependency Injection)

Se utiliza el patrón de inyección de dependencias para lograr un bajo acoplamiento entre los componentes del sistema. Los diferentes componentes, como el controlador, el servicio y el calculador de distancia, se inyectan donde sea necesario.

En la clase `DistanceController`, la dependencia de `DistanceService` se inyecta mediante la anotación `@Autowired`.

En la clase `DistanceService`, la dependencia de `EuclideanDistanceCalculator` se inyecta mediante la anotación `@Autowired`.

### Patrón de Controlador (Controller Pattern)

El patrón de controlador se aplica para manejar las solicitudes HTTP entrantes y dirigirlas al servicio correspondiente para su procesamiento. Esto mantiene una separación clara entre la capa de presentación y la lógica de negocio.

La clase `DistanceController` actúa como el controlador en este patrón. Define rutas de solicitud, maneja las entradas y dirige las solicitudes al servicio adecuado.

### Patrón de Servicio (Service Pattern)

El patrón de servicio se utiliza para encapsular la lógica de negocio y proporcionar una interfaz coherente para interactuar con dicha lógica. Los servicios actúan como intermediarios entre el controlador y otras capas del sistema.

En la clase `DistanceService`, se implementa el patrón de servicio. Contiene la lógica para calcular la distancia euclidiana y actúa como un puente entre el controlador y el calculador de distancia.

### Manejo de Errores (Error Handling)

Se implementa un sólido manejo de errores utilizando las anotaciones de manejo de excepciones de Spring. Esto garantiza que las respuestas de error sean coherentes y útiles para los clientes de la API.

La clase `DistanceController` utiliza la anotación `@ExceptionHandler` para capturar y manejar excepciones, y devuelve respuestas de error detalladas utilizando la clase `ApiError`.

## Estructura de Directorios
```
src/
└── main/
    └── java/
        └── com/
            └── example/
                └── demo/
                    ├── controller/
                    │   └── DistanceController.java
                    ├── service/
                    │   ├── DistanceService.java
                    │   └── EuclideanDistanceCalculator.java
                    ├── model/
                    │   ├── Point.java
                    │   ├── DistanceRequest.java
                    │   └── DistanceResponse.java
                    ├── error/
                    │   └── ApiError.java
                    └── EuclideanDistanceSingletonApplication.java
```

## Cómo Probar con Postman

1. Asegúrate de que el proyecto esté en ejecución.

2. Abre Postman y crea una nueva solicitud POST.

3. Establece la URL de la solicitud a `http://localhost:8080/calculate-distances`.

4. Asegúrate de que los encabezados estén configurados correctamente:
   - `Content-Type`: `application/json`
   - `Accept`: `application/json`

5. En la pestaña "Body", selecciona "Raw" y elige "JSON (application/json)" como tipo de contenido.

6. Ingresa un cuerpo de solicitud JSON de ejemplo, por ejemplo:
   ```json
   {
       "x1": 1,
       "y1": 2,
       "x2": 4,
       "y2": 6
   }
