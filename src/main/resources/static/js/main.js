const URL_CATEGORIAS = '/api/categoria/categorias/';
const URL_PRODUCTO_POR_CATEGORIA = '/api/producto/categoria/';
const URL_PRODUCTO_POR_NOMBRE = '/api/producto/productos/';
const URL_ELIMINAR_PRODUCTO = '/api/producto/eliminar/';
const URL_DETALLES_PRODUCTO = '/api/producto/detalles/';
const URL_ACTUALIZAR_PRODUCTO = '/api/producto/actualizar/';
const URL_CREAR_PRODUCTO = '/api/producto/crear';

const http = new Http;
const ui = new Ui;

let idCategoria=0;
let botonNuevo;
let selectCategoria;
let buscarPorNombre;
let botonActualizar;
let botonGuardar;
let botonEliminar;

http.get(URL_CATEGORIAS)
        .then(data => {
            ui.showSeleccionCategoria(data);
        })
        .then(() => {
            selectCategoria = document.querySelector('#categoriaSelect');

            selectCategoria.addEventListener('change', e => {
                idCategoria=e.target.value;
                http.get(URL_PRODUCTO_POR_CATEGORIA + idCategoria)
                        .then(data => {
                            if (data.message === 'Producto no encontrado') {
                                ui.showAlerta();
                                setTimeout(() => {
                                    ui.hideAlerta();
                                }, 2000);
                            } else {
                                ui.showTablaProductos(data);
                            }
                        });
            });

        });

const eliminar = id => {
    return idEliminar = () => id;
};

botonEliminar = document.querySelector("#btnEliminar");
botonEliminar.addEventListener('click', () =>{
         http.delete(URL_ELIMINAR_PRODUCTO + idEliminar())
            .then(() => {
                http.get(URL_PRODUCTO_POR_CATEGORIA + idCategoria)
                        .then(data => {
                            if (data.message === 'Producto no encontrado') {
                                ui.showAlerta();
                                setTimeout(() => {
                                    ui.hideAlerta();
                                }, 2000);

                            } else {
                                ui.showTablaProductos(data);
                            }
                        });

                ui.hideDetalles();
            });     
    });
const  detalles = id => {
    let guardarCategorias = [];
    http.get(URL_CATEGORIAS)
            .then(data => {
                data.map(c => {
                    return   guardarCategorias.push(c);
                });
            })
            .then(() => {
                http.get(URL_DETALLES_PRODUCTO + id)
                        .then(data => {
                            ui.showDetalles(data, guardarCategorias);
                            guardarDetalles();
                        });
            });

};


buscarPorNombre = document.querySelector('#buscarPorNombre');
buscarPorNombre.addEventListener('keyup', e => {
    const texto = e.target.value;
    if (texto !== "") {
        ui.hideAlerta();
        http.get(URL_PRODUCTO_POR_NOMBRE + texto)
                .then(data => {
                    if (data.message === 'Producto no encontrado') {
                        ui.showAlerta();
                        setTimeout(() => {
                            ui.hideAlerta();
                        }, 2000);

                    } else {
                        ui.showTablaProductos(data);
                    }
                });

    }
}
);

const guardarDetalles = () => {
    botonActualizar = document.querySelector("#btn-actualizar");
    let prod = {};
    prod.categoria = {};
    seleCate = document.querySelector("#put-idcategoria");
    seleCate.addEventListener('change', e => {
        prod.categoria.id = e.target.value;
    });

    botonActualizar.addEventListener('click', () => {
        prod.id = document.querySelector("#put-idnombre").value;
        prod.nombre = document.querySelector("#put-nombre").value;
        prod.modelo = document.querySelector("#put-modelo").value;
        prod.precio = document.querySelector("#put-precio").value;
        prod.stock = document.querySelector("#put-stock").value;
        prod.descripcion = document.querySelector("#put-descripcion").value;
        prod.urlImagen = document.querySelector("#put-urlimagen").value;
        prod.categoria.id = document.querySelector("#put-idcategoria").value;
        http.put(URL_ACTUALIZAR_PRODUCTO + prod.id, prod)
                .then((data) => {
                    if (data.ok) {
                        ui.showActualizado("Producto Actualizado correctamente!", "ok");
                        setTimeout(() => {
                            ui.hideActualizado();
                        }, 2000);
                    } else {
                        ui.showActualizado("Error!! complete los campos requeridos", "error");
                        setTimeout(() => {
                            ui.hideActualizado();
                        }, 2000);
                    }

                });
    });
};

botonNuevo = document.querySelector('#btn-nuevo');
botonNuevo.addEventListener('click', () => {

    http.get(URL_CATEGORIAS)
            .then(data => {
                ui.showNuevo(data);
            })
            .then(() => {
                guardarNuevo();
            });
});

const guardarNuevo = () => {
    botonGuardar = document.querySelector("#btn-guardar");
    let prod = {};
    prod.categoria = {};
    seleCate = document.querySelector("#post-idcategoria");
    seleCate.addEventListener('change', e => {
        prod.categoria.id = e.target.value;
    });
    botonGuardar.addEventListener('click', () => {
        prod.nombre = document.querySelector("#post-nombre").value;
        prod.modelo = document.querySelector("#post-modelo").value;
        prod.precio = document.querySelector("#post-precio").value;
        prod.stock = document.querySelector("#post-stock").value;
        prod.descripcion = document.querySelector("#post-descripcion").value;
        prod.urlImagen = (document.querySelector("#post-urlimagen").value !== "") ?
                          document.querySelector("#post-urlimagen").value : "/img/noimg.jpg";
        if (prod.nombre !== "")
        {
            http.post(URL_CREAR_PRODUCTO, prod)
                    .then((data) => {
                        if (data.ok) {
                            ui.showActualizado("Producto guardado correctamente!", "ok");
                            setTimeout(() => {
                                ui.hideActualizado();
                            }, 2000);
                        } else {
                            ui.showActualizado("Error!! complete los campos requeridos", "error");
                            setTimeout(() => {
                                ui.hideActualizado();
                            }, 2000);
                        }

                    });
        } else {
            ui.showActualizado("Error!! complete los campos requeridos", "error");
            setTimeout(() => {
                ui.hideActualizado();
            }, 2000);
        }
    });


};


