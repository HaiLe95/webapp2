function personCreate(event) {
    jQuery.ajax({
        type: 'POST',
        url:  '/person/create',
        data: {
            name:    jQuery('#name').val(),
            surname: jQuery('#surname').val(),
            age:     jQuery('#age').val()
        },
        success: function (response) {
            event.preventDefault();
            jQuery('#name').val('');
            jQuery('#surname').val('');
            jQuery('#age').val('');
        },
        error: function (errorThrown) {
            console.log( errorThrown );
        }
    });
}

function findAllPersons() {
    jQuery.ajax({
        type: 'GET',
        url:  '/person/findall',
        success: function (response) {
            processDataPersons(response);
        },
        error: function (errorThrown) {
            console.log( errorThrown );
        }
    });
}

/* UI Scripts */

function createPersonsTable() {
    jQuery('#workspace')
        .empty()
        .append('<table id="tblPersons">');
    jQuery('#tblPersons')
        .append('<caption>Persons Table</caption>')
        .append('<thead><tr id="header"></tr></thead>');
    jQuery('#header')
        .append('<th>ID</th>')
        .append('<th>NAME</th>')
        .append('<th>SURNAME</th>')
        .append('<th>AGE</th>');
    /* Получаем все имеющиеся записи*/
    findAllPersons();
}

function processDataPersons(result) {
    var person = jQuery.parseJSON(result);

    jQuery('#tblPersons')
        .append('<tbody id="body"></tbody>');
    jQuery('#body')
        .empty();

    for (var i = 0; i < person.length; i++) {
        jQuery('#body').append('<tr id="body_row_' + i + '"></tr>');
        jQuery('#body_row_' + i)
            .append('<td id="person_id">'      + person[i].id      + '</td>')
            .append('<td id="person_name">'    + person[i].name    + '</td>')
            .append('<td id="person_surname">' + person[i].surname + '</td>')
            .append('<td id="person_age">'     + person[i].age     + '</td>');
    }
}