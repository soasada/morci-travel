<template>
    <div>
        <label :for="label" class="sr-only">{{text}}</label>
        <div class="input-group input-group-sm">
            <div class="input-group-prepend">
                <div class="input-group-text">
                    <font-awesome-icon :icon="['fas', icon]"/>
                </div>
            </div>
            <input :ref="label" type="date" class="form-control" :id="label" :value="value"
                   @input="$emit('input', $event.target.value)">
        </div>
    </div>
</template>

<script>
    export default {
        name: 'InputDate',
        props: {
            value: {
                required: true
            },
            label: {
                type: String,
                required: true
            },
            text: {
                type: String,
                required: true
            },
            icon: {
                type: String,
                required: true
            }
        }
    }
</script>

<style scoped>

</style>