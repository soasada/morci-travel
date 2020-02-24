<template>
    <div class="mt-search">
        <form>
            <div class="form-row">
                <div class="form-group col-md-2">
                    <label for="inputJourneyType">Journey Type</label>
                    <select id="inputJourneyType" class="form-control mt-search-journey-type">
                        <option disabled selected value>Select an option please</option>
                        <option value="ONEWAY">One-way</option>
                        <option value="ROUNDTRIP">Round trip</option>
                    </select>
                </div>
                <div class="form-group col-md-2">
                    <label for="inputPassengers">Passengers</label>
                    <select id="inputPassengers" class="form-control mt-search-passengers">
                        <option disabled selected value>Select an option please</option>
                        <option value="ONEWAY">One-way</option>
                        <option value="ROUNDTRIP">Round trip</option>
                    </select>
                </div>
            </div>

            <div class="form-row">

            </div>
        </form>
    </div>
</template>

<script>
    export default {
        name: 'SearchEngine'
    }
</script>

<style scoped>

</style>