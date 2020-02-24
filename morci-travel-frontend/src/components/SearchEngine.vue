<template>
    <div class="container-fluid bg-light py-5 mt-search">
        <div class="container">
            <form>
                <div class="form-row">
                    <div class="form-group col-md-2">
                        <label for="inputJourneyType" class="col-form-label col-form-label-sm">{{ $t('journey_type')
                            }}</label>
                        <select id="inputJourneyType" class="form-control form-control-sm mt-search-journey-type">
                            <option selected value="ONEWAY">{{ $t('oneway') }}</option>
                            <option value="ROUNDTRIP">{{ $t('roundtrip') }}</option>
                        </select>
                    </div>
                    <div class="form-group col-md-2">
                        <label for="inputPassengers" class="col-form-label col-form-label-sm">{{ $t('passenger')
                            }}</label>
                        <select id="inputPassengers" class="form-control form-control-sm mt-search-passengers">
                            <option v-for="(item, index) in $t('passengers')" :key="item + index" :value="index">
                                {{item}}
                            </option>
                        </select>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-3">
                        <label for="inputDeparture">{{ $t('departure') }}</label>
                        <input type="text" class="form-control" id="inputDeparture">
                    </div>
                    <div class="form-group col-md-3">
                        <label for="inputArrival">{{ $t('arrival') }}</label>
                        <input type="text" class="form-control" id="inputArrival">
                    </div>
                </div>
            </form>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'SearchEngine'
    }
</script>

<style scoped>

</style>