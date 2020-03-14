<template>
    <div class="container-fluid bg-light py-5 mt-search">
        <div class="container">
            <form>
                <div class="row">
                    <div class="col-md-2">
                        <label for="inputJourneyType" class="sr-only">{{ $t('journey_type') }}</label>
                        <div class="input-group input-group-sm">
                            <div class="input-group-prepend">
                                <div class="input-group-text">
                                    <font-awesome-icon :icon="['fas', 'map-signs']"/>
                                </div>
                            </div>
                            <select id="inputJourneyType" class="form-control" v-model="journeyType">
                                <option selected value="ONEWAY">{{ $t('oneway') }}</option>
                                <option value="ROUNDTRIP">{{ $t('roundtrip') }}</option>
                            </select>
                        </div>
                    </div>

                    <div class="col-md-2">
                        <label for="inputPassengers" class="sr-only">{{ $t('passenger') }}</label>
                        <div class="input-group input-group-sm">
                            <div class="input-group-prepend">
                                <div class="input-group-text">
                                    <font-awesome-icon :icon="['fas', 'user']"/>
                                </div>
                            </div>
                            <select id="inputPassengers" class="form-control">
                                <option v-for="(item, index) in $t('passengers')" :key="item + index" :value="index">
                                    {{item}}
                                </option>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-2">
                        <label for="inputDeparture"></label>
                        <div class="input-group input-group-sm">
                            <div class="input-group-prepend">
                                <div class="input-group-text">
                                    <font-awesome-icon :icon="['fas', 'arrow-alt-circle-right']"/>
                                </div>
                            </div>
                            <select id="inputDeparture" class="form-control">
                                <option selected value="BCN">Barcelona</option>
                                <option value="AGP">Malaga</option>
                            </select>
                        </div>
                    </div>

                    <div class="col-md-2">
                        <label for="inputArrival" class="sr-only"></label>
                        <div class="input-group input-group-sm">
                            <div class="input-group-prepend">
                                <div class="input-group-text">
                                    <font-awesome-icon :icon="['fas', 'arrow-alt-circle-left']"/>
                                </div>
                            </div>
                            <select id="inputArrival" class="form-control form-control-sm">
                                <option selected value="AGP">Malaga</option>
                                <option value="BCN">Barcelona</option>
                            </select>
                        </div>
                    </div>

                    <div class="col-md-2">
                        <label for="inputDepartureDate"></label>
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
    export default {
        name: 'SearchEngine',
        data() {
            return {
                journeyType: 'ONEWAY'
            };
        }
    }
</script>

<style scoped>

</style>