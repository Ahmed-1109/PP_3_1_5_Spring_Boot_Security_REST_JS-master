$(async function () {
    await newUser();
});

async function newUser() {

    const form = document.forms["formNewUser"];

    form.addEventListener('submit', addNewUser)

    function addNewUser(e) {
        e.preventDefault();

        const selected_options = document.querySelector('#AddNewUserRoles').selectedOptions;

        const rolesNamesArray = new Array(selected_options.length);
        for (let i = 0; i < selected_options.length; i++) {
            rolesNamesArray[i] = selected_options[i].value;
        }

        fetch(`http://localhost:8080/api/v1/admin/user/new`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                name: form.name.value,
                secondName: form.secondName.value,
                age: form.age.value,
                email: form.email.value,
                password: form.password.value,
                roles: rolesNamesArray
            })
        }).then(() => {
            form.reset();
            allUsers();
            $('#usersTableTab').click();

        })
    }
}

