class Http {
    async get(url) {
        const respuesta = await fetch(url, { 
            method: 'GET',
             headers: {
                'Content-type': 'application/json'
            }
           });
        let productos = JSON.parse(await respuesta.text());
        return productos;
    }
    async post(url, data) {
        const respuesta = await fetch(url, {
            method: 'POST',
            headers: {
                'Content-type': 'application/json'
            },
            body: JSON.stringify(data)
        });
        return respuesta;
    }

    async put(url, data) {
        const respuesta = await fetch(url, {
            method: 'PUT',
            headers: {
                'Content-type': 'application/json'
            },
            body: JSON.stringify(data)
        });
       return respuesta;
    }
    async delete(url) {
        const respuesta = await fetch(url, {
            method: 'DELETE',
             headers: {
                'Content-type': 'application/json'
            }
           });
        return respuesta;
    }

}


