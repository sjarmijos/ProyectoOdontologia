window.addEventListener("load", function () {
  (function  () {
    const url = "/odontologo";
    const settings = {
      method: "GET"
    };

    fetch(url, settings)
      .then(response => response.json())
      .then(data => {
        for (let odontologo of data) {
          var table = document.getElementById("odontologosTableBody"); // Asegúrate de que este ID exista en tu HTML
          var odontologoRow = table.insertRow();
          let tr_id = 'tr_' + odontologo.id;
          odontologoRow.id = tr_id;

          const deleteButton = '<button' +
                                ' id=' + '\"' + odontologo.id + '\"' +
                                ' type="button" onclick="deleteBy('+odontologo.id+')" class="btn btn-circle btn-danger">' +
                                '<i class="fas fa-trash"></i>' +
                                '</button>';

          const updateButton = '<button' +
                                ' id=' + '\"' + 'btn_id_' + odontologo.id + '\"' +
                                ' type="button" onclick="findBy('+odontologo.id+')" class="btn btn-circle btn-success">' +
                                '<i class="fas fa-pencil-alt"></i>' +
                                '</button>';
          odontologoRow.innerHTML =
            "<td>" + odontologo.id + "</td>" +
            '<td class="matricula">' + odontologo.matricula.toUpperCase() + "</td>" +
            '<td class="nombre">' + odontologo.nombre.toUpperCase() + "</td>" +
            '<td class="apellido">' + odontologo.apellido.toUpperCase() + "</td>" +
            '<td class="Acciones">' + updateButton + "  " +deleteButton + "</td>";
        }
      })
      .catch((error) => console.error('Error al obtener los odontólogos:', error));
  })();
});