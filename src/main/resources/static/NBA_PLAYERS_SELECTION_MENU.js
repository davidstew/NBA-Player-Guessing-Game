const apiUrl = 'https://api-nba-v1.p.rapidapi.com/players';
const apiKey = '84821ec6bamshe0441b30627243ap1267aejsn1bcce07576ce';

// Make the GET request using Axios
axios.get(apiUrl, {
    params: {
        team : '11',
        season: '2023'
    },
    headers: {
        'x-rapidapi-key': apiKey,
        'x-rapidapi-host': 'api-nba-v1.p.rapidapi.com'
    }
})
    .then(response => {
        //console.log(response.data.response);
        const players = response.data.response;
        //
        // // Populate dropdown with player names
        populateDropdown(players);
    })
    .catch(error => {
        console.error('Error fetching data:', error);
    });

function populateDropdown(players) {
    const dropdown = $('#playerDropdown');
    players.forEach(player => {
        dropdown.append($('<option></option>').text(`${player.firstname} ${player.lastname}`).val(`${player.firstname} ${player.lastname}`));
        // dropdown.append($('<option></option>').text(`${player.firstname} ${player.lastname}`).val(player.id));
    });

    // Initialize Select2
    dropdown.select2({
        placeholder: 'Select a player',
        allowClear: true // Optional: Add a clear button to the dropdown
    });

    // Event listener for dropdown change
    dropdown.on('change', function () {
        const selectedPlayerId = $(this).val();
        const selectedPlayerName = $(this).find(':selected').text();
        console.log('Selected player:', selectedPlayerId, selectedPlayerName);
    });
}

