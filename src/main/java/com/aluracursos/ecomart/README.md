Para saber más: cuidados con la clave de la API:

Una clave de API permite la comunicación entre tu aplicación y los servicios proporcionados por una plataforma,
como OpenAI. Funciona como una contraseña que autentica y autoriza las solicitudes que tu aplicación envía
a la API.

Por lo tanto, proteger esta clave es extremadamente importante para evitar accesos no autorizados y mantener
la integridad de tus proyectos.

¿Qué es una clave de API?
Una clave de API es un token único que es proporcionado por un servicio cuando te registras para usar sus APIs. 
Esta clave debe ser insertada en tus solicitudes para autenticar tu aplicación y permitir que acceda a los 
recursos de la API.

Sin esta clave, tu aplicación no podrá comunicarse con la API del servicio.

Cuidados con la clave de API:
Mantener la clave de API segura es fundamental para proteger tus datos y garantizar que solo las aplicaciones 
autorizadas tengan acceso a los servicios que utilizas. A continuación, se listan algunos cuidados importantes 
que debes tener con respecto a tus claves de API:

Seguridad:
Almacenamiento seguro: Nunca almacenes tu clave de API en texto plano en el código fuente o en ubicaciones 
accesibles públicamente, como repositorios GitHub. Utiliza variables de entorno o servicios de gestión de 
secretos para mantener tu clave segura.
Acceso restringido: Limita el acceso a la clave solo a las personas que realmente la necesitan. No compartas tu 
clave en foros públicos o con terceros no confiables.
Rotación:
Cambio regular: Acostúmbrate a rotar tus claves de API periódicamente. Esto minimiza el riesgo de uso indebido
en caso de compromiso.
Proceso de rotación: Asegúrate de tener un proceso bien definido para rotar las claves, incluyendo notificaciones
y actualizaciones en los entornos de desarrollo y producción.
Monitoreo:
Registros de acceso: Utiliza registros para monitorear todas las solicitudes hechas con tu clave de API, ya
que esta práctica puede ayudar a identificar actividades inusuales o sospechosas.
Limitación de acceso: Si es posible, configura límites de uso y restricciones geográficas o de IP para reducir
el riesgo de abuso.
Revocación:
Respuesta rápida: Si sospechas que tu clave de API ha sido comprometida, devuélvela inmediatamente y genera una
nueva. OpenAI ofrece una interfaz donde puedes gestionar y revocar tus claves de API.
Investiga la causa: Después de revocar una clave comprometida, investiga cómo ocurrió el compromiso y toma 
medidas para prevenir futuros incidentes.
Capas de autenticación:
Autenticación Multifactor (MFA): Siempre que sea posible, habilita MFA en las cuentas que tienen acceso para
generar o visualizar claves de API, ya que esto agrega otra capa de seguridad.
Tokens temporales: Si el servicio lo permite, utiliza tokens temporales que expiran después de un cierto período,
en lugar de claves permanentes.
Capacitación:
Buenas prácticas: Asegúrate de que todas las personas de tu equipo conozcan las buenas prácticas de seguridad 
en relación con el uso y manejo de las claves de API.
Procedimientos: Documenta y distribuye procedimientos claros sobre cómo generar, utilizar, almacenar y revocar 
claves de API.
Al seguir las recomendaciones anteriores, reduces considerablemente los riesgos de seguridad, construyendo
un entorno mucho más confiable para el desarrollo y operación de tus aplicaciones, que se integran con 
servicios externos a través de claves de API.

-----------------------------------------------------------------

Para saber más: parámetros de la API.

La API de OpenAI posee varios parámetros disponibles que pueden ajustarse para obtener los resultados 
deseados en tus aplicaciones.

Estos parámetros influyen en el comportamiento del modelo y la calidad de las respuestas generadas. 
A continuación, se detallan los principales parámetros y su funcionamiento:

Temperature (Temperatura):
Definición: El parámetro Temperature controla la aleatoriedad de las respuestas generadas por el modelo.
Rango de valores: 0.0 a 2.0.
Descripción: Valores más bajos como 0.5 o 0.6 hacen que el modelo produzca respuestas más determinísticas y 
enfocadas, reduciendo la creatividad. Valores más altos como 1.2 o 1.5 aumentan la creatividad y la
diversidad de las respuestas, pero también pueden introducir más incoherencia.
Uso: Utiliza un valor bajo para tareas que requieren respuestas precisas y coherentes, como explicaciones 
técnicas. Usa temperature alta para tareas creativas como la escritura de historias.
Max Tokens (Máximo de Tokens):
Definición: El parámetro Maximum Tokens define el número máximo de tokens (palabras o partes de palabras)
en la respuesta generada por el modelo.
Rango: Depende del modelo utilizado. Normalmente tiene un límite de 4096 o 16384 tokens.
Descripción: Este parámetro limita la extensión de la respuesta. Por ejemplo, si se define como 50, la
respuesta no excederá los 50 tokens.
Uso: Ajusta según la necesidad de la aplicación. Para respuestas cortas y directas, usa un valor menor. 
Para respuestas más detalladas, utiliza un valor mayor.
TopP (o Muestreo Nuclear):
Definición: El parámetro TopP, también conocido como muestreo nuclear, controla la diversidad restringiendo
el conjunto de candidatos para la siguiente palabra.
Rango: 0.0 a 1.0.
Descripción: Con TopP de 0.9, el modelo considera solo el 90% de los candidatos más probables (basado en su 
probabilidad acumulativa) para la siguiente palabra. Esto puede hacer que las respuestas sean más variadas
y menos predecibles.
Uso: Utiliza en conjunto con temperature para ajustar la creatividad y diversidad de las respuestas. Valores
más altos pueden generar respuestas más variadas.
Frequency penalty (Penalización de frecuencia):
Definición: El parámetro Frequency penalty aplica una penalización a las palabras que ya han aparecido en la
respuesta.
Rango: 0.0 a 2.0.
Descripción: Valores positivos reducen la probabilidad de repetir las mismas palabras, incentivando la 
diversidad léxica. Valores negativos pueden aumentar la probabilidad de repetición.
Uso: Utiliza un valor alto cuando desees respuestas con menor repetición de palabras, útil en situaciones
que requieren mayor variación léxica.
Presence penalty (Penalización por presencia):
Definición: El parámetro Presence penalty penaliza la presencia de ciertas palabras en la respuesta.
Rango: 0.0 a 2.0.
Descripción: Similar a Frequency penalty, pero enfocado en la presencia de palabras, no solo en la frecuencia.
Valores altos desincentivan la inclusión de palabras presentes en contextos anteriores, mientras que valores
bajos incentivan su inclusión.
Uso: Ajusta para controlar la inclusión de ciertas palabras en la respuesta, manteniendo o alterando el
contexto de manera más flexible.
Stop sequences (Secuencias de parada):
Definición: El parámetro Stop sequences define una o más secuencias de caracteres que, al encontrarse,
hacen que el modelo interrumpa la generación de texto.
Descripción: Puede ser una cadena única o una lista de cadenas. Cuando una de estas secuencias aparece 
en la respuesta generada, la generación de texto se detiene.
Uso: Se utiliza para delimitar respuestas y evitar salidas excesivamente largas o fuera de contexto.
Por ejemplo, en un chatbot, puedes definir secuencias de parada para garantizar que el modelo responda 
de manera concisa.
Entender y ajustar los parámetros de la API de OpenAI permite obtener respuestas más alineadas a las 
necesidades de tu aplicación, ya sea técnica, creativa o conversacional.

Experimenta con diferentes combinaciones de parámetros para descubrir qué configuraciones funcionan mejor
para tu caso específico.
