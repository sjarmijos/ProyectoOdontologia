window.addEventListener('load', function () {

    const formulario = document.querySelector('#update_turno_form');

    formulario.addEventListener('submit', function (event) {
        let turnoId = document.querySelector('#turno_id').value;

        const formData = {
            id: document.querySelector('#turno_id').value,
            paciente: {
                id: document.querySelector('#paciente_id').value,
            },
            odontologo: {
                id: document.querySelector('#odontologo_id').value,
            },
            fecha: document.querySelector('#fecha').value
        };

        const url = '/turno';
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
      const url = '/turno/get'+"/"+id;
      const settings = {
          method: 'GET'
      }
      fetch(url,settings)
      .then(response => response.json())
      .then(data => {
            let turno = data;
            document.querySelector('#turno_id').value = turno.id;
            document.querySelector('#fecha').value = turno.fecha;
            document.querySelector('#paciente_id').value = turno.paciente.id;
            document.querySelector('#odontologo_id').value = turno.odontologo.id;
            document.querySelector('#div_turno_updating').style.display = "block";
      }).catch(error => {
          alert("Error: " + error);
      })
}