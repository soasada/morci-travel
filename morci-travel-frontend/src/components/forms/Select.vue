<template>
    <select :id="id" class="custom-select custom-select-sm d-block w-100" @change="$emit('input', $event.target.value)">
        <option v-for="(item, index) in options" :key="item.text + index" :value="item.value">
            {{item.text}}
        </option>
    </select>
</template>

<script>
    export default {
        name: 'Select',
        props: {
            value: {
                required: true
            },
            id: {
                type: String,
                required: true
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