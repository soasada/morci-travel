<template>
    <div class="container-fluid bg-light py-5 mt-search">
        <div class="container">
            <div class="text-center">
                <h2>{{$t('search_center_message')}}</h2>
                <p class="lead">{{$t('search_center_message_lead')}}</p>
            </div>
            {{journeyType}}
            <form>
                <div class="row">
                    <div class="col-md-2">
                        <InputSelectIcon v-model="journeyType" name="inputJourneyType" :text="$t('journey_type')"
                                         icon="map-signs" :options="journeyTypes"/>
                    </div>
                    <div class="col-md-2">
                        <InputSelectIcon v-model="passengers" name="inputPassengers" :text="$t('passenger')" icon="user"
                                         :options="$t('passengers')"/>
                    </div>
                    <div class="col-md-2">
                        <InputSelect v-model="departure" name="inputDeparture" :text="$t('departure')" :options="departures"/>
                    </div>
                    <div class="col-md-2">
                        <InputSelect v-model="arrival" name="inputArrival" text="" :options="departures.reverse()"/>
                    </div>
                    <div class="col-md-2">
                        <label for="inputDepartureDate" class="sr-only"></label>
                        <div class="input-group input-group-sm">
                            <div class="input-group-prepend">
                                <div class="input-group-text">
                                    <font-awesome-icon :icon="['fas', 'calendar-week']"/>
                                </div>
                            </div>
                            <input ref="inputDepartureDate" type="date" class="form-control"
                                   id="inputDepartureDate">
                        </div>
                    </div>

                    <div v-show="journeyType === 'ROUNDTRIP'" class="col-md-2">
                        <label for="inputReturnDate" class="sr-only"></label>
                        <div class="input-group input-group-sm">
                            <div class="input-group-prepend">
                                <div class="input-group-text">
                                    <font-awesome-icon :icon="['fas', 'calendar-day']"/>
                                </div>
                            </div>
                            <input ref="inputReturnDate" type="date" class="form-control form-control-sm"
                                   id="inputReturnDate">
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</template>

<script>
    import InputSelectIcon from '@/components/forms/InputSelectIcon';
    import InputSelect from '@/components/forms/InputSelect';

    export default {
        name: 'SearchEngine',
        components: {
            InputSelectIcon,
            InputSelect
        },
        data() {
            return {
                journeyType: 'ONEWAY',
                passengers: 1,
                departure: '',
                arrival: ''
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
        }
    };
</script>

<style scoped>

</style>