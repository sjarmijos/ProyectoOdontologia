window.addEventListener("load", function () {
  (function  () {
    const url = "/turno";
    const settings = {
      method: "GET",
    };

    fetch(url, settings)
      .then(response => response.json())
      .then(data => {
        for (let turno of data) {
          var table = document.getElementById("turnosTableBody"); // Asegúrate de que este ID exista en tu HTML
          var turnoRow = table.insertRow();
          let tr_id = 'tr_' + turno.id;
          turnoRow.id = tr_id;

          const deleteButton = '<button' +
                                ' id=' + '\"' + turno.id + '\"' +
                                ' type="button" onclick="deleteBy('+turno.id+')" class="btn btn-circle btn-danger">' +
                                '<i class="fas fa-trash"></i>' +
                                '</button>';

          const updateButton = '<button' +
                                ' id=' + '\"' + 'btn_id_' + turno.id + '\"' +
                                ' type="button" onclick="findBy('+turno.id+')" class="btn btn-circle btn-success">' +
                                '<i class="fas fa-pencil-alt"></i>' +
                                '</button>';
          turnoRow.innerHTML =
            "<td>" + turno.id + "</td>" +
            '<td class="fecha">' + turno.fecha + "</td>" +
            '<td class="paciente">' + turno.paciente.nombre + ' ' + turno.paciente.apellido + "</td>" +
            '<td class="odontologo">' + turno.odontologo.nombre + ' ' + turno.odontologo.apellido + "</td>" +
            '<td class="Acciones">' + updateButton + "  " +deleteButton + "</td>";
        }
      })
      .catch((error) => console.error('Error al obtener los turnos:', error));
  })();
});