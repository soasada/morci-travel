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
                        <InputSelectIcon v-model="passengers" label="inputPassengers" :text="$t('passenger')"
                                         icon="user" :options="$t('passengers')"/>
                    </div>
                    <div class="col-md-2">
                        <InputSelect v-model="departure" label="inputDeparture" :text="$t('departure')"
                                     :options="departures"/>
                    </div>
                    <div class="col-md-2">
                        <InputSelect v-model="arrival" label="inputArrival" :text="$t('arrival')"
                                     :options="departures.reverse()"/>
                    </div>
                    <div class="col-md-2">
                        <InputDate v-model="departureDate" label="inputDepartureDate" text="" icon="calendar-week"/>
                    </div>

                    <div v-show="journeyType === 'ROUNDTRIP'" class="col-md-2">
                        <InputDate v-model="returnDate" label="inputReturnDate" text="" icon="calendar-day"/>
                    </div>
                </div>
                <div class="row justify-content-md-center">
                    <div class="col-md-3 py-3">
                        <button class="btn btn-primary btn-block" type="submit">{{$t('search')}}</button>
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
                passengers: 1,
                departure: '',
                arrival: '',
                departureDate: '',
                returnDate: ''
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
            search() {

            }
        }
    };
</script>

<style scoped>

</style>