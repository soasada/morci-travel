<template>
    <div class="container-fluid bg-light py-5 mt-search">
        <div class="container">
            <div class="text-center">
                <h2>{{$t('search_center_message')}}</h2>
                <p class="lead">{{$t('search_center_message_lead')}}</p>
            </div>
            <form @submit.prevent="search">
                <div class="row">
                    <div class="col-md-2">
                        <InputSelectIcon v-model="journeyType" label="inputJourneyType" :text="$t('journey_type')"
                                         icon="map-signs" :options="journeyTypes"/>
                    </div>
                    <div class="col-md-2">
                        <InputSelectIcon v-model="model.passengers" label="inputPassengers" :text="$t('passenger')"
                                         icon="user" :options="$t('passengers')"/>
                    </div>
                    <div class="col-md-2">
                        <InputSelect v-model="model.departure" label="inputDeparture" :text="$t('departure')"
                                     :options="departures"/>
                    </div>
                    <div class="col-md-2">
                        <InputSelect v-model="model.arrival" label="inputArrival" :text="$t('arrival')"
                                     :options="departures.reverse()"/>
                    </div>
                    <div class="col-md-2">
                        <InputDate v-model="model.departureDate" label="inputDepartureDate" text=""
                                   icon="calendar-week"/>
                    </div>

                    <div v-show="journeyType === 'ROUNDTRIP'" class="col-md-2">
                        <InputDate v-model="model.returnDate" label="inputReturnDate" text="" icon="calendar-day"/>
                    </div>
                </div>
                <div class="row justify-content-md-center">
                    <div class="col-md-3 py-3">
                        <button v-if="!searching" class="btn btn-primary btn-block" type="submit">{{$t('search')}}</button>
                        <button v-else class="btn btn-primary btn-block" type="submit" disabled>
                            <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>
                            {{$t('searching')}}
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</template>

<script>
    import InputSelectIcon from '@/components/forms/InputSelectIcon';
    import InputSelect from '@/components/forms/InputSelect';
    import InputDate from '@/components/forms/InputDate';
    import http from '@/http';

    export default {
        name: 'SearchEngine',
        components: {
            InputSelectIcon,
            InputSelect,
            InputDate
        },
        data() {
            return {
                journeyType: 'ONEWAY',
                model: {
                    passengers: 1,
                    departure: 'AGP',
                    arrival: 'BCN',
                    departureDate: new Date(),
                    returnDate: null
                },
                searching: false
            };
        },
        computed: {
            journeyTypes() {
                return [
                    {value: 'ONEWAY', text: this.$t('oneway')},
                    {value: 'ROUNDTRIP', text: this.$t('roundtrip')}
                ];
            },
            departures() {
                return [
                    {value: 'BCN', text: 'Barcelona'},
                    {value: 'AGP', text: 'Malaga'}
                ];
            }
        },
        methods: {
            async search() {
                if (!this.searching) {
                    this.searching = true;
                    const response = await http.post('/search', this.model);
                    const searchId = await response.json();
                    let eventSource = new EventSource(`/v1/search/${searchId}/push`);

                    eventSource.onerror = () => {
                        eventSource.close();
                        this.searching = false
                    };

                    eventSource.addEventListener('search-result', (e) => {
                        console.log(e.data);
                    }, false);
                }
            }
        }
    };
</script>

<style scoped>

</style>