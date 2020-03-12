<template>
    <div class="container-fluid bg-light py-5 mt-search">
        <div class="container">
            <form>
                <div class="row">
                    <div class="col-md-2 pr-0">
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

                    <div class="col-md-2 pl-0">
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
                    <div class="col-md-2 pr-1">
                        <label for="inputDeparture" class="col-form-label col-form-label-sm"></label>
                        <select id="inputDeparture" class="form-control form-control-sm">
                            <option selected value="BCN">Barcelona</option>
                            <option value="AGP">Malaga</option>
                        </select>
                    </div>

                    <div class="col-md-2 pl-1">
                        <label for="inputArrival" class="col-form-label col-form-label-sm"></label>
                        <select id="inputArrival" class="form-control form-control-sm">
                            <option selected value="AGP">Malaga</option>
                            <option value="BCN">Barcelona</option>
                        </select>
                    </div>

                    <div class="col-md-2 pr-0">
                        <label for="inputDepartureDate" class="col-form-label col-form-label-sm"></label>
                        <input ref="inputDepartureDate" type="date" class="form-control form-control-sm"
                               id="inputDepartureDate">
                    </div>

                    <div v-show="showReturnDate" class="col-md-2 pl-0">
                        <label for="inputReturnDate" class="col-form-label col-form-label-sm"></label>
                        <input ref="inputReturnDate" type="date" class="form-control form-control-sm"
                               id="inputReturnDate">
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
                journeyType: 'ONEWAY',
                showReturnDate: false
            };
        },
        computed: {
            journeyType() {
                return this.journeyType;
            }
        },
        watch: {
            journeyType(newJourneyType) {
                this.showReturnDate = newJourneyType === 'ROUNDTRIP';
            }
        }
    }
</script>

<style scoped>

</style>