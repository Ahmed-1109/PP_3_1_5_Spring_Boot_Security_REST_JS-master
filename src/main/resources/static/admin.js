$(async function() {
    await allUsers();
});
const table = $('#tbodyAllUserTable');
async function allUsers() {
    table.empty()
    fetch(`http://localhost:8080/api/v1/admin/user/`)
        .then(response => response.json())
        .then(dataAboutUser => {
            $(`#emailH4`).append(dataAboutUser.email);

            dataAboutUser.forEach(userInTable => {
                const roles = userInTable.roles.map(zzz => zzz.role.substring(5).concat(" ")).toString().replaceAll(`,`, ``);

                const usersTable = `$(
                        <tr>
                            <td>${userInTable.id}</td>
                            <td>${userInTable.name}</td>   
                            <td>${userInTable.secondName}</td> 
                            <td>${userInTable.age}</td>                      
                            <td>${userInTable.email}</td>
                            <td>${roles}</td>
                            <td>
                                <button type="button" class="btn btn-info" data-toggle="modal" id="buttonEdit"
                                data-action="edit" data-id="${userInTable.id}" data-target="#edit">Edit</button>
                            </td>
                            <td>
                                <button type="button" class="btn btn-danger" data-toggle="modal" id="buttonDelete"
                                data-action="delete" data-id="${userInTable.id}" data-target="#delete">Delete</button>
                            </td>
                        </tr>)`;
                table.append(usersTable);

            })

        })
}