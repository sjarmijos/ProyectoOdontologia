window.addEventListener("load", function () {
  (function  () {
    const url = "/paciente";
    const settings = {
      method: "GET",
    };

    fetch(url, settings)
      .then(response => response.json())
      .then(data => {
        for (let paciente of data) {
          var table = document.getElementById("pacientesTableBody"); // Asegúrate de que este ID exista en tu HTML
          var pacienteRow = table.insertRow();
          let tr_id = 'tr_' + paciente.id;
          pacienteRow.id = tr_id;

          const deleteButton = '<button' +
                                ' id=' + '\"' + paciente.id + '\"' +
                                ' type="button" onclick="deleteBy('+paciente.id+')" class="btn btn-circle btn-danger">' +
                                '<i class="fas fa-trash"></i>' +
                                '</button>';

          const updateButton = '<button' +
                                ' id=' + '\"' + 'btn_id_' + paciente.id + '\"' +
                                ' type="button" onclick="findBy('+paciente.id+')" class="btn btn-circle btn-success">' +
                                '<i class="fas fa-pencil-alt"></i>' +
                                '</button>';
          pacienteRow.innerHTML =
            "<td>" + paciente.id + "</td>" +
            '<td class="nombre">' + paciente.nombre.toUpperCase() + "</td>" +
            '<td class="apellido">' + paciente.apellido.toUpperCase() + "</td>" +
            '<td class="cedula">' + paciente.cedula + "</td>" +
            '<td class="domicilio">' + paciente.domicilio.calle + ' '
                                     + paciente.domicilio.localidad + ' '
                                     + paciente.domicilio.numero + ' '
                                     + paciente.domicilio.provincia +"</td>" +
            '<td class="email">' + paciente.email + "</td>" +
            '<td class="Acciones">' + updateButton + "  " +deleteButton + "</td>";
        }
      })
      .catch((error) => console.error('Error al obtener los pacientes:', error));
  })();
});