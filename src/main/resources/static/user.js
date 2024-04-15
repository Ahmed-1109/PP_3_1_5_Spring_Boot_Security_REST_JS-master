$(async function () {
    await userU();
});

async function userU() {
    fetch(`http://localhost:8080/api/v1/user/`)
        .then(response => response.json())
        .then(dataAboutUser => {
            $(`#emailH4`).append(dataAboutUser.email);
            const rolesInHeader = dataAboutUser.roles.map(zzz => zzz.role.substring(5).concat(" ")).toString().replaceAll(`,`, ``);
            $(`#rolesUserPage`).append(rolesInHeader);
            const user =
                `$(
                <tr>
                <td>${dataAboutUser.id}</td>
                <td>${dataAboutUser.name}</td>
                <td>${dataAboutUser.secondName}</td>
                <td>${dataAboutUser.age}</td>
                <td>${dataAboutUser.email}</td>
                <td>${rolesInHeader}</td>`;
            $(`#userTable`).append(user);
        })
}