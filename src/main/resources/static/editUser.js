$(async function() {
    editUser();
});
function editUser() {
    const editForm = document.forms["formEditUser"];
    editForm.addEventListener("submit", ev => {
        ev.preventDefault();
        const selected_options = document.querySelector('#editUserRoles').selectedOptions;

        const rolesNamesArray = new Array(selected_options.length);
        for (let i = 0; i < selected_options.length; i++) {
            rolesNamesArray[i] = selected_options[i].value;
        }

        fetch(`http://localhost:8080/api/v1/admin/user/edit/` + editForm.id.value, {
            method: 'PATCH',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                id: editForm.id.value,
                name: editForm.name.value,
                secondName: editForm.secondName.value,
                age: editForm.age.value,
                email: editForm.email.value,
                password: editForm.password.value,
                roles: rolesNamesArray
            })
        }).then(() => {
            $('#editFormCloseButton').click();
            allUsers();
        })
    })
}

$('#edit').on('show.bs.modal', ev => {
    const button = $(ev.relatedTarget);
    const id = button.data('id');
    editUser2(id);
})

async function editUser2(id) {
    const user = await getUser(id);
    const form = document.forms["formEditUser"];
    form.id.value = user.id;
    form.name.value = user.name;
    form.secondName.value = user.secondName;
    form.age.value = user.age;
    form.email.value = user.email;
    form.password.value = user.password;
}