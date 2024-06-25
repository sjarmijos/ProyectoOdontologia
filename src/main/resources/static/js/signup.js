window.addEventListener('load', function () {

    const formulario = document.querySelector('#form_sign_up');

    formulario.addEventListener('submit', function (event) {

        const formData = {
            nombre: document.querySelector('#nombre').value,
            username: document.querySelector('#username').value,
            email: document.querySelector('#email').value,
            password: document.querySelector('#password').value,
            usuarioRole: document.querySelector('#role').value
        };

        const url = '/usuarios/signup';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                 resetUploadForm();
            })
            .catch(error => {
                    //Si hay algun error se muestra un mensaje diciendo que la pelicula
                    //no se pudo guardar y se intente nuevamente
                    let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                     '<strong> Error intente nuevamente</strong> </div>'

                      document.querySelector('#response').innerHTML = errorAlert;
                      document.querySelector('#response').style.display = "block";
                     //se dejan todos los campos vacíos por si se quiere ingresar otra pelicula
                     resetUploadForm();})
    });


    function resetUploadForm(){
        document.querySelector('#nombre').value = "";
        document.querySelector('#username').value = "";
        document.querySelector('#email').value = "";
        document.querySelector('#password').value = "";
        document.querySelector('#role').value = "";
    }
});