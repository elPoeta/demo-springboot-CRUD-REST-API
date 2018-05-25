class Ui{
showTablaProductos(productos) {
let template = `<table class="table table-hover ml-3">
                         <thead>
                             <tr>
                                 <th>Categoria</th>
                                 <th>Nombre</th>
                                 <th>Precio U$$</th>
                                 <th>Precio $</th>
                                 <th>Unidades</th>
                                 <th>Ver</th>
                                 <th>Eliminar</th>
                           </tr>
                        </thead>
                              <tbody>`;
        productos.map(producto => {
        template += `<tr>
                            <td >${producto.categoria.nombre}</td>
                            <td >${producto.nombre}</td>
                            <td >${producto.precio}</td>
                            <td >${producto.precioPesos}</td>
                            <td >${producto.stock}</td>
                             <td ><a href="#${producto.id}"><i class="Tiny material-icons text-primary" onclick=detalles(${producto.id});>visibility</i></a></td>
                            <td ><a href="#${producto.id}" data-toggle="modal" data-target="#deleteModal"><i class="Tiny material-icons text-danger" onclick= 'eliminar(${producto.id});'">delete_forever</i></a></td>
                         </tr>
                  `;
        });
        template += `</tbody>
                 </table>`;
        document.querySelector('#tablaProductos').innerHTML = template;
}

showSeleccionCategoria(categorias){
let template = `<select id="categoriaSelect" class="custom-select custom-select-lg mb-5 ml-3">
                        <option selected disabled>Seleccionar Categoria</option>
                        <option value="0">Todas</option>`;
        categorias.map(categoria => {
        template += `<option value="${categoria.id}">${categoria.nombre}</option>`;
        });
        template += `</select>`;
        document.querySelector(`#selectCategoria`).innerHTML = template;
}

showNuevo(categorias){
let template = `
<div class="container">
                            <div class="row">
                                <div class="col-md-9">
                                    <div class="card">
                                        <div class="card-header">
                                            <h4>Nuevo producto</h4>
                                        </div>
                                        <div class="card-body">
                                            <form>
                                                <div class="form-row">
                                                    <div class="form-group col-md-4">
                                                        <label for="name">Nombre (*)</label>
                                                        <input type="text" id="post-nombre" class="form-control" value="" required>
                                                    </div>
                                                    <div class="form-group col-md-4">
                                                        <label for="modelo">Modelo</label>
                                                        <input type="text" id="post-modelo" class="form-control" value="">
                                                    </div>
                                                    <div class="form-group col-md-4">
                                                       
                                                       <label for="categoria">Categoria (*)</label>
                                                       <select id="post-idcategoria" class="form-control" required>
                                                       <option selected disabled>Seleccionar Categoria</option>`
        categorias.map(categoria => {
        template += `<option value="${categoria.id}">${categoria.nombre}</option>`;
        });
        template += `</select>
                                                      </div>
                                                    <div class="form-group col-md-12">
                                                        <label for="body">Descrpción</label>
                                                        <textarea name="editor1" id="post-descripcion" class="form-control" rows="5"></textarea>
                                                    </div>
                                                     <div class="form-group col-md-4">
                                                        <label for="precioDolar">Precio U$$ (*)</label>
                                                        <input type="text" id="post-precio" class="form-control" value="" required>
                                                    </div>
                                                 
                                                     <div class="form-group col-md-4">
                                                        <label for="stock">Stock</label>
                                                        <input type="text" id="post-stock" class="form-control" value="">
                                                     </div>
                                                    <div class="form-group col-md-12">
                                                        <label for="url">Url imagen</label>
                                                        <input type="text" id="post-urlimagen" class="form-control" value=""> 
                                                    </div>
                                                </div>    
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <img src="/img/logo.png" alt="Sin imagen" class="d-block img-fluid mb-3">
                                    <button type="submit" id="btn-guardar" class="btn btn-outline-success btn-block">Guardar</button>
                                </div>
                            </div>
                        </div>`;
        document.querySelector('#mensajeActualizado').style.display = 'none';
        document.querySelector('#detalles').style.display = 'block';
        document.querySelector(`#detalles`).innerHTML = template;
}
showDetalles(producto, categorias){
let template = `
<div class="container">
                            <div class="row">
                                <div class="col-md-9">
                                    <div class="card">
                                        <div class="card-header">
                                            <h4>Detalles</h4>
                                        </div>
                                        <div class="card-body">
                                            <form>
                                                <div class="form-row">
                                                    <div class="form-group col-md-4">
                                                        <label for="name">Nombre (*)</label>
                                                         <input type="text" id="put-nombre" class="form-control" value="${producto.nombre}" required>
                                                        <input type="hidden" id="put-idnombre" class="form-control" value="${producto.id}">                 
                                                    </div>
                                                    <div class="form-group col-md-4">
                                                        <label for="modelo">Modelo</label>
                                                        <input type="text" id="put-modelo" class="form-control" value="${producto.modelo}">
                                                    </div>
                                                    <div class="form-group col-md-4">
                                                           <label for="categoria">Categoria (*)</label>
                                                       <select id="put-idcategoria" class="form-control" required>
                                                        <option selected value="${producto.categoria.id}">${producto.categoria.nombre}</option> `
                                                                            categorias.map(categoria => {
                                                                          if (categoria.id !== producto.categoria.id){
                                                                     template += `<option value="${categoria.id}">${categoria.nombre}</option>`;
                                                                               }
                                                                       });
                                                                 template += `</select>
                                                    </div>
                                                    <div class="form-group col-md-12">
                                                        <label for="body">Descrpción</label>
                                                        <textarea name="editor1" id="put-descripcion" class="form-control" rows="5">${producto.descripcion}</textarea>
                                                    </div>
                                                     <div class="form-group col-md-4">
                                                        <label for="precioDolar">Precio U$$ (*)</label>
                                                        <input type="text" id="put-precio" class="form-control" value="${producto.precio}" required>
                                                    </div>
                                                    <div class="form-group col-md-4">
                                                        <label for="precioPeso">Precio $</label>
                                                        <input type="text" class="form-control" id="put-precioPesos" value="${producto.precioPesos}" readonly>
                                                    </div>
                                                     <div class="form-group col-md-4">
                                                        <label for="stock">Stock</label>
                                                        <input type="text" id="put-stock" class="form-control" value="${producto.stock}">
                                                     </div>
                                                    <div class="form-group col-md-12">
                                                        <label for="url">Url imagen</label>
                                                        <input type="text" id="put-urlimagen" class="form-control" value="${producto.urlImagen}"> 
                                                    </div>
                                                </div>    
                                            </form>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <img src="${producto.urlImagen}" alt="Sin imagen" class="d-block img-fluid mb-3">
                                    <button type="submit" id="btn-actualizar" class="btn btn-outline-success btn-block">Actualizar</button>
                                </div>
                            </div>
                        </div>`;
        document.querySelector('#mensajeActualizado').style.display = 'none';
        document.querySelector('#detalles').style.display = 'block';
        document.querySelector(`#detalles`).innerHTML = template;
}
showAlerta(){
document.querySelector('#mensajeNoEncontrado').style.display = 'block';
}

hideAlerta(){
document.querySelector('#mensajeNoEncontrado').style.display = 'none';
}
hideDetalles(){
document.querySelector('#detalles').style.display = 'none';
}
showActualizado(msj, estado){    
    const msjG = document.querySelector('#mensajeActualizado');
        msjG.style.display = 'block';
        if(estado === "ok"){
              msjG.setAttribute("class","alert alert-success ml-3 col-md-8");  
        }else{
            msjG.setAttribute("class","alert alert-warning ml-3 col-md-8"); 
        }
    document.querySelector('#mensajeGuardado').innerHTML =`<strong>${msj}</strong>`
}

hideActualizado(){
   document.querySelector('#mensajeActualizado').style.display = 'none';
}
}

