//JS
const clients_tab = `
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-12 text-center">
            <div class="section-title">
                <h2>Clients</h2>
            </div>
        </div>
    </div>
    <div class="clients">
        <table class="table table-bordered table-dark">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Surname</th>
                <th scope="col">Name</th>
                <th scope="col">Patronymic</th>
                <th scope="col">Birth date</th>
                <th scope="col">Gender</th>
                <th scope="col">Email</th>
                <th scope="col">Update</th>
            </tr>
            </thead>
            <tbody>
            {{#clients}}
                <tr>
                    <td> {{id}}</td>
                    <td>{{surname}}</td>
                    <td>{{name}}</td>
                    <td>{{patronymic}}</td>
                    <td>{{birthDate}}</td>
                    <td>{{gender}}</td>
                    <td>{{email}}</td>
                    <td>
                        <form action="clientUpdateForm">
                            <input type="hidden" name="id" value="{{id}}">
                            <input type="submit" value="...">
                        </form>
                    </td>
                </tr>
            {{/clients}}
            </tbody>
        </table>
    </div>
</div>
`;

document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('addClientSubmit').onclick = (event) => {
        event.preventDefault();
        ajaxSubmitForm();
    };

})

function ajaxSubmitForm() {
    let form = document.getElementById('clientForm');
   let formData = new FormData(form);

   let json = JSON.stringify(Object.fromEntries(formData));

   console.log(json);

   let request = new XMLHttpRequest();
    request.open('post','/rest/addNewClient');
    request.setRequestHeader('Content-Type', 'application/json; charset=utf-8');
    request.send(json);

    request.addEventListener('readystatechange',()=>{
        if(request.readyState!==4){
            return
        }
        if(request.status===200){
            let clients = JSON.parse(request.responseText);
            clients = {
                'clients':clients
            }
            let resultHtml=mustache.render(clients_tab,clients)
            document.getElementById('clientsTableId').innerHTML = resultHtml;

        }else{
            alert(request.statusText);
        }

    })
}