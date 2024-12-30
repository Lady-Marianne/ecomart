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
