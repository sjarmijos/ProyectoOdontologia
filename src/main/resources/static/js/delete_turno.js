function deleteBy(id){

  const url = '/turno/'+ id;
  const settings = {
      method: 'DELETE'
  }
  fetch(url,settings)
  .then(response => response.json())

  //borrar la fila de la pelicula eliminada
  let row_id = "#tr_" + id;
  console.log(row_id);
  document.querySelector(row_id).remove();
}