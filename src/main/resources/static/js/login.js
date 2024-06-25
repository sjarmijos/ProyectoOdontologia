window.addEventListener('load', function () {

    const formulario = document.querySelector('#form_log_in');

    formulario.addEventListener('submit', function (event) {
        event.preventDefault();  // Prevenir el comportamiento por defecto del formulario

        const url = '/auth/login';

        const formData = {
            username: document.querySelector('#username').value,
            password: document.querySelector('#password').value,
        };

        console.log('Form Data:', formData);  // Añadir para depuración

        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': localStorage.getItem('token')
            },
            body: JSON.stringify(formData)
        };

        console.log('Settings:', settings);  // Añadir para depuración

        fetch(url, settings)
            .then(response => {
                if (response.ok) {
                    return response.json();
                }
                throw new Error(response.statusText);
            })
            .then(responseJSON => {
                console.log('Response JSON:', responseJSON);  // Añadir para depuración
                localStorage.setItem('token', responseJSON.token);  // Guardar el token en el almacenamiento local
                window.location.href = '../index.html';  // Redirigir a la página principal
            })
            .catch(error => {
                console.log(error);
                alert('Usuario o contraseña incorrectos');
                resetUploadForm();
            });
    });

    function resetUploadForm(){
        document.querySelector('#username').value = "";
        document.querySelector('#password').value = "";
    }

    const signupButton = document.querySelector('#btn-signup');

    signupButton.addEventListener('click', function() {
        window.location.href = '../signup.html';  // Cambia esto a la URL correcta si es necesario
    });
});
