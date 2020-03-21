<template>
    <div>
        <label :for="label" class="sr-only">{{ text }}</label>
        <Select v-model="selectValue" :id="label" :options="options" @input="$emit('input', selectValue)"/>
    </div>
</template>

<script>
    import Select from '@/components/forms/Select';

    export default {
        name: 'InputSelect',
        components: {
            Select
        },
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
            options: {
                type: Array,
                required: true
            }
        },
        data() {
            return {
                selectValue: undefined
            };
        }
    }
</script>

<style scoped>

</style>