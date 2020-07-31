# Proyecto_Final
Examen de POO 

se pidio desarrollo de un sistema que permita realizar la facturación de una distribuidora de productos para el hogar. 
La distribuidora cuenta con varios productos que se encuentran almacenados en diferentes bodegas ubicadas geográficamente a 
lo largo del país.

primero se creo los paquetes:

    ec.edu.ups.DAO
    ec.edu.ups.IDAO
    ec.edu.ups.controlador
    ec.edu.ups.idioma
    ec.edu.ups.modelo
    ec.edu.ups.vista
    imagenes
    
**1.ec.edu.ups.modelo**
en este paquete se crearon todas las clases necesarios para poder crear una factura. 

    Bodega.java 
    Cliente.java 
    Factura.java 
    Persona.java 
    Producto.java 
    Usuario.java
    
**2. Bodega**
Declaraciones que tiene  la clase bodega en este caso seran de accesibilidad privada los 2 atributos 
     
Getters y setters: 

     Se crearan  los metodos get y set de la clase bodega 
     Los métodos getter y setter se utilizan para definir una propiedad, 
     a estos se accede como propiedades situadas fuera de la clase, aunque
     las defina dentro de la clase como métodos.
     
HashCode, Equals & toString:
    
     hashcode: es un metodo sobreescrito dentro de la clase bodega se encarga de crear
     un codigo unico de una bodega
     equals: busca dentro de la clase si existe el nombre de la bodega 
     si consige su finalidad  tendremos como reultado un retorno de true y de no encontrarlo 
     nos devolvera un false
     toString:El metodo  to String nos sirve para imprimir los datos de la clase bodega 
     pero en  en orden

**3. Cliente**
Esta clase es la que contiene la representacion de los datos que necesita  el sistema para su funcionamiento, 
hereda los metodos y atributos de la clase persona. 

    Metodo ValidarEspacios: Metodo en el cual se llena con espacios o  se recorta a una cierta cantidad
    de caracteres con el fin de guardar la informacion con el tamaño exacto para 
    ser guardados correctamente en el archivo binario y completar el numero de 
    bytes asignados.
     
Getters y setters: 

     Se crearan  los metodos get y set de la clase cliente 
     Los métodos getter y setter se utilizan para definir una propiedad, 
     a estos se accede como propiedades situadas fuera de la clase, aunque
     las defina dentro de la clase como métodos.
     
HashCode, Equals & toString:
    
     hashcode: es un metodo sobreescrito dentro de la clase clientes se encarga de crear
     un codigo unico de un cliente
     equals: busca dentro de la clase si existe la cedula del cliente
     si consige su finalidad  tendremos como reultado un retorno de true y de no encontrarlo 
     nos devolvera un false
     toString:El metodo  to String nos sirve para imprimir los datos de la clase cliente 
     pero en  en orden
 
**4. Factura**
Getters y setters: 

     Se crearan  los metodos get y set de la clase Factura 
     Los métodos getter y setter se utilizan para definir una propiedad, 
     a estos se accede como propiedades situadas fuera de la clase, aunque
     las defina dentro de la clase como métodos.
     
HashCode, Equals & toString:
    
     hashcode: es un metodo sobreescrito dentro de la clase Factura se encarga de crear
     un codigo unico de una factura
     equals: busca dentro de la clase si existe una factura con el mismo numero
     si consige su finalidad  tendremos como reultado un retorno de true y de no encontrarlo 
     nos devolvera un false
     toString:El metodo  to String nos sirve para imprimir los datos de la clase factura 
     pero en  en orden

**5.Persona**
Esta clase es la que contiene la representacion de los datos que necesita 
el sistema para su funcionamiento, es la clase padre de las clases: Cliente,
Usuario.

    Metodo ValidarEspacios: Metodo en el cual se llena con espacios o  se recorta a una cierta cantidad
    de caracteres con el fin de guardar la informacion con el tamaño exacto para 
    ser guardados correctamente en el archivo binario y completar el numero de 
    bytes asignados.
     
Getters y setters: 

     Se crearan  los metodos get y set de la clase Persona 
     Los métodos getter y setter se utilizan para definir una propiedad, 
     a estos se accede como propiedades situadas fuera de la clase, aunque
     las defina dentro de la clase como métodos.
     
HashCode, Equals & toString:
    
     hashcode: es un metodo sobreescrito dentro de la clase Persona se encarga de crear
     un codigo unico de una Persona
     equals: busca dentro de la clase si existe la cedula de una persona
     si consige su finalidad  tendremos como reultado un retorno de true y de no encontrarlo 
     nos devolvera un false
     toString:El metodo  to String nos sirve para imprimir los datos de la clase Persona 
     pero en  en orden
     
**6.Producto**
El metodo  produto nos ayudara a inicializar los atributos dentro del constructor 
con todos los atributos de a clase resiviendo como parametros el codigo, nombreProducto,el precio 
y la cantidad,  ademas de rcibir guarda la informacion alos atributos propios de esta clase

Getters y setters: 

     Se crearan  los metodos get y set de la clase Producto 
     Los métodos getter y setter se utilizan para definir una propiedad, 
     a estos se accede como propiedades situadas fuera de la clase, aunque
     las defina dentro de la clase como métodos.
     
HashCode, Equals & toString:
    
     hashcode: es un metodo sobreescrito dentro de la clase Producto se encarga de crear
     un codigo unico de un producto
     equals: busca dentro de la clase si existe una factura con el mismo numero
     si consige su finalidad  tendremos como reultado un retorno de true y de no encontrarlo 
     nos devolvera un false
     toString:El metodo  to String nos sirve para imprimir los datos de la clase Producto
     pero en  en orden

**7.Usuario**
Esta clase es la que tiene la representacion de los datos que necesita el
sistema para su funcionamiento.

     metodo Validar Espacios:Este metodo nos permite decirle cuantos espacios le dejamos usar y si este 
     le falta completar lo llenamos con espacios o si se ha pasado lo cortamos.
     
Getters y setters: 

     Se crearan  los metodos get y set de la clase Usuario 
     Los métodos getter y setter se utilizan para definir una propiedad, 
     a estos se accede como propiedades situadas fuera de la clase, aunque
     las defina dentro de la clase como métodos.
     
HashCode, Equals & toString:
    
     hashcode: es un metodo sobreescrito dentro de la clase Usuario se encarga de crear
     un codigo unico de un usuario
     equals: busca dentro de la clase si existe un usuario con el mismo numero
     si consige su finalidad  tendremos como reultado un retorno de true y de no encontrarlo 
     nos devolvera un false
     toString:El metodo  to String nos sirve para imprimir los datos de la clase usuario
     pero en  en orden
     
**8.Paquete ec.edu.ups.DAO**
en este paquete se crearon las siguientes clases:

    BodegaDAO.java 
    ClienteDAO.java 
    FacturaDAO.java 
    PersonaDAO.java 
    ProductoDAO.java 
    UsuarioDAO.java

**9.BodegaDAO.java**
Datos de la clase BodegaDAO:

     Dimensiones del archivo:
     String nombre -> 25 bytes + 2 
     String direccion -> 50 bytes + 2 
     Stringcuidad ->25 bytes + 2

     total registro = 106
     
Metodos:

     Metodo Crear Bodega:El metodo crea traducido seria crea, que vamos a crear?
     en este caso creariamos bodejgas q ya que esta ricibiendo como parámetros
     bodega. entonces a propósito de esto en la codificación es decir que este método
     nos va a crear o registrar los datos de la bodega y usar el método buscar nos ubicariamos
     con el puntero en l posición del archivo y ese empezara a leer o escribir en esa posición
     ademas de esto estamos haciendo uso de writeUTF donde le decimos que nos escriba un texto 
     en un formato de tipo aString o utf -8 pero claro esto de debe hacer con sus respectivas 
     limitaciones lanzando y atrpaango las pérdidas
     
     Metodo lee Bodega:El metodo leer bodega se encarga de leer todo dentro del archivo especificado 
     con el RandomAccesFile, ya que podras leer el nombre lo estamos pasando como 
     parametros un dato de tipo String nombre y nos estamos ayudando con 
     los saltos para poder controlar donde se crea ya que el buscar también puede ubicarse 
     en el final del archivo para poder hacer las transacciones específicas especificadas.

     Actualización de Metodo Bodega:El memetodo actualizar bodega esta reicibiendo como parametr bodega
     donde nos ubicamos en el unicio con ell buscar y esto hara que el usuario
     despuesde que pase por eso la cofificación el usuario ingrese los nuevos datos que se le daran 
     a la clase bodega con todos sus atributos es decir 
     la infomacion antigua sera suplantada por una nueva que sera ingresada por el usuario
     
      Eliminar Metodo: El metodo eliminar esta resibiendo coomo parametro un nombre de tipo string ya que 
      para eliminar primero tenemos que buscarle ala bodega y despues de eso estamos
      indica que bodega sera eliminadaa para que el metodo le elimine desde esa psosicion en a
      adelante con todos sus atributos incluidos
      
     El metodos listar Bodegas:Este método nos dara a conocer una lista de bodegas gracias ala lista de clases 
     podremos hacer que este método se ejecute de una manera correcta para ellos debemo
     controlar los saltos que demos dentro del archivo para poder recoorer todo 
     y encontrar todas las bodegas disponibles para poder despues agregar los datos e
     datos encontrados para posteriomente ser listads y que el GUI puede observar 
     todo lo que esta dentro de los términos y pueda hacer consutltas posteriormente en 
     otras interfaces
**10.ClienteDAO.java**
datos de la clase Cliente: 

     Estructura del archivo:
     String cedula = 10 bytes private 
     String nombre = 25 bytes 
     String apellido = 25 bytes 
     String nombreDelLocal 25 bytes 
     String telefono = 25 bytes 
     String direccion = 50 bytes

     Total bytes registro = 172 bytes
     
Metodos:

     Metodo Create:Metodo sobrescrio de la clase ICliente con el fin de escribir o ingresar
     la informacion recibida como parametro en el archivo binario.
     
     Metodo Read: Metodo sobrescrito de la clase ICliente donde se busca y retorna la 
     informacion que este ligada a la id, comparando los datos guardados en el 
     archivo con el parametro recibido.
     
     Metodo Update: Metodo sobrescrito de la clase ICliente, recibe un parametro de tipo
     cliente, donde comparamos el id del parametro con los id recuperados
     del archivo para poder acualizar la informacion que este ligada al id
     del cliente.
     
     Metodo Delete: Metodo sobrescrito de la clase ICliente, busca la informacion que este 
     ligada al id para despues remplazar con espacios vacios realizando una 
     eliminacion logica.
     
     Metodo findAllClientes: Metodo sobrescrito de la clase ICLiente, recupera toda la informacion guardada
     en el archivo para guardar en una lista para ser retornada.
     
**11.FacturaDAO**
Datos de la clase Factura:

     private int numeroDeFactura; | 4 bytes 
     private int cantidadVendida; | 4
     bytes private boolean estado; | 1 byte 
     private double subtotal; | 8 bytes
     private double iva; | 8 bytes 
     private double total; | 8 bytes 
     private Cliente cliente (cedula)| 10 bytes + 2 bytes 
     private Producto producto (codigo) | 10 bytes + 2 bytes
     
     total detalleOrden = 4+4+10+2 =20 bytes
     total factura = 4+1+8+8+8+10+2=41 bytes
     
metodos: 

     Create: Este método recibe una lista de tipo Factura en la cual con esa lista
     extraemos los datos y los vamos agregando a los dos archivos individuales
     que se tiene para la factura. En un archivo se recorre un for Each en la 
     cual solamente se carga el numero de la factura, la cantidad vendida, 
     y el código del producto. En el otro archivo se guardan los datos 
     importantes de la factura la cual es el numero de la factura, 
     la cedula del cliente, el subtotal, el IVA, el total y el estado 
     de la factura. 
     
     readDetalleFactura: Este método recibe en sus parámetros un objeto de tipo entero.
     Este método primero inicializa una lista, después con un while(),
     se recorre todo el archivo del detalle de la factura. Después se hace 
     una condición en la cual se compara si es que el numero de la factura
     es igual el entero que se encuentra en el parámetro, se agrega ese 
     objeto de tipo factura a la lista, sino cumple no lo agrega a la lista.
     Al final retorna la lista de tipo factura o sino retorna un null si es 
     que nunca lo encontró.
     
     readFactura: Este método recibe en sus parámetros un objeto de tipo entero. 
     Este método va consultando en el archivo factura si es que el entero que
     esta en su parámetro existe en el archivo factura, y va saltando de dato 
     en dato. Si es que lo encuentra retorna ese objeto de tipo factura sino
     retorna un null. 
     
     findAllFacturasDisponibles: Este método lee todas las facturas dentro del archivo Facturas y lee el 
     estado de la factura. Si es que el estado de la factura es verdadero lo
     agrega a una lista de tipo factura. Al final retorna esta lista o sino 
     retorna un null.
     
     findAllFacturasAnuladas: Este método lee todas las facturas dentro del archivo Facturas y lee el 
     estado de la factura. Si es que el estado de la factura es falso lo 
     agrega a una lista de tipo factura. Al final retorna esta lista o sino 
     retorna un null.
     
     getCodigoActual:Este método los que hace es leer el ultimo numero que existe en el
     archivo factura una vez que encuentra el ultimo numero de la factura 
     lo retorna y le suma un valor mas para que al facturar se produzca un 
     nuevo numero y no un repetido. 
     
     anularFactura: Este método recibe en sus parámetros un objeto de tipo entero. A este 
     método se le pase el numero de la factura que quieren anular. Después 
     busca ese numero de la factura dentro del archivo Factura, cuando lo 
     encuentra cambia el estado de la factura de verdadero a falso. 
     Por ultimo se retorna todos los objetos dentro de esa factura a 
     sus bodegas. 
     
     regresarProductos: Este método recibe en sus parámetros un objeto de tipo entero.  Este 
     método lo que hace es buscar todas la facturas que tengan el mismo numero
     que esta en sus parámetros y después llama al productoDAO para que 
     actualice ese producto con los datos que se le están agregando.

**12. ProcudtoDAO**
datos de la clase producto:

     private String codigo | 10 caracteres + 2 bytes
     Private String nombreDeProducto | 25 caracteres + 2 bytes 
     private double precioDeProdcuto | 8 bytes 
     private int cantidad | 4 bytes 
     Private Bodega bodega (nombre de Bodega) | 25 caracteres + 2 bytes

     total= 78 bytes

metodos:
    
     Metodo create: El metodo crear producto en primer lugar se ocupa en la posicion final del archivo en la 
     ruta ya especificada despues de esp procedera a escribir en la posicion ya encontrada 
     con anterioridad estableciendo un codigo, producto, cantidad, nombre ala bodega pero dento de
     la bodega
     
     Metodo read: Dentro del metodo read  lo que aremos en leer el ficher pero con los procesos que se 
     requieran en dicho metodo por ejemplo  en este caso tendremos un fichero de productos 
     donde se procedera a  establceer los valores a cada atributo de  factura en este caso 
     crenando un  producto interno donde se  estableceran el codigo, numero, producto, direccion
     y la cantidad de productos.
     
     Metodo read Codigo: El metodo para leer el codigo nos ayudara para establecer siertos valores alos atributos de la c
     clase producto en ellos analizaremos la manera en que son establecidos los calores alos atributos pero 
     esta ves solo  podremos observar los datos en caso de que este metodo sea llamado en la GUI
     
     Metodo update: El metodo actualizar bodega nos sirve en especial para renombrar siertos atributos ya estabelcido en 
     la clase producto, mismos que el usuario podra leer ya con GUI para ellos es nesario controlar los saltos
     en este caso iniciara en cero eh ira s aumentando dependiento el usu que se le de al metodo 
     y donde sea invocado.
     
     Metodo delete: El metodo eliminar nos eliminara de una manera directa un producto ya creado con anterioridad ya que ademas de
     eso esta controlado de que exista el producto dentro de los archivos  punto dat para poder ser ejecutado en metodo de 
     caso contrario no podra  no servira para el cual fue planteado.
     
     Metodo listar productos: El metodo a cuestion es muy necesario en esta clase ya que sin ellos el usuario no podra
     observar todo lo que tiene a sus disposicion para poder hacer dichas modifcaciones o 
     consultas  para ellos anbuscarenos un codigo que nos facilitara la consulta individual de los 
     productos estableciendo los calores dentro de una tabla que esta actuando con el usuario.
     
     Metodo Listar Productos por Bodega:El metodo listar esta englobando a todas las bodegas y se podra analizar el de una manera 
     legible todos los datos especificados en alguno de los atributos para ellos se establecera y se 
     emepzara a ver dentro del arhchivo desde la posisicon 0 eh ira leyendo todo los productos que encuentre para 
     posteriormente  ser mostrados en la GUI 
     
**13. UsuarioDAO**
detos de la clase usuario:

     String cedula = 10 caracteres 
     String nombre = 25 caracteres 
     String apellido = 25 caracteres 
     String Correo = 50 caracteres 
     String contrasena= 8 caracteres
     
     total= 128 bytes

metodos:

     Metodo create:Este metodo es el encargado de crear.
     Le decimos que registre los datos del usuario y con el metodo seej que
     coloque el puntero en la posicion del archivo y este empezara a leer o
     escribir en dicha posicion y con el writeUTF le decimos que escriba texto
     en el formato UTF - 8 precidiendo con la longitud del texto.
     
     Metodo read: Este metodo es el que se encarga de leer, como nuestro registro consta de
     128 bytes. le decimos que el salto va a ser de cero ya que nuesto cedula
     seria el que esta primero. mientras nuestro salto sea menor a la longitud
     de nuestro archivo nuestro puntero se va y le decimos con readUTF lee el
     numero de bytes.
     
     Metodo update: Encargado de actualizar los datos del usuario,Si la cedula es igual a la
     cedula del usuario le decimos que va a saltar 12 bytes debido a que no
     podemos cambiar los datos de la cedula y le damos los nuevos datos al
     usuario
     
     metodo delete:
     Encargado de eliminar un usuario, en este caso como estamos haciendo con
     archivos binarios no le podemos eliminar lo que hariamos es
     sobreescribirle de espacios.
     
     Metodo listar Usuario:Con este metodo Listamos todos los usuarios que se hayan registrado y le
     hacemos con el metodo readUTF leemos los bytes.
     
     Metodo login:Este metodo es el encargado del inicio de sesion del usuario.

**14.paquete ec.esu.ups.controlador**
En este paquetes se crearon todas las clses que van a interactuar con la interfaz

    ControladorBodega.java
    ControladorCliente.java
    ControladorFactura.java
    ControladorProducto.java
    Controladorusuario.java

**15.ContorladorBodega.java**

metodos:

    Metodo ControladorBodega: El metodo constructor bodega hace que un elemento de la clase controlador
    Bodega cuyo identificador coincide con el de la clase bodega y que tiene
    por objetivo obligar a y controlar cómo se inicializa una instancia de
    una determinada clase, ya que el lenguaje Java no permite que las
    variables miembro de una nueva instancia queden sin inicializar.
    
     Metodo crearBodega: El metodo crear bodega nos ayuda con la facilidad nesearia y se puede
     desarrolllar con normalidad debido a que resive como parametros los
     atributos de Bodega que son de tipo String y estos seran los que se
     ecnargen de crearo registrar o actualizar bodegas en este caso solo
     tendremos la facilidad para crear una bodega llamando ala bodega dao para
     poder lleva acabo el codigo
     
     Metodo buscarBodega: El metod buscar bodega se va a ubicar dentro del fichero ya especiicado
     en el dao de el proyecto y esto servira para poder identificar donde esta
     y que modificaciones se puede llevar a cabo entonces la funciolidad de
     este metodo es con valores de retorno ya que si contiene una bodega nos
     retornara una bodega de caso contrario un null
     
     Metodo eliminar Bodega: Para llevar a cabo el metodo eliminar es necesario considerar que
     necesita un parametro de entrada para poder buscar eh identificar donde
     esta la bodega especificada para poder hacer efectivo este metodo es
     necesario llamar al dao que proseda a su busqueda y posteriormente
     econtrada a ser eliminada
     
     Metodo listarBodegas: Este metodo es primordial ya que nos ayuda aque la GUI pueda ver observar
     interactuar con las bodegas entonces teneidno como resultados bodegas
     modificables o fijas en caso de que el usuario solo quiera consultar
     cosas o productos dentro de la mismo pero considerando que la
     funcionalidad de este metodo se debe en su totalidad ala clase llama que
     esta dentro del paquete DAO (bodegaDAO).
**16.ControladorCliente.java**
Esta clase realiza como intermediario entre la vista, el modelo y el dao para manejar la informacion ingresada.
metodos:

    MetodoControladorCliente: Metodo constructor en el cual se recibe como paramerto el clienteDao.
    
    Metodo crearCLiente: Este metodo recibe la informacion mediante parametros para crear un nuevo
    objeto tipo cliente y enviar al dao para registrar en el archivo.
    
     Metodo buscarCliente: Recibe un atributo tipo string para enviar al cliienteDao y luego compara
     la informacion retornada desde el dao, si es diferente de null, retorna al
     cliente y si es igual a null, retorna null.
     
     Metodo actualizarCliente: Este metodo realiza como inetermediario entre la vista y dao, tecibe como
     paametro un cliente y este el envia al Dao para que sea modificado en el 
     archivo.
     
     Metodo eliminarCliente: Recibe como parametro un String y le envi al dao para buscar el cliente y
     el cliente retornado se vuelve a enviar al dao para que se elimine del 
     archivo.
     
     Metodo listarClientes:Recibe desde el dao informacion que es guardada en una variable tipo
     Lista y esta misma es retornada a la vista para ser listada.
     
**17.ControladorFactura.java**
metodos:

     CrearFactura: Este metodo recibe en su parametro una lista de tipo Factura. Pasa esa lista
     al facturaDAO.
     
     buscarDetalleFactura: 
     este método recibe en su parámetro un objeto de tipo entero.  
     Este método llama al FacuturaDAO y le pasa el numero de la factura 
     para que le retorne el detalle de la factura con el mismo numero. 
     
     buscarFactura: este método recibe en su parámetro un objeto de tipo entero.  
     Este método llama al FacuturaDAO y le pasa el numero de la factura 
     para que le retorne el detalle de la factura con el mismo numero. 
     
     listarFacturasActivas: Este método llama al facturaDAO y le pide que le encuentre la lista de 
     facturas que son validas y que las retorne.
     
     listarFacturasAnuladas: Este método llama al facturaDAO y le pide que le encuentre la lista de 
     facturas que no son validas y que las retorne.
     
     AnularFacturas:Este método recibe en sus parámetros un objeto de tipo entero y llama 
     al FacturaDAO para que anule la factura que tiene el mismo numero de 
     factura que se tiene en el parámetro.
     
     codigo: Este método consigue el siguiente código de la factura y lo retorna. 

**19.ControladorUsuario**
metodos: 

     Metodo Registrar usuario: Pasamos como parametro los datos del usuario,y llamamos los metodos del usaurioDAO
     y creamos al usuario.
     
     Metodo buscar Usuario:En este metodo mandamos a buscar por el numero de cedula y si lo encuentra 
     nos retorna al usuario.
     
     Metodo devolver Usuario: Este metodo nos sirve para retornar al usuario en este caso le estamos usando
     para los datos de l tabla de entrada en la interfaz.
     
     metodo validar Usuario:Este metodo es el encargado de que cuando el usuario inicie sesion vea si 
     que los datos que ingreso sean correctos.
     
     Metodo actualizar usuario: Se encarga de actualizar los datos del usuario.
     
     Metodo eliminar Usuario:Es el encargado de eliminar un usuario
     Le pasamos como parametro la cedula, y mandamos a buscar si el usuario 
     existe con el metodo delete lo eliminamos.
     
     metodo listar Usuario: Este metodo es el encargado de listar todos los usuario creados, le instanciamos
     un ArrayList y mandamos a llamamos al metodo del usuarioDAO findAll.
     
**20.ec.edu.ups.idioma**
en este paquete solamente se crearon dos clases de tipo properties.

    mensaje_en_EU.properties (cambia el idioma en ingles)
    mensaje_es_EC.properties (cambia el idioma en Español)
    
**21.imagenes**
este paquete solamente contiene todas las imagenes utilizadas para la visualizacion de la interfaz.

**22.ec.edu.ups.vista**
en este paquete se crearon todas la interfaces en las cuales el usuario va a interactuar.

    ventanaBodega.java
    ventanaCliente.java
    ventanaFactura.java
    ventanaIniciarSesion.java
    ventanaListarFacturas.java
    ventanaPrincipal.java
    ventanaProductos.java
    ventanaRegistarCliente.java
    ventanaRegistrarUsuario.java
    ventanaUsuario.java
    
**23.VentanaBodega.java**
en esta interfaz se crearon todos los metodos para llamar al controlador.

Crear nueva ventana bodega
Para este metodo estamos controlando la visibilidad de siertos componentes como la actualizacion de vista y la desactivacion de los
botones que interactuaran con la interfaz grafica de usuario, El initComponents() no lo puedes modificar asi no mas, en el metodo donde el
ide lleva el control de lo que hace, si lo alteras posiblemente ya no pueda cargarse la interfaz. Lo que puedes hacer es usar el editor del ide hasta donde ya creas que no puedes mas, luego lo que haces es un copy-paste del initComponents(), si lo haces tendrias dos metodos con el mismo nombre, aca solo debes de documetar el metodo del ide y listo, ya puedes modificar el initComponents() que haz copiado

metodos:

     Metodo Actualizar Vista: Este metodo se encarga directamente con la GUI ya que si llamamos este metodo
     tendremos como resultados los datos cargados dentro de la tabla Datos
     haciendo que el usuario pueda ver los datos de la bodega que en este caso serian solo 
     tres datos que serian el nombre la direccion y a ciudad donde estara
     ubicado la bodega a gestionar
     
     Metodo Limpiar: El metodo clean o limpiar es muy usable para la GUI porque ara que la experiencia
     con el usuario sea satisfactorio ya que  cada ves que el metodo sea llamado 
     este podra limpiar los espacios designados para el nomnre ladireccion y la ciudad 
     aunque ya esten caargados los datos ese metodo podra limpiar en caso de que sea llamado
     
      Metodo activar botones: El metodo activar botones nos da la factibilidad en los comandos como 
      de botones como actualizar, buscar, cancelar, eliminar, para que estos botones
      sean acivados  de la manera true, dependera mucho de el tipo de gestion que este 
      haciendo el usuario en la ventana bodega para que el pueda tener accesibilidad a 
      estos botones seria como una restriccion para ellos ya que no podran estar activando
      y desactivando sino reguirse ala funcionalidad del programa
      
       Metodo desactivar botones: El siguiente metodo nos descativara los botoes para que el usuario no pueda manipular
       dependiendo el tio de gestion este haciendo ellos tendran la accesibilidad 
       y en caso de que este metodo sea invocado en cualquier otro el metodo nos ara que 
       se desactiven a diferencia el metodo anteriormente tratado
       
        Metodo btnActualizarActionPerformed:Este metodo fue generado automaticamente por java y correcponde 
        al boton actualizar que esta en la interfaz grafica de usuario y este metodo ara que
        establesca los nombre direciones y la ciudad de donde estara situado la bodega a gestionar
        ya que estara avtivado solo este boton y el nuevo en caso de que el usuario quiera
        agregar otra bodega ala lista de bodegas
        
        Metodo btnBuscarActionPerformed: Este metodo es la encargada de buscar dentro de la tabla creada donde estaran 
        todos los datos almacenados con  las caracteristicas de bodega, y esto controlara 
        que el usuario en el momento de buscar una bodega la coficacion permita buscar dentro
        con un for ya que debera recorrer todas las columnas con el dato que el  usuario
        le dara para su busqueda y en caso de no encontrarle nos dara un mensaje de error
        y en caso de que  si solo nos dara  los valores encontrados dentro del dato especificado
        
        Metodo botonEliminarActionPerformed:El metodo eliminar nos ayudara a eliminar  las bodegas que esten alamecenados dentro del fichero
        automanticamente pero por supuesto si el dato a eliminar es correcto se procedera con la ejecucion del codigo elimninar 
        en caso de que se logre desarrollar con exito tendremos como resultado un 
        Bodega eliminado con exito
        
         Metodo btnNuevoActionPerformed: El metodo nuevo nos ayudara a crear una bodega nuevo con los nombre. direciones
         y ciudad establecida por el usuario estos datos inmetiatamente pasaran alos ficheros
         para ser almacenados  de una manera automatica ya que si se procede a ejecutar 
         este metodo  es lo que hara.
         
         Metodo TblDatosMouseClicked: El metodo daos es la que nos muestra los atributos de bodega de una manera inmediata solo 
         cuando se selecione ndicha columna se procedera a ejecutarse este codigo 
         devolviendonos de una manera rapida el estatus de la bodega selecionada y maracandola
         de una manera particular que sea diferenciada de las demas columnas
         
          Metodo botonCancelarActionPerformed:El metodo cancelar nos ayudara simplemente a detener un proceso 
          que el ussuario este haciendo en la interfaz limpiando todo lo que este echo ya permitiendole que pueda 
          el volver hacer todo ese proceso o hacer otro distinto.
          
 **24.VentanCliente.java**
 en esta interfaz se crearon todos los metodos para llamar al controlador.
 
     Metodo tblClienteMouseClicked: Al hacer click sobre alguna fila de la tabla, esta recupera los datos guardados
     en esa fila y le asigna a los JTextField correspondientes habilitando los botones de eliminar, actualizar, cancelar.
 
     Metodo btnListarClientesActionPerformed: Lista todos los clientes registrados llamando al metodo LlenarDatosTabla
     
     Metodo btnBuscarClienteActionPerformed: Al presionar el boton de buscar, recupra la informacion del JTextField 
     buscarCliente donde le envia al controlador y luego retornar el cliente y mostrar en el clliente encontrado en la tabla.
     
     Metodo btnActualizarClienteActionPerformed: Al presionar el boton este reupera la informacion de los JTextField y actualiza
     el cliente enviando al controldor.
     
     Metodo btnLimpiarActionPerformed: Al presionar el boton este borra toda la informacion de la interfaz, con 
     ayuda de los metodos limpiar, botones, editables y limpiezaTabla.
     
     Metodo btnCancelarClienteActionPerformed: El metodo realiza la accion de quitar la seleccion del jTable y borrar la
     informacion de todos los JTextField ademas vuelve a desabilitar los botones.
     
     Metodo btnEliminarClienteActionPerformed: Este metodo al hacer click el boton de eliminar, recupera el dato del 
     JTextField cedulaCliente y le envia al controlador para eliminar la informacion ligada a la cedula.
     
     Metodo botones: Este metodo desactiva los botones actualizar, cancelar, eliminar cuando no esta seleccionado 
     ningun elemento de la tabla.
     
      Metodo editables: Este metodo desabilita la opcion de editar los jtext para no realizar ningun
      cambio si no se desea.
     
     Metodo limpiar: Borra todo el texto que este ingresado en los campos de texto o JTextField
     
     Metodo llenarDatosTabla: Este metodo lista todo los cllientes que se hayan registrado, guardando en una 
     variable tipo lista lo que retorna el controlador para ser agregado a la tabla.
     
     Metodo listarCliente: Este metodo lista al cliente que se encuentra al presionar el boton buscar,
     recibe como parametro el cliente y el metodo le agrega a la tabla.
     
     Metodo limpiarTabla: Borra todos los datos de la Jtable
     
**25.VentanaFactura**
 en esta interfaz se crearon todos los metodos para llamar al controlador.
 
 metodos:
 
     limpiar: Este metodo limpia todo el contenido que pueda estar escrito en las cajas de texto y tambien los combo-boxs.
     
     FechaActual: Este método formatea la manera en la que se quiere visualizar la fecha 
     del computador al momento de implantarlo en la factura.
     
     actualizarCmbxBodega: Este método ayuda a formatear el modelo de la tabla ya que cuando se 
     agrega una bodega y un producto se les debe añadir a estas para que le 
     permita al usuario interactuar con los nuevos producto y bodegas. 
     
     ActivarTextBoxs: Este método solamente habilita las cajas de texto para que el usuario 
     pueda editarlas.
     
     desActivarTextBoxs: Este método solamente deshabilita las cajas de texto para que el usuario no pueda editarlas.
     
     actualizarVista: Este método ayuda a actualizar la vista de la tabla ya que se debe añadir
     nuevo elementos cada vez y la tabla debe actualizarse cada vez. 
     
Eventos:

     formFocusGained: Este evento solamente acude a los métodos dentro de la interfaz y es que 
     cada vez que pierda el enfoque y vuelva a ganar enfoque se actualizara el
     combo-box automáticamente, se formatea la fecha de la caja de texto y también se actualiza el numero de factura.
     
     cmbxBodegaFocusLost:Este evento lo que permite es que cuando el combo-box pierda enfoque se 
     actualiza automáticamente el combo-box de producto con los productos que existen en esa bodega. 
     
     txtCedulaKeyTyped:Este evento corre cada vez que presionen “ENTER” en el teclado, comprueba
     que todos los campos estén completos, sino soltará un error y un 
     opciónpane aparecerá. Si no salta error los datos del cliente se cargarán
     automáticamente en las cajas de texto. Si el cliente no existe un 
     OptionPane aparecerá en la cual pregunta al usuario si quiere crear 
     un nuevo cliente. Si es que selecciona que si se activara el botón para 
     registrar el cliente y también se activaran las cajas de texto para que 
     el usuario pueda ingresar los datos.
     
     botonCalcularActionPerformed: Este evento permite que se calcule los valores del subtotal, el IVA y el
     total cuando se presione le botón calcular.
     
     botonProductosActionPerformed: Este evento lo que hace es cargar el producto seleccionado en el combo-box
     en la tabla para poder proceder a facturarlo.
     
     botonCrearFacturaActionPerformed: Este evento lo que hace es extraer todos los datos de las cajas de texto
     y de la tabla, procede a crear una factura.
     
     botonRegistrarClienteActionPerformed:Este evento lo que hace es registrar a un nuevo cliente para poder crear 
     una factura. 
     
**26.VentanaListaFactura**
 en esta interfaz se crearon todos los metodos para llamar al controlador.
 
     VistaDatosFacturaValida: Este método actualiza la vista de la tabla para listar todas la facturas
     que son validas.
     
     VistaDatosFacturaAnuladas:Este método actualiza la vista de la tabla para listar todas la facturas 
     que no son validas.
     
     cargarDetalleFactura: Este método recibe en su parámetro un objeto de tipo entero. Este método 
     actualiza la tabla de detalles y lista todos los detalles de una factura 
     en especifica.
     
     limpiar: Este método ayuda a limpiar todos los contenidos dentro de las cajas de 
     texto y limpia todos los datos dentro de la tabla de detalles. 
     
Eventos: 
    
     botonListarAnuladasActionPerformed: Este evento permite que al presionar el botón listar Anuladas cargue el
     método de VistaDatosFacturaAnuladas() la cual actualizara la tabla 
     listando todas las facturas anuladas.
     
     botonListarValidasActionPerformed:Este evento permite que al presionar el botón listar Validas cargue el
     método de VistaDatosFacturaValida() la cual actualizara la tabla listando todas las facturas validas.
     
     botonAnularActionPerformed:Este evento permite que al presionar el botón anular se cargue los datos 
     de la factura seleccionada en la tabla y anule los datos dentro de esa factura.
     
     botonVerDetallesActionPerformed: Este evento permite que al seleccionar el botón “ver” se cargue los 
     detalles de esa factura en los campos de texto y en la tabla de detalles.
     
     botonClearActionPerformed: Este evento lo que permite es limpiar los campos de texto y la tabla de detalles.

**27.VentanaRegistrarCliente**
en esta interfaz se crearon todos los metodos para llamar al controlador.

Eventos: 

     Metodo btnRegistrarClienteActionPerformed: Este metodo recupera los datos ingresados en los JtextField al presionar el
     botón y envia al controlador.
     
     Metodo btnRegresarClienteActionPerformed: Cierra la pantalla que esta visible al hacer click en el boton.
     
     Metodo limpiar: Este metodo borra el texto que esta ingresado en los jTextField.

**28.VentanaREgistrarUsuario**
en esta interfaz se crearon todos los metodos para llamar al controlador.

Eventos:

     Boton Registar:Validamos los campos de texto, guardamos el texto ingresado en los campos.
     
     Boton limpiar: Con este boton le vaciamos lo campos de texto.
     
     Metodo limpiar: Con este metodo le setteamos los campos a texto en blanco.

**29.VentanaUsuario**
en esta interfaz se crearon todos los metodos para llamar al controlador.

Eventos:

     Boton actualizar:Con este boton recuperamos toda la informacion que el usuario ingrese  en el campo 
     de texto y lo actualiza.
     
     metodo tabla Usuario: Este metodo lo utilizamos para seleccionar los datos de la tabla
     
     metodo cargar lista de usuario: Utilizamos este metodo para listar todos los datos que se hayan registrado.
     
     boton listar: Al presionar el boton listamos todos los usuarios que se han registrado.
     
     Boton buscar: Al presionar este boton nos muestra en la tabla los datos del usuario que haya buscado.
     
     Boton eliminar: Al presionar este boton eliminamos el usuario que este seleccionado en la tabla
     le decimos con JOptionPane.showConfirmDialog si esta seguro de eliminar.
     
     Metodo cargarUsuarioTabalaUsuario: Este metodo lo estamos utilizando para actualizar la tabla.
     
Metodos:    

     Metodo devolver Usuario: Este metodo lo usamos para devolver al usaurio 
     
     Metodo actualizarDatosUsuario: Este metodo nos permite buscar al usaurio y listarlo pasandolo como parametro 
     la cedula.
     
     metodo listar Usuario:Le pasamos como parametro al usuario, la utilizamos para buscar al usuario.
     
     Metodo limpiarTabla: Con este metodo limpiamos la tabla.
     
     Metodo limpiar: Limpiamos todos los campos de texto de la interfaz.

