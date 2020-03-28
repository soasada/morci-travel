import Vue from 'vue';
import VueI18n from 'vue-i18n';

Vue.use(VueI18n);

function generatePassengers(lang) {
    let passengers = [];
    let passengerWord = '';

    switch (lang) {
        case 'es':
            passengerWord = 'pasajero';
            break;
        default:
            passengerWord = 'passenger';
            break;
    }

    for (let i = 0; i < 9; i++) {
        if (i === 0) {
            passengers.push({value: 1, text: '1 ' + passengerWord});
        } else {
            passengers.push({value: (i + 1), text: (i + 1) + ' ' + passengerWord + 's'});
        }
    }

    return passengers;
}

const messages = {
    en: {
        welcome: 'Welcome',
        journey_type: 'Journey Type',
        oneway: 'One-way',
        roundtrip: 'Round trip',
        passenger: 'Passengers',
        passengers: generatePassengers('en'),
        departure: 'Departure',
        arrival: 'Arrival',
        search_center_message: 'What Are You Looking For?',
        search_center_message_lead: 'Search for least costly fares available!',
        search: 'Search',
        searching: 'Searching...'
    },
    es: {
        welcome: 'Bienvenido',
        journey_type: 'Tipo de viaje',
        oneway: 'Solo ida',
        roundtrip: 'Ida y Vuelta',
        passenger: 'Pasajeros',
        passengers: generatePassengers('es'),
        departure: 'Origen',
        arrival: 'Destino',
        search_center_message: '¿Qué Buscas?',
        search_center_message_lead: '¡Busca las tarifas más baratas disponibles!',
        search: 'Buscar',
        searching: 'Buscando...'
    }
};

const i18n = new VueI18n({
    locale: 'en', // set locale
    fallbackLocale: 'es', // set fallback locale
    messages, // set locale messages
});

export default i18n;