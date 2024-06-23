window.addEventListener('load', function () {

    const formulario = document.querySelector('#update_paciente_form');

    formulario.addEventListener('submit', function (event) {
        let pacienteId = document.querySelector('#paciente_id').value;
        let domicilioId = document.querySelector('#domicilio_id').value;

        const formData = {
            id: document.querySelector('#paciente_id').value,
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            cedula: document.querySelector('#cedula').value,
            fechaIngreso: document.querySelector('#fechaIngreso').value,
            domicilio: {
                id: document.querySelector('#domicilio_id').value,
                calle: document.querySelector('#calle').value,
                numero: document.querySelector('#numero').value,
                localidad: document.querySelector('#localidad').value,
                provincia: document.querySelector('#provincia').value
            },
            email: document.querySelector('#email').value
        };

        const url = '/paciente';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
          fetch(url,settings)
          .then(response => response.json())

    })
 })

function findBy(id) {
      const url = '/paciente'+"/"+id;
      const settings = {
          method: 'GET'
      }
      fetch(url,settings)
      .then(response => response.json())
      .then(data => {
            document.querySelector('#paciente_id').value = data.id;
            document.querySelector('#nombre').value = data.nombre;
            document.querySelector('#apellido').value = data.apellido;
            document.querySelector('#cedula').value = data.cedula;
            document.querySelector('#fechaIngreso').value = data.fechaIngreso;
            document.querySelector('#domicilio_id').value = data.domicilio.id;
            document.querySelector('#calle').value = data.domicilio.calle;
            document.querySelector('#numero').value = data.domicilio.numero;
            document.querySelector('#localidad').value = data.domicilio.localidad;
            document.querySelector('#provincia').value = data.domicilio.provincia
            document.querySelector('#email').value = data.email;
            document.querySelector('#div_paciente_updating').style.display = "block";
      }).catch(error => {
          alert("Error: " + error);
      })
}