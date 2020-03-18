<template>
    <div class="col-md-2">
        <label :for="name" class="sr-only">{{ text }}</label>
        <div class="input-group input-group-sm">
            <div class="input-group-prepend">
                <div class="input-group-text">
                    <font-awesome-icon :icon="['fas', icon]"/>
                </div>
            </div>
            <select :id="name" class="form-control" @change="$emit('input', $event.target.value)">
                <option v-for="(item, index) in options" :key="item.text + index" :value="item.value">
                    {{item.text}}
                </option>
            </select>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'InputSelect',
        props: {
            value: {
                type: String,
                required: true
            },
            name: {
                type: String,
                required: true
            },
            text: {
                type: String,
                required: true
            },
            icon: {
                type: String,
                required: false
            },
            options: {
                type: Array,
                required: true
            }
        }
    }
</script>

<style scoped>

</style>