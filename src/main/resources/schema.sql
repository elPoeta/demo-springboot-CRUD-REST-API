
/**
 * Author:  elPoeta
 * Created: May 16, 2018
 */

DROP TABLE IF EXISTS categoria;
DROP TABLE IF EXISTS producto;



CREATE TABLE categoria (
    id BIGINT IDENTITY PRIMARY KEY,
    nombre VARCHAR(50)
);

CREATE TABLE producto (
    id BIGINT IDENTITY PRIMARY KEY,
    categoria_id BIGINT FOREIGN KEY REFERENCES categoria,
    nombre VARCHAR(100),
    modelo VARCHAR(65),
    precio DECIMAL(10,2),
    stock INT,
    descripcion CLOB(30k),
    url_imagen VARCHAR(255),
);



INSERT INTO categoria VALUES (1,'Cuerdas');
INSERT INTO categoria VALUES (2,'Viento');
INSERT INTO categoria VALUES (3,'Percusión');
INSERT INTO categoria VALUES (4,'Teclados y Pianos');
INSERT INTO categoria VALUES (5,'Amplificadores');
INSERT INTO categoria VALUES (6,'Accesorios');


 INSERT INTO producto VALUES(1,1,'Ukelele serie java','MJ1TBR',105.4,3,'Ukelele Soprano,Java, Cpo: Nyatoh, Mango: Mahogany, Pte y Diap: Rwd, Cdas:AQUILA, Cejuela: NUBONE c:Transp BRW','/img/guitar2.png');
 INSERT INTO producto VALUES(2,3,'Tambor JBJD-109','JBJD-109',234.94,2,'Tambora de madera, parches de cuero con golpeador','/img/drum2.jpg');
 INSERT INTO producto VALUES(3,4,'Samsom Graphite 49','SG-49',314.58,1,'Teclado Controlador Midi USB, Graphite Line, 49t STD, Sensit, Slide, c BK','/img/piano1.jpg');
 INSERT INTO producto VALUES(4,2,'Clarinete JBCL-510','JBCL-510',173.22,5,'Clarinete, 17 llaves, Bb, Bakelita lustrado, con estuche','/img/wind1.png');
 INSERT INTO producto VALUES(5,1,'American Original 60s Stratocaster','Stratocaster 6060',373,5,'Un período de cambio, tanto para Fender como para la cultura pop en su conjunto, en la década de 1960 la Strat se suavizó ligeramente a medida que crecía. El golpeador blanco se actualizó en verde menta, y el diapasón se cambió del arce original al palosanto, agregando una nota más suave al sonido claro y articulado de la Strat. La Stratocaster de los 60 American Original mantiene intactos estos refinamientos al tiempo que agrega una sensación moderna y un nuevo cambio de pastillas al icónico instrumento que ayudó a crear el rock de guitarra tal como lo conocemos.','/img/guitar3.png');
 INSERT INTO producto VALUES(6,5,'Blues Cube Artist Amplificador para Guitarra','Blues Cube',103,9,'La reinventada serie Blues Cube lanza el clásico combo amplificador 1x12 a una nueva era, combinando el sonido genuino y la respuesta del bulbo con la moderna fiabilidad y fácil portabilidad. Yendo mas allá del modelado, la filosofía de diseño Tube Logic de Roland comienza con la cuidadosa reproducción del funcionamiento interno de la venerada era de amplificadores de bulbos en toda forma, desde la entrada de la guitarra, a la salida de la bocina. Los canales Versatile, Clean y Crunch pueden ser usados independientemente o combinados para obtener un complejo rango de sonidos, mientras que los modos de salida con poder variable permiten invocar el quemador sonido a toda-velocidad en cualquier nivel de volumen. Probado en la gira y micro-afinado con las experiencias de los máximos intérpretes, el Blues Cube listo-para-el-show, entrega el mágico sonido dulce y la sensación satisfactoria que hacen del combo amplificador de guitarra un instrumento altamente expresivo.','/img/amp1.jpg');
 INSERT INTO producto VALUES(7,3,'Bateria Roland TD-K30','TD-K30',1935.67,3,'Por más de una década la revolucionaria línea V-Drums de Roland, gracias a su expresiva calidad de sonido e increíble respuesta a la interpretación, ha liderado a la industria. Con la introducción de la serie “V-Pro SuperNATURAL-powered,” el set de batería electrónica alcanza un nuevo pináculo en interpretación de batería. “Sonidos SuperNATURAL” con Modelado de Comportamiento, junto con avanzada tecnología de detección, proveen un nuevo nivel de expresiva calidad de sonido e interpretación, resultando en un instrumento que reacciona y responde a todas las delicadezas, matices y dinámicas de la técnica del baterista. En adición a esto, funcionalidad USB de reproducción de audio ha sido añadida, para expander la paleta de ejecución. Para el escenario (TD-30KV) o para grabaciones profesionales (TD-30K), la nueva V-Pro es verdaderamente una experiencia tanto natural, como completa, en la ejecución de batería.','/img/drum1.jpg');
 INSERT INTO producto VALUES(8,5,'Jazz Chorus JC-40','JC-40',124.8,6,'El Jazz Chorus JC-40 entrega el renombrado tono Roland “JC clean” y su distintivo efecto estéreo chorus en un combo amplificador compacto con características evolucionadas para el guitarrista moderno. Tal como en el amplificador JC-120 buque insignia en el que está basado, el JC-40 ofrece un sonido estéreo clásico que es la paleta perfecta para darle forma al tono con pedales de efectos. Ahora, porta una entrada estéreo verdadera para el desempeño realzado con pedales de efectos estéreo, sintetizadores de guitarra, equipo modelador de guitarra, y multi-efectos. En adición, los efectos a bordo del JC-40 incluyen nuevas funciones añadidas y sonidos actualizados para soportar las necesidades de los intérpretes de hoy.','/img/amp2.jpg');
 INSERT INTO producto VALUES(9,1,'JMJ ROAD WORN® MUSTANG® BASS','JMJ BASS 011',578,4,'Conocido como un verdadero renovador de la escena musical moderna, entre las credenciales de Justin Meldal-Johnsen están Beck, Nine Inch Nails, Drake y muchos más. Sus créditos de producción incluyen a Jimmy Eat World, Paramour y M83, entre otros. JMJ es un ejemplo brillante de los actuales músicos / productores multi-género, siempre empujando los límites e inspirando a otros. Del estudio al escenario, el preciado 67 Mustang Bass de Justin es su herramienta favorita. Nos asociamos con él para crear un bajo de firma de 4 cuerdas inspirado en su instrumento vintage Daphne Blue, el Justin Meldal-Johnsen Road Worn Mustang Bass.','/img/bass1.png');
 