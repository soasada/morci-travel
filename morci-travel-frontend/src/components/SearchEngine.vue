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
                        <button v-if="!searching" class="btn btn-primary btn-block" type="submit">{{$t('search')}}
                        </button>
                        <button v-else class="btn btn-primary btn-block" type="submit" disabled>
                            <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>
                            {{$t('searching')}}
                        </button>
                    </div>
                </div>
                <div class="row justify-content-md-center">
                    <table class="table is-fullwidth">
                        <thead>
                        <tr>
                            <th>Company</th>
                            <th>Departure Time</th>
                            <th>Arrival Time</th>
                            <th>Price</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr v-for="val in searchResults" :key="val.company">
                            <td>{{val.company}}</td>
                            <td>{{val.departureTime}}</td>
                            <td>{{val.arrivalTime}}</td>
                            <td>{{val.price}}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </form>
        </div>
    </div>
</template>

<script>
    import InputSelectIcon from '@/components/forms/InputSelectIcon';
    import InputSelect from '@/components/forms/InputSelect';
    import InputDate from '@/components/forms/InputDate';

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
                }
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
            },
            searching() {
                return this.$store.state.searching;
            },
            searchResults() {
                return this.$store.state.searchResult;
            }
        },
        methods: {
            search() {
                this.$store.dispatch('search', this.model);
            }
        }
    };
</script>

<style scoped>

</style>