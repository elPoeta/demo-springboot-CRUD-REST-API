# demo-springboot-CRUD-REST-API

Spring es un factory de objetos. Es decir, se encargará de construir por nosotros objetos (nos evitará hacer el "new Clase()..."). Pero además de constuir las clases cuando se lo pidamos, le inyectará las dependencias que esa clase tenga, construyendo los objetos según sea necesario (y, recursivamente, seteando las dependencias de los objetos dependientes).

Es decir, Spring es un factory de objetos que inyecta dependencias.

Estos objetos en Spring se conocen como "beans". Una clase se define como bean al agregarle alguna de estas anotaciones: @Component, @Controller, @RestController, @Service, @Repository. Además, allí mismo se declaran las propiedades del objeto que tienen dependencias a otros beans marcandolas con la anotación @Autowired.
